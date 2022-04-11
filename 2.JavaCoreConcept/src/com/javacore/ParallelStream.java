package com.javacore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ParallelStream {


    public List<String> stringTransform(List<String> namesList) {
        return namesList.stream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Bob", "Jamie", "Jill", "Rick");
        ParallelStream parallelStreamsExample = new ParallelStream();
        List<String> resultList = parallelStreamsExample.stringTransform(namesList);
        System.out.println("Final Result : " + resultList);
    }

    private String addNameLengthTransform(String name) {
        return name.length() + name;
    }
}
