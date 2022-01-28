package filemanipulation;

public class Product {

    private String  id;
    private String name;
    private String price;

    public Product(String id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getId() + ";" + getName() + ";" + getPrice();
    }
}