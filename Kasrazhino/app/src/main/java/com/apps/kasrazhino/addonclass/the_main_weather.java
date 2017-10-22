package com.apps.kasrazhino.addonclass;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import Data.SimUtil;
import cz.msebera.android.httpclient.Header;

public class the_main_weather extends AppCompatActivity {
    final int REQ_COD = 123;
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    final String APP_ID = "605cad47bea2f791d48fbea72959ebff";

    ImageButton starting_icon;
    String LOCATION_PROVIDER = LocationManager.NETWORK_PROVIDER;
    LocationManager locationManeger;
    LocationListener locationListenner;
    int MIN_TIME = 5000;
    int MIN_DISTANCE = 1000;

    TextView mCityLabel;
    ImageView mWeatherImage;
    TextView mTemperatureLabel;

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("weather", "onresume() called");
        getWeatherForCurrentLocation();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main_weather);

        mCityLabel = (TextView) findViewById(R.id.locationTV);
        mWeatherImage = (ImageView) findViewById(R.id.weatherSymbolIV);
        mTemperatureLabel = (TextView) findViewById(R.id.tempTV);
        ImageButton changeCityButton = (ImageButton) findViewById(R.id.changeCityButton);

//        SimUtil sim = new SimUtil();
        SimUtil.sendSMS(getBaseContext() , 0 ,"09367070485" , null , "HAHA Works!" , null , null );


        Log.i("SimClumSlotIndex" , "Sim_info...:"+SimUtil.getSIMInfo(getBaseContext()).toString() );
//        SimUtil.getSIMInfo(getBaseContext()).toString();
    }

    private  void letsDoNetworking(RequestParams params){
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(WEATHER_URL , params ,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess (int statusCod , Header[] headers , JSONObject response ){
                Log.i("web_res" , response.toString());
                Log.i("weather" , "Sucsess! JSOn");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.i("weather REc_NET_ERR" , "FAILD : "+throwable.toString());
                Toast.makeText(the_main_weather.this , "REQUEST FAILD" ,Toast.LENGTH_SHORT).show();
            }


        });
    }

    private void getWeatherForCurrentLocation() {
        locationManeger = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationListenner = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("location_lissner", "loaction chainged");

                String longtud = String.valueOf(location.getLongitude());
                String latigtude = String.valueOf(location.getLatitude());

                Log.i("location" , "Lag = "+latigtude +" : " + "Long = " + longtud);

                RequestParams params = new RequestParams();
                params.put("lat" , latigtude);
                params.put("lon" , longtud);
                params.put("appid" , APP_ID);
                letsDoNetworking(params);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Log.i("location_lissner", "location Disabled");
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this ,new String[] {Manifest.permission.ACCESS_COARSE_LOCATION ,Manifest.permission.ACCESS_FINE_LOCATION } , REQ_COD );
            return;
        }
        locationManeger.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, locationListenner);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQ_COD){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.i("weather" , "location accepted permission");
                getWeatherForCurrentLocation();
            }else{
                Log.i("weather" , "Permission Dennied");
            }
        }
    }
}
