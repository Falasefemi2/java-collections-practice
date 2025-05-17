package com.project.studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Management management = new Management();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Register Student");
            System.out.println("2. Add Subject Score");
            System.out.println("3. View All Students");
            System.out.println("4. Search Student by ID or Name");
            System.out.println("5. Show Top Scorer");
            System.out.println("6. Exit");

            System.out.println("Choose your option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 ->
                    management.registerStudent();
                case 2 ->
                    management.addSubjectScore();
                case 3 ->
                    management.viewAllStudents();
                case 4 ->
                    management.searchStudent();
                case 5 ->
                    management.showTopScorer();
                case 6 -> {
                    System.out.println("Exiting....");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid option");
                }
            }
        }

    }
}
