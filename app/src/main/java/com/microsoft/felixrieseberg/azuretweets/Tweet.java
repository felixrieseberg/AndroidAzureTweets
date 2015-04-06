package com.microsoft.felixrieseberg.azuretweets;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Tweet {

    public String text;
    public String author;
    public String timestamp;

    @com.google.gson.annotations.SerializedName("id")
    private String tId;

    public Tweet(String text, String author, String id) {
        this.text = text;
        this.author = author;
        this.timestamp = getTimestamp();
        this.setId(id);
    }

    public Tweet() {
        this.text = "";
        this.author = "";
        this.timestamp = getTimestamp();
    }

    /**
     * Returns the id of the tweet
     * @return id
     */
    public String getId() {
        return tId;
    }

    /**
     * Sets the id of the tweet
     * @param id
     */
    public final void setId(String id) {
        tId = id;
    }

    /**
     * Returns a pretty timestamp for the tweet, including 'Written at' text.
     * @return pretty timestamp
     */
    private String getTimestamp() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'Written at' hh:mm 'on' E, MM.dd.yyyy");
        return simpleDateFormat.format(calendar.getTime());
    }
}