package com.example.otimus.yipllisting.model;


import com.google.gson.annotations.SerializedName;

/**
 * Created by Otimus on 10/31/2016.
 */
public class PostItem {
    @SerializedName("userId")
    Integer userId;

    @SerializedName("id")
    Integer id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;

    public PostItem() {
    }

    public PostItem(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
