import java.util.ArrayList;
import java.util.Scanner;

public class BookTicket {

    public static void book(Flight currentflight,int PassengerId,int tickets){
        String passengerDetails =" ";
        passengerDetails = "Passenger ID " + PassengerId + " -- " + " Number of Tickets Booked " 
                            + tickets + " -- " + "Total cost " + currentflight.price * tickets;
        currentflight.addPassengerDetails(passengerDetails, tickets, PassengerId);
        currentflight.printFightDetails();
        currentflight.printPassengerDetails();
    }

    public static void cancel(Flight currentflight,int PassengerId){
        currentflight.cancelTickets(PassengerId);
        currentflight.printFightDetails();
        currentflight.printPassengerDetails();
    }

    public static void print(Flight f){
        f.printFightDetails();
    }
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for(int i=0;i<2;i++){
            flights.add(new Flight());
        }
        int PassengerId=1;
        while(true){
            System.out.println("1.Book   2.Cancel   3.Details");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                {
                    System.out.println("Enter Flight id");
                    int fid = sc.nextInt();
                    if(fid>flights.size()){
                        System.out.println("Invalid Flight Id");
                        break;
                    }
                    Flight currentflight=null;
                    for(Flight f:flights){
                        if(f.flightid==fid){
                            currentflight = f;
                            f.printFightDetails();
                            break;
                        }
                    }

                    System.out.println("Enter no of tickets....");

                    int t = sc.nextInt();
                    if(t>currentflight.tickets){
                        System.out.println("Not Enough Tickets....");
                        break;
                    }
                    book(currentflight, PassengerId, t);
                    
                    PassengerId = PassengerId+1;
                    break;
                }

                case 2:
                {
                    System.out.println("Enter Flight id  to cancel");
                    int fid = sc.nextInt();
                    if(fid>flights.size()){
                        System.out.println("Invalid Flight Id");
                        break;
                    }
                    Flight currentflight=null;
                    for(Flight f:flights){
                        if(f.flightid==fid){
                            currentflight = f;
                            f.printFightDetails();
                            break;
                        }
                    }
                    System.out.println("Enter Passenger id  to cancel");
                    int id = sc.nextInt();
                    cancel(currentflight, PassengerId);
                    break;
                }

                case 3:
                {
                    for(Flight f:flights){
                        if(f.passengerdetails.size()<0){
                            System.out.println("No Passenger Details Found for Flight Id"+f.flightid);
                        }
                        else{
                            print(f);
                        }
                    }
                    break;
                }
            
                default:
                    break;
            }
        }
    }
}
