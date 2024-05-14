package com.stemgon.stemly.contacts.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Contact {
    private int id;
    private int userId;
    @SerializedName("created_at")
    private Date createdAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    @SerializedName("full_name")
    private String fullName;
//    @SerializedName("body")
    private String tagline;
    public Contact(int id,  String fullName, String tagline, Date createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.tagline = tagline;
        this.createdAt = createdAt;
    }

    public Contact(int id, int userId, String fullName, String tagline) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.tagline = tagline;
        System.out.println(tagline);
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTagline() {
        return tagline;
    }
}
