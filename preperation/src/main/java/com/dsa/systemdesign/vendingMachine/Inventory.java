package com.dsa.systemdesign.vendingMachine;

import static com.dsa.systemdesign.vendingMachine.Constants.*;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> stock = new HashMap<>();

    public Inventory(){
        for (Item item : Item.values()){
            stock.put(item, 5);
        }
    }

    public boolean isAvailable(Item item){
        return stock.getOrDefault(item, 0) > 0;
    }

    public void reduce(Item item){
        stock.put(item, stock.get(item) - 1);
    }

    public void printInventory(){
        System.out.println("Available Items: ");
        for (Map.Entry<Item, Integer> item : stock.entrySet()){
            System.out.println(item.getKey() + " - " + item.getValue()+ " left");
        }
    }
}
