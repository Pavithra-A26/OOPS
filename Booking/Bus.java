public class Bus{
    int busid;
    String busname;
    String source;
    String destination;
    int available_seats;
    double amount;
    public Bus(int busid,String busname,String source,String destination,int available_seats,double amount){
        this.busid=busid;
        this.busname=busname;
        this.source=source;
        this.destination=destination;
        this.available_seats=available_seats;
        this.amount=amount;
    }
}