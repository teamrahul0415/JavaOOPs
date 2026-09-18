package Exception_Handling;

import java.util.Scanner;

public class AgeValidation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int age =sc.nextInt();
        try{

            //we make a user defind method for exception
            ageCheck(age);
        }
        catch(InvalidAgeException e){
            System.out.println("Invalid age");
        }
        finally{
            System.out.println("It alwayes executed");
        }
    }
    static void ageCheck(int a) throws InvalidAgeException{
        if(a<18) throw new InvalidAgeException("Age is Invalid");
        System.out.println("Eligible to vote");
    }
    
}
//make class for invalid age exception
class InvalidAgeException extends Exception{     //checked exception
    //const...
    InvalidAgeException(String msg){
        super(msg);
    }
}
