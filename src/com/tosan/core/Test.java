/*
package com.tosan.core;

import com.tosan.core.account.RialAccount;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(250);
        list.add(600);
        list.add(-1);

        Number max = getMax(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        System.out.print(max);


        List<String> list2 = new ArrayList<>();

        list.add("250");
        list.add("600");
        list.add("-1");

        String max2 = getMax(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.print(max);


        add(list);

    }

    public static <T> T getMax(List<T> list, Comparator<T> comparator) {
        T max = null;


        //Collections.max()

        for (T element : list) {
            if (max == null || comparator.compare(element, max) > 0)
                max = element;
        }

        return max;
    }


    public static double add(List<? super Integer> numbers){
        double sum=0;
        for (Number a: numbers)
            sum += a.doubleValue();

        return sum;
    }
}
*/
