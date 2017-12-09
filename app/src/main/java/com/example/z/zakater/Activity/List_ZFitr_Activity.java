package com.example.z.zakater.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.z.zakater.Adapter.RecyclerAdapterZfit;
import com.example.z.zakater.Helper.Hlp_zakat;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZFitr;

import java.util.ArrayList;

public class List_ZFitr_Activity extends AppCompatActivity {

    RecyclerView mrecyclerView;
    RelativeLayout mlinearLayout;
    RecyclerAdapterZfit mrecyclerAdapterZfit;
    ArrayList<Model_ZFitr> list;
    ImageView addImage;


    //database
    Hlp_zakat mHlp_zakat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__zfitr_);
        initView();
        getDataFromDataBase();
        initObjeck();
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(List_ZFitr_Activity.this, ZFitrCount_Activity.class);
                startActivity(i);
                finish();
            }
        });

    }


    private void getDataFromDataBase() {
        mHlp_zakat = new Hlp_zakat(getApplicationContext());
        list = mHlp_zakat.getAllDataFitr();

    }

    private void initObjeck() {

        mrecyclerAdapterZfit = new RecyclerAdapterZfit(list, this);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mrecyclerView.setAdapter(mrecyclerAdapterZfit);

    }

    private void initView() {
      mrecyclerView =findViewById(R.id.recycleView);
      mlinearLayout = findViewById(R.id.linearLayout);
      addImage = findViewById(R.id.aimgdd);
    }

    public void delete(Model_ZFitr model_zFitr){
        mHlp_zakat.deleteDataFitrFromDb(model_zFitr);
        list.remove(model_zFitr);
        mrecyclerAdapterZfit.notifyDataSetChanged();
        Toast.makeText(this, "Berhasil mendelete data", Toast.LENGTH_SHORT).show();

    }
}
