// package Collection_Framework.ComparatorANDComprable;
import java.util.*;

class students{
    int rollno;
    String name;
    int marks;

    students(int rollno, String name,int marks){
        this.rollno=rollno;
        this.name=name;
        this.marks=marks;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
          return rollno + " " + name + " " + marks;
    }
}
class studentcomparator implements Comparator<students>{
    @Override
    public int compare(students o1, students o2) {
        // TODO Auto-generated method stub
        if(o1.marks!=o2.marks){

        return o2.marks-o1.marks;
    }
    return o1.rollno-o2.rollno;

    }

}

class NameComparator implements Comparator<students>{
    @Override
    public int compare(students o1, students o2) {
        // TODO Auto-generated method stub
       return o2.name.compareTo(o1.name);
    }
}

public class Custom_comp2 {

    public static void main(String[] args) {
        ArrayList<students> stu=new ArrayList<>();


        stu.add(new students(10, "Rahul", 95));
        stu.add(new students(2, "Ishika", 99));
        stu.add(new students(21, "Rajan", 93));
        stu.add(new students(23, "Amar", 92));
        stu.add(new students(25, "Jay", 94));

        stu.sort(new studentcomparator());
        System.out.println(stu);

        stu.sort(new NameComparator());
        //OR
        // Collections.sort(stu, new NameComparator());
        System.out.println(stu);


      


        
    }
}
    


