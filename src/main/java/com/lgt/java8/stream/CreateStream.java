package com.lgt.java8.stream;

import com.lgt.java8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        //可以通过Collection系列集合提供的stream()或parallelStream()
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        //通过Arrays中的静态方法stream()获取数组流
        Employee[] employees = new Employee[11];
        Stream<Employee> stream2 = Arrays.stream(employees);
        //通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        //创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);

    }
}
