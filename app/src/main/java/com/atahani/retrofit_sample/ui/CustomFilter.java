package com.atahani.retrofit_sample.ui;


import android.widget.Filter;

import com.atahani.retrofit_sample.adapter.DataAdapterCall;
import com.atahani.retrofit_sample.adapter.DataAdapterContract;
import com.atahani.retrofit_sample.adapter.DataAdapterCustomer;
import com.atahani.retrofit_sample.adapter.DataAdapterProduct;
import com.atahani.retrofit_sample.adapter.DataAdapterSupplier;
import com.atahani.retrofit_sample.adapter.DataAdapterUser;
import com.atahani.retrofit_sample.models.CallModel;
import com.atahani.retrofit_sample.models.ContractModel;
import com.atahani.retrofit_sample.models.CustomerModel;
import com.atahani.retrofit_sample.models.ProductModel;
import com.atahani.retrofit_sample.models.SupplierModel;
import com.atahani.retrofit_sample.models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Basirdez on 11/16/2017.
 */

public class CustomFilter extends Filter {

    String string;

    DataAdapterCall adapter;
    List<CallModel> filterList;

    DataAdapterCustomer adapter_customer;
    List<CustomerModel> filterList_customer;

    DataAdapterContract adapter_contact;
    List<ContractModel> filterList_contact;

    DataAdapterProduct adapter_product;
    List<ProductModel> filterList_product;

    DataAdapterSupplier adapter_supplier;
    List<SupplierModel> filterList_supplier;

    DataAdapterUser adapter_user;
    List<UserModel> filterList_user;

    public CustomFilter(DataAdapterCall adapter, List<CallModel> filterList, String s) {
        this.adapter = adapter;
        this.filterList = filterList;
        this.string = s;

    }

    public CustomFilter(DataAdapterCustomer adapter, List<CustomerModel> filterList, String s) {
        this.adapter_customer = adapter;
        this.filterList_customer = filterList;
        this.string = s;
    }

    public CustomFilter(DataAdapterContract adapter, List<ContractModel> filterList, String s) {
        this.adapter_contact = adapter;
        this.filterList_contact = filterList;
        this.string = s;
    }

    public CustomFilter(DataAdapterProduct adapter, List<ProductModel> filterList, String s) {
        this.adapter_product = adapter;
        this.filterList_product = filterList;
        this.string = s;
    }

    public CustomFilter(DataAdapterSupplier adapter, List<SupplierModel> filterList, String s) {
        this.adapter_supplier = adapter;
        this.filterList_supplier = filterList;
        this.string = s;
    }

    public CustomFilter(DataAdapterUser adapter, List<UserModel> filterList, String s) {
        this.adapter_user = adapter;
        this.filterList_user = filterList;
        this.string = s;
    }

    //Filter
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //Validity

        if(constraint != null && constraint.length() > 0){
            constraint = constraint.toString().toUpperCase();

            if(string.equals("call")){
                List<CallModel> filteredList = new ArrayList<>();

                for (CallModel s: filterList){
                    if(s.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(s);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }
            else if(string.equals("customer")){
                List<CustomerModel> filteredList = new ArrayList<>();

                for (CustomerModel c : filterList_customer){
                    if(c.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(c);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }

            else if(string.equals("contact")){
                List<ContractModel> filteredList = new ArrayList<>();

                for (ContractModel c : filterList_contact){
                    if(c.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(c);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }
            else if(string.equals("product")){
                List<ProductModel> filteredList = new ArrayList<>();

                for (ProductModel c : filterList_product){
                    if(c.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(c);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }
            else if(string.equals("supplier")){
                List<SupplierModel> filteredList = new ArrayList<>();

                for (SupplierModel c : filterList_supplier){
                    if(c.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(c);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }
            else if(string.equals("user")){
                List<UserModel> filteredList = new ArrayList<>();

                for (UserModel c : filterList_user){
                    if(c.getTitle().toUpperCase().contains(constraint)){
                        filteredList.add(c);
                    }
                }
                results.count = filteredList.size();
                results.values = filteredList;

            }


            return results;

        }



        if (string.equals("call")){
            results.count = filterList.size();
            results.values = filterList;
        }
        else if (string.equals("customer")){
            results.count = filterList_customer.size();
            results.values = filterList_customer;
        }
        else if (string.equals("contact")){
            results.count = filterList_contact.size();
            results.values = filterList_contact;
        }
        else if (string.equals("product")){
                results.count = filterList_product.size();
                results.values = filterList_product;
        }
        else if (string.equals("supplier")){
            results.count = filterList_supplier.size();
            results.values = filterList_supplier;
        }
        else if (string.equals("user")){
            results.count = filterList_user.size();
            results.values = filterList_user;
        }


        return results;
    }


    //Display
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        if (string.equals("call")){
            adapter.mData = (List<CallModel>) results.values;
            adapter.notifyDataSetChanged();
        }

        if (string.equals("customer")){
            adapter_customer.mData = (List<CustomerModel>) results.values;
            adapter_customer.notifyDataSetChanged();
        }

        if (string.equals("contact")){
            adapter_contact.mData = (List<ContractModel>) results.values;
            adapter_contact.notifyDataSetChanged();
        }

        if (string.equals("product")){
            adapter_product.mData = (List<ProductModel>) results.values;
            adapter_product.notifyDataSetChanged();
        }

        if (string.equals("supplier")){
            adapter_supplier.mData = (List<SupplierModel>) results.values;
            adapter_supplier.notifyDataSetChanged();
        }

        if (string.equals("user")){
            adapter_user.mData = (List<UserModel>) results.values;
            adapter_user.notifyDataSetChanged();
        }

    }
}