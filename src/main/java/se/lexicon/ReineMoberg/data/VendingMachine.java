package se.lexicon.ReineMoberg.data;

import se.lexicon.ReineMoberg.model.Product;

public interface VendingMachine {

    boolean addMoney(int money);                //Add to money pool
    Product buy(int money, int productNumber);  //By a product
    int returnChange();                         //Return change and reset money pool
    int getBalance();                           //Returns money pool amount
    String getDescription(int productNumber);   //View a product description
    String[] presentProducts();                 //Returns all product's name and number
    void restockVendingMachine();               //Fills machine with products

}
