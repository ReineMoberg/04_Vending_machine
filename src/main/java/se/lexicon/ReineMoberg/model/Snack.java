package se.lexicon.ReineMoberg.model;

public class Snack extends Product{

    private int sugarPercent;

    public Snack() {
        super();
        sugarPercent = 0;
    }

    public Snack(String name, int price) {
        super(name, price);
        sugarPercent = 0;
    }

    public Snack(String name, int price, int sugarPercent) {
        super(name, price);
        this.sugarPercent = sugarPercent;
    }

    @Override
    public String examine() {
        return toString();
    }

    @Override
    public String use() {
        return "This snack sure is sweet!";
    }

    @Override
    public Product purchase() {
        Product purchasedSnack = new Snack(this.getName(), this.getPrice(),this.getSugarPercent());
        setName("Empty");
        setPrice(0);
        setSugarPercent(0);
        return purchasedSnack;
    }

    public int getSugarPercent() {
        return sugarPercent;
    }

    public void setSugarPercent(int sugarPercent) {
        this.sugarPercent = sugarPercent;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Percent sugar: '" + sugarPercent + "%'";
    }
}
