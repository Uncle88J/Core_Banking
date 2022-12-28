package com.tosan.core.customer;

import com.tosan.core.exceptions.CustomerNotFoundException;
import com.tosan.core.exceptions.TransactionException;
import com.tosan.core.operation.AddBalanceOperation;
import com.tosan.core.operation.Operation;
import com.tosan.core.operation.TransactionOperation;

import java.util.*;

public class CustomerManager<T extends Customer> {


    private List<T> customers;
    private Map<Integer, T> customersMap;
    private Set<T> customersSet;

    private ICustomerDAO customerDAO;

    public CustomerManager() {
        customers = new LinkedList<>();
        customersMap = new TreeMap<>();
    }

    public OrganizationCustomer createOrganizationCustomer(int id, String orgName) {
        OrganizationCustomer customer = new OrganizationCustomer(id, orgName);
        customerDAO.saveCustomer(customer);
        //addCustomer(customer);
        return customer;
    }


    public void modifyCustomerBalance(T customer, long balance) {
        customer.setBalance(balance);
        AddBalanceOperation operation = new AddBalanceOperation(customer, this, balance);
        customer.getOperationStack().push(operation);
    }


    public void doTransaction(T debit, T credit, long amount) throws TransactionException {

        if (debit.isLocked())
            throw new TransactionException("Account locked");

        if (debit.getBalance() < amount)
            throw new TransactionException("Not enough Balance");

        debit.setBalance(debit.getBalance() - amount);
        credit.setBalance(credit.getBalance() + amount);


        TransactionOperation operation = new TransactionOperation(credit, this, amount, debit);
        credit.getOperationStack().push(operation);
    }

    public void addCustomer(T customer) {
        customers.add(customer);
        customersMap.put(customer.getId(), customer);
    }

    public boolean removeCustomer(T customer) {
        customersMap.remove(customer.getId());
        return customers.remove(customer);
    }

    public ArrayList<T> getCustomers() {

        ArrayList<T> customersList = new ArrayList<>(customers);
        Collections.sort(customersList, (Comparator<Object>) (o1, o2) -> ((Customer) o2).getId() - ((Customer) o1).getId());
        return customersList;
    }

    public T findCustomerById(int id) throws CustomerNotFoundException {

        T customer = customersMap.get(id);


        if (customer == null)
            throw new CustomerNotFoundException();
        else
            return customer;
    }

    public Operation rollback(Customer customer) {
        if (customer.getOperationStack().isEmpty())
            return null;


        Operation operation = customer.getOperationStack().pop();
        operation.rollback();
        return operation;
    }

  /*  public Operation rollback(){

    }*/


    /*public void saveCustomers(){
        File file = new File("Customers.cd");
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            StringBuilder stringBuilder = new StringBuilder();

            for (Customer customer:customers){
                stringBuilder.append(customer.getId()).append(",")
                        .append(customer.getBalance()).append(",")
                        .append(customer.getFirstName()).append(",")
                        .append(customer.getLastName()).append(",")
                        .append(customer.getAddress()).append("\n");
            }
            bufferedWriter.write(stringBuilder.toString());

            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

    /*public void loadCustomers(){
        customers.clear();

        File file = new File("Customers.cd");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                if (!line.isEmpty()){
                    String[] customerDetails = line.split(",");
                    Customer customer =createCustomer(Integer.parseInt(customerDetails[0]),customerDetails[2],customerDetails[3]);
                    customer.setBalance(Long.parseLong(customerDetails[1]));
                    customer.setAddress(customerDetails[4]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    /*public void saveCustomersObject(){
        try {
            File file = new File("Customers.cd");
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            outputStream.writeObject(customers.get(1));


            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Customer customer = (Customer) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/


}
