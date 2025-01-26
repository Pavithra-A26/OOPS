import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SuperStore superStore = new SuperStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Super Store!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                // Registration
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Are you a Buyer or Seller? ");
                String userType = scanner.nextLine();
                superStore.register(username, password, userType);

            } else if (choice == 2) {
                // Login
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                User user = superStore.login(username, password);

                if (user != null) {
                    if (user instanceof Seller) {
                        handleSellerActions((Seller) user, superStore, scanner);
                    } else if (user instanceof Buyer) {
                        handleBuyerActions((Buyer) user, superStore, scanner);
                    }
                }
            } else if (choice == 3) {
                // Exit
                System.out.println("Thank you for using Super Store! Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleSellerActions(Seller seller, SuperStore superStore, Scanner scanner) {
        while (true) {
            System.out.println("\nSeller Actions:");
            System.out.println("1. Add Item to Inventory");
            System.out.println("2. Update Item in Inventory");
            System.out.println("3. List Inventory");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter product stock: ");
                int stock = scanner.nextInt();
                seller.addtoinventary(new Product(name, price, stock));
            } else if (choice == 2) {
                System.out.print("Enter product name to update: ");
                String name = scanner.nextLine();
                System.out.print("Enter new stock: ");
                int stock = scanner.nextInt();
                seller.updateitem(name, stock);
            } else if (choice == 3) {
                superStore.listInventary(seller);
            } else if (choice == 4) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleBuyerActions(Buyer buyer, SuperStore superStore, Scanner scanner) {
        while (true) {
            System.out.println("\nBuyer Actions:");
            System.out.println("1. Add Item to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();
                buyer.addtocart(new Product(name, price, 1)); // Stock doesn't matter for cart
            } else if (choice == 2) {
                superStore.showCart(buyer);
            } else if (choice == 3) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
