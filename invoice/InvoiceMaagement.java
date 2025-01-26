import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceMaagement {
    static ArrayList<Invoice> invoices = new ArrayList<>();
    private static int counter =1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Create Invoice      2.show All Invoice     3.exit   ");
        int choice=sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                {
                    createInvoice(sc);
                    break;
                }

            case 2:{
                showInvoice(sc);
                break;
            }
        
            default:
                break;
        }
        }
    }

    public static void createInvoice(Scanner sc){
        System.out.println("Enter Customer Name");
        String name = sc.nextLine();
        System.out.println("Enter Amount....");
        double amount = sc.nextInt();

        invoices.add(new Invoice(counter, name, amount));
        counter++;

        System.out.println("Invoice created....");
    }

    public static void showInvoice(Scanner sc){
        if(invoices.size()<=0){
            System.out.println("No Invoice Available");
            return;
        }

        for(Invoice invoice:invoices){
            System.out.printf("Customer Id : %d |  Customer Name : %s |  Amount : %.2f \n",
            invoice.customerid,invoice.name,invoice.amount);
            
        }
    }
}
