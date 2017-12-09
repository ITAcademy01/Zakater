package com.example.z.zakater.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.z.zakater.Adapter.RecyclerAdapterZmal;
import com.example.z.zakater.Helper.Hlp_zakat;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZMal;

import java.util.ArrayList;

/**
 * Created by z on 08/12/17.
 */

public class List_Zmal_Acitivity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    RelativeLayout mlinearLayout;
    RecyclerAdapterZmal mrecyclerAdapterZmal;
    ArrayList<Model_ZMal> list;
    ImageView addImage;

    Hlp_zakat mHlp_zakat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__zfitr_);
        initView();
        getDataFromDataBase();
        initObjeck();

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(List_Zmal_Acitivity.this, ZMalCount_Activity.class);
                startActivity(i);
                finish();
            }
        });

    }
        private void getDataFromDataBase() {
            mHlp_zakat = new Hlp_zakat(getApplicationContext());
            list = mHlp_zakat.getAllDataMal();

        }


    private void initObjeck() {

        mrecyclerAdapterZmal = new RecyclerAdapterZmal(list, this);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mrecyclerView.setAdapter(mrecyclerAdapterZmal);

    }


    private void initView() {
        mrecyclerView =findViewById(R.id.recycleView);
        mlinearLayout = findViewById(R.id.linearLayout);
        addImage = findViewById(R.id.aimgdd);
    }

    public void delete(Model_ZMal model_zMal){
        mHlp_zakat.deleteDataMalFromDb(model_zMal);
        list.remove(model_zMal);
        mrecyclerAdapterZmal.notifyDataSetChanged();
        Toast.makeText(this, "Berhasil mendelete data", Toast.LENGTH_SHORT).show();

    }
}
