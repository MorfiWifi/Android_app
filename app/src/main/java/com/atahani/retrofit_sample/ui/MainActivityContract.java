package com.atahani.retrofit_sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.atahani.retrofit_sample.R;
import com.atahani.retrofit_sample.adapter.DataAdapterContract;
import com.atahani.retrofit_sample.models.ContractModel;
import com.atahani.retrofit_sample.models.ErrorModel;
import com.atahani.retrofit_sample.network.FakeDataProvider;
import com.atahani.retrofit_sample.network.FakeDataService;
import com.atahani.retrofit_sample.utility.ErrorUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by m.hosein on 11/11/2017.
 */

public class MainActivityContract extends AppCompatActivity {

    private DataAdapterContract mAdapter;
    private FakeDataService mTService;
    private RecyclerView mRylist;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.default_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("لیست تماس ها");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //bind user image and name to toolbar
        //  txDisplayName.setText(mAppPreferenceTools.getUserName());

        FakeDataProvider provider = new FakeDataProvider();
        mTService = provider.getTService();
        //config recycler view
        mRylist = (RecyclerView) findViewById(R.id.ry_list);
        mRylist.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new DataAdapterContract(this, new DataAdapterContract.DataEventHandler() {
            @Override
            public void onEditData(String Id, int position) {
                //start activity to edit
                Intent editIntent = new Intent(getBaseContext(), CreateOrEditOrDetailContract.class);
                editIntent.putExtra("ACTION_TO_DO_KEY", 2);
                editIntent.putExtra("ID_KEY", Id);
                startActivityForResult(editIntent, 7);
            }

            @Override
            public void onDeleteData(String Id, final int position) {
                Call<ContractModel> call = mTService.deleteContractById(Id);
                //async request
                call.enqueue(new Callback<ContractModel>() {
                    @Override
                    public void onResponse(Call<ContractModel> call, Response<ContractModel> response) {
                        if (response.isSuccessful()) {
                            //get call from server just for test
                            getContractFromServer();
                        } else {
                            ErrorModel errorModel = ErrorUtils.parseError(response);
                            Toast.makeText(getBaseContext(), "Error type is " + errorModel.Message + " description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ContractModel> call, Throwable t) {
                        //occur when fail to deserialize || no network connection || server unavailable
                        Toast.makeText(getBaseContext(), "Fail it >> " + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onDetailData(String Id, int position) {
                Intent detailIntent = new Intent(getBaseContext(), CreateOrEditOrDetailContract.class);
                detailIntent.putExtra("ACTION_TO_DO_KEY", 2);
                detailIntent.putExtra("ID_KEY", Id);
                detailIntent.putExtra("detail",01);
                startActivity(detailIntent);

            }
        });
        mRylist.setAdapter(mAdapter);
        //get tweets in load
        getContractFromServer();

    }

    /**
     * get tweets from server
     */
    private void getContractFromServer() {
        Call<List<ContractModel>> call = mTService.getContract();
        call.enqueue(new Callback<List<ContractModel>>() {
            @Override
            public void onResponse(Call<List<ContractModel>> call, Response<List<ContractModel>> response) {

                if (response.isSuccessful()) {
                    //update the adapter data
                    mAdapter.updateAdapterData(response.body());
                    mAdapter.notifyDataSetChanged();
                } else {
                    ErrorModel errorModel = ErrorUtils.parseError(response);
                    Toast.makeText(getBaseContext(), "Error type is " + errorModel.Message + " , description " + errorModel.MessageDetail, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ContractModel>> call, Throwable t) {
                //occur when fail to deserialize || no network connection || server unavailable
                Toast.makeText(getBaseContext(), "Fail it >> " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 7 && resultCode == -1) {
            getContractFromServer();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_default, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mAdapter.getFilter().filter(query);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {

            return true;
        }


        if (id == R.id.action_add) {
            //start new activity to send
            Intent postNewIntent = new Intent(this, CreateOrEditOrDetailContract.class);
            postNewIntent.putExtra("ACTION_TO_DO_KEY", 3);
            startActivityForResult(postNewIntent,7);
        }
        return super.onOptionsItemSelected(item);
    }

}
