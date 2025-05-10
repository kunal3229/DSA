package com.dsa.systemdesign.vendingMachine;

import static com.dsa.systemdesign.vendingMachine.Constants.*;

public class VendingMachine {

    private MachineState state;
    private Item selectedItem;
    private int moneyInserted;
    private Inventory inventory;

    public VendingMachine(){
        this.state = MachineState.IDLE;
        this.inventory = new Inventory();
    }

    public void selectItem(Item item){

        if (state != MachineState.IDLE){
            System.out.println("Cannot use Machine now");
            return;
        }

        if(!inventory.isAvailable(item)){
            System.out.println(item + " is out of stock ");
            return;
        }

        this.selectedItem = item;
        this.state = MachineState.ITEM_SELECTED;
        System.out.println(item + " selected. Please insert: " + item.getPrice());
    }

    public void insertMoney(int money){
        if(state != MachineState.ITEM_SELECTED){
            System.out.println("Please select item: ");
            return;
        }

        this.moneyInserted = money;
        this.state = MachineState.MONEY_INSERTED;

        if(moneyInserted < selectedItem.getPrice()){
            System.out.println("Inserted money is not enough. Please insert " +(selectedItem.getPrice() - moneyInserted) + " more");
        }else{
            dispenseItem();
        }
    }

    private void dispenseItem() {
        if (state != MachineState.MONEY_INSERTED){
            System.out.println("Payment Not Complete.");
            return;
        }

        this.state = MachineState.DISPENSING;
        inventory.reduce(selectedItem);

        int change = moneyInserted - selectedItem.getPrice();
        System.out.println("Dispensing" + selectedItem + ". Please collect your item");

        if(change > 0){
            System.out.println("Returning change:" + change);
        }

        reset();
    }

    private void reset() {
        this.state = MachineState.IDLE;
        this.selectedItem = null;
        this.moneyInserted = 0;
        System.out.println("Machine is ready for next customer.\n");
    }

    public void showItems() {
        inventory.printInventory();
    }
}
