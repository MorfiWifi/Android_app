package com.apps.kasrazhino.addonclass;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import alcazer.morfi.ridetrack.About_device;
import alcazer.morfi.ridetrack.Alarm_center;
import alcazer.morfi.ridetrack.Device_list_v2;
import alcazer.morfi.ridetrack.GpsDevice;
import alcazer.morfi.ridetrack.Log_names;
import alcazer.morfi.ridetrack.MainActivity_flow;
import alcazer.morfi.ridetrack.MapsActivity;
import alcazer.morfi.ridetrack.R;
import alcazer.morfi.ridetrack.SettingActivity;
import alcazer.morfi.ridetrack.log_app_pass;
import alcazer.morfi.ridetrack.log_dev_pass;

/**
 * Created by WifiMorfi on 8/5/2017.
 */

public class Alert_MI {
    public static Context context;
    AlertDialog.Builder alertDialog;
    MainActivity_flow main;
    Object b;
    public Alert_MI(MainActivity_flow main){
        b  = main;
        this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }

    public Alert_MI(About_device about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }
    public Alert_MI(SettingActivity about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }
    public Alert_MI(Alarm_center about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }

    public Alert_MI(Log_names about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }
    public Alert_MI(log_dev_pass about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }
    public Alert_MI(log_app_pass about){
        b  = about;
        //this.main = main;
        alertDialog = new AlertDialog.Builder((Activity) b);
    }
    public void Grate_YES_NO(String Title , String  Mesage  , final int MOD , final GpsDevice device){
        //AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        final Activity ac = (Activity)b;

        alertDialog.setTitle(Title);
        alertDialog.setMessage(Mesage);
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("بله",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String sim = device.simnumber;

                        SMS_CON sms_con = new SMS_CON(ac.getBaseContext());
                        if (MOD == 0){
//                            SMS_CON sms_con = new SMS_CON(main.getBaseContext());
//                            sms_con.Send_sms();

                            sms_con.Send_sms(device ,device.pass + ",A205,1" ,"A205");


                            //ON parking mod


                            DBManager db = new DBManager(main.getBaseContext());
                            // FIXME: 8/5/2017 insert history ...
                            
                           
                            db.Close();
                        }
                        if (MOD == 1){
                            //off parking mod

                            sms_con.Send_sms(device ,device.pass + ",A205,0" ,"A205");




                            DBManager db = new DBManager(main.getBaseContext());
                            // FIXME: 8/5/2017 insert history ...


                            db.Close();
                        }if (MOD == 2){

                            sms_con.Send_sms(device ,device.pass + ",A01" ,"A01");





                        }
                        if (MOD == 3){

                            sms_con.Send_sms(device ,"A?" ,"A?");





                        }if (MOD == 4){
                            Alarm_center.Speed_Quest = DBManager.Yes;



                        }

                    }
                });
        alertDialog.setNegativeButton("خیر",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }
    boolean res = true;
        public boolean Oline_Offline_MAP (final Context context , final GpsDevice device){
        final Activity ac = (Activity)b;

        alertDialog.setTitle("نقشه");
        alertDialog.setMessage("برای مشاهده ی موقعیت می خواهید از اینترنت استفاده کنید یا SMS ؟");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("SMS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MapsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        dialog.cancel();
                    }
                });
        alertDialog.setNegativeButton("نقشه آنلاین",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String url = device.Webb_Adress;
                        //sharedPreferences1.getString(Main_Activity_Empty.Web_Adress , Main_Activity_Empty.No_Adress_Inserted);
                        if ( isOnline(context)) {
                            if (!(url.equals("") ||url.equals("http://"))){
                                if (!url.startsWith("http://")){
                                    url = "http://" + url;
                                }
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                Uri web_site;
                                try {
                                    web_site = Uri.parse(url);
                                }catch ( Exception e   ){
                                    Toast.makeText(context,"چه لینکیه آخه!" ,Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                i.setData(web_site);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(i);
                            }else {
                                Toast.makeText(context,"آدرسی ندادی!" ,Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(context, "اصلا آنلاین نیستی!", Toast.LENGTH_SHORT).show();
                        }
                        dialog.cancel();
                    }
                });
        alertDialog.show();
        return res;
    }

    public void No_DEV_EXIT_AYA (final Log_names log_names){
        final Activity ac = (Activity)b;

        alertDialog.setTitle("خروج");
        alertDialog.setMessage("دستگاهی وجود ندارد خارج می شوید ؟");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("بله",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        log_names.finish();
                        // try exit on this thing...............
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        log_names.startActivity(intent);
                        //finish();
                        dialog.cancel();
                    }
                });
        alertDialog.setNegativeButton("خیر",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }


    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void Dev_Pass_Better (final log_dev_pass log_names){
        final Activity ac = (Activity)b;

        alertDialog.setTitle("تغییر رمز دستگاه");
        alertDialog.setMessage("آیا تمایل به تغییر رمز سخت افزار دارید ؟");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("بله",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (log_dev_pass.log_names != null){
                            log_dev_pass.log_names.force_chainge = true;
                            log_dev_pass.log_names.Load_dev();
                            // try exit on this thing...............
//                            Intent intent = new Intent(Intent.ACTION_MAIN);
//                            intent.addCategory(Intent.CATEGORY_HOME);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            log_names.startActivity(intent);
                            //finish();
                        }
                        dialog.cancel();
                    }
                });
        alertDialog.setNegativeButton("خیر",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (log_dev_pass.log_names != null){
                            log_dev_pass.log_names.endThis = true;
                            log_dev_pass.device.pass = log_dev_pass.device.oldPass;

                        }
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    public void Choose_SIM(final  GpsDevice device){
        Activity activity = (Activity)b;
        Gson gson = new Gson();
        String[] sets =
                gson.fromJson(device.TEMP_VALS , String[].class);
        final List<SimInfo> list =
        SMS_CON.getSIMInfo(activity.getBaseContext());
        if (list.size() < 2)
            Log.i("ERROR" , "WHAT THE HELL ONE SIM HERE!!!");

        String sim1 = list.get(0).getSlot() + "\n" + list.get(0).getDisplay_name();
        String sim2 = list.get(1).getSlot() + "\n" + list.get(1).getDisplay_name();

        alertDialog.setTitle("دو سیک کارت");
        alertDialog.setMessage("سیم کارت موردنظر جهت ارسال پیام به دستگاه را انتخواب کنید");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton(sim1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        log_names.finish();
//                        // try exit on this thing...............
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        log_names.startActivity(intent);
                        //finish();
                        try {
                            Activity activity = (Activity)b;
                            DBManager db = new DBManager(activity);
                            Gson gson = new Gson();
                            String[] s =
                                    gson.fromJson(device.TEMP_VALS , String[].class);
                            s[20] = String.valueOf(list.get(0).getId_()); // Uses first....
                            device.TEMP_VALS =
                                    gson.toJson(s);
                            db.Update_Device(device);
                            SMS_CON SMS = new SMS_CON(activity.getBaseContext());
                            SMS.Send_sms(db.getDevice_BYSIM(device.simnumber).get(0) ,"A?","A?" );
                            db.Close();
                            Intent intent = new Intent(activity.getApplicationContext() , Device_list_v2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();
                            dialog.cancel();
                        }catch (Exception e){
                            Log.i("ERROR" , "ALERT_SIM");
                        }
                    }
                });
        alertDialog.setNegativeButton(sim2,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        log_names.finish();
//                        // try exit on this thing...............
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        log_names.startActivity(intent);
                        //finish();
                        try {
                            Activity activity = (Activity)b;
                            DBManager db = new DBManager(activity);
                            Gson gson = new Gson();
                            String[] s =
                                    gson.fromJson(device.TEMP_VALS , String[].class);
                            s[20] = String.valueOf(list.get(1).getId_()); // Uses second....
                            device.TEMP_VALS =
                                    gson.toJson(s);
                            db.Update_Device(device);
                            SMS_CON SMS = new SMS_CON(activity.getBaseContext());
                            SMS.Send_sms(db.getDevice_BYSIM(device.simnumber).get(0) ,"A?","A?" );
                            db.Close();
                            Intent intent = new Intent(activity.getApplicationContext() , Device_list_v2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();
                            dialog.cancel();
                        }catch (Exception e){
                            Log.i("ERROR" , "ALERT_SIM");
                        }
                    }
                });
        alertDialog.show();
    }
    public void Alert_SIM(final GpsDevice device  ){
        alertDialog.setTitle("دو سیک کارت");
        alertDialog.setMessage("تلفن شما دارای دو سیم کارت است جهت تعیین سیم کارت برای ارسال اطلاعات از بخش تنظیمات گوشی ، سیم کارت پیش فرض خود را انتخواب کنید");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton("بستن",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        log_names.finish();
//                        // try exit on this thing...............
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        log_names.startActivity(intent);
                        //finish();
                        try {
                            Activity activity = (Activity)b;
                            DBManager db = new DBManager(activity);
                            Gson gson = new Gson();
                            String[] s =
                                    gson.fromJson(device.TEMP_VALS , String[].class);
                            s[20] = DBManager.No; // Uses Default....
                            device.TEMP_VALS =
                                    gson.toJson(s);
                            db.Update_Device(device);
                            SMS_CON SMS = new SMS_CON(activity.getBaseContext());
                            SMS.Send_sms(db.getDevice_BYSIM(device.simnumber).get(0) ,"A?","A?" );
                            db.Close();
                            Intent intent = new Intent(activity.getApplicationContext() , Device_list_v2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();
                            dialog.cancel();
                        }catch (Exception e){
                            Log.i("ERROR" , "ALERT_SIM");
                        }
                    }
                });
        alertDialog.show();
    }
    public void Choose_SIM_Settings(final  GpsDevice device){
        Activity activity = (Activity)b;
        Gson gson = new Gson();
        String[] sets =
                gson.fromJson(device.TEMP_VALS , String[].class);
        final List<SimInfo> list =
                SMS_CON.getSIMInfo(activity.getBaseContext());
        if (list.size() < 2)
            Log.i("ERROR" , "WHAT THE HELL ONE SIM HERE!!!");

        String sim1 = list.get(0).getSlot() + "\n" + list.get(0).getDisplay_name();
        String sim2 = list.get(1).getSlot() + "\n" + list.get(1).getDisplay_name();

        alertDialog.setTitle("دو سیک کارت");
        alertDialog.setMessage("سیم کارت موردنظر جهت ارسال پیام به دستگاه را انتخواب کنید");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setPositiveButton(sim1,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        log_names.finish();
//                        // try exit on this thing...............
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        log_names.startActivity(intent);
                        //finish();
                        try {
                            Activity activity = (Activity)b;
                            DBManager db = new DBManager(activity);
                            Gson gson = new Gson();
                            String[] s =
                                    gson.fromJson(device.TEMP_VALS , String[].class);
                            s[20] = String.valueOf(list.get(0).getId_()); // Uses first....
                            device.TEMP_VALS =
                                    gson.toJson(s);
                            db.Update_Device(device);
                            SMS_CON SMS = new SMS_CON(activity.getBaseContext());
                            SMS.Send_sms(db.getDevice_BYSIM(device.simnumber).get(0) ,"A?","A?" );
                            db.Close();
                            Toast.makeText(activity.getBaseContext() ,"تغییرات اعمال شد" , Toast.LENGTH_SHORT).show();
                            /*Intent intent = new Intent(activity.getApplicationContext() , Device_list_v2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();*/
                            dialog.cancel();
                        }catch (Exception e){
                            Log.i("ERROR" , "ALERT_SIM");
                        }
                    }
                });
        alertDialog.setNegativeButton(sim2,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
//                        log_names.finish();
//                        // try exit on this thing...............
//                        Intent intent = new Intent(Intent.ACTION_MAIN);
//                        intent.addCategory(Intent.CATEGORY_HOME);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        log_names.startActivity(intent);
                        //finish();
                        try {
                            Activity activity = (Activity)b;
                            DBManager db = new DBManager(activity);
                            Gson gson = new Gson();
                            String[] s =
                                    gson.fromJson(device.TEMP_VALS , String[].class);
                            s[20] = String.valueOf(list.get(1).getId_()); // Uses second....
                            device.TEMP_VALS =
                                    gson.toJson(s);
                            db.Update_Device(device);
                            SMS_CON SMS = new SMS_CON(activity.getBaseContext());
                            SMS.Send_sms(db.getDevice_BYSIM(device.simnumber).get(0) ,"A?","A?" );
                            db.Close();
                            Toast.makeText(activity.getBaseContext() ,"تغییرات اعمال شد" , Toast.LENGTH_SHORT).show();
                            /*Intent intent = new Intent(activity.getApplicationContext() , Device_list_v2.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            activity.finish();*/
                            dialog.cancel();
                        }catch (Exception e){
                            Log.i("ERROR" , "ALERT_SIM");
                        }
                    }
                });
        alertDialog.show();
    }
//    Intent intent = new Intent(getApplicationContext() , Device_list_v2.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    startActivity(intent);
//    finish();  //Use to chainge The ACTIVITY....
}
