package com.example.otimus.yipllisting.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Otimus on 11/6/2016.
 */
public class DetailItem implements Serializable{
    @SerializedName("postId")
    private Integer postId;
    @SerializedName("id")
     private Integer id;
    @SerializedName("name")
     private  String pname;
    @SerializedName("email")
    private String email;
    @SerializedName("body")
    private  String body;

    public DetailItem() {
    }

    public DetailItem(Integer postId, Integer id, String pname, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.pname = pname;
        this.email = email;
        this.body = body;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



}
