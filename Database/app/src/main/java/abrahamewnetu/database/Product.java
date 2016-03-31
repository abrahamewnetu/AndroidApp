package abrahamewnetu.database;

/**
 * Created by abrahamewnetu on 3/7/16.
 */
public class Product {
    private int id;
    private String productName;
    private int quantity;

    public Product(){

    }

    public Product(int i, String s, int q){
        id =i;
        productName = s;
        quantity = q;
    }

    public Product(String s, int q){
        productName = s;
        quantity = q;
    }

    public void setId(int i){
        id = i;
    }

    public int getId(){
        return id;
    }

    public void setProductName(String s){
        productName = s;
    }

    public String getProductName(){
        return productName;
    }

    public void setQuantity(int i){
        quantity = i;
    }

    public int getQuantity(){
        return quantity;
    }
}
