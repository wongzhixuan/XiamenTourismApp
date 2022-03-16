package com.example.xiamentourismapp;

public class ExploreModel {
    private String card_title;
    private String card_description;
    private String card_rating;
    private int card_image;

    // Constructor
    public ExploreModel(String card_title, String card_description, String card_rating, int card_image){
        this.card_title = card_title;
        this.card_description = card_description;
        this.card_rating = card_rating;
        this.card_image = card_image;
    }

    // Getter and Setter
    public String getCard_title() {
        return card_title;
    }

    public void setCard_title(String card_title) {
        this.card_title = card_title;
    }

    public String getCard_description() {
        return card_description;
    }

    public void setCard_description(String card_description) {
        this.card_description = card_description;
    }

    public String getCard_rating() {
        return card_rating;
    }

    public void setCard_rating(String card_rating) {
        this.card_rating = card_rating;
    }

    public int getCard_image() {
        return card_image;
    }

    public void setCard_image(int card_image) {
        this.card_image = card_image;
    }
}
