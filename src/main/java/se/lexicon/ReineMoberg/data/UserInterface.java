package se.lexicon.ReineMoberg.data;

import se.lexicon.ReineMoberg.model.Denominations;
import se.lexicon.ReineMoberg.model.Product;

import java.util.Arrays;
import java.util.Scanner;

/*
 *Virtual vending machine simulates a vending machine
 *that has a console interface with digit buttons
 *0 - 9 with an Enter (E), and an Exit (X) button.
*/

public class UserInterface {

    private static final Scanner userInput = new Scanner(System.in);
    private static VendingMachine vendingMachine = new VendingMachineImpl();

    public static void main(String[] args) {

        vendingMachine.restockVendingMachine();

        while (true){
            System.out.println();
            System.out.println("################################");
            System.out.println("## Virtual Vending Machine #####");
            System.out.println("################################");
            System.out.println("## 1. Buy a product ############");
            System.out.println("## 2. View product info ########");
            System.out.println("## 3. Restock vending machine ##");
            System.out.println("## X. Exit #####################");
            System.out.println("################################");
            String operationType = userInput.nextLine();
            switch (operationType.toLowerCase()){
                case "1":
                    buyProduct();
                    break;
                case "2":
                    viewProductInfo();
                    break;
                case "3":
                    vendingMachine.restockVendingMachine();
                    break;
                case ("x"):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Operation is not valid, try again.");

            }
        }

    }

    private static void buyProduct() {
        System.out.println();
        System.out.println("################################");
        System.out.println("## Accepted denominations: #####");
        System.out.println(Arrays.toString(Denominations.values()));
        boolean userContinue = true;
        while (userContinue) {
            System.out.println();
            System.out.println("################################");
            System.out.println("## Insert money ################");
            System.out.println("## E. Buy a product ############");
            System.out.println("## X. Exit #####################");
            System.out.println("################################");
            System.out.println("## Balance: " + vendingMachine.getBalance() + "kr");
            String operationType = userInput.nextLine();
            if (operationType.matches(".*\\d.*")) {
                int money = Integer.parseInt(operationType);
                if (!vendingMachine.addMoney(money)){
                    System.out.println("Denomination is not valid.");
                }
            } else {
                switch (operationType.toLowerCase()){
                    case "e":
                        System.out.println();
                        System.out.println("################################");
                        System.out.println("## Select product ##############");
                        System.out.println("## X. Exit #####################");
                        System.out.println("################################");
                        String productSelect = userInput.nextLine();
                        if (productSelect.matches(".*\\d.*")) {
                            int productNumberInt = Integer.parseInt(productSelect);
                            Product boughtProduct = vendingMachine.buy(productNumberInt);
                            if (boughtProduct == null) {
                                System.out.println("Enter a valid product number or add more money.");
                            } else {
                                System.out.println("Please take your product: ");
                                System.out.println(boughtProduct.examine());
                                System.out.println(boughtProduct.use());
                            }
                        } else {
                            if (productSelect.equalsIgnoreCase("x")) {
                                System.out.println("Here is your change: " + vendingMachine.returnChange() + "kr");
                                userContinue = false;
                            } else {
                                System.out.println("Operation is not valid, try again.");
                            }
                        }
                        break;
                    case "x":
                        System.out.println("Here is your change: " + vendingMachine.returnChange() + "kr");
                        userContinue = false;
                        break;
                    default:
                        System.out.println("Operation is not valid, try again.");
                }
            }
        }

    }

    private static void viewProductInfo() {
        boolean userContinue = true;
        while (userContinue) {
            System.out.println();
            System.out.println("################################");
            System.out.println("## Enter product number ########");
            System.out.println("## E. Show all products ########");
            System.out.println("## X. Exit #####################");
            System.out.println("################################");
            String operationType = userInput.nextLine();
            if (operationType.matches(".*\\d.*")) {
                int productNumber = Integer.parseInt(operationType);
                String resultMessage = vendingMachine.getDescription(productNumber);
                System.out.println(resultMessage);
                userContinue = false;
            } else {
                switch (operationType.toLowerCase()) {
                    case "e":
                        Arrays.stream(vendingMachine.presentProducts()).forEach(System.out::println);
                        userContinue = false;
                        break;
                    case "x":
                        userContinue = false;
                        break;
                    default:
                        System.out.println("Operation is not valid, try again.");
                }
            }
        }
    }
}
