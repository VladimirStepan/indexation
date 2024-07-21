package org.example;

import java.util.*;

public class Port {
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
        return result;
    }

    public List<List<Integer>> uniqueСombination(String[] indexes) {
        List<List<Integer>> list = convert(indexes);
        List<List<Integer>> result = new ArrayList<>();
        uniqueСombinationReqursion(list, new ArrayList<>(), 0, result);

        return result;
    }

    private void uniqueСombinationReqursion(List<List<Integer>> list, List<Integer> arr, int index, List<List<Integer>> result) {

        if (index == list.size()) {
            result.add(new ArrayList<>(arr));
            return;
        }

        for (Integer i : list.get(index)) {
            arr.add(i);
            uniqueСombinationReqursion(list, arr, index + 1, result);
            arr.remove(arr.size() - 1);
        }
    }
}

