package QPrac;

abstract class Shape {

    // Abstract method then class v abstract hona chaiye...
    abstract double area();

    void displayArea() {
        System.out.println("Area = " + area());
    }
}


class Circle extends Shape {

    double radius;

    // now we make const..
    Circle(double radius) {
        this.radius = radius;
    }

   //override ho rha h.
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape {

    double length;
    double width;

    // Constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // yaha v override ho rha h...
    @Override
    double area() {
        return length * width;
    }
}


public class ShapeAreaCal {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        // Circle  ka object using parent as a refernce..
        shapes[0] = new Circle(5.0);

        // Rectangle ka object using parent as reference ....
        shapes[1] = new Rectangle(4.0, 6.0);

        // Loop
        for (Shape s : shapes) {

            s.displayArea();
        }
    }
}