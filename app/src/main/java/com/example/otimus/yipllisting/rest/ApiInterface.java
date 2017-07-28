package com.example.otimus.yipllisting.rest;


import com.example.otimus.yipllisting.model.DetailItem;
import com.example.otimus.yipllisting.model.PostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Otimus on 10/31/2016.
 */
public interface ApiInterface{
    @GET("posts")
    Call<List<PostItem>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<DetailItem>> getDetails(@Path("id") int id);
 }