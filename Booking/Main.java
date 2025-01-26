import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Bus> Buses =  new ArrayList<>();
    private static ArrayList<booking> Bookings = new ArrayList<>();
    private static int bookingid=1;

    public static void main(String[] args) {
        initializebus();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.display bus list           2.book     3.display bookings    4.cancel       5.exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:{
                    dispalybuses();
                    break;
                }
                case 2:{
                    Bookticket(sc);
                    break;
                }
                case 3:{
                    dispalybookings();
                    break;
                }
                case 4:{
                    cancelticket(sc);
                    break;
                }
                case 5:{
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }

    public static void initializebus(){
        Buses.add(new Bus(1,"BUS1","A","B",10,500.0));
        Buses.add(new Bus(2,"BUS2","c","d",5,600.0));
    }

    public static void dispalybuses(){
       for(Bus bus:Buses){
            System.out.printf("Bus Id: %d  | Bus Name : %s | Source : %s  | Destination :%s | Available Seats: %d |  Amount :%.2f \n", 
            bus.busid,bus.busname,bus.source,bus.destination,bus.available_seats,bus.amount);
       }
    }

    public static void Bookticket(Scanner sc){
        System.out.println("Enter bus id");
        int bus=sc.nextInt();
        Bus selectedBus=findbusbyId(bus);

        if(selectedBus==null){
            System.out.println("Invalid bus id..");
            return;
        }
        System.out.println("Enter your name");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter no of seats");
        int seats = sc.nextInt();
        
        sc.nextLine();

        if(seats>selectedBus.available_seats){
            System.out.println("Not enough seats");
            return;
        }
        
       
        selectedBus.available_seats -= seats;
        

        System.out.println("Your Bill amount is "+ seats*(selectedBus.amount));
        Bookings.add(new booking(bookingid++, bus, name, seats));
        System.out.println("Ticket Booked");
    }

    public static void dispalybookings(){
        if(Bookings.isEmpty()){
            System.out.println("NO booking available");
            return;
        }
        for(booking booked:Bookings){
            System.out.printf("Booking id : %d    |   Bus id : %d    |   Name : %s  |  No of seats : %d \n",
            booked.bookingid,booked.busid,booked.name,booked.no_of_seatts);
        }
    }

    public static void cancelticket(Scanner sc){
        System.out.println("Enter your booking id");
        int id = sc.nextInt();
        booking currentbooking = findBookinByid(id);
        if(currentbooking==null){
            System.out.println("No Booking found");
            return;
        }
        Bus currentbus = findbusbyId(currentbooking.busid);
        currentbus.available_seats += currentbooking.no_of_seatts;
        Bookings.remove(currentbooking);
        System.out.println("Your Amoun Rs."+ currentbooking.no_of_seatts*(currentbus.amount)+ "is refunded");
    }

    public static booking findBookinByid(int bookingid){
        for(booking booked:Bookings){
            if(booked.bookingid==bookingid){
                return booked;
            }
        }
        return null;
    }

    public static Bus findbusbyId(int busid){
        for(Bus bus:Buses){
            if(busid==bus.busid){
                return bus;
            }
        }
        return null;
    }
}
