package com.example.z.zakater.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.z.zakater.Adapter.RecyclerAdapter;
import com.example.z.zakater.Helper.Helper_zakatFitr;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZFitr;

import java.util.ArrayList;

public class List_ZFitr_Activity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayout mlinearLayout;
    RecyclerAdapter mrecyclerAdapter;
    ArrayList<Model_ZFitr> list;

    //database
    Helper_zakatFitr mHelper_zakatFitr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__zfitr_);
        initView();
        getDataFromDataBase();
        initObjeck();
    }


    private void getDataFromDataBase() {
        mHelper_zakatFitr= new Helper_zakatFitr(getApplicationContext());
        list = mHelper_zakatFitr.getAllData();
    }

    private void initObjeck() {

        mrecyclerAdapter= new RecyclerAdapter(list, getApplicationContext());


        mrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        mrecyclerView.setAdapter(mrecyclerAdapter);

    }

    private void initView() {
      mrecyclerView =findViewById(R.id.recycleView);
      mlinearLayout = findViewById(R.id.linearLayout);
    }
}
