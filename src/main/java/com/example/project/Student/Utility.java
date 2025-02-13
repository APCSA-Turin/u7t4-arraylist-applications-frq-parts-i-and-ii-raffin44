package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list){
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; 
            for (int j = i + 1; j < n; j++) {
                Student s1 = list.get(j);      
                Student s2 = list.get(minIndex); 
                // Sorting logic based on:
                // 1. Last name (alphabetically)
                // 2. First name (if last names are the same)
                // 3. GPA (higher first, if both names are identical)
                if (s1.getLastName().compareTo(s2.getLastName()) < 0 || 
                    (s1.getLastName().compareTo(s2.getLastName()) == 0 && s1.getFirstName().compareTo(s2.getFirstName()) < 0) ||
                    (s1.getLastName().compareTo(s2.getLastName()) == 0 && s1.getFirstName().compareTo(s2.getFirstName()) == 0 && s1.getGpa() > s2.getGpa())) {
                    minIndex = j; 
                }
            }
            Student temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
        return list; 
    }
}
