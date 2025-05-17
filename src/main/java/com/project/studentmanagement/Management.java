package com.project.studentmanagement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Management {

    private Map<String, Student> students = new LinkedHashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void registerStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine().trim();

        if (students.containsKey(id)) {
            System.out.println("Student already exits with ID: " + id);
        }

        System.out.println("Enter student name: ");
        String name = scanner.nextLine().trim();

        Student student = new Student(id, name);
        students.put(id, student);
        System.out.println("Student added sccessfully");
    }

    public void addSubjectScore() {
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine().trim();

        if (!students.containsKey(id)) {
            System.out.println("No student available with ID; " + id);
            return;
        }

        System.out.println("Enter subject name: ");
        String subject = scanner.nextLine().trim();

        Student student = students.get(id);
        if (student.getSubjectScores().containsKey(subject)) {
            System.out.println("Student already has a score for " + subject);
            System.out.println("Do you want to update the score(yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                System.out.println("Subject updated cancelled");
                return;
            }
        }

        System.out.println("Enter score between 1-100");
        int score;
        try {
            score = Integer.parseInt(scanner.nextLine().trim());
            if (score < 0 || score > 100) {
                System.out.println("Score must be between 0 and 100");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number input");
            return;
        }

        student.getSubjectScores().put(subject, score);
        System.out.println("Score added/updatd for " + student.getName() + " in " + subject);
    }

    public void viewAllStudents() {
        System.out.println("All Students");
        for (Map.Entry<String, Student> student : students.entrySet()) {
            Object key = student.getKey();
            Object val = student.getValue();
            System.out.println("ID: " + key + " NAME: " + val);
        }
    }

    public void searchStudent() {
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine().trim();

        Student student = students.get(id);

        if (student == null) {
            System.out.println("No student found with ID: " + id);
            return;
        }

        System.out.println("Student Info");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Subjects & Scores: " + student.getSubjectScores());
        System.out.println("Total Score: " + student.getTotalScore());
        System.out.println("Average Score: " + student.getAverageScore());
    }

    public void showTopScorer() {
        if (students.isEmpty()) {
            System.out.println("No students registered");
            return;
        }

        Student topScorer = null;
        int highestAverage = -1;

        for (Student student : students.values()) {
            int avg = student.getAverageScore();
            if (avg > highestAverage) {
                highestAverage = avg;
                topScorer = student;
            }
        }

        if (topScorer != null) {
            System.out.println("Top Scorer");
            System.out.println("ID: " + topScorer.getId());
            System.out.println("Name: " + topScorer.getName());
            System.out.println("Average Score: " + highestAverage);
            System.out.println("Subject & Scores: " + topScorer.getSubjectScores());
        }
    }
}
