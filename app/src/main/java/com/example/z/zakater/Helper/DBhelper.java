package com.example.z.zakater.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by z on 06/12/17.
 */

public class DBhelper extends SQLiteOpenHelper{


    public final static String DATABASE_NAME = "zakatdb";
    private final static String TABLE_ZAKATFITRAH = "zakatfitrah";
    private final static int DATABASE_VERSION = 1;


    //nama nama column, kenapa kita buat dia
    private final static String _id = "id";
    private final static String COL_NAMA_KEPALAKEL = "namaKepalaKel";
    private final static String COL_JUMLAH_ANGKEL= "jumlahAngkel";
    private final static String COL_TOTAL_ZAKATFITRAH = "totalZakatFitrah";




    /*
    * ini constructor , ketika objecknya dibuat maka database juga akan dibuat  */
    public DBhelper(Context context) {


        super(context, DATABASE_NAME, null,DATABASE_VERSION );
    }


    /*
    * ketika Db helper pertama kali dibuat objecknya maka dia akan meng-create table Zakat fitrah*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        final  String CREATE_TABEL_ZAKATFITRAH = "create table "+ TABLE_ZAKATFITRAH +" ("
                +_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                //autoincrement berarti dia akan bertambah secara otomatis setiap
                // kita menginputkan sebuah data , dgn kata lain kita tidak perlu mengisi id setiap kali isi data
                //guna dari id sendiri ialah sebagai patokan , ketika melakukan update atau delete
                +COL_NAMA_KEPALAKEL+" TEXT NOT NULL, "
                +COL_JUMLAH_ANGKEL+" INTEGER NOT NULL, "
                +COL_TOTAL_ZAKATFITRAH+" INTEGER NOT NULL)";
        db.execSQL(CREATE_TABEL_ZAKATFITRAH);



    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //ini adalah getter and setter , method getter untuk mengambil nilai sedangkan
    //method setter untuk meng-inisiasi nilai-nya
    public static String getTableZakatfitrah() {
        return TABLE_ZAKATFITRAH;
    }

    public static String get_id() {
        return _id;
    }

    public static String getColNamaKepalakel() {
        return COL_NAMA_KEPALAKEL;
    }

    public static String getColJumlahAngkel() {
        return COL_JUMLAH_ANGKEL;
    }

    public static String getColTotalZakatfitrah() {
        return COL_TOTAL_ZAKATFITRAH;
    }

}
