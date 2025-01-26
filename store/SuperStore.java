import java.util.HashMap;
import java.util.Map;

public class SuperStore {
    private Map<String,User> users = new HashMap<>();
    public User register(String username,String password ,String usertype){
        if(users.containsKey(username)){
            System.out.println("User already registered....");
            return null;
        }
        User user = usertype.equalsIgnoreCase("Buyer")? new Buyer(username, password): new Seller(username, password);
        users.put(username,user);
        System.out.println("User Registration successfull");
        return user;
    }

    public User login(String username,String password){
        User user = users.get(username);
        if(user != null && user.validatePass(password)){
            System.out.println("User Login successfull.........");
            return user;
        }
        System.out.println("Invalid creadentials....");
        return null;
    }

    public void listInventary(Seller seller){
        System.out.println("Inventart:");
        for(Product product:seller.getInventary()){
            System.out.println(product.getitemname() + "-$" + product.getprice() + "-stock" + product.getstock());
        }
    }

    public void showCart(Buyer buyer){
        System.out.println("Cart:");
        for(Product product:buyer.getcart()){
            System.out.println(product.getitemname() + "-$" +product.getprice());
        }
    }
}
