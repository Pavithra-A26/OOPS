public class Invoice{
    // private static int idcounter;
    String name;
    int customerid;
    double amount;
    public Invoice(int customerid,String name,double amount){
        this.customerid=customerid;
        this.name=name;
        this.amount=amount;
    }
}