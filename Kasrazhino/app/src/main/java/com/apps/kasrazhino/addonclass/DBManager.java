/*
package com.apps.kasrazhino.addonclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;

import alcazer.morfi.ridetrack.GpsDevice;
import alcazer.morfi.ridetrack.Setting_item;

*/
/**
 * Created by Morfi on 4/29/2017.
 *//*


public class DBManager {
    private SQLiteDatabase sqlDB;
    public static final String Valid = "YES";
    public static final String NotValid = "NO";
    public static final String NoPelak = "NOPELAK";
    public static final String DevNoModel = "NOMODEL";
    public static final String Yes = "YES";
    public static final String No = "NO";
    public static final String Red = "RED";
    public static final String Green = "GREEN";
    public static final String ASOAL = "A?";
    public static final String A029 = "A29";
    public static final String A02 = "A02";
    public static final String A200 = "A200,****";
    public static final String A09 = "A09";


    public static final String DBName = "AppDataBase";
    public static final String TableDevices = "Devices";
    public static final String DevID = "ID";
    public static final String DevValid = "DevValid";
    public static final String DevName = "DevName";
    public static final String DevModel = "DevModel";
    public static final String SimNum = "DevSim";
    public static final String DevPelak = "DevPelak";
    public static final String DevPass = "DevPass";
    public static final String AppPass = "AppPass";
    public static final String OldPass = "OLDPASS";
    public static final String Engine_Mod = "ENGINEMOD";
    public static final String IMEI = "IMEI";
    public static final String SerialNumber = "SERIALNUM";
    public static final String GuarantiDate = "GURDATE";
    public static final String Last_Command_Sent = "LASTCOMMAND";
    public static final String Last_Command_Recived = "LASTCOMMANDREC";
    public static final String Pelack = "PELAK";
    public static final String Parking_St = "PARKSTATUS";


    public static final String TableHistory = "History";
    public static final String HistoryID = "ID";
    public static final String DevId = "DevID";
    public static final String HisType = "HistoryType";
    public static final String Date = "Date";
    public static final String Readed = "Readed";
    public static final String MapType = "MapType";
    public static final String MessageType = "Message";
    public static final String Content = "Content";
    public static final String NotReaded = "NOTREADED";
    public static final String HasRed = "READED";
    public static final String Send_Recive = "SEND_RECIVE";
    public static final String SENT = "SENT";
    public static final String RECIVED = "RECIVED";


    public static final String TableSetting = "Settings";
    public static final String SettingID                                                = "ID";
    public static final String Dom                                                      =  "DOM";
    public static final String Port                                                     = "PORT";
    public static final String APN                                                      = "APN";
    public static final String Ussd                                                     = "USSD";
    public static final String Credit                                                   = "CREDIT";
    public static final String Opt                                                      = "OPT";
    public static final String Degri                                                    = "DEGRI";
    public static final String Distance                                                 = "DISTANCE";
    public static final String SendInMove                                               = "SENDINMOVE";
    public static final String SendStop                                                 = "SENDSTOP";
    public static final String WantedSpeed                                              = "WANTEDSPEED2";
    public static final String ActiveDangerSpeed                                        = "ACTIVEDANGERSPEED";
    public static final String RepitDangSpeed                                           = "REPINDANGERSPEED";
    public static final String DangerSpeed                                              = "DANGERSPEED";
    public static final String StandByMod                                               = "STANDBYMOD";
    public static final String DOP_ACC                                                  = "DOP_ACC";
    public static final String DOP_ALW                                                  = "DOP_ALW";
    public static final String RTC_SET                                                  = "RTC_SET";
    public static final String RTC_RUN                                                  = "RTC_RUN";
    public static final String R_ADD                                                    = "R_ADD";
    public static final String Gps_acc                                                  = "GPS_ACC";
    public static final String SP_C                                                     = "SP_C";

    public  static final String TEMP_VALS           = "TEMPVAL"  ;


    public static final String SENT_FA    = "ارسال شده";
    public static final String RECIVED_FA      = "دریافت شده";


    public static final String Webb_Adress      = "WEBADRESS";




    public static final String SoftVersion = "Soft";
    public static final String HardVersion = "Harf";


    public static final String TableLocation = "LOCATION";
    public static final String LocationID = "ID";
    public static final String Location_X = "X";
    public static final String Location_Y = "Y";
    public static final String Location_Date = "LOCATION_DATE";
    public static final String System_Date = "SYSTEM_DATE";
    public static final String Location_info = "LOCATION_INFO";



    //ringtons active or disable
    public static final String TableRings = "RINGINGS";
    public static final String Elec = "BATTRY";
    public static final String Door = "DOOR";
    public static final String Motr = "MOTOR";
    public static final String All = "allAlarms";
    public static final String Park = "PARKING";
    public static final String Wanted = "WANTEDSPEED";

    //status (wich are currently ringing)
    public static final String Battry_st = "BATTRYST";
    public static final String Wanted_st = "WANTEDST";
    public static final String Door_st = "DOORST";
    public static final String Engine_st = "ENGINEST";
    public static final String Parking_Alarm = "PARKINGST";


    public  static  final  String Degri_1  ="DEG1";
    public  static  final  String Degri_2  ="DEG2";
    public  static  final  String Distance_1  ="DIS1";
    public  static  final  String Distance_2  ="DIS2";
    public  static  final  String RUN_T  ="RUNT";
    public  static  final  String Balande  ="BALANCE";
    public  static  final  String TD_SP  ="TD_SP";
    public  static  final  String SPC_1  ="SPC_1";
    public  static  final  String SPC_2  ="SPC_2";


    // TODO: 4/29/2017 add setting item to data base (when massage recived from A02)
    //static final String TableSettings = "Setting";

    static final int DBVersion =30;

    static  final String CrateTableDevice = "Create table IF NOT EXISTS "
            + TableDevices + "(ID integer PRIMARY KEY AUTOINCREMENT," + DevName
            + " text," + SimNum +" text," +DevPass + " text," + AppPass
            + " text,"+ DevModel + " text,"+DevPelak+ " text,"+OldPass + " text,"
            + Engine_Mod + " text,"+ IMEI+ " text,"+ Last_Command_Sent+ " text,"+ Last_Command_Recived
            + " text,"+SerialNumber+" text,"+ GuarantiDate+" text,"
            + SoftVersion+" text," +HardVersion+" text," + Elec +" text," +Door + " text,"
            +Motr + " text," + All + " text,"+ Park + " text," + Pelack + " text,"
            +Wanted + " text,"+Parking_St+" text,"+Webb_Adress+" text,"+

    Dom + " text,"+
            Port + " text,"+
    APN + " text,"+
            Ussd + " text,"+
    Credit + " text,"+
            Opt + " text,"+
    Degri_1 + " text,"+
            Degri_2 + " text,"+
    Distance_1 + " text,"+
            Distance_2 + " text,"+
    SendInMove + " text,"+
            SendStop + " text,"+
    WantedSpeed + " text,"+
            ActiveDangerSpeed + " text,"+
    RepitDangSpeed + " text,"+
            DangerSpeed + " text,"+
    DOP_ACC + " text,"+
            DOP_ALW + " text,"+
    RTC_SET + " text,"+
            RTC_RUN + " text,"+
    R_ADD + " text,"+
            Gps_acc + " text,"+
    RUN_T + " text,"+
            StandByMod + " text,"+
    Balande + " text,"+
            TD_SP + " text,"+
    SPC_1 + " text,"+
            SPC_2 + " text," +TEMP_VALS + " text," +
    Battry_st+" text," + Engine_st+ " text,"+Door_st+ " text,"
            + Wanted_st+" text,"+Parking_Alarm+ " text,"+ SP_C+" text," + DevValid  + " text)";

    static  final String CrateTableHistory = "Create table IF NOT EXISTS "
            + TableHistory + "(ID integer PRIMARY KEY AUTOINCREMENT," + DevId +
            " text," + HisType +" text," +Date + " text,"+Readed + " text,"
            +SimNum + " text,"+Send_Recive + " text,"  + Content   + " text)";

    static  final String CrateTableSettings = "Create table IF NOT EXISTS "
            + TableSetting + "( " + DevId +
            " text," + Dom +" text," +Port + " text,"+APN + " text,"
            +Ussd+ " text,"+Credit+ " text,"+Opt+ " text,"+Degri
            + " text,"+Distance+ " text,"+SendInMove+ " text,"+SendStop+ " text,"+WantedSpeed
            + " text,"+ActiveDangerSpeed+ " text,"+RepitDangSpeed+ " text,"+DangerSpeed+ " text,"+StandByMod  + " text,"
            + SimNum   + " text,"  + DOP_ACC   + " text,"+ DOP_ALW   + " text,"+ RTC_SET   + " text,"
            + RTC_RUN   + " text,"+ R_ADD   + " text,"+ Gps_acc   + " text,"+ SP_C   +  " text," +TEMP_VALS + " text,"   + " PRIMARY KEY("+DevId+"))";




    static  final String CrateTableLocations = "Create table IF NOT EXISTS "
            + TableLocation + "(ID integer PRIMARY KEY AUTOINCREMENT," + DevId +
            " text," + Location_X +" text," +Location_Y + " text,"+Location_Date + " text," + Location_info + " text,"
            +System_Date + " text)";

//    static  final String CrateTableRings = "Create table IF NOT EXISTS "
//            + TableRings + "(ID integer PRIMARY KEY AUTOINCREMENT," + DevId +
//            " text," + Elec +" text," +Door + " text,"+Motr + " text," + All + " text,"+ Park + " text,"
//            +Wanted + " text)";

    static class DatabaseHelperUser extends SQLiteOpenHelper{

        DatabaseHelperUser(Context context){
            super(context , DBName , null , DBVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(CrateTableDevice);
            sqLiteDatabase.execSQL(CrateTableHistory);
            sqLiteDatabase.execSQL(CrateTableSettings);
            sqLiteDatabase.execSQL(CrateTableLocations);
            //sqLiteDatabase.execSQL(CrateTableRings);


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TableDevices);
            sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TableHistory);
            sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TableSetting);
            sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TableLocation);
            //sqLiteDatabase.execSQL("Drop table IF EXISTS "+ CrateTableRings);
            onCreate(sqLiteDatabase);
        }
    }

    public DBManager(Context context){

        DatabaseHelperUser db = new DatabaseHelperUser(context);
        sqlDB = db.getWritableDatabase();
    }



    public long InsertDevice (ContentValues values){
        long id =  sqlDB.insert(TableDevices,"",values);
        // failed => id = 0 or less
        return id;
    }

    public long InsertHistory (ContentValues values){
        long id =  sqlDB.insert(TableHistory,"",values);
        // failed => id = 0 or less
        return id;
    }
    public long InsertSetting_from_setting_item (Setting_item setting_item){
//        ContentValues values = new ContentValues();
//        values.put(DevId , setting_item.DevId);
//        values.put(DBManager.Dom , setting_item.Dom );
//        values.put(DBManager.Port , setting_item.Port);
//        values.put(DBManager.APN , setting_item.APN);
//        values.put(DBManager.Ussd , setting_item.Ussd);
//        values.put(DBManager.Credit , setting_item.Credit);
//        values.put(Opt, setting_item.Opt);
//        values.put(DBManager.Degri , setting_item.Degri);
//        values.put(DBManager.Distance , setting_item.Distance);
//        values.put(DBManager.SendInMove , setting_item.SendInMove);
//        values.put(DBManager.SendStop , setting_item.SendStop);
//        values.put(DBManager.WantedSpeed , setting_item.WantedSpeed);
//        values.put(ActiveDangerSpeed, setting_item.ActiveDangerSpeed);
//        values.put(DBManager.RepitDangSpeed , setting_item.RepitDangSpeed);
//        values.put(DBManager.DangerSpeed , setting_item.DangerSpeed);
//        values.put(DBManager.StandByMod , setting_item.StandByMod);
//
//        long id =  sqlDB.insert(TableSetting,"",values);
        // failed => id = 0 or less
        return 0;
    }
    public long InsertHistory_from_histoey (String HisMOD  , String date , String send_Recive , String content , GpsDevice device ){
        ContentValues values = new ContentValues();
        values.put(DevId , device.ID);
        values.put(DBManager.Send_Recive , send_Recive);
        values.put(DBManager.Date , date);
        values.put(DBManager.Readed , No);
        values.put(DBManager.Content , content);
        values.put(DBManager.HisType , HisMOD);

        long id =  sqlDB.insert(TableHistory,"",values);
        // failed => id = 0 or less
        return id;
    }


    public long InsertSetting (ContentValues values){
        long id =  sqlDB.insert(TableSetting,"",values);
        // failed => id = 0 or less
        return id;
    }

    public long InsertLocation (ContentValues values){
        long id =  sqlDB.insert(TableLocation,"",values);
        // failed => id = 0 or less
        return id;
    }

    public int Delete (String TableName ,String Selection ,String [] SelectionArgs){

        int count = sqlDB.delete(TableName , Selection , SelectionArgs);
        return count;
    }

    public int Update (String TableName , ContentValues values, String Selection , String[] SelectionArgs){

        int count = sqlDB.update(TableName , values , Selection , SelectionArgs);
        return count;
    }
    public ArrayList<Location_item> getLocations_fom_simnum (String simNum){
        ArrayList<Location_item> location_items = new ArrayList<>();

        String[] Argomans ={simNum};
        Cursor cursor2 =
        query(TableDevices , null , SimNum + "=?" ,Argomans,DevID );
        String DEVID = "";

        if (cursor2.moveToFirst()){


            DEVID =
            cursor2.getColumnName(cursor2.getColumnIndex(DevID));
            return
            getLocations_fom_id(DEVID);


        }else {
            return location_items;
        }


    }
    public ArrayList<Location_item> getLocations_fom_id (String DevId){
        ArrayList<Location_item> location_items = new ArrayList<>();

        String[] arg = {DevId};
        Cursor cursor =
        query(TableLocation , null , DBManager.DevId +" =?",arg,DBManager.HistoryID);

        if (cursor.moveToFirst()){
            do {
                Location_item location_item = new Location_item();

                location_item.DevId = cursor.getString(cursor.getColumnIndex(DBManager.DevId));
                location_item.Location_date = cursor.getString(cursor.getColumnIndex(DBManager.Location_Date));
                location_item.System_date = cursor.getString(cursor.getColumnIndex(DBManager.System_Date));
                location_item.x = cursor.getString(cursor.getColumnIndex(DBManager.Location_X));
                location_item.y = cursor.getString(cursor.getColumnIndex(DBManager.Location_Y));
                location_item.Location_info = cursor.getString(cursor.getColumnIndex(DBManager.Location_info));
                //cursor.getString()

                location_items.add(location_item);

                Log.i("Location" , "loadded in DB");

            }while (cursor.moveToNext());


        }



        return location_items;
    }

    public Long Insert_History (history_item his){
        ContentValues values = new ContentValues();
        values.put(DevId , his.DevID);
        values.put(Send_Recive , his.Send_Recive);
        values.put(Date , his.Date);
        values.put(Readed , No);
        values.put(Content , his.Content);
        values.put(HisType , his.HisType);

        return   sqlDB.insert(TableHistory,"",values);
    }


    public int Update_Device (GpsDevice device){
        String[] args = {device.ID};
        ContentValues values = new ContentValues();
        values.put(DBManager.DevName , device.name);
        values.put(DBManager.SimNum , device.simnumber);
        values.put(DBManager.Engine_Mod , device.Engine_Mod);
        values.put(DBManager.DevPass , device.pass);
        values.put(DBManager.Last_Command_Sent , device.last_command_sent);
        values.put(DBManager.DevModel , device.model);
        values.put(DBManager.DevValid , device.Validity);
        values.put(DBManager.IMEI , device.IMEI);
        values.put(DBManager.AppPass , device.Apppass);
        values.put(DBManager.Last_Command_Recived , device.last_command_recived);
        values.put(DBManager.OldPass , device.oldPass);
        values.put(DBManager.SerialNumber , device.SerialNumber);
        values.put(DBManager.GuarantiDate , device.GuarantiDate);
        values.put(DBManager.DevPelak , device.Pelack);
        values.put(DBManager.SoftVersion , device.SoftVersion);
        values.put(DBManager.AppPass , device.serial);
        values.put(DBManager.Door , device.door_status);
        values.put(DBManager.Motr , device.motor_status);
        values.put(DBManager.All , device.all_status);
        values.put(DBManager.Park , device.Parking_ICON);
        values.put(DBManager.Wanted , device.wanted_status);
        values.put(DBManager.Parking_St , device.park_status);
        values.put(DBManager.Elec , device.elec_status);
        values.put(DBManager.Webb_Adress , device.Webb_Adress);

        values.put(DBManager.Dom                , device.Dom                     );
        values.put(DBManager.Port               , device.Port                      );
        values.put(DBManager.APN                , device.APN                     );
        values.put(DBManager.Ussd               , device.Ussd                    );
        values.put(DBManager.Credit            , device.Credit                  );
        values.put(DBManager.Balande            , device.Balande             );
        values.put(DBManager.Opt                , device.Opt                     );
        values.put(DBManager.Degri_1            , device.Degri_1                 );
        values.put(DBManager.Degri_2            , device.Degri_2                 );
        values.put(DBManager.Distance_1         , device.Distance_1              );
        values.put(DBManager.Distance_2         , device.Distance_2              );
        values.put(DBManager.SendInMove         , device.SendInMove              );
        values.put(DBManager.SendStop           , device.SendStop              );
        values.put(DBManager.DangerSpeed        , device.DangerSpeed          );
        values.put(DBManager.ActiveDangerSpeed  , device.ActiveDangerSpeed    );
        values.put(DBManager.RepitDangSpeed     , device.RepitDangSpeed        );
        values.put(DBManager.WantedSpeed        , device.WantedSpeed           );
        values.put(DBManager.DOP_ACC            , device.DOP_ACC              );
        values.put(DBManager.DOP_ALW            , device.DOP_ALW             );
        values.put(DBManager.RTC_SET            , device.RTC_SET             );
        values.put(DBManager.RTC_RUN            , device.RTC_RUN             );
        values.put(DBManager.R_ADD              , device.R_ADD               );
        values.put(DBManager.Gps_acc            , device.Gps_acc             );
        values.put(DBManager.RUN_T              , device.RUN_T               );
        values.put(DBManager.StandByMod         , device.StandByMod          );
        values.put(DBManager.TD_SP              , device.TD_SP               );
        values.put(DBManager.SPC_1              , device.SPC_1               );
        values.put(DBManager.SPC_2              , device.SPC_2               );


        //currently ringing alarms
        values.put(DBManager.Wanted_st            , device.Wanted_st             );
        values.put(DBManager.Door_st              , device.Door_st               );
        values.put(DBManager.Engine_st            , device.Engine_st             );
        values.put(DBManager.Parking_Alarm        ,device.Parking_Alarm          );
        values.put(DBManager.Battry_st            , device.Battry_st             );

        values.put(DBManager.TEMP_VALS            , device.TEMP_VALS             );





        int count = sqlDB.update(DBManager.TableDevices , values , DBManager.DevID + " = ?" , args);
        return count;
    }

    public  int Insert_Update_Setting (GpsDevice device , String[] message){
        if (message.length < 20)
            return 0;
        String[] arg = {device.ID};
        Cursor cursor =
        query(TableSetting , null , DevId + "=?"  , arg , device.ID);


        ContentValues contentValues = new ContentValues();
        contentValues.put(Dom ,message[2] );
        contentValues.put(Port ,message[3] );
        contentValues.put(APN , message[4]);
        contentValues.put(Ussd ,message[5] );
        contentValues.put(Credit , message[6]);
        contentValues.put(Opt , message[7]);
        contentValues.put(Degri ,message[8] );
        contentValues.put(Distance , message[9]);
        contentValues.put(SendInMove ,message[10] );
        contentValues.put(SendStop ,message[11]);
        contentValues.put(WantedSpeed , message[2]); //?
        contentValues.put(ActiveDangerSpeed , message[14]);
        contentValues.put(RepitDangSpeed ,message[15] );
        contentValues.put(DangerSpeed ,message[16] );
        contentValues.put(DOP_ACC , message[17]);
        contentValues.put(DOP_ALW ,message[18] );
        contentValues.put(RTC_SET , message[19]);
        contentValues.put(RTC_RUN , message[20]);
        contentValues.put(R_ADD , message[21]);
        contentValues.put(Gps_acc , message[13]);
        contentValues.put(SP_C ,message[12] );
        contentValues.put(StandByMod ,message[22] );


        if (cursor.moveToFirst()) {
            Update(TableSetting ,contentValues , DevId + "=?"  , arg);

        }else{
            Long g =
            InsertSetting(contentValues);
            int i  =Integer.parseInt(g.toString());
            return  i;
        }
        return 0;
    }

    public int Insert_Device (GpsDevice device){
        ContentValues values = new ContentValues();
        values.put(DBManager.DevName , device.name);
        values.put(DBManager.SimNum , device.simnumber);
        values.put(DBManager.Engine_Mod , device.Engine_Mod);
        values.put(DBManager.DevPass , device.pass);
        values.put(DBManager.Last_Command_Sent , device.last_command_sent);
        values.put(DBManager.DevModel , device.model);
        values.put(DBManager.DevValid , device.Validity);
        values.put(DBManager.IMEI , device.IMEI);
        values.put(DBManager.AppPass , device.Apppass);
        values.put(DBManager.Last_Command_Recived , device.last_command_recived);
        values.put(DBManager.OldPass , device.oldPass);
        values.put(DBManager.SerialNumber , device.SerialNumber);
        values.put(DBManager.GuarantiDate , device.GuarantiDate);
        values.put(DBManager.DevPelak , device.Pelack);
        values.put(DBManager.SoftVersion , device.SoftVersion);
        values.put(DBManager.AppPass , device.serial);
        values.put(DBManager.Door , device.door_status);
        values.put(DBManager.Motr , device.motor_status);
        values.put(DBManager.All , device.all_status);
        values.put(DBManager.Park , device.Parking_ICON);
        values.put(DBManager.Wanted , device.wanted_status);
        values.put(DBManager.Parking_St , device.park_status);
        values.put(DBManager.Elec , device.elec_status);
        values.put(DBManager.Webb_Adress , device.Webb_Adress);

        values.put(DBManager.Dom                , device.Dom                     );
        values.put(DBManager.Port               , device.Port                      );
        values.put(DBManager.APN                , device.APN                     );
        values.put(DBManager.Ussd               , device.Ussd                    );
        values.put(DBManager.Credit            , device.Credit                  );
        values.put(DBManager.Balande            , device.Balande             );
        values.put(DBManager.Opt                , device.Opt                     );
        values.put(DBManager.Degri_1            , device.Degri_1                 );
        values.put(DBManager.Degri_2            , device.Degri_2                 );
        values.put(DBManager.Distance_1         , device.Distance_1              );
        values.put(DBManager.Distance_2         , device.Distance_2              );
        values.put(DBManager.SendInMove         , device.SendInMove              );
        values.put(DBManager.SendStop           , device.SendStop              );
        values.put(DBManager.DangerSpeed        , device.DangerSpeed          );
        values.put(DBManager.ActiveDangerSpeed  , device.ActiveDangerSpeed    );
        values.put(DBManager.RepitDangSpeed     , device.RepitDangSpeed        );
        values.put(DBManager.WantedSpeed        , device.WantedSpeed           );
        values.put(DBManager.DOP_ACC            , device.DOP_ACC              );
        values.put(DBManager.DOP_ALW            , device.DOP_ALW             );
        values.put(DBManager.RTC_SET            , device.RTC_SET             );
        values.put(DBManager.RTC_RUN            , device.RTC_RUN             );
        values.put(DBManager.R_ADD              , device.R_ADD               );
        values.put(DBManager.Gps_acc            , device.Gps_acc             );
        values.put(DBManager.RUN_T              , device.RUN_T               );
        values.put(DBManager.StandByMod         , device.StandByMod          );
        values.put(DBManager.TD_SP              , device.TD_SP               );
        values.put(DBManager.SPC_1              , device.SPC_1               );
        values.put(DBManager.SPC_2              , device.SPC_2               );



        //currently ringing Alarms
        values.put(DBManager.Wanted_st            , device.Wanted_st             );
        values.put(DBManager.Door_st              , device.Door_st               );
        values.put(DBManager.Engine_st            , device.Engine_st             );
        values.put(DBManager.Parking_Alarm        ,device.Parking_Alarm          );
        values.put(DBManager.Battry_st            , device.Battry_st             );

        values.put(DBManager.TEMP_VALS            , device.TEMP_VALS             );

        Long l = InsertDevice(values);
        int s = Integer.parseInt (l.toString());
        return s ;
    }


    public  int Insert_Update_Setting (String simNum , String[] message){
        if (message.length < 20)
            return 0;
        ArrayList<GpsDevice> devices = getDevice_BYSIM(simNum);
        if (devices.size() < 1 )
            return 0 ;
        GpsDevice device = devices.get(0);
        String[] arg = {device.ID};
        Cursor cursor =
                query(TableSetting , null , DevId + "=?"  , arg , device.ID);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Dom ,                 message[2]   );
        contentValues.put(Port ,                message[3]   );
        contentValues.put(APN ,                 message[4]      );
        contentValues.put(Ussd ,                message[5]      );
        contentValues.put(Credit ,              message[6]      );
        contentValues.put(Opt ,                 message[7]      );
        contentValues.put(Degri ,               message[8]   );
        contentValues.put(Distance ,            message[9]      );
        contentValues.put(SendInMove ,          message[10]         );
        contentValues.put(SendStop ,            message[11]     );
        contentValues.put(WantedSpeed ,         message[2]      ); //?
        contentValues.put(ActiveDangerSpeed ,   message[14]     );
        contentValues.put(RepitDangSpeed ,      message[15]     );
        contentValues.put(DangerSpeed ,         message[16]         );
        contentValues.put(DOP_ACC ,             message[17]         );
        contentValues.put(DOP_ALW ,             message[18]         );
        contentValues.put(RTC_SET ,             message[19]     );
        contentValues.put(RTC_RUN ,             message[20]     );
        contentValues.put(R_ADD ,               message[21]         );
        contentValues.put(Gps_acc ,             message[13]         );
        contentValues.put(SP_C ,                message[12]         );
        contentValues.put(StandByMod ,          message[22]          );
        if (cursor.moveToFirst()) {
            Update(TableSetting ,contentValues , DevId + "=?"  , arg);
        }else{
            Long g =
                    InsertSetting(contentValues);
            int i  =Integer.parseInt(g.toString());
            return  i;
        }
        return 0;
    }
    public  int Insert_Update_Setting (Setting_item setting_item){





        //Insert setting here ... .!...not ill
        return 0;
    }

    public ArrayList<history_item> getHistory_by_DEV (GpsDevice device){

        ArrayList<history_item> history_items = new ArrayList<>();
        String[] args = {device.ID};
        //query()
        Cursor cursor = this.query(DBManager.TableHistory,null ,DevId + "=?"  ,args,DBManager.HistoryID);
        if (cursor.moveToFirst()){
            do {

                history_item item  = new history_item();



                item.HisType = cursor.getString(cursor.getColumnIndex(DBManager.HisType));
                item.IsHistory = DBManager.Yes;
                item.Readed = cursor.getString(cursor.getColumnIndex(DBManager.Readed));
                item.SimNum = cursor.getString(cursor.getColumnIndex(DBManager.SimNum));
                item.Content = cursor.getString(cursor.getColumnIndex(DBManager.Content));
                item.DevID = cursor.getString(cursor.getColumnIndex(DBManager.DevId));
                item.Send_Recive = cursor.getString(cursor.getColumnIndex(DBManager.Send_Recive));
                item.Date = cursor.getString(cursor.getColumnIndex(DBManager.Date));

                history_items.add(item);
                //lv.setAdapter();


            }while (cursor.moveToNext());
        }

        return history_items;
    }

    public ArrayList<GpsDevice> getDevice_BYSIM(String SimNum){
        //GpsDevice gpsDevice = new GpsDevice();
        ArrayList<GpsDevice> devices = new ArrayList<>();
        String[] args = {SimNum};
        //query()
        Cursor cursor = this.query(DBManager.TableDevices,null ,DBManager.SimNum + "=?"  ,args ,DBManager.SimNum);
        if (cursor.moveToFirst()){
            do {
                DataConverter DC = new DataConverter();
                devices.add(DC.Cursor_to_Gps(cursor));
            }while (cursor.moveToNext());
        }

        return devices;
    }



    public Cursor query ( String table ,String [] Projection , String Selecin , String[] SelectionArgs , String SortOrder){

        SQLiteQueryBuilder db = new SQLiteQueryBuilder();
        db.setTables(table);


        Cursor courser = db.query(sqlDB , Projection ,Selecin , SelectionArgs , null , null , SortOrder);

        return courser;
    }

    public ArrayList<GpsDevice> grtDevice (String id){
        ArrayList<GpsDevice> devices = new ArrayList<>();
        String[] args = {id};
        Cursor cursor = this.query(DBManager.TableDevices,null ,DevID + "=?"  ,args,DBManager.DevValid);
        if (cursor.moveToFirst()){
            do {
                DataConverter DC = new DataConverter();
                devices.add(DC.Cursor_to_Gps(cursor));
            }while (cursor.moveToNext());
        }
        return devices;
    }

    public void Close (){
        sqlDB.close();
        }
        }
*/
