package com.ecart;

import java.util.List;

public class DisplayItem {

    private Cart cartItem;

    public DisplayItem(Cart cartItem) {
        this.cartItem = cartItem;
    }

    public void display()
    {
        String title = InputClass.readString("Enter Title : ");
        String brand = InputClass.readString("Enter Brand : ");
        float priceMin = (float) InputClass.readNumber("Enter minimum price",0);
        float priceMax = (float) InputClass.readNumber("Enter Maximum Price",priceMin);
        float rating = (float) InputClass.readNumber("Enter rating (1-5)",1,5);
        cartItem.addFilter(title,brand,priceMin,priceMax,rating);
    }

}
