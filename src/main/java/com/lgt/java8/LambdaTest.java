package com.lgt.java8;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {


    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee("guo", 28, 2111),
                new Employee("liu", 18, 1111),
                new Employee("tai", 38, 3111)
        );
        Collections.sort(employeeList, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return Integer.compare(x.getSalary(), y.getSalary());
            } else {
                return -Integer.compare(x.getAge(), y.getAge());
            }
        });
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
    

}

