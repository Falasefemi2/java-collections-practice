package com.project.studentmanagement;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private String id;
    private String name;
    private Map<String, Integer> subjectScores;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.subjectScores = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSubjectScores() {
        return subjectScores;
    }

    public int getTotalScore() {
        int total = 0;
        for (Map.Entry<String, Integer> score : subjectScores.entrySet()) {
            total += score.getValue();
        }
        return total;
    }

    public int getAverageScore() {
        if (subjectScores.isEmpty()) {
            return 0;
        }
        int total = getTotalScore();
        return total / subjectScores.size();
    }

}
