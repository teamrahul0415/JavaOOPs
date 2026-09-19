package Collection_Framework;

import java.util.*;

public class AttendanceSystem {

    public static void markAttendance(Set<Integer> attendance,  int studentId) {
        attendance.add(studentId);
        // Write your code
    }

    public static boolean isPresent(Set<Integer> attendance,int studentId) {
        // Write your code
        return attendance.contains(studentId);
        // return false;
        
    }

    public static int getAttendanceCount(Set<Integer> attendance) {
        // Write your code
        return attendance.size();
        // return 0;
    }

    public static void displayAttendance(Set<Integer> attendance) {
        // Write your code
        System.out.println(attendance);
    }

    public static void main(String[] args) {

        Set<Integer> attendance = new LinkedHashSet<>();

        markAttendance(attendance, 105);
        markAttendance(attendance, 102);
        markAttendance(attendance, 108);
        markAttendance(attendance, 105);
        markAttendance(attendance, 101);

        displayAttendance(attendance);

        System.out.println("Student 108 present: "
                + isPresent(attendance, 108));

        System.out.println("Total Present: "
                + getAttendanceCount(attendance));
    }
}

