package com.marcos.livraria.util.db;

import java.util.Scanner;

public class ClassScanner {
    private static Scanner scanner = null;

    public static Scanner getScanner(){
        if(scanner == null) {
            scanner = new Scanner(System.in);
            return scanner;
        } else return scanner;
    }

    public static void closeScanner(){
        if(scanner != null) {
            scanner.close();
        }
    }
}
