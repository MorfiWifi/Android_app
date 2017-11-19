/*
package com.apps.kasrazhino.addonclass;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import data.handler.DataConverter;
import data.handler.SMS_CON;


public class CustumAdapter_Device extends BaseAdapter {
    private Context context;
    private ArrayList<GpsDevice> items;
    private static LayoutInflater inflater = null;
    public  static int x = 0;
    public  static int y = 0;
    public static  Activity activity;
    public static  Activity Device_list;
    public static  int Tag;
    int possion;
    //private  HashMap<String  , HashMap<String , String>> temp_map = new HashMap<String , HashMap<String , String>>();
    int sw_binery_con = 0;

    public static Activity List_Activity;
    public static Typeface typeface;

    public CustumAdapter_Device(Context context, ArrayList<GpsDevice> data) {

        */
/*y = y/2;
        x = x/2;*//*

        this.context = context;
        items = data;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    public int get_sw_binery_con() {
        return sw_binery_con;
    }

    public void set_sw_binery_con(int a) {
        sw_binery_con = a;
    }

    @Override
    public int getCount() {

        return  items == null ? 0 : items.size();

        //return items.size();
    }

    @Override
    public Object getItem(int i) {
        if (getCount() > 0){
            return items.get(i);
        }
        else return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        final GpsDevice dev = items.get(i);
        possion = i;
        //HashMap<String, String> temp;


        //Gson gson = new Gson();

        */
/*SharedPreferences sharedPreferences = context.getSharedPreferences("Prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hashmap", gson.toJson(dev));
        editor.apply();*//*



        if (view == null) {
            AssetManager am = context.getAssets();
            typeface = Typeface.createFromAsset(am,
                    String.format(Locale.US, "fonts/%s", "BNAZANIN.TTF"));


            view1 = inflater.inflate(R.layout.dev_item_layout, null);

            TextView tv = (TextView)
                    view1.findViewById(R.id.text_dev_name);
            tv.setTypeface(typeface);

            ImageView imageView =  (ImageView)view1.findViewById(R.id.imageView_validation);
            tv.setTag(i);
            View right_leyout = view1.findViewById(R.id.devices_right_leyout);
            right_leyout.setTag(i);
            right_leyout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    possion = (int)view.getTag();

                    if (items.get(possion).Validity.equals(DBManager.Valid)){
                        Intent intent = new Intent(context, MainActivity_flow.class);
                        MainActivity_flow.device = items.get(possion);

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        context.startActivity(intent);
                        Device_list.finish();
                    }else {

                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
                        alertDialog.setTitle("ادامه");
                        alertDialog.setMessage("دستگاه تایید نشده پیام دوباره فرستاده شود ؟");
                        alertDialog.setPositiveButton("بله",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        if (items.get(possion).last_command_sent.equals(DBManager.ASOAL)){
                                            SMS_CON sms_con = new SMS_CON(context);
                                            sms_con.Send_sms(items.get(possion) ,items.get(possion).last_command_sent , "A?" );
                                        }else if (items.get(possion).last_command_sent.equals(DBManager.A200)){
                                            SMS_CON sms_con = new SMS_CON(context);
                                            sms_con.Send_sms(items.get(possion) ,items.get(possion).oldPass +","+ items.get(possion).last_command_sent, "A200" );
                                        }else if (items.get(possion).last_command_sent.equals(DBManager.A029)) {
                                            SMS_CON sms_con = new SMS_CON(context);
                                            sms_con.Send_sms(items.get(possion) ,items.get(possion).oldPass + "," +items.get(possion).last_command_sent +"," + items.get(possion).pass, "A29" );
                                        }
                                        else {
                                            SMS_CON sms_con = new SMS_CON(context);
                                            sms_con.Send_sms(items.get(possion) ,items.get(possion).oldPass + "," +items.get(possion).last_command_sent, items.get(possion).last_command_sent );
                                        }
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
                }
            });

            tv.setText(dev.name);

            tv.setTag(i);

            ImageView btn_edit = (ImageView)
                    view1.findViewById(R.id.btn_edit_device_pen);


            btn_edit.setTag(i);

            btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Device_Edit.device = items.get(Tag);
                    Intent intent = new Intent(context, Device_Edit.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    int Tag = (int) view.getTag();
                    Device_Edit.device = items.get(Tag);
//                    intent.putExtra(Devices_List.NAME, items.get(Tag).name);
//                    intent.putExtra(Devices_List.SMSPASS, items.get(Tag).pass);
//                    intent.putExtra(Devices_List.Simnum, items.get(Tag).simnumber);
                    context.startActivity(intent);

                    Device_Edit.activity = activity;
                    //activity.finish();



                    Load_data(Device_list_v2.ViewList_Devices);

                    Device_list.finish();



                }
            });

            ImageView message_img = (ImageView) view1.findViewById(R.id.unRead_Message);
            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.blink);
            DataConverter dataConverter = new DataConverter(context);


            if (dataConverter.HasAlarm(items.get(possion) ) > 0 ){
                message_img.setVisibility(View.VISIBLE);
                message_img.startAnimation(animation);
            }else {
                message_img.clearAnimation();
                message_img.setVisibility(View.GONE);
            }




            if (items.get(possion).Validity.equals(DBManager.Valid)){
                imageView.setImageResource(R.drawable.ic_check_circle2);
                imageView.setVisibility(View.GONE);
                //hide progress....
                ProgressBar pb = (ProgressBar)
                        view1.findViewById(R.id.progressBar_device_list);
                pb.setVisibility(View.GONE);
                //imageView.setImageDrawable(Drawable.createFromPath());
            }else {
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.ic_check_circle_red);
                // progress blink....
                ProgressBar pb = (ProgressBar)
                view1.findViewById(R.id.progressBar_device_list);
                //pb.setMax(4);
                pb.getProgressDrawable().setColorFilter(Color.BLUE , PorterDuff.Mode.SRC_IN );
                //pb.getProgressDrawable().setColorFilter(
                        //Color.RED, PorterDuff.Mode.DARKEN);
                if (items.get(possion).last_command_recived == null){
                    items.get(possion).last_command_recived = "NON";
                }

                pb.setIndeterminate(false);

                try {
                    if (MainActivity_flow.HASA09){
                        pb.setMax(5);
                        switch (items.get(possion).last_command_recived){

                            case DBManager.ASOAL :
                                Log.i("prog" , "is 1");
                                pb.setProgress(1);
                                break;
                            case DBManager.A200 :
                                Log.i("prog" , "is 2");
                                pb.setProgress(2);
                                break;
                            case DBManager.A02 :
                                Log.i("prog" , "is 3");
                                pb.setProgress(3);
                                break;
                            case DBManager.A09 :
                                Log.i("prog" , "is 4");
                                pb.setProgress(4);
                                break;
                            case DBManager.A029 :
                                Log.i("prog" , "is 5");
                                pb.setProgress(5);
                                break;

                            default:
                                Log.i("prog" , "is 0! default");
                                //pb.setProgress(0);
                                break;
                        }

                    }else {
                        pb.setMax(4);
                        switch (items.get(possion).last_command_recived){
                            case DBManager.ASOAL :
                                Log.i("prog" , "is 1");
                                pb.setProgress(1);
                                break;
                            case DBManager.A200 :
                                Log.i("prog" , "is 2");
                                pb.setProgress(2);
                                break;
                            case DBManager.A02 :
                                Log.i("prog" , "is 3");
                                pb.setProgress(3);
                                break;
                            case DBManager.A029 :
                                Log.i("prog" , "is 4");
                                pb.setProgress(4);
                                break;
                            default:
                                Log.i("prog" , "is 0! default");
                                //pb.setProgress(0);
                                break;
                        }
                    }


                }catch (Exception e){
                    Log.i("Ex in progress" , e.getMessage());
                }



                pb.setVisibility(View.VISIBLE);
                pb.setAnimation(animation);
            }



            ImageView btn_remove = (ImageView)
                    view1.findViewById(R.id.btn_remove_device);

            btn_remove.setTag(i);

            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Tag = (int) view.getTag();

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Device_list_v2.thisActivity);
                    //alertDialog.findViewByid(R)
                    // Setting Dialog Title
                    alertDialog.setTitle("حذف");
                    // Setting Dialog Message

                    alertDialog.setMessage("مطمئنی که حذف بشه ؟");
                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.mipmap.ic_launcher);
                    // Setting Positive "Yes" Button
                    alertDialog.setPositiveButton("بله",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    GpsDevice gpsDevice =
                                            items.get(Tag);

                                    DBManager db =
                                            new DBManager(context);


                                    items.remove(Tag);

                                    String[] args = {gpsDevice.ID};
                                    Cursor cursor =
                                            db.query(DBManager.TableDevices, null, DBManager.DevID + " = ?", args, DBManager.DevID);

                                    if (cursor.moveToFirst()) {
                                        db.Delete(DBManager.TableDevices, DBManager.DevID + " = ?", args);
                                    }
                                    db.Close();




                                    db =
                                            new DBManager(context);
                                    cursor =
                                            db.query(DBManager.TableSetting, null, DBManager.DevId + " = ?", args, DBManager.DevId);

                                    if (cursor.moveToFirst()) {
                                        db.Delete(DBManager.TableSetting, DBManager.DevId + " = ?", args);
                                    }

                                    db.Close();


                                    db =
                                            new DBManager(context);
                                    cursor =
                                            db.query(DBManager.TableHistory, null, DBManager.DevId + " = ?", args, DBManager.DevId);

                                    if (cursor.moveToFirst()) {
                                        db.Delete(DBManager.TableHistory, DBManager.DevId + " = ?", args);
                                    }
                                    db.Close();


                                    db =
                                            new DBManager(context);
                                    cursor =
                                            db.query(DBManager.TableLocation, null, DBManager.DevId + " = ?", args, DBManager.DevId);

                                    if (cursor.moveToFirst()) {
                                        db.Delete(DBManager.TableLocation, DBManager.DevId + " = ?", args);
                                    }

                                    db.Close();



                                    Load_data(Device_list_v2.ViewList_Devices);

                                }
                            });
                    // Setting Negative "NO" Button
                    alertDialog.setNegativeButton("خیر",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to invoke NO event
                                    dialog.cancel();
                                }
                            });
                    // Showing Alert Message
                    alertDialog.show();












                }
            });
            //btn.setOnClickListener();


        }


        return view1;
    }

    public void Load_data(View view) {
        DBManager db = new DBManager(context);
        //List<String> contacts = new ArrayList<>();
        ArrayList<GpsDevice> devices = new ArrayList<GpsDevice>();

        //CustumeAdapter custumeAdapter = new CustumeAdapter(getBaseContext() , )
        ListView lv = (ListView)
                view.findViewById(R.id.device_list_v2);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext() , R.layout.context_detail , R.id.name , contacts);


        //db.query()
        String[] args = {DBManager.Valid};
        Cursor cursor = db.query(DBManager.TableDevices, null, null, null, DBManager.DevName);


        if (cursor.moveToFirst()) {
            do {
                DataConverter DC = new DataConverter();
                devices.add(DC.Cursor_to_Gps(cursor));
            } while (cursor.moveToNext());


        }

        CustumAdapter_Device custumAdapter_device = new CustumAdapter_Device(context, devices);

        if (devices.size() > 0){
            lv.setAdapter(custumAdapter_device);
        }else   {lv.setAdapter(null);}



        db.Close();

    }

}
*/
