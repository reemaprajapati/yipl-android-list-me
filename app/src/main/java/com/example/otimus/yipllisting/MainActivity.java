package com.example.otimus.yipllisting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.otimus.yipllisting.model.PostItem;
import com.example.otimus.yipllisting.rest.ApiClient;
import com.example.otimus.yipllisting.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<PostItem>> call=apiInterface.getPosts();
        call.enqueue(new Callback<List<PostItem>>() {

            @Override
            public void onResponse(Call<List<PostItem>> call, Response<List<PostItem>> response) {
                recyclerView.setAdapter(new PostAdapter(response.body(), new PostAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(PostItem item) {

                    }
                }));
            }

            @Override
            public void onFailure(Call<List<PostItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
 }
