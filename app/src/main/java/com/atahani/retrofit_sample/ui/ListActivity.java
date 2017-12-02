package com.atahani.retrofit_sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.atahani.retrofit_sample.R;
import com.atahani.retrofit_sample.utility.AppPreferenceTools;

public class ListActivity extends AppCompatActivity {
    private AppPreferenceTools mAppPreferenceTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.listtoolbarr);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        mAppPreferenceTools = new AppPreferenceTools(this);
    //    if (mAppPreferenceTools.isAuthorized()) {

            AppCompatTextView txDisplayName = (AppCompatTextView) toolbar.findViewById(R.id.tx_name);
            txDisplayName.setText(mAppPreferenceTools.getUserName());


            temp_class tester = new temp_class();
            //tester.doInBackground("kasrazhi_aa","bbBB11!!","kasrazhi_aa","185.4.30.96")
        //Toast.makeText(this ,tester.ConnectToDatabase()  , Toast.LENGTH_LONG).show();





      //  }
    // else {
        //the user is not logged in so should navigate to sing in activity
     //   startActivity(new Intent(this, SignInActivity.class));
      //  finish();
   // }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_log_out) {

            //send request to server to terminate this application

             //           mAppPreferenceTools.removeAllPrefs();
                        //navigate to sign in activity
               //         startActivity(new Intent(getBaseContext(), SignInActivity.class));
                        //finish this
  ///                      finish();
//
                }



        return super.onOptionsItemSelected(item);
    }

    public void OnClickCall(View v){

        startActivity(new Intent(getBaseContext(), MainActivityCall.class));

    }

    public void onclickSupplier(View v){
        startActivity(new Intent(getBaseContext(), MainActivitySupplier.class));

    }
    public  void OnClickCostumer(View v){
        startActivity(new Intent(getBaseContext(), MainActivityCustomer.class));

    }
    public  void OnClickContract(View v){
        startActivity(new Intent(getBaseContext(), MainActivityContract.class));


    }

    public void OnClickUser(View v) {
        startActivity(new Intent(getBaseContext(), MainActivityUser.class));

    }


    public void OnClickProduct(View v){

        startActivity(new Intent(getBaseContext(), MainActivityProduct.class));

    }

    public void Accountant(View view) {

        startActivity(new Intent(getBaseContext(), Accountant.class));
    }
}


