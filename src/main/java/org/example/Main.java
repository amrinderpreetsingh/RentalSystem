package org.example;

import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Rental Management System");
        View view = new View();
        view.menu();
    }
}