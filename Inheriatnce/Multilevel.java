class Animal{
    void eat(){
        System.out.println("All Animal eats.....");
    }
}

class Mammal extends Animal{
    void walk(){
        System.out.println("All mammals walk....");
    }
}

class Dog extends Mammal{
    void bark(){
        System.out.println("All dogs bark....");
    }
}


public class Multilevel {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.eat();
        myDog.walk();
        myDog.bark();
    }
}
