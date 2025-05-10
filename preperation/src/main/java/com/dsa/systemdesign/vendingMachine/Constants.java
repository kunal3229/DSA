package com.dsa.systemdesign.vendingMachine;

public class Constants {

    enum Item {
        COKE(25), PEPSI(35), SODA(45);

        private int price;

        Item(int price){
            this.price = price;
        }

        public int getPrice(){
            return price;
        }
    }

    enum MachineState{
        IDLE, ITEM_SELECTED, MONEY_INSERTED, DISPENSING
    }


}
