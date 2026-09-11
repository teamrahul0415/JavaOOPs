package Exception;

import java.util.*;

public class predefinedExcep {

    public static void main(String[] args) {

        int[] nums = {1, 2, 34, 6, 78, 77};

        Scanner sc = new Scanner(System.in);

        try {
            int i = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(nums[i]);
            System.out.println(nums[b] / b);
        }

        catch (ArithmeticException e) {
            System.out.println("Exception caught is " + e.getMessage());
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught is " + e.getMessage());
        }

        finally {
            sc.close();
            System.out.println("Finally Excuted");
        }
    }
}