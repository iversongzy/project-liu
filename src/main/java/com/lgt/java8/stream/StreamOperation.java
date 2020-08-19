package com.lgt.java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamOperation {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        strings.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

        System.out.println("_______________________");

    }
}
