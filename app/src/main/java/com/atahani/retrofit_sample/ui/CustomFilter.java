package com.atahani.retrofit_sample.ui;


import android.widget.Filter;

import com.atahani.retrofit_sample.adapter.DataAdapterCall;
import com.atahani.retrofit_sample.models.CallModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basirdez on 11/16/2017.
 */

public class CustomFilter extends Filter {

    DataAdapterCall adapter;
    List<CallModel> filterList;

    public CustomFilter(DataAdapterCall adapter, List<CallModel> filterList) {
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
            List<CallModel> filteredList = new ArrayList<>();

            for (CallModel s: filterList){
                if(s.Message.toUpperCase().contains(constraint)){
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

        adapter.mData = (List<CallModel>) results.values;
        adapter.notifyDataSetChanged();
    }
}