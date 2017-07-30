package com.example.otimus.yipllisting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otimus.yipllisting.model.DetailItem;

import java.util.List;

/**
 * Created by Otimus on 11/6/2016.
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.CommentHolder> {

    List<DetailItem> detailItemList;

    public DetailAdapter(List<DetailItem> detailItemList) {
        this.detailItemList = detailItemList;
    }

    @Override
    public CommentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail,parent,false);
        return new CommentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentHolder holder, int position) {
        holder.name.setText(detailItemList.get(position).getPname());
        holder.email.setText(detailItemList.get(position).getEmail());
        holder.body.setText(detailItemList.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return detailItemList.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        TextView name, email,body;
        public CommentHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.cname);
            email=(TextView)itemView.findViewById(R.id.cemail);
            body=(TextView)itemView.findViewById(R.id.cbody);
        }
    }


}



