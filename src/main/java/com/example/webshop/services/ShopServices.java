package com.example.webshop.services;

import com.example.webshop.models.ShopItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopServices {

    List<ShopItem> getAllItems();

    void addNewItem( String name, String description, double price, int quantityOfStack);

    List<ShopItem> listAvailable();

    List<ShopItem> orderedFromCheapest();

    List<ShopItem> listNikeItems();

    double showAverageStock();

    List<ShopItem> showMostExpensiveItem();
}
