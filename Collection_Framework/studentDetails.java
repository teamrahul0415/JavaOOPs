package Collection_Framework;
import java.util.*;

class student{
    String name;
    int rollno;
    int marks;

    student(String name, int rollno ,int marks){
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;
    }

    void display(){
        System.out.println("student name is "+name);
        System.out.println("student roll is "+rollno);
        System.out.println("student marks is "+marks);
    }
    
}
public class studentDetails {
    public static void main(String[] args) {
        //now we make to studnet class ke array list
        List<student> li= new LinkedList<>();
        li.add(new student("Rahul", 2,90));
        li.add(new student("Aman" ,5,98));
        li.add(new student("Ishika" ,1,100));

        // System.out.println(li);


        // Iterator<student> it = li.iterator(); 
        // while (it.hasNext()) { 
        //     student s = it.next(); 
        //     s.display();
        // }

        for(student val : li){
            val.display();
        }
        
    }
    
}
