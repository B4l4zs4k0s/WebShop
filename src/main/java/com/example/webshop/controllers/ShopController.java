package com.example.webshop.controllers;

import com.example.webshop.services.ShopServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {
    ShopServices shopServices;

    public ShopController(ShopServices shopServices) {
        this.shopServices = shopServices;
    }

    @GetMapping("/webShop")
    public String showAllItems(Model model) {
        model.addAttribute("webShop", shopServices.getAllItems());
        return "web-shop";
    }

    @GetMapping("/only-available")
    public String showAvailable(Model model) {
        model.addAttribute("webShop", shopServices.listAvailable());
        return "web-shop";
    }

    @GetMapping("/cheap-first")
    public String orderFromCheapest(Model model) {
        model.addAttribute("webShop", shopServices.orderedFromCheapest());
        return "web-shop";
    }

    @GetMapping("/show-nike")
    public String showNike(Model model) {
        model.addAttribute("webShop", shopServices.listNikeItems());
        return "web-shop";
    }

    @GetMapping("/most-expensive-available")
    public String showMostExpensive(Model model) {
        model.addAttribute("webShop", shopServices.showMostExpensiveItem());
        return "web-shop";
    }

    @GetMapping("/average-stock")
    public String showAverageStock(Model model){
        model.addAttribute("average", "Average stock: " + shopServices.showAverageStock());
        return "average-stock";
    }

    @GetMapping("/add-new-item")
    public String showAddNewItemPage(){
        return "add-new-item";
    }

    @PostMapping("/add-new-item")
    public String addNewItem(String name, String description, double price,int quantityOfStock){
        shopServices.addNewItem(name,description,price,quantityOfStock);
        return "redirect:/webShop";
    }
}
