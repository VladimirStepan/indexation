package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Port port = new Port(new String[]{"1-2,5-3","6,8-7"});
        Port port = new Port();
//        for(Integer integers : port.convert(new String[]{"1-2,5-3","6,8-7"}))
//            System.out.println(integers);

        List<List<Integer>> list = port.convert(new String[]{"1,3-5", "2", "3-4"});

        System.out.println("-----------"+port.convert2(new String[]{"1,3-5", "2", "3-4"}));


        System.out.println(port.uniqueСombination(new String[]{"1,3-5", "2", "3-4"}));
    }
}