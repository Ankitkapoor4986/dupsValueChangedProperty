package com.ankit.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ankit on 23/9/16.
 */
public class MainClass {
    public static void main(String[] args) {
        Map<String,Set<String>> lineMap=new HashMap<>();
        System.out.println("Starting....");
        try(BufferedReader br=new BufferedReader(new FileReader("/home/ankit/Desktop/pppchanges.txt"))){
            String sCurrentLine;

            while (((sCurrentLine = br.readLine()) != null)) {
                if ((sCurrentLine.startsWith("-") ||
                        sCurrentLine.startsWith("+")) && sCurrentLine.contains("=")) {

                    if (sCurrentLine.startsWith("-")) {
                        sCurrentLine = sCurrentLine.replace("-", "").trim();
                    }
                    if (sCurrentLine.startsWith("+")) {
                        sCurrentLine = sCurrentLine.replace("+", "").trim();
                    }
                    System.out.println(sCurrentLine);

                    String[] keyValPair = sCurrentLine.split("=");
                    Set<String> lineSet;
                    lineSet = lineMap.get(keyValPair[0]);

                    if (lineSet == null) {
                        lineSet = new HashSet<>();
                        lineMap.put(keyValPair[0], lineSet);
                    }
                    if(keyValPair.length==2) {
                        lineSet.add(keyValPair[1]);
                    }
                    else{
                        lineSet.add("");
                    }

                }
            }
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");
            System.out.println("__________________________________________________________________");




            List<String> duplicatePropertyWhoseValuesChanged = lineMap.
                    entrySet().stream().
                    filter(entry -> entry.getValue().size() == 2)
                    .map(entry -> entry.getKey()).collect(Collectors.toList());

            duplicatePropertyWhoseValuesChanged.forEach(
                    s->System.out.println(s)
            );
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
