import java.util.ArrayList;

public class Flight {
    static int id;
    int flightid;
    int tickets;
    int price;
    ArrayList<Integer> passengerids;
    ArrayList<String> passengerdetails;
    ArrayList<Integer> bookedTicketPerPassenger;
    ArrayList<Integer> passengerCost;

    public Flight(){
        tickets=50;
        price = 5000;
        id = id+1;
        flightid=id;
        passengerdetails = new ArrayList<>();
        passengerids = new ArrayList<>();
        passengerCost =new ArrayList<>();
        bookedTicketPerPassenger = new ArrayList<>();
    }

    public void addPassengerDetails(String passengerdetail,int noOfTickets,int passengerid){
        passengerdetails.add(passengerdetail);
        passengerids.add(passengerid);
        passengerCost.add(price*noOfTickets);

        price += 200*noOfTickets;
        tickets -= noOfTickets;
        bookedTicketPerPassenger.add(noOfTickets);
        System.out.println("Ticket booked Successfully.....");

    }

    public void cancelTickets(int passengerid){
        int indexToRemove = passengerids.indexOf(passengerid);
        System.out.println("Index"+indexToRemove);
        if(indexToRemove<0){
            System.out.println("Passenger Id not found........");
            return;
        }
        int ticketsToCancel = bookedTicketPerPassenger.indexOf(indexToRemove);
        tickets += ticketsToCancel;

        int costToDecrease = passengerCost.indexOf(indexToRemove);
        price -= 200 * ticketsToCancel;
        System.out.println("Amount refunded rs." + passengerCost.indexOf(indexToRemove));

        passengerdetails.remove(indexToRemove);
        passengerids.remove(Integer.valueOf(passengerid));
        passengerCost.remove(indexToRemove);
        bookedTicketPerPassenger.remove(indexToRemove);
    }

    public void printFightDetails(){
        System.out.println("Flight ID" + flightid + "--" + "Remaining Tickets" + tickets + "--"+"Price" + price);
    }

    public void printPassengerDetails(){
        System.out.println("Flight Id" + flightid + "--->");
        for(String detail:passengerdetails){
            System.out.println(detail);
        }
    }
}