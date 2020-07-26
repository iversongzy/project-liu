package com.lgt.studentmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        while (true) {
            System.out.println("Welcome to use student manager system!");
            System.out.println("1.Check student message!");
            System.out.println("2.Add student message!");
            System.out.println("3.Delete student message!");
            System.out.println("4.Change student message!");
            System.out.println("please input num: ");
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            switch (index) {
                case 1:
                    findAllStudentMessage(students);
                    break;
                case 2:
                    addStudentMessage(students, sc);
                    break;
                case 3:
                    deleteStudentMessage(students, sc);  
                    break;
                case 4:
                    changeStudentMessage(students, sc);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("input num error!");
                    break;
            }
        }
    }

    private static void changeStudentMessage(ArrayList<Student> students, Scanner sc) {
        System.out.println("please input deleted id");
        int id = sc.nextInt();
        int flag = -1;
        for(Student student : students) {
            if(student.getId() == id){
                flag = id;
                System.out.println("input name: ");
                student.setName(sc.nextLine());
                System.out.println("input age: ");
                student.setAge(sc.nextInt());
                System.out.println("input address: ");
                student.setAddress(sc.nextLine());
            }
        }
        if(flag == -1){
            System.out.println("input num error.");
        }
    }

    private static void deleteStudentMessage(ArrayList<Student> students, Scanner sc) {
        System.out.println("please input deleted id");
        int id = sc.nextInt();
        int flag = -1;
        for(Student student : students) {
            if(student.getId() == id){
                flag = id;
                students.remove(student);
            }
        }
        if(flag == -1){
            System.out.println("input num error.");
        }
    }

    private static void addStudentMessage(ArrayList<Student> students, Scanner sc) {
        System.out.println("input id");
        int id = sc.nextInt();
        System.out.println("input name");
        String name = sc.nextLine();
        System.out.println("input age");
        int age = sc.nextInt();
        System.out.println("input address");
        String address = sc.nextLine();
        Student student = new Student(id, name, age, address );
        students.add(student);
    }

    private static void findAllStudentMessage(ArrayList<Student> students) {
        if (students.size() <= 0) {
            System.out.println("No date.");
        } else {
            for (Student student : students) {
                System.out.println(student.getId() + student.getName() + student.getAge()
                        + student.getAddress());
            }
        }
    }
}
