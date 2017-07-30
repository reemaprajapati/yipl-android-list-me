package com.example.otimus.yipllisting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.otimus.yipllisting.databaseHelper.SQLiteHandler;
import com.example.otimus.yipllisting.model.DetailItem;
import com.example.otimus.yipllisting.model.PostItem;
import com.example.otimus.yipllisting.rest.ApiClient;
import com.example.otimus.yipllisting.rest.ApiInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    SQLiteHandler db;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new SQLiteHandler(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        savePosts();
        saveDetails();

        recyclerView.setAdapter(new PostAdapter(db.allPosts(),new PostAdapter.OnItemClickListener(){
            @Override
            //sending details from MainActivity to DetailActivity as "list" on each item click
            public void onItemClick(PostItem item) {
                Intent intent=new Intent(new Intent(getApplicationContext(),DetailActivity.class));
                List<DetailItem> items=new ArrayList<>();
                items.addAll(db.allDetails(item.getId()));
                intent.putExtra("list", (Serializable) items);
                startActivity(intent);
            }
        }));

    }


    //retrieving data from www.jsonplaceholder.typecode.com/posts and storing to the database
    public void savePosts(){


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<PostItem>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<PostItem>>() {

            @Override
            public void onResponse(Call<List<PostItem>> call, Response<List<PostItem>> response) {
                for (PostItem postitem : response.body()
                        ) {
                    db.addPost(postitem);
                    Log.d("posts",postitem.getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<PostItem>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    //retrieving data from www.jsonplaceholer.typecode.com/posts/{id}/comments
    public  void saveDetails(){
        ApiInterface apiInterfaceDetail= ApiClient.getClient().create(ApiInterface.class);
        //each post item has details in DetailActivity
        for(int i=1;i<=100;i++) {
            Call<List<DetailItem>> callDetail = apiInterfaceDetail.getDetails(i);
            callDetail.enqueue(new Callback<List<DetailItem>>() {
                @Override
                public void onResponse(Call<List<DetailItem>> call, Response<List<DetailItem>> response) {
//                recyclerView.setAdapter(new DetailAdapter(response.body()));
//                int id=response.body().get(0).getId();
                    for (DetailItem detailItem:response.body()
                            ) {
                        db.addDetail(detailItem);
                        Log.d("details",detailItem.getPname());

                    }

                }

                @Override
                public void onFailure(Call<List<DetailItem>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }

    }
 }
