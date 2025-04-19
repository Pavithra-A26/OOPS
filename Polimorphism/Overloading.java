class Calculator{
    int add(int a,int b){
        return a+b;
    }
    int add(int a, int b,int c){
        return a+b+c;
    }
    double add(double a,double b){
        return a+b;
    }
}

class Overloading{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(2,3));
        System.out.println(calc.add(2,3,2));
        System.out.println(calc.add(2.2,3.2));
    }
}