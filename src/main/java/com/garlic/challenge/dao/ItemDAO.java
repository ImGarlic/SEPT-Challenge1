package com.garlic.challenge.dao;

import com.garlic.challenge.model.Item;
import com.garlic.challenge.model.Items;

import org.springframework.stereotype.Repository;

public class ItemDAO {
    private static Items list = new Items();

    static {
        list.getItemList().add(new Item(1, "Apple", "Delicious tasty fruit", "", 1.5));
        list.getItemList().add(new Item(1, "Pen", "Write things!", "", 2.0));
        list.getItemList().add(new Item(1, "Paper", "Get written on", "", 0.2));
        list.getItemList().add(new Item(1, "Water", "Delicious tasty drink", "", 3.0));
    }

    public Items getAllItems() {
        return list;
    }

    public void addItem(Item item) {
        list.getItemList().add(item);
    }
}
