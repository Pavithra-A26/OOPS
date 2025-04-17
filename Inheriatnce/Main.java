class Animal{
    void eat(){
        System.out.println("Animal eats food....");
    }
}

class Dog extends Animal{
    void sound(){
        System.out.println("Dog Barks....");
    }
}

public class Main {
    public static void main(String args[]){
        Dog mydog = new Dog();
        mydog.eat();
        mydog.sound();
    }
    
}