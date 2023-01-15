package com.example.webshop.services;

import com.example.webshop.models.ShopItem;
import com.example.webshop.models.WebShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopServices {

    private WebShop webShop;

    @Autowired
    public ShopServiceImpl(WebShop webShop) {
        this.webShop = webShop;
    }

    @Override
    public List<ShopItem> getAllItems() {
        return webShop
                .getItemsList();
    }

    @Override
    public void addNewItem(String name, String description, double price, int quantityOfStack) {
        ShopItem shopItem = new ShopItem(name, description, price, quantityOfStack);
        webShop.getItemsList().add(shopItem);
    }

    @Override
    public List<ShopItem> listAvailable() {
        return webShop
                .getItemsList()
                .stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<ShopItem> orderedFromCheapest() {
        return webShop
                .getItemsList()
                .stream()
                .sorted(Comparator.comparing(ShopItem::getPrice))
                .toList();
    }

    @Override
    public List<ShopItem> listNikeItems() {
        return webShop
                .getItemsList()
                .stream()
                .filter(item -> item.getName().toLowerCase().contains("nike")
                        || item.getDescription().toLowerCase().contains("nike"))
                .toList();
    }

    @Override
    public double showAverageStock() {
        return webShop
                .getItemsList()
                .stream()
                .mapToDouble(ShopItem::getQuantityOfStock)
                .average()
                .getAsDouble();
    }

    @Override
    public List<ShopItem> showMostExpensiveItem() {
        return webShop
                .getItemsList()
                .stream()
                .filter(shopItem -> shopItem.getQuantityOfStock() > 0)
                .max(Comparator.comparingDouble(ShopItem::getPrice))
                .stream().toList();
    }
}
