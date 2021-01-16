package se.lexicon.ReineMoberg.data;

import se.lexicon.ReineMoberg.model.*;

public class VendingMachineImpl implements VendingMachine{

    private final int FULL_VENDING_MACHINE = 9;
    private static Product[] products;
    private int moneyPool;

    public VendingMachineImpl() {
        moneyPool = 0;
        products = new Product[FULL_VENDING_MACHINE];
    }


    @Override
    public boolean addMoney(int money) {
        boolean successAddMoney = false;
        for (Denominations denomination : Denominations.values()) {
            if (denomination.getValueInt() == money) {
                moneyPool += money;
                successAddMoney = true;
                break;
            }
        }
        return successAddMoney;
    }

    @Override
    public Product buy(int productNumber) {
        if (productNumber < 1 ||
                productNumber > FULL_VENDING_MACHINE ||
                moneyPool < products[productNumber - 1].getPrice() ||
                products[productNumber - 1].getPrice() == 0) {
            return null;
        } else {
            moneyPool -= products[productNumber - 1].getPrice();
            return products[productNumber - 1].purchase();
        }
    }

    @Override
    public int returnChange() {
        int change = moneyPool;
        moneyPool = 0;
        return change;
    }

    @Override
    public int getBalance() {
        return moneyPool;
    }

    @Override
    public String getDescription(int productNumber) {
        if (productNumber < 1 || productNumber > FULL_VENDING_MACHINE) {
            return productNumber + ". is not a valid product number";
        } else if (products[productNumber - 1] == null) {
            return productNumber + ". Product is not defined.";
        } else {
            return productNumber + ". " + products[productNumber - 1].examine();
        }
    }

    @Override
    public String[] presentProducts() {
        String[] allProducts = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                allProducts[i] = (i + 1) + ". Product is not defined.";
            } else {
                allProducts[i] = (i + 1) + ". " + products[i].examine();
            }
        }
        return allProducts;
    }

    @Override
    public void restockVendingMachine() {
        for (int i = 0; i < products.length; i++) {
            if (i < 3) {
                products[i] = new Drink("Coca Cola", 18, "33cl");
            }
            if (i >= 3 && i < 6) {
                products[i] = new Food("Cheese sandwich", 45, 800);
            }
            if (i >= 6) {
                products[i] = new Snack("Hershey Bar", 25, 60);
            }
        }
    }

}
