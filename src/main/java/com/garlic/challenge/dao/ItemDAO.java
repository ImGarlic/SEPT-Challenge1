package com.garlic.challenge.dao;

import com.garlic.challenge.model.Item;
import com.garlic.challenge.model.Items;

import org.springframework.stereotype.Repository;
@Repository
public class ItemDAO {
    private static Items list = new Items();

    static {
        list.getItemList().add(new Item(1, "Apple", "Delicious tasty fruit", "", 1.5));
        list.getItemList().add(new Item(2, "Pen", "Write things!", "", 2.0));
        list.getItemList().add(new Item(3, "Paper", "Get written on", "", 0.2));
        list.getItemList().add(new Item(4, "Water", "Delicious tasty drink", "", 3.0));
    }

    public Items getAllItems() {
        return list;
    }

    public Item getItem(Integer id) {
        return list.getItemList().get(id);
    }

    public void addItem(Item item) {
        list.getItemList().add(item);
    }

    public void deleteItem(Integer id) {
        list.getItemList().remove(list.getItemList().get(id));
        // Update all remaining Ids
        for(int i = id; i < list.getItemList().size(); ++i) {
            list.getItemList().get(i).setId(list.getItemList().get(i).getId() - 1);
            System.out.println(i);
        }
    }
}
