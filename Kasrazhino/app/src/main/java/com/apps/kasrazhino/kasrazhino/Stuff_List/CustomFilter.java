package com.apps.kasrazhino.kasrazhino.Stuff_List;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basirdez on 11/16/2017.
 */

public class CustomFilter extends Filter {

    stuffAdapter adapter;
    List<stuff> filterList;

    public CustomFilter(stuffAdapter adapter, List<stuff> filterList) {
        this.adapter = adapter;
        this.filterList = filterList;
    }

    //Filter
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //Validity

        if(constraint != null && constraint.length() > 0){
            constraint = constraint.toString().toUpperCase();
            List<stuff> filteredList = new ArrayList<>();

            for (stuff s: filterList){
                if(s.getTitle().toUpperCase().contains(constraint)){
                    filteredList.add(s);
                }
            }

            results.count = filteredList.size();
            results.values = filteredList;
            return results;

        }

        results.count = filterList.size();
        results.values = filterList;

        return results;
    }


    //Display
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.data = (List<stuff>) results.values;
        adapter.notifyDataSetChanged();
    }
}
