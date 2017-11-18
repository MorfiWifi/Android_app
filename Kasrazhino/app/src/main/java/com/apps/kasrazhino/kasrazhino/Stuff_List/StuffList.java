package com.apps.kasrazhino.kasrazhino.Stuff_List;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.apps.kasrazhino.kasrazhino.R;

import java.util.ArrayList;
import java.util.List;

public class StuffList extends AppCompatActivity {

    RecyclerView recyclerView;
    private stuffAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuff_list);
        
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        searchView = (SearchView) findViewById(R.id.mySearch);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        adapter = new stuffAdapter(StuffList.this, getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(StuffList.this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

    }

    public static List<stuff> getData(){
        List<stuff> data = new ArrayList<>();
        int icons[] = {R.drawable.ic_list,R.drawable.ic_list, R.drawable.ic_list, R.drawable.ic_list, R.drawable.ic_list, R.drawable.ic_list,R.drawable.ic_list};
        String titles[] = {"salam0", "salam2", "salam3", "salam0", "salam2", "salam3", "salam0","bedrood"};

        for(int i=0; i<titles.length && i<icons.length; i++){

            stuff current= new stuff();
            current.icnnId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }
}
