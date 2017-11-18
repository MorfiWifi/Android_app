package com.apps.kasrazhino.kasrazhino.Stuff_List;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.kasrazhino.kasrazhino.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.loopj.android.http.AsyncHttpClient.LOG_TAG;
import static com.loopj.android.http.AsyncHttpClient.log;

/**
 * Created by Basirdez on 11/2/2017.
 */

public class stuffAdapter extends RecyclerView.Adapter<stuffAdapter.MyViewHolder> implements Filterable {

    private LayoutInflater inflater;
    List<stuff> data = Collections.emptyList();
    List<stuff> filterList;
    CustomFilter filter;


    public stuffAdapter(Context context, List<stuff> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
        //serch filter:
        this.filterList = data;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create View -> inflate layout to view -> put the view to view holder -> return holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // put data from data model to view holder
        stuff current = data.get(position);
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.icnnId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){

            filter = new CustomFilter(this,filterList);
        }
        return filter;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title;
        ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            icon = (ImageView) itemView.findViewById(R.id.img_row);
        }

    }
}
