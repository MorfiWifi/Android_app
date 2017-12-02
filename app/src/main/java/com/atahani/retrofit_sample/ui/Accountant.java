package com.atahani.retrofit_sample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.atahani.retrofit_sample.R;
import com.atahani.retrofit_sample.adapter.DataAdapterCall;
import com.atahani.retrofit_sample.models.AuthenticationResponseModel;
import com.atahani.retrofit_sample.models.ErrorModel;
import com.atahani.retrofit_sample.models.SignInRequestModel;
import com.atahani.retrofit_sample.network.FakeDataProvider;
import com.atahani.retrofit_sample.network.FakeDataService;
import com.atahani.retrofit_sample.utility.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Accountant extends AppCompatActivity {

    private DataAdapterCall mAdapter;
    private FakeDataService mTService;
    private RecyclerView mRylist;
    private  Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountant);

        toolbar = (Toolbar) findViewById(R.id.default_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("حسابرسی");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FakeDataProvider provider = new FakeDataProvider();
        mTService = provider.getTService();

        //ProductModel.getProductFromServer(this);

        //Call<AuthenticationResponseModel> signIn(@Body SignInRequestModel signInRequestModel);



        SignInRequestModel signInRequestModel = new SignInRequestModel();
        signInRequestModel.email = "admin";
        signInRequestModel.password = "bbBB11!!";


        try{
            Sighnin(signInRequestModel);
        }catch (Exception e){
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }




    }

    private void Sighnin(SignInRequestModel signInRequestModel) {
        Call<AuthenticationResponseModel> sighnin = mTService.signIn(signInRequestModel);
        sighnin.enqueue(new Callback<AuthenticationResponseModel>() {
            @Override
            public void onResponse(Call<AuthenticationResponseModel> call, Response<AuthenticationResponseModel> response) {
                if (response.isSuccessful()) {
                    //update the adapter data
                    // mAdapter.updateAdapterData(response.body());
                    // mAdapter.notifyDataSetChanged();
                    Toast.makeText(getBaseContext(), "Suuccess To Log in To SYS!!!", Toast.LENGTH_SHORT).show();
                } else {
                    ErrorModel errorModel = ErrorUtils.parseError(response);
                    Toast.makeText(getBaseContext(), "Couldnt Log in" + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AuthenticationResponseModel> call, Throwable t) {
                try {
                    Toast.makeText(getBaseContext(), "Fail it >> " + t.getMessage(), Toast.LENGTH_LONG).show();
                }catch (Exception e){

                }

            }



        });
    }
}
