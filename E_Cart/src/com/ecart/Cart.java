package com.ecart;

import java.util.List;

public class Cart {


    static List<Item> products =   List.of(
            new Item("T-Shirt","Adidas",1500f,4.5f),
            new Item("Watch","Mi",9999f,4.5f),
            new Item("Jumb-Suit","Levis",1000f,3.5f),
            new Item("Kajal","Lakme",250f,4.4f),
            new Item("Mobile","Mi",10500f,4.0f),
            new Item("Note Book","Classmates",85f,4.0f),
            new Item("Pencil","Apsara",20f,4.0f),
            new Item("Hair Serum","Livon",500f,4.0f)
    );

    public void addFilter(String title,
                          String brand,
                          float priceMin,
                          float priceMax,
                          float rating
    ) {

        products.stream()
                .filter(m -> m.getTitle().toLowerCase().equals(title.toLowerCase()))
                .filter(m -> m.getBrand().toLowerCase().equals(brand.toLowerCase()))
                .filter(m -> m.getPrice() > priceMin)
                .filter(m -> m.getPrice()< priceMax)
                .filter(m -> m.getRating() >= rating)
                .forEach(m -> System.out.println(
                        "Item : "+m.getTitle() +" , "+ "Brand :" + " "+ m.getBrand()+" , "+
                                "Price : "+m.getPrice()+" , "+ "Rating : "+m.getRating()));

    }

}
