package com.dsa.systemdesign.vendingMachine;

public class VendingMachineApp {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.showItems();

        vendingMachine.selectItem(Constants.Item.COKE);
        vendingMachine.insertMoney(35);
        vendingMachine.selectItem(Constants.Item.SODA);
        vendingMachine.insertMoney(10);
    }
}
