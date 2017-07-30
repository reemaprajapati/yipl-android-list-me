package com.example.otimus.yipllisting.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.otimus.yipllisting.adapters.DetailAdapter;
import com.example.otimus.yipllisting.R;
import com.example.otimus.yipllisting.model.DetailItem;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            e.printStackTrace();
        }
        Intent i = getIntent();
            ArrayList<DetailItem> list = (ArrayList<DetailItem>) i.getSerializableExtra("list");
             String title=i.getStringExtra("post title");
              String body=i.getStringExtra("post body");

            recyclerView = (RecyclerView) findViewById(R.id.recyclerview_comment);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new DetailAdapter(list));
    }
}

