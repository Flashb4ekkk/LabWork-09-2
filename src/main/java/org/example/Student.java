package org.example;

import java.util.Random;

public class Student {
    private int numberInGroup;
    private String secondName;
    private int course;
    private specialication specialication;
    private int marksPhysics;
    private int marksMathematics;
    private int marksProgramming;
    private int marksNM;
    private int marksPedagogy;

    public Student() {
        Random ran = new Random();
        this.numberInGroup = ran.nextInt(28) + 1;
        this.secondName = randomSecondName();
        this.course = ran.nextInt(4) + 1;
        this.specialication = randomSpecialication();
        this.marksPhysics = ran.nextInt(5) + 1;
        this.marksMathematics = ran.nextInt(5) + 1;
        if(specialication == org.example.specialication.CS) {
            this.marksProgramming = ran.nextInt(5) + 1;
            this.marksNM = 0;
            this.marksPedagogy = 0;
        }
        else if( specialication == org.example.specialication.IN) {
            this.marksNM = ran.nextInt(5) + 1;
            this.marksProgramming = 0;
            this.marksPedagogy = 0;
        }
        else {
            this.marksPedagogy = ran.nextInt(5) + 1;
            this.marksProgramming = 0;
            this.marksNM = 0;
        }
    }

    public Student(String secondName, org.example.specialication specialty, int physicsMark) {
        this.secondName = secondName;
        this.specialication = specialty;
        this.marksPhysics = physicsMark;
    }

    @Override
    public String toString() {
        return String.format("| %2s | %13s | %6s | %9s | %8s | %11s | %11s | %17s | %9s |", numberInGroup, secondName, course, specialication, marksPhysics, marksMathematics, marksProgramming, marksNM, marksPedagogy);
    }

    private specialication randomSpecialication() {
        Random ran = new Random();
        specialication[] specialications = org.example.specialication.values();
        return specialications[ran.nextInt(specialications.length)];
    }

    private String randomSecondName() {
        Random ran = new Random();
        String[] secondNames = {"Shevchenko", "Kovalenko", "Boyko", "Kolesnik", "Ponomarenko", "Stepanenko", "Savchenko", "Tkachenko", "Tereshchenko", "Romanenko",
                "Lysenko", "Polishchuk", "Kryvonos", "Tkachuk", "Melnyk", "Fedorenko", "Bondarenko", "Dovzhenko", "Kushnir", "Hrytsenko"};
        return secondNames[ran.nextInt(secondNames.length)];
    }

    public int getMarksPhysics() {
        return marksPhysics;
    }

    public int getMarksMathematics() {
        return marksMathematics;
    }

    public int getMarksProgramming() {
        return marksProgramming;
    }

    public String getSecondName() {
        return secondName;
    }
    public specialication getSpecialty() {
        return specialication;
    }
}
