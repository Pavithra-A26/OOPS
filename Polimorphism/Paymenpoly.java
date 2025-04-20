class Payment{
    void pay(double amount){
        System.out.println("Amount $."+amount+" paying from general method.....");
    }
}

class Card extends Payment{
    @Override
    void pay(double amount){
        System.out.println("Amount $."+amount+" paying from card payment method.....");
    }
}

class Upi extends Payment{
    @Override
    void pay(double amount){
        System.out.println("Amount $."+amount+" paying from UPI payment method.....");
    }
}

public class Paymenpoly {
    public static void main(String[] args) {
        Card mycard = new Card();
        mycard.pay(556.87);
        Upi myupi = new Upi();
        myupi.pay(532.5);
    }
}
