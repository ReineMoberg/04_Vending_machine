package se.lexicon.ReineMoberg.model;

public class Drink extends Product{

    private String volume;

    public Drink() {
        super();
        volume = "Undefined";
    }

    public Drink(String name, int price) {
        super(name, price);
        volume = "Undefined";
    }

    public Drink(String name, int price, String volume) {
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String examine() {
        return toString();
    }

    @Override
    public String use() {
        return "This drink quenches my thirst!";
    }

    @Override
    public Product purchase() {
        Product purchasedDrink = new Drink(this.getName(), this.getPrice(),this.getVolume());
        setName("Empty");
        setPrice(0);
        setVolume("Undefined");
        return purchasedDrink;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Volume: " + volume;
    }
}
