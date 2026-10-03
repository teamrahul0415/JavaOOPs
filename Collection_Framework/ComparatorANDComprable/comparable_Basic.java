import java.util.*;
public class comparable_Basic {

    public static class Student implements Comparable<Student>{
        String name;
        int rollNo;
        int marks;

        public Student(String name, int rollNo, int marks){
            this.name=name;
            this.rollNo=rollNo;
            this.marks=marks;
        }
        //COMPARE OR SORT  BY ROLLNO OR MARKS
        // @Override 
        // public int compareTo(Student that){
        //     return this.rollNo-that.rollNo;
        // }

        //COMPARE OR SORT BY NAME  OR WE CAN SAY STRING
        
        @Override 
        public int compareTo(Student that){
            return this.name.compareTo(that.name);
        }
        @Override 
        public String toString(){
            return name+" "+rollNo+" "+marks;
        }
    }
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();

        list.add(new Student("Rahul",5,98));
        list.add(new Student("Satyam",3,99));
        list.add(new Student("Prince",1,95));

        Collections.sort(list);

        System.out.println(list);


        
    }
    
    
}
