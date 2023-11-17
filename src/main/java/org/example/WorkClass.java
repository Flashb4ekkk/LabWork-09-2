package org.example;

import java.util.Scanner;

import static org.example.ActionsWithStudents.*;

public class WorkClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scan.nextInt();
        Student[] students = new Student[n];
        initArray(students);
        printArray(students);
        //task 1
        System.out.println("number of \"satisfactory\" marks: " + searchGoodMarks(students));
        System.out.println("student which get 4 & 5 marks: " + String.join(", ", searchSecondNameOfStudents(students)));

        //task 2
        sortStudents(students);
        printArray(students);

        initArray(students);
        printArray(students);
        Integer[] indices = createIndexArray(students.length);
        sortIndices(indices, students);
        printArrayByIndices(indices, students);


        sortStudents(students);
        printArray(students);
        String targetSecondName = "Melnyk";
        specialication targetSpecialty = specialication.CS;
        int targetPhysicsMark = 3;
        System.out.println("student with parameters: " + "secondName: " + targetSecondName + ", specialication: " + targetSpecialty +
                ", phycics mark: " + targetPhysicsMark + ": " + binarySearch(students, targetSecondName, targetSpecialty, targetPhysicsMark));
    }

    public static String[] searchSecondNameOfStudents(Student[] ar) {
        String[] matchingSecondNames = new String[ar.length];
        int count = 0;
        for (Student st : ar) {
            if ((st.getMarksPhysics() == 4 || st.getMarksPhysics() == 5) && (st.getMarksMathematics() == 4 || st.getMarksMathematics() == 5)) {
                matchingSecondNames[count++] = st.getSecondName();
            }
        }
        if (count == 0) {
            return new String[]{"there are no such students"};
        } else {
            String[] result = new String[count];
            System.arraycopy(matchingSecondNames, 0, result, 0, count);
            return result;
        }
    }

    public static int searchGoodMarks(Student[] ar){
        int goodMark = 0;
        for (Student student : ar) {
            if (student.getMarksPhysics() >= 3) {
                goodMark++;
            }
            if (student.getMarksMathematics() >= 3) {
                goodMark++;
            }
            if (student.getMarksProgramming() >= 3) {
                goodMark++;
            }
        }
        return goodMark;
    }

    public static void initArray(Student[] ar){
        for(int i = 0; i < ar.length; i++){
            ar[i] = new Student();
        }
    }

    public static void printArray(Student[] arr) {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("| " + String.format("%2s", "№") + " | " + String.format("%13s", "secondName") + " | " + String.format("%6s", "course") +
                " | " + String.format("%9s", "specialty") + " | " + String.format("%8s", "physics") + " | " + String.format("%11s", "Mathematics") +
                " | " + String.format("%11s", "programming") + " | " + String.format("%17s", "numerical methods") + " | " + String.format("%9s", "pedagogy") + " |");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Student st : arr) {
            System.out.println(st);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }
}
