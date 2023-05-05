package com.example.gatheringapp;

public class Chalet {

    private String chalet_name;
    private int chalet_id;
    private String chalet_decription ;
    private String chalet_address;
    private int chalet_price;
    private byte[] image;

    private String imageName;


    // image ?


    public Chalet(String chalet_name, int chalet_id, String chalet_decription, String chalet_address, int chalet_price , byte[] image , String imageName) {
        this.chalet_name = chalet_name;
        this.chalet_id = chalet_id;
        this.chalet_decription = chalet_decription;
        this.chalet_address = chalet_address;
        this.chalet_price = chalet_price;
        this.image = image;
        this.imageName = imageName;
    }

    public Chalet(String chalet_name  , String chalet_decription, String chalet_address, int chalet_price) {
        this.chalet_name = chalet_name;
        this.chalet_decription = chalet_decription;
        this.chalet_address = chalet_address;
        this.chalet_price = chalet_price;
    }



    public Chalet(String chalet_name, int chalet_id, int chalet_price) {
        this.chalet_name = chalet_name;
        this.chalet_id = chalet_id;
        this.chalet_price = chalet_price;
    }

    public Chalet(String chalet_name, int chalet_price) {
        this.chalet_name = chalet_name;
        this.chalet_price = chalet_price;
    }

    public Chalet(String name, int i, String description, String address, int price) {

        this.chalet_name = chalet_name;
        this.chalet_id = chalet_id;
        this.chalet_price = chalet_price;
        this.chalet_address = address;
        this.chalet_decription = description;

    }

    public String getChalet_name() {
        return chalet_name;
    }

    public int getChalet_id() {
        return chalet_id;
    }

    public String getChalet_decription() {
        return chalet_decription;
    }

    public String getChalet_address() {
        return chalet_address;
    }

    public int getChalet_price() {
        return chalet_price;
    }

    public void setChalet_name(String chalet_name) {
        this.chalet_name = chalet_name;
    }

    public void setChalet_id(int chalet_id) {
        this.chalet_id = chalet_id;
    }

    public void setChalet_decription(String chalet_decription) {
        this.chalet_decription = chalet_decription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setChalet_address(String chalet_address) {
        this.chalet_address = chalet_address;
    }

    public void setChalet_price(int chalet_price) {
        this.chalet_price = chalet_price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
