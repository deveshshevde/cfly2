package com.huawei.android.multiscreen.dlna.sdk.dmc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ie.a;

public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "dlna_sdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private StringBuffer a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Folder(_id integer primary key autoincrement,");
        stringBuffer.append("folder_id text,");
        stringBuffer.append("_display_name text,operateType integer DEFAULT 0,");
        stringBuffer.append("parent_id text,device_id integer,");
        stringBuffer.append("UNIQUE (folder_id, device_id))");
        return stringBuffer;
    }

    private StringBuffer b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Device(_id integer primary key autoincrement,");
        stringBuffer.append("device_id integer,_display_name text, device_type integer,udn text,device_product integer )");
        return stringBuffer;
    }

    private StringBuffer c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Image(_id integer primary key autoincrement,");
        stringBuffer.append("item_id text,");
        stringBuffer.append("_data text,_size long,_display_name text,");
        stringBuffer.append("mime_type text,title text,date_created text,date_added integer,");
        stringBuffer.append("date_modified integer,description text,picasa_id text,");
        stringBuffer.append("isprivate integer,latitude double,longitude double,datetaken ");
        stringBuffer.append("integer,orientation integer,mini_thumb_magic integer,bucket_id text,");
        stringBuffer.append("bucket_display_name text,parent_id text,device_id integer,ref_id text,albumart_uri text,");
        stringBuffer.append("upnp_class text,");
        stringBuffer.append("UNIQUE (item_id, device_id))");
        return stringBuffer;
    }

    private StringBuffer d() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Video(_id integer primary key autoincrement,");
        stringBuffer.append("item_id text,");
        stringBuffer.append("_data text,_size long,_display_name text unique,");
        stringBuffer.append("mime_type text,title text,date_created text,date_added integer,");
        stringBuffer.append("date_modified integer,duration text,artist text,");
        stringBuffer.append("album text,resolution text,description text,isprivate ");
        stringBuffer.append("integer,tags text,category text,language text,mini_thumb_data text,");
        stringBuffer.append("latitude double,longitude double,datetaken integer,");
        stringBuffer.append("mini_thumb_magic integer,bucket_id text,");
        stringBuffer.append("bucket_display_name text,bookmark integer,parent_id text,device_id integer,ref_id text,albumart_uri text,");
        stringBuffer.append("upnp_class text,");
        stringBuffer.append("UNIQUE (item_id, device_id))");
        return stringBuffer;
    }

    private StringBuffer e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Audio(_id integer primary key autoincrement,");
        stringBuffer.append("item_id text,");
        stringBuffer.append("_data text,_size long,_display_name text unique,");
        stringBuffer.append("mime_type text,title text,date_created text,date_added integer,");
        stringBuffer.append("date_modified integer,title_key text,duration text,");
        stringBuffer.append("artist_id integer,artist text,composer text,");
        stringBuffer.append("album_id integer,track integer,year integer,is_ringtone integer,");
        stringBuffer.append("is_music integer,is_alarm integer,is_notification integer,is_podcast integer,");
        stringBuffer.append("bookmark integer,parent_id text,device_id integer,ref_id text,albumart_uri text,");
        stringBuffer.append("upnp_class text,");
        stringBuffer.append("UNIQUE (item_id, device_id))");
        return stringBuffer;
    }

    private StringBuffer f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("create table ");
        stringBuffer.append("Tuner(_id integer primary key autoincrement,");
        stringBuffer.append("item_id text,");
        stringBuffer.append("_data text,mime_type text,title text,parent_id text,device_id integer,albumart_uri text,");
        stringBuffer.append("channel_nr interger,channel_name text,channel_id interger,recordable interger,contentsource interger,");
        stringBuffer.append("program_rating interger,price text,channelid_type text,iptv_contentid text,iptv_userid text,");
        stringBuffer.append("upnp_class text,");
        stringBuffer.append("UNIQUE (item_id, device_id))");
        return stringBuffer;
    }

    public synchronized void close() {
        super.close();
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.execSQL(b().toString());
        sQLiteDatabase.execSQL(a().toString());
        sQLiteDatabase.execSQL(c().toString());
        sQLiteDatabase.execSQL(d().toString());
        sQLiteDatabase.execSQL(e().toString());
        sQLiteDatabase.execSQL(f().toString());
        sQLiteDatabase.endTransaction();
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Device");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Folder");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Image");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Video");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Audio");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Tuner");
        onCreate(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a.c("DatabaseHelper", "Upgrading database from version " + i2 + " to " + i3 + ", which will destroy all old data");
    }
}
