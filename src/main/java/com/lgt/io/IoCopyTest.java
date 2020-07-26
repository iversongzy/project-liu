package com.lgt.io;

import java.io.*;

public class IoCopyTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("G:\\IdeaProjects\\lgt\\why.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("G:\\IdeaProjects\\lgt\\copy.txt"));

        String context;
        while ((context = br.readLine())!=null) {
            bw.write(context);
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
