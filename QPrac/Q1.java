package QPrac;

     // Define the Person class
class Person {
    // Declare a private variable to store the name of the person
    private String name;
    // Declare a private variable to store the age of the person
    private int age;

    // Constructor for the Person class that initializes the name and age variables
    public Person(String name, int age) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the age variable to the provided age parameter
        this.age = age;
    }

    // Method to retrieve the name of the person
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to retrieve the age of the person
    public int getAge() {
        // Return the value of the age variable
        return age;
    }

    // Method to set the name of the person
    public void setName(String name) {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to set the age of the person
    public void setAge(int age) {
        // Set the age variable to the provided age parameter
        this.age = age;
    }
}

public class Q1 {
    // Define the main method which is the entry point of the program
    public static void main(String[] args) {
        // Create an instance of the Person class with the name "Rahul Kumar" and age 19
        Person person1 = new Person("Rahul Kumar", 19);
        // Create another instance of the Person class with the name "Ishika" and age 18
        Person person2 = new Person("Ishika", 18);

        // Print the name and age of person1 to the console
        System.out.println(person1.getName() + " is " + person1.getAge() + " years old.");
        // Print the name and age of person2 to the console
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old.\n");

        // Modify the age of person1 using the setter methods
        person1.setAge(14);
        // Modify the name and age of person2 using the setter methods
        person2.setName("Aman");
        person2.setAge(12);
        System.out.println("Set new age and name:");
        // Print the updated name and age of person1 to the console
        System.out.println(person1.getName() + " is now " + person1.getAge() + " years old.");
        // Print the updated name and age of person2 to the console
        System.out.println(person2.getName() + " is now " + person2.getAge() + " years old.");
    }
} 
