package com.microsoft.felixrieseberg.azuretweets;

public class Tweet {

    public String text;
    public String author;

    @com.google.gson.annotations.SerializedName("id")
    private String tId;

    public Tweet(String text, String author, String id) {
        this.text = text;
        this.author = author;
        this.setId(id);
    }

    public Tweet() {
        this.text = "";
        this.author = "";
    }

    // Returns the id
    public String getId() {
        return tId;
    }

    // Sets the id
    public final void setId(String id) {
        tId = id;
    }
}