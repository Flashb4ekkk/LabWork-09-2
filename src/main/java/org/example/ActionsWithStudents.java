package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class ActionsWithStudents {
    //task 1
    public static void sortStudents(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int physicsCompare = Integer.compare(s1.getMarksPhysics(), s2.getMarksPhysics());
                if (physicsCompare != 0) {
                    return physicsCompare;
                }
                int specialtyCompare = s1.getSpecialty().compareTo(s2.getSpecialty());
                if (specialtyCompare != 0) {
                    return specialtyCompare;
                }
                return s1.getSecondName().compareTo(s2.getSecondName());
            }
        });
    }

    //task 2
    public static Integer[] createIndexArray(int length) {
        Integer[] indices = new Integer[length];
        for (int i = 0; i < length; i++) {
            indices[i] = i;
        }
        return indices;
    }

    public static void sortIndices(Integer[] indices, Student[] students) {
        Arrays.sort(indices, Comparator
                .comparing((Integer i) -> students[i].getMarksPhysics())
                .thenComparing(i -> students[i].getSpecialty())
                .thenComparing(i -> students[i].getSecondName()));
    }

    public static void printArrayByIndices(Integer[] indices, Student[] students) {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("| " + String.format("%2s", "№") + " | " + String.format("%13s", "secondName") + " | " + String.format("%6s", "course") +
                " | " + String.format("%9s", "specialty") + " | " + String.format("%8s", "physics") + " | " + String.format("%11s", "Mathematics") +
                " | " + String.format("%11s", "programming") + " | " + String.format("%17s", "numerical methods") + " | " + String.format("%9s", "pedagogy") + " |");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for (Integer index : indices) {
            System.out.println(students[index]);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

    //task 3
    public static boolean binarySearch(Student[] students, String secondName, specialication specialication, int physicsMark) {
        int L = 0, R = students.length - 1, m;
        do {
            m = (L + R) / 2;
            if (students[m].getMarksPhysics() == physicsMark && students[m].getSpecialty().equals(specialication) && students[m].getSecondName().equals(secondName)) {
                return true;
            }
            if ((students[m].getMarksPhysics() < physicsMark)
                    || (students[m].getMarksPhysics() == physicsMark && students[m].getSpecialty().compareTo(specialication) < 0)
                    || (students[m].getMarksPhysics() == physicsMark && students[m].getSpecialty().equals(specialication) && students[m].getSecondName().compareTo(secondName) < 0)) {
                L = m + 1;
            } else {
                R = m - 1;
            }
        } while (L <= R);
        return false;
    }
}
