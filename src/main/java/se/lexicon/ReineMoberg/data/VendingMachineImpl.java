package se.lexicon.ReineMoberg.data;

import se.lexicon.ReineMoberg.model.Denominations;
import se.lexicon.ReineMoberg.model.Product;

public class VendingMachineImpl implements VendingMachine{

    private final int FULL_VENDING_MACHINE = 10;
    private Denominations denominations;
    private Product[] products;
    private int moneyPool;

    public VendingMachineImpl() {
        moneyPool=0;
        products = new Product[FULL_VENDING_MACHINE];
    }


    @Override
    public boolean addMoney(int money) {
        return false;
    }

    @Override
    public Product buy(int money, int productNumber) {
        return null;
    }

    @Override
    public int returnChange() {
        return 0;
    }

    @Override
    public int getBalance() {
        return 0;
    }

    @Override
    public String getDescription(int productNumber) {
        return null;
    }

    @Override
    public String[] presentProducts() {
        return new String[0];
    }

    @Override
    public void restockVendingMachine() {

    }


}
