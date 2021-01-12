package se.lexicon.ReineMoberg.model;

public class Food extends Product{

    private int calories;

    public Food() {
        super();
        calories = 0;
    }

    public Food(String name, int price) {
        super(name, price);
        calories = 0;
    }

    public Food(String name, int price, int calories) {
        super(name, price);
        this.calories = calories;
    }

    @Override
    public String examine() {
        return toString();
    }

    @Override
    public String use() {
        return "This food tastes good!";
    }

    @Override
    public Product purchase(int money) {
        if(money < getPrice() || getPrice() == 0) {
            return null;
        }
        else {
            Product purchasedFood = new Food(this.getName(), this.getPrice());
            setName("Empty");
            setPrice(0);
            setCalories(0);
            return purchasedFood;
        }
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" +
                "calories=" + calories +
                "} " + super.toString();
    }
}
