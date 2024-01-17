package com.example.cart;

import android.media.Image;

public class ListItem {
    private int image;
    private String name;
    private String price;
    private int Quantity;


    //private int qnt;
    public ListItem(int image, String price,String name) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.Quantity = 0;
    }

    public int getImage() {
        return image;
    }

    public void setQuantity(int Quantity) {this.Quantity = Quantity;}


    public String getName() {return name;}

    public  String getPrice() {return price;}
    public int getQuantity(){return Quantity;}

   // public String getLocation() {return location;}

   // public void setName(String name) {this.name = name;}

   // public void setPrice(int price) {this.price = price;}

   // public int getQnt() {return qnt;}

   // public void setQnt(int qnt) {this.qnt = qnt;}
}
