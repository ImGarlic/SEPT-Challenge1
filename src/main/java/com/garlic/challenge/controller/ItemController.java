package com.garlic.challenge.controller;

import java.net.URI;
import com.garlic.challenge.dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.garlic.challenge.dao.ItemDAO;
import com.garlic.challenge.model.Item;
import com.garlic.challenge.model.Items;


@RestController
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDAO;

    @GetMapping(path="/items", produces = "application/json")
    public Items getItems()
    {
        return itemDAO.getAllItems();
    }

    @GetMapping(path="/item{id}", produces = "application/json")
    public Item getItem(@PathVariable Integer id)
    {
        return itemDAO.getItem(id);
    }


}
}
