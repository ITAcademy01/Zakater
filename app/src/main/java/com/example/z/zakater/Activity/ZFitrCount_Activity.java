package com.example.z.zakater.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.z.zakater.Helper.Helper_zakatFitr;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZFitr;

public class ZFitrCount_Activity extends AppCompatActivity {


    /*
    * disini adalah deklarasi objeck penamaan variable
    *
    * */
    EditText edtKepalaKel ;
    EditText edtJumlahKel;
    Button btnHitung;
    Button btnRecord;
    TextView texthasil;



    /*
    pembuatan global variable Integer hasilHitung
    agar bisa diakses oleh semua elemen kelas ini */
    Integer hasilHitung;
    Helper_zakatFitr mheHelper_zakatFitr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zfitr_count_);
        initView();


        /*
        * ini adalah evenHandling ketika user mengklik
        * btn hitung maka method ini akan berjalan
        *
        * */
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //kita mengambil nilai dari jumlah Keluarga yg diinput oleh user
                // kemudian menyimpannya dalam variable String jumlahKel;
                String jumlahKel = edtJumlahKel.getText().toString();

                //disini kita mengubah variabletype String ke dalam variableType Integer
                Integer jumlahKelInt = Integer.parseInt(jumlahKel);
/*
                ini adlah pembuatan variable takaran , keyword final berarti
                kita tidak bisa merubahnya setelah inisiasi*/
                final int takaran = 3 ;

                //  Integer hasilHitung = jumlahKelInt * takaran ;
                hasilHitung = jumlahKelInt * takaran;

                texthasil.setText(hasilHitung +" kg");
            }


        });



        //event handling btnRecord, kita menyimpan data keDatabase .
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kita mengambil nama keluarga yg telah diinputkan oleh user
                String namaKeluarga = edtKepalaKel.getText().toString();
                //mengambil jumlah keluarga yg tlah diinputkan oleh user kemudian mengubahnya
                // kedalam variabletype int
                int jumlahKeluarga = Integer.parseInt(edtJumlahKel.getText().toString());
                //mengambil
                int totalZakat = hasilHitung;


                Model_ZFitr modelZakatFitrah = new Model_ZFitr(namaKeluarga, jumlahKeluarga, totalZakat);
                mheHelper_zakatFitr = new Helper_zakatFitr(ZFitrCount_Activity.this);
                mheHelper_zakatFitr.simpanHasilHitung(modelZakatFitrah);

                Intent i = new Intent(ZFitrCount_Activity.this, List_ZFitr_Activity.class);
                startActivity(i);
            }
        });


    }



    /**
     * ini adalah method untuk meng-inisiasi view(Widget) kita yang
     * sudah kita setting id-nya pada file XML kita
     *
     * dengan kata lain kita membuat objeck di file java kemudian kita menghubungkannya
     * dengan id-nya di layout file java trsebut kita
     */
    private void initView() {
        edtKepalaKel= findViewById(R.id.edtkepalaKeluarga);
        edtJumlahKel = findViewById(R.id.editJumlahAnggota);
        texthasil = findViewById(R.id.txthasilhitung);
        btnHitung = findViewById(R.id.btnHitungZakatFitr);
        btnRecord = findViewById(R.id.recordToDb);

    }
}
