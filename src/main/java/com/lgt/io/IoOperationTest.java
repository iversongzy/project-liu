package com.lgt.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IoOperationTest {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("G:\\IdeaProjects\\lgt\\why.txt");
        fileWriter.write("I love you!");
        fileWriter.flush();
        fileWriter.close();

        FileReader fileReader = new FileReader("G:\\IdeaProjects\\lgt\\why.txt");
        int ch;
        while((ch = fileReader.read()) != -1){
            System.out.print((char)ch);
        }
        fileReader.close();
    }
}
