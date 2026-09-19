package Collection_Framework;

// A student can register for multiple courses, but the same course cannot be registered twice.
// Driver Code
import java.util.*;

public class CourseRegistration {

    public static void registerCourse(Set<String> courses, String course) {

        // Write your code
        courses.add(course);
    }

    public static boolean isRegistered(Set<String> courses, String course) {
        // Write your code
        return courses.contains(course);
        // return false;
    }

    public static void dropCourse(Set<String> courses, String course) {
        // Write your code
        courses.remove(course);

    }

    public static void displayCourses(Set<String> courses) {
        // Write your code
        // for(String val : courses){
        //     System.out.println(val);
        // }
        System.out.println(courses);
    }

    public static void main(String[] args) {

        Set<String> courses = new HashSet<>();

        registerCourse(courses, "Java");
        registerCourse(courses, "Python");
        registerCourse(courses, "DBMS");
        registerCourse(courses, "Java");

        System.out.println("Courses:");
        displayCourses(courses);

        System.out.println("Python registered: "
                + isRegistered(courses, "Python"));

        dropCourse(courses, "DBMS");

        System.out.println("After dropping DBMS:");
        displayCourses(courses);
    }
}

