package se.lexicon.ReineMoberg.model;

public abstract class Product {

    private String name;
    private int price;

    public Product() {
        name = "Empty";
        price = 0;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    //Show product info
    public abstract String examine();

    //Use or consume product
    public abstract String use();

    //Purchase product. Return purchased product
    public abstract Product purchase();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " +
                "Name: " + name +
                ", Price: " + price + "kr";
    }
}
