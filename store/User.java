import java.util.ArrayList;

abstract class User {

    protected String username ;
    protected String password;

    public User(String username ,String password) {
        this.username=username;
        this.password=password;
    }
    public String getUsername(){
        return username;
    }
    public boolean validatePass(String password){
        return this.password.equals(password);
    }
}

class Buyer extends User{
    ArrayList<Product>  cart = new ArrayList<>();
    public Buyer (String username , String password){
        super(username, password);
    }
    public void addtocart(Product product){
        cart.add(product);
        System.out.println("item added to cart.....");
    }
    public ArrayList<Product> getcart(){
        return cart;
    }
}

class Seller extends User{
    ArrayList<Product> inventary = new ArrayList<>();
    public Seller(String username ,String password){
        super(username, password);
    }
    public void addtoinventary(Product product){
        inventary.add(product);
        System.out.println("Item added to inventary....");
    }
    public void updateitem(String productname,int newstock){
        for(Product product: inventary){
            if(product.getitemname().equals(productname)){
                product.setStock(newstock);
                System.out.println(productname + "Updatted to new stock" + newstock);
            }
        }
        System.out.println(productname + "Product not found");
    }

    public ArrayList<Product> getInventary(){
        return inventary;
    }
}

class Product {
    private String itemname;
    private Double itemprice;
    private int stock;
    public Product(String itemname,Double itemprice,int stock) {
        this.itemname=itemname;
        this.itemprice=itemprice;
        this.stock=stock;
    }
    public String getitemname(){
        return itemname;
    }
    public Double getprice(){
        return itemprice;
    }
    public int getstock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock=stock;
    }
}