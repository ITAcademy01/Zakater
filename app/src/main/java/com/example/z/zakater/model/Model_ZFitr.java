package com.example.z.zakater.model;

/**
 * Created by z on 06/12/17.
 */

public class Model_ZFitr {
    private int id;
    private int totalHasil ;
    private int jumlahKeluarga;
    private String kepalaKelName  ;



    //constructor dengan 3 parameter -- >
    //parameter adalah sebuah variable/data di method
    // yang dapat diubah dari luar method untuk menginisiasi / menigisi
    // nilai variable2 yang ada dalam sebuah class
    public Model_ZFitr(String kepalaKelName,int totalHasil, int jumlahKeluarga ) {
        this.totalHasil = totalHasil;
        this.jumlahKeluarga = jumlahKeluarga;
        this.kepalaKelName = kepalaKelName;
    }

    public Model_ZFitr (int id, String kepalaKelName, int totalHasil, int jumlahKeluarga) {
        this.id = id;
        this.totalHasil = totalHasil;
        this.jumlahKeluarga = jumlahKeluarga;
        this.kepalaKelName = kepalaKelName;
    }

    public Model_ZFitr() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalHasil() {
        return totalHasil;
    }

    public void setTotalHasil(int totalHasil) {
        this.totalHasil = totalHasil;
    }

    public int getJumlahKeluarga() {
        return jumlahKeluarga;
    }

    public void setJumlahKeluarga(int jumlahKeluarga) {
        this.jumlahKeluarga = jumlahKeluarga;
    }

    public String getKepalaKelName() {
        return kepalaKelName;
    }

    public void setKepalaKelName(String kepalaKelName) {
        this.kepalaKelName = kepalaKelName;
    }
}
