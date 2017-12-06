package com.example.z.zakater.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.z.zakater.model.Model_ZFitr;

import java.util.ArrayList;

/**
 * Created by z on 06/12/17.
 */

public class Helper_zakatFitr {
    Context context ;
    DBhelper mdBhelper;
    SQLiteDatabase msqLiteDatabase;
    public Helper_zakatFitr(Context context) {
        this.context = context;
        mdBhelper = new DBhelper(context);
    }

    /**
     * @param model_zFitr
     * @return
     */
    public boolean simpanHasilHitung(Model_ZFitr model_zFitr){
        //kita meminta acces write database,
        // untuk menulis data di database yg telah kita buat
        msqLiteDatabase = mdBhelper.getWritableDatabase();

        //contentvalues kelas untuk menyimpan data sementara sebelum di insert
        ContentValues contentValues = new ContentValues();

        /*
       parameter pertama adalah ke column mana kita akan menyimpan data
       parameter kedua adalah data apa yang kita simpan.   */
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




    public ArrayList <Model_ZFitr>  getAllData(){
        msqLiteDatabase = mdBhelper.getReadableDatabase();
        String [] Allcolumn = { mdBhelper.get_id(),
                mdBhelper.getColNamaKepalakel(), mdBhelper.getColJumlahAngkel(),
                mdBhelper.getColTotalZakatfitrah()

        };



        Cursor cursor = msqLiteDatabase.query(mdBhelper.getTableZakatfitrah(), Allcolumn,
                null, null, null, null , null);
        ArrayList <Model_ZFitr> list = new ArrayList<>();
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String namaKepalaKel = cursor.getString(1);
//        String namaKepalaKel = cursor.getString(cursor.getColumnIndex(mdBhelper.getColNamaKepalakel()));
                int jumlahKeluarga = cursor.getInt(2);
//        int jumlahKeluarga = cursor.getInt(cursor.getColumnIndex(mdBhelper.getColJumlahAngkel()));
                int totalZakat= cursor.getInt(3);
//        int totalZakat= cursor.getInt(cursor.getColumnIndex(mdBhelper.getColTotalZakatfitrah()));
                Model_ZFitr zakatFitrah = new Model_ZFitr(namaKepalaKel, jumlahKeluarga, totalZakat);
                list.add(zakatFitrah);
                cursor.moveToNext();
            }
        }

        return list;

    }





}
