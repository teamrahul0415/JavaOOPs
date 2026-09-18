// package QPrac;

// public class RentalTest {
//     public static void main(String[] args) {
//         Rentable car = new car();
//         Rentable bike = new bike();
 
//         double carRent = car.calculateRent(3);
//         double bikeRent = bike.calculateRent(2);
 
//         // System.out.println("Car rent incl. tax: " + (carRent + carRent * car.TAX_RATE));
//         // System.out.println("Bike rent incl. tax: " + (bikeRent + bikeRent * bike.TAX_RATE));
//         System.out.println("Total vehicles rented: " + car.totalVehiclesRented);
//     }
// }

// interface Rentable{
//     double calculateRent(int days); 
// }

// class car implements Rentable{
//     static int totalVehiclesRented=0;

// public double calculateRent(int days){
//     totalVehiclesRented++;
//     return 1500*days;
// }
// }

// class bike implements Rentable{
//     // static int totalVehiclesRented=0;

// public double calculateRent(int days){
//     car.totalVehiclesRented++;
//     return 500*days;
// }
// }
    
interface Rentable {

    double calculateRent(int days);
}


class Car implements Rentable {

    static int totalVehiclesRented = 0;
    static final double TAX_RATE = 0.05;

    @Override
    public double calculateRent(int days) {

        totalVehiclesRented++;

        return 1500 * days;
    }
}


class Bike implements Rentable {

    static int totalVehiclesRented = 0;
    static final double TAX_RATE = 0.05;

    @Override
    public double calculateRent(int days) {

        totalVehiclesRented++;

        return 500 * days;
    }
}


public class RentalTest {

    public static void main(String[] args) {

        Rentable car = new Car();
        Rentable bike = new Bike();

        double carRent = car.calculateRent(3);
        double bikeRent = bike.calculateRent(2);

        System.out.println(
            "Car rent incl. tax: "
            + (carRent + carRent * Car.TAX_RATE)
        );

        System.out.println(
            "Bike rent incl. tax: "
            + (bikeRent + bikeRent * Bike.TAX_RATE)
        );

        System.out.println(
            "Total vehicles rented: "
            + Car.totalVehiclesRented
        );
    }
}