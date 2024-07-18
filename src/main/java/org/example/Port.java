package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Port {
    private String[] index;

    public Port(String[] index) {
        this.index = index;
    }

    public Port() {
    }

    //{"1,3-5", "2", "3-4"}
    public List<List<Integer>> convert(String[] indexes) {
        List<List<Integer>> result = new ArrayList<>();
        for (String index : indexes) {
            List<Integer> number = new ArrayList<>();
            String[] parts = index.split(",");

            for (String part : parts) {
                if (part.contains("-")) {
                    String[] part_2 = part.split("-");
                    int start = Integer.parseInt(part_2[0]);
                    int end = Integer.parseInt(part_2[1]);

                    for (int i = start; i <= end; i++) {
                        number.add(i);
                    }
                } else {
                    number.add(Integer.parseInt(part));
                }
            }
            result.add(number);
        }
        System.out.println(result + "++++++++++++");
        return result;
    }

    //{"1,3-5", "2", "3-4"}

    public List<Integer> convert2(String[] indexes) {
        List<Integer> result = new ArrayList<>();
        for (String index : indexes) {
            List<Integer> number = new ArrayList<>();
            String[] parts = index.split(",");

            for (String part : parts) {
                if (part.contains("-")) {
                    String[] part_2 = part.split("-");
                    int start = Integer.parseInt(part_2[0]);
                    int end = Integer.parseInt(part_2[1]);

                    for (int i = start; i <= end; i++) {
                        number.add(i);
                    }
                } else {
                    number.add(Integer.parseInt(part));
                }
            }
            result.addAll(number);
        }
        return result.stream().sorted().distinct().collect(Collectors.toList());
    }

    public List<List<Integer>> uniqueСombination(String[] indexes) {
        List<List<Integer>> list = convert(indexes);
        List<List<Integer>> result = new ArrayList<>();
        uniqueСombinationReqursion(list, new ArrayList<>(), 0, result);

        return result;
    }

    private void uniqueСombinationReqursion(List<List<Integer>> list, List<Integer> arr, int index, List<List<Integer>> result) {

        if (index == list.size()){
            result.add(new ArrayList<>(arr));
            return;
        }

        for(Integer i : list.get(index)){
            arr.add(i);
            uniqueСombinationReqursion(list, arr, index + 1,  result);
            arr.remove(arr.size()-1);
        }
    }
}

