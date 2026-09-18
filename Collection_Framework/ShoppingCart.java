package Collection_Framework;

import java.util.*;

public class ShoppingCart {

    public static void addProduct(List<String> cart, String product) {
        cart.add(product);
        // Write your code
    }

    public static void removeProduct(List<String> cart, String product) {
        cart.remove(product);
        // Write your code
    }

    public static int countProduct(List<String> cart, String product) {
        int count=0;
        for(String val : cart){
            if(product.equals(val)){
                count++;
            }
        }
        // Write your code
        return count;
    }

    public static void displayCart(List<String> cart) {
        Iterator<String> it = cart.iterator();
        while(it.hasNext()){
            String product=it.next();
            System.out.println(product);
        }
        // Write your code
    }

    public static void main(String[] args) {

        List<String> cart = new ArrayList<>();

        addProduct(cart, "Laptop");
        addProduct(cart, "Mouse");
        addProduct(cart, "Keyboard");
        addProduct(cart, "Mouse");
        addProduct(cart, "Mouse");

        System.out.println("Cart:");
        displayCart(cart);

        System.out.println("Mouse quantity: "
                + countProduct(cart, "Mouse"));

        removeProduct(cart, "Mouse");

        System.out.println("After removing one Mouse:");
        displayCart(cart);
    }
}

