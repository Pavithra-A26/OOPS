class Printer{
    void print(){
        System.out.println("printing......");
    }
}

class Photoprinter extends Printer{
    @Override
    void print(){
        System.out.println("printing photo......");
    }
}

class Pdfprinter extends Printer{
    @Override
    void print(){
        System.out.println("printing pdf......");
    }
}

public class Overriding {
    public static void main(String[] args) {
        Photoprinter myphoto = new Photoprinter();
        myphoto.print();
        Pdfprinter mypdf = new Pdfprinter();
        mypdf.print();
    }
}
