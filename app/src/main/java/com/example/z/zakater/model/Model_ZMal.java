package com.example.z.zakater.model;

/**
 * Created by z on 08/12/17.
 */

public class Model_ZMal  {
    private int id;
    private String namaPemilik;
    private String hargaEmas;
    private String totalZakatMal;

    public Model_ZMal(int id, String namaPemilik, String hargaEmas, String totalZakatMal) {
        this.id = id;
        this.namaPemilik = namaPemilik;
        this.hargaEmas = hargaEmas;
        this.totalZakatMal = totalZakatMal;
    }

    public Model_ZMal(String namaPemilik, String hargaEmas, String totalZakatMal) {
        this.namaPemilik = namaPemilik;
        this.hargaEmas = hargaEmas;
        this.totalZakatMal = totalZakatMal;
    }

    public Model_ZMal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getHargaEmas() {
        return hargaEmas;
    }

    public void setHargaEmas(String hargaEmas) {
        this.hargaEmas = hargaEmas;
    }

    public String getTotalZakatMal() {
        return totalZakatMal;
    }

    public void setTotalZakatMal(String totalZakatMal) {
        this.totalZakatMal = totalZakatMal;
    }
}
