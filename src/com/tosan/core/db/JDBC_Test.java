package com.tosan.core.db;

import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class JDBC_Test {

    public static void connect() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();
        Scanner s = new Scanner(System.in);

        PreparedStatement pst;
        pst = con.prepareStatement("insert into emp values (?,?,?)");
        System.out.println("pls insert id");
        int i = s.nextInt();
        s.nextLine();
        System.out.println("pls insert name");
        String ss = s.nextLine();
        System.out.println("pls insert family");
        String ss1 = s.nextLine();
        pst.setString(1, i + "");
        pst.setString(2, ss);
        pst.setString(3, ss1);

        pst.executeUpdate();

        ResultSet rs = st.executeQuery("select * from emp ");
        HashMap<Integer, emp> hm = new HashMap<Integer, emp>();
        while (rs.next()) {

            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

            hm.put(rs.getInt(1), new emp(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }
        con.close();
        st.close();
        System.out.println("_____________________");
        System.out.println(hm.size());
        for (emp o : hm.values()
        ) {
            System.out.println(o.getFamily() + " " + o.getName() + " " + o.getId());
        }
    }


    public static void main(String[] args) {
        try {
            JDBC_Test.connect();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

}