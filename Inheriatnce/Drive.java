class Vehicle{
    void start(){
        System.out.println("Vehicle is startted.....");
    }
}

class Car extends Vehicle{
    void drived(){
        System.out.println("Car is driven.....");
    }
}

class Bike extends Vehicle{
    void ride(){
        System.out.println("Bike is ridden......");
    }
}

public class Drive {
    public static void main(String[] args) {
        Car myCar =new Car();
        myCar.start();
        myCar.drived();

        Bike myBike = new Bike();
        myBike.start();
        myBike.ride();
    }
}
