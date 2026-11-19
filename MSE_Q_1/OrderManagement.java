
import java.sql.*;
import java.util.Scanner;

public class OrderManagement {

    static final String URL =
        "jdbc:mysql://localhost:3305/ecommerce_db";

    static final String USER = "root";
    static final String PASSWORD = "Team@0415";

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(
                 URL, USER, PASSWORD)) {

            System.out.println("Database Connected!");

            int choice;

            do {
                System.out.println("\n--- ORDER MANAGEMENT ---");
                System.out.println("1. Insert Orders");
                System.out.println("2. Display Orders");
                System.out.println("3. Increase Quantity");
                System.out.println("4. Update Status");
                System.out.println("5. Total Value and Delete");
                System.out.println("0. Exit");

                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    
                    case 1:

                        String insert = "INSERT INTO Orders "
                            + "VALUES (?, ?, ?, ?, ?, ?)";

                        try (PreparedStatement ps =
                             con.prepareStatement(insert)) {

                            for (int i = 1; i <= 3; i++) {

                                System.out.println("Enter Order " + i);

                                System.out.print("Order ID: ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Customer Name: ");
                                String name = sc.nextLine();

                                System.out.print("Product Name: ");
                                String product = sc.nextLine();

                                System.out.print("Quantity: ");
                                int qty = sc.nextInt();

                                System.out.print("Unit Price: ");
                                double price = sc.nextDouble();
                                sc.nextLine();

                                System.out.print("Status: ");
                                String status = sc.nextLine();

                                Order o = new Order(
                                    id, name, product,
                                    qty, price, status
                                );

                                ps.setInt(1, o.getOrderId());
                                ps.setString(2, o.getCustomerName());
                                ps.setString(3, o.getProductName());
                                ps.setInt(4, o.getQuantity());
                                ps.setDouble(5, o.getUnitPrice());
                                ps.setString(6, o.getStatus());

                                try {
                                    ps.executeUpdate();
                                    System.out.println("Order Inserted");
                                }
                                catch (SQLException e) {
                                    if ("23000".equals(e.getSQLState())) {
                                        System.out.println("Duplicate Order ID!");
                                    } else {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                        }
                        break;


                    
                    case 2:

                        System.out.print("Enter Status: ");
                        String status = sc.nextLine();

                        String select = "SELECT * FROM Orders "
                            + "WHERE status = ? AND quantity > 2 "
                            + "ORDER BY unit_price DESC";

                        try (PreparedStatement ps =
                             con.prepareStatement(select)) {

                            ps.setString(1, status);

                            try (ResultSet rs = ps.executeQuery()) {

                                while (rs.next()) {

                                    Order o = new Order(
                                        rs.getInt("order_id"),
                                        rs.getString("customer_name"),
                                        rs.getString("product_name"),
                                        rs.getInt("quantity"),
                                        rs.getDouble("unit_price"),
                                        rs.getString("status")
                                    );

                                    o.display();
                                }
                            }
                        }
                        break;


                
                    case 3:

                        System.out.print("Enter Order ID: ");
                        int id = sc.nextInt();

                        System.out.print("Quantity to Add: ");
                        int qty = sc.nextInt();

                        if (qty <= 0) {
                            System.out.println("Invalid Quantity");
                            break;
                        }

                        String update = "UPDATE Orders "
                            + "SET quantity = quantity + ? "
                            + "WHERE order_id = ?";

                        try (PreparedStatement ps =
                             con.prepareStatement(update)) {

                            ps.setInt(1, qty);
                            ps.setInt(2, id);

                            if (ps.executeUpdate() > 0) {
                                System.out.println("Quantity Updated");
                            } else {
                                System.out.println("Order Not Found");
                            }
                        }
                        break;


                    
                    case 4:

                        System.out.print("Enter Order ID: ");
                        int oid = sc.nextInt();
                        sc.nextLine();

                        String find = "SELECT * FROM Orders "
                            + "WHERE order_id = ?";

                        try (PreparedStatement ps =
                             con.prepareStatement(find)) {

                            ps.setInt(1, oid);

                            try (ResultSet rs = ps.executeQuery()) {

                                if (rs.next()) {

                                    Order o = new Order(
                                        rs.getInt("order_id"),
                                        rs.getString("customer_name"),
                                        rs.getString("product_name"),
                                        rs.getInt("quantity"),
                                        rs.getDouble("unit_price"),
                                        rs.getString("status")
                                    );

                                    System.out.println("Current Order:");
                                    o.display();

                                    System.out.print("New Status: ");
                                    String ns = sc.nextLine();

                                    if (ns.equalsIgnoreCase("Pending") ||
                                        ns.equalsIgnoreCase("Shipped") ||
                                        ns.equalsIgnoreCase("Delivered") ||
                                        ns.equalsIgnoreCase("Cancelled")) {

                                        String q = "UPDATE Orders "
                                            + "SET status = ? "
                                            + "WHERE order_id = ?";

                                        try (PreparedStatement ps2 =
                                             con.prepareStatement(q)) {

                                            ps2.setString(1, ns);
                                            ps2.setInt(2, oid);
                                            ps2.executeUpdate();

                                            System.out.println("Status Updated");
                                        }
                                    } else {
                                        System.out.println("Invalid Status");
                                    }

                                } else {
                                    System.out.println("Order Not Found");
                                }
                            }
                        }
                        break;

                    case 5:

                        String sum = "SELECT SUM(quantity * unit_price) "
                            + "AS total FROM Orders";

                        try (PreparedStatement ps =
                             con.prepareStatement(sum);
                             ResultSet rs = ps.executeQuery()) {

                            if (rs.next()) {
                                System.out.println("Total Order Value: "
                                    + rs.getDouble("total"));
                            }
                        }

                        System.out.print("Enter Order ID to Delete: ");
                        int did = sc.nextInt();

                        String delete = "DELETE FROM Orders "
                            + "WHERE order_id = ? "
                            + "AND status = 'Cancelled'";

                        try (PreparedStatement ps =
                             con.prepareStatement(delete)) {

                            ps.setInt(1, did);

                            if (ps.executeUpdate() > 0) {
                                System.out.println("Order Deleted");
                            } else {
                                System.out.println(
                                    "Cannot Delete: Order not found "
                                    + "or not Cancelled"
                                );
                            }
                        }
                        break;


                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while (choice != 0);

        }
        catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
