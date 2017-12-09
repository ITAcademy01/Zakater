package com.example.z.zakater.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.z.zakater.model.Model_ZFitr;
import com.example.z.zakater.model.Model_ZMal;

import java.util.ArrayList;

/**
 * Created by z on 06/12/17.
 */

public class Hlp_zakat {
    Context context ;
    DBhelper mdBhelper;
    SQLiteDatabase msqLiteDatabase;


    public Hlp_zakat(Context context) {
        this.context = context;
        mdBhelper = new DBhelper(context);
    }

    /**
     * @param model_zFitr = meminta data yg disimpan kedalam model
     *
     * @return
     */
    public boolean simpanHslZFitr(Model_ZFitr model_zFitr){
        // meminta acces write database,
        msqLiteDatabase = mdBhelper.getWritableDatabase();

        //contentvalues kelas untuk menyimpan data sementara sebelum di insert
        ContentValues contentValues = new ContentValues();

        /*
       parameter pertama adalah ke column mana kita akan menyimpan data
       parameter kedua adalah data apa yang akan kita simpan.   */
        contentValues.put(mdBhelper.getColNamaKepalakel(), model_zFitr.getKepalaKelName());
        contentValues.put(mdBhelper.getColJumlahAngkel(), model_zFitr.getJumlahKeluarga());
        contentValues.put(mdBhelper.getColTotalZakatfitrah(), model_zFitr.getTotalHasil());

        //variable insert sebagai patokan apakah insertmethod kita berhasil atau tidak,
        // jika  mengmbalikan nilai -1 berarti gagal .
        long insert = msqLiteDatabase.insert(mdBhelper.getTableZakatfitrah(), null, contentValues);

        //flow control , cek berhasil atau tidaknya input kita
        if (insert > -1){
            Toast.makeText(context, "BERHASIL", Toast.LENGTH_SHORT).show();
            return true ;

        }else{
            Toast.makeText(context, "GAGAL", Toast.LENGTH_SHORT).show();
            return false ;
        }
    }


    public boolean simpanHslZMal(Model_ZMal model_zMal){
        // meminta acces write database,
        msqLiteDatabase = mdBhelper.getWritableDatabase();

        //contentvalues kelas untuk menyimpan data sementara sebelum di insert
        ContentValues contentValues = new ContentValues();

        /*
       parameter pertama adalah ke column mana kita akan menyimpan data
       parameter kedua adalah data apa yang akan kita simpan.   */
        contentValues.put(mdBhelper.getColNamaPemilik(), model_zMal.getNamaPemilik());
        contentValues.put(mdBhelper.getColHargaEmas(), model_zMal.getHargaEmas());
        contentValues.put(mdBhelper.getColTotalZakatmal(), model_zMal.getTotalZakatMal());

        //variable insert sebagai patokan apakah insertmethod kita berhasil atau tidak,
        // jika  mengmbalikan nilai -1 berarti gagal .
        long insert = msqLiteDatabase.insert(mdBhelper.getTableZakatmal(), null, contentValues);

        //flow control , cek berhasil atau tidaknya input kita
        if (insert > -1){
            Toast.makeText(context, "BERHASIL", Toast.LENGTH_SHORT).show();
            return true ;

        }else{
            Toast.makeText(context, "GAGAL", Toast.LENGTH_SHORT).show();
            return false ;
        }
    }




    public ArrayList <Model_ZFitr> getAllDataFitr(){
        msqLiteDatabase = mdBhelper.getReadableDatabase();
        String [] Allcolumn = { mdBhelper.getFITRAH_id(),
                mdBhelper.getColNamaKepalakel(), mdBhelper.getColJumlahAngkel(),
                mdBhelper.getColTotalZakatfitrah()};

        Cursor cursor = msqLiteDatabase.query(mdBhelper.getTableZakatfitrah(), Allcolumn,
                null, null, null, null , null);
        ArrayList <Model_ZFitr> list = new ArrayList<>();
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){

                int id = cursor.getInt(0);
                String namaKepalaKel = cursor.getString(1);
            //String namaKepalaKel = cursor.getString(cursor.getColumnIndex(mdBhelper.getColNamaKepalakel()));
                int jumlahKeluarga = cursor.getInt(2);
            //int jumlahKeluarga = cursor.getInt(cursor.getColumnIndex(mdBhelper.getColJumlahAngkel()));
                int totalZakat= cursor.getInt(3);
            //int totalZakat= cursor.getInt(cursor.getColumnIndex(mdBhelper.getColTotalZakatfitrah()));
                Model_ZFitr zakatFitrah = new Model_ZFitr(id, namaKepalaKel, jumlahKeluarga, totalZakat);
                list.add(zakatFitrah);
                cursor.moveToNext();
            }
        }

        return list;

    }


    public ArrayList <Model_ZMal> getAllDataMal(){
        msqLiteDatabase = mdBhelper.getReadableDatabase();
        String [] Allcolumn = { mdBhelper.getMAL_id(),
                mdBhelper.getColNamaPemilik(), mdBhelper.getColHargaEmas(),
                mdBhelper.getColTotalZakatmal()};


        Cursor cursor = msqLiteDatabase.query(mdBhelper.getTableZakatmal(), Allcolumn,
                null, null, null, null , null);
        ArrayList <Model_ZMal> list = new ArrayList<>();
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){

                int id = cursor.getInt(0);
                String namaKepalaKel = cursor.getString(1);
            //String namaKepalaKel = cursor.getString(cursor.getColumnIndex(mdBhelper.getColNamaKepalakel()));
                String jumlahKeluarga = cursor.getString(2);
            //int jumlahKeluarga = cursor.getInt(cursor.getColumnIndex(mdBhelper.getColJumlahAngkel()));
                String totalZakat= cursor.getString(3);
            //int totalZakat= cursor.getInt(cursor.getColumnIndex(mdBhelper.getColTotalZakatfitrah()));
                Model_ZMal zakatmal= new Model_ZMal(id, namaKepalaKel, jumlahKeluarga, totalZakat);
                list.add(zakatmal);
                cursor.moveToNext();
            }
        }

        return list;

    }


    public void deleteDataFitrFromDb(Model_ZFitr model_zFitr){
        msqLiteDatabase = mdBhelper.getWritableDatabase();
        int id = model_zFitr.getId();
        msqLiteDatabase.delete(mdBhelper.getTableZakatfitrah(), mdBhelper.getFITRAH_id()+"="+id,null );


    }
      public void deleteDataMalFromDb(Model_ZMal model_zMal){
        msqLiteDatabase = mdBhelper.getWritableDatabase();
        int id = model_zMal.getId();
        msqLiteDatabase.delete(mdBhelper.getTableZakatmal(), mdBhelper.getMAL_id()+"="+id,null );


    }








}
