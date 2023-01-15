package com.example.webshop.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WebShop {
    private List<ShopItem> itemsList;

    public WebShop() {
        itemsList = new ArrayList<>();
        itemsList.add(new ShopItem("guitar","electric guitar",60000,5));
        itemsList.add(new ShopItem("mug","best mug",2000,50));
        itemsList.add(new ShopItem("digispark","hackzzz",2200,2));
        itemsList.add(new ShopItem("nike shoes","comfy shoes",30000,3));
        itemsList.add(new ShopItem("nike socks","overpriced socks",30000,0));
    }

    public List<ShopItem> getItemsList() {
        return itemsList;
    }


}
