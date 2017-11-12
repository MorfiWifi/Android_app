package com.apps.kasrazhino.fortest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by WifiMorfi on 12/11/2017.
 */

public class AsyncHttp {
    final String WEATHER_URL = "http://kasrazhino.company/api/AllSuppliers";
    final String APP_ID = "605cad47bea2f791d48fbea72959ebff";

    public void testApi (Context con ,RequestParams params ){
        letsDoNetworking(params , con);

    }


    private  void letsDoNetworking(RequestParams params , final Context context){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(WEATHER_URL , params ,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess (int statusCod , Header[] headers , JSONObject response ){
                Log.i("web_res" , response.toString());
                Log.i("weather" , "Sucsess! JSOn");
                try {
                    Toast.makeText(context , "REQUEST Succes" ,Toast.LENGTH_SHORT).show();
                    JSONArray ja =
                    response.getJSONArray("0");
                    Log.i("RECIVED" , ja.toString());

                }catch (Exception e){
                    Log.i("RECIVED" , "FAILD : "+e.getMessage().toString());
                }

                Toast.makeText(context , "REQUEST Succes" ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i("weather REc_NET_ERR" , "FAILD : "+throwable.toString());
                Toast.makeText(context , "REQUEST FAILD" ,Toast.LENGTH_SHORT).show();
            }


        });
    }

}
