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


    //column name in database
    private final static String FITRAH_id = "id";
    private final static String COL_NAMA_KEPALAKEL = "namaKepalaKel";
    private final static String COL_JUMLAH_ANGKEL= "jumlahAngkel";
    private final static String COL_TOTAL_ZAKATFITRAH = "totalZakatFitrah";


    private final static String TABLE_ZAKATMAL= "zakatmal";

    private final static String MAL_id = "id";
    private final static String COL_NAMA_PEMILIK = "nama";
    private final static String COL_HARGA_EMAS= "hargaemas";
    private final static String COL_TOTAL_ZAKATMAL = "totalzakatmal";




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
                + FITRAH_id +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                //autoincrement berarti dia akan bertambah secara otomatis setiap
                // kita menginputkan sebuah data , dgn kata lain kita tidak perlu mengisi id setiap kali isi data
                //guna dari id sendiri ialah sebagai patokan , ketika melakukan update atau delete
                +COL_NAMA_KEPALAKEL+" TEXT NOT NULL, "
                +COL_JUMLAH_ANGKEL+" INTEGER NOT NULL, "
                +COL_TOTAL_ZAKATFITRAH+" INTEGER NOT NULL)";


        final  String CREATE_TABEL_ZAKATMAL = "create table "+ TABLE_ZAKATMAL +" ("
                + MAL_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_NAMA_PEMILIK+" TEXT NOT NULL, "
                +COL_HARGA_EMAS+" TEXT NOT NULL, "
                +COL_TOTAL_ZAKATMAL+" TEXT NOT NULL)";


        db.execSQL(CREATE_TABEL_ZAKATFITRAH);
        db.execSQL(CREATE_TABEL_ZAKATMAL);


    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ZAKATFITRAH);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_ZAKATMAL);


        // Create tables again
        onCreate(db);



    }


    //ini adalah getter and setter , method getter untuk mengambil nilai sedangkan
    //method setter untuk meng-inisiasi nilai-nya
    public static String getTableZakatfitrah() {
        return TABLE_ZAKATFITRAH;
    }

    public static String getFITRAH_id() {
        return FITRAH_id;
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

    public static String getTableZakatmal() {
        return TABLE_ZAKATMAL;
    }

    public static String getMAL_id() {

        return MAL_id;
    }

    public static String getColNamaPemilik() {
        return COL_NAMA_PEMILIK;
    }

    public static String getColHargaEmas() {
        return COL_HARGA_EMAS;
    }

    public static String getColTotalZakatmal() {
        return COL_TOTAL_ZAKATMAL;
    }
}
