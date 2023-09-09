package com.practice.quotes;

import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("q")
    private String quote;

    @SerializedName("a")
    private String author;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
