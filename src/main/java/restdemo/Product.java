package restdemo;

public class Product {

    private String name;
    
    private int price;
    
    public Product() {
    }
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String s) {
        name = s;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int p) {
        price = p;
    }
    
    @Override
    public String toString() {
        return String.format("(%s for %d)", name, price);
    }
}

