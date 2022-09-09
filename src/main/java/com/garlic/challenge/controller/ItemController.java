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

    @PostMapping(path="", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = false) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item)
            throws Exception
    {
        Integer id = itemDAO.getAllItems().getItemList().size() + 1;
        item.setId(id);

        itemDAO.addItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/item{id}")
                .buildAndExpand(item.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/items", produces = "application/json")
    public Items getItems()
    {
        return itemDAO.getAllItems();
    }

    @GetMapping(path="/item{id}", produces = "application/json")
    public Item getItem(@PathVariable Integer id)
    {
        return itemDAO.getItem(id - 1);
    }

    @PutMapping(path="/item{id}", consumes = "application/json", produces = "application/json")
    public Item updateItem(@RequestBody Item updatedItem, @PathVariable Integer id)
    {
        itemDAO.getItem(id - 1).setTitle(updatedItem.getTitle());
        itemDAO.getItem(id - 1).setDesc(updatedItem.getDesc());
        itemDAO.getItem(id - 1).setImagePath(updatedItem.getImagePath());
        itemDAO.getItem(id - 1).setPrice(updatedItem.getPrice());

        return itemDAO.getItem(id - 1);
    }
}
