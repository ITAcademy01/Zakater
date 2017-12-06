package com.example.z.zakater.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZFitr;

import java.util.ArrayList;

/**
 * Created by z on 06/12/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<Model_ZFitr> list ;
    Context context;

    public RecyclerAdapter(ArrayList<Model_ZFitr> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlist, null );
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        holder.tnama_kepala_kel.setText(list.get(position).getKepalaKelName());
        holder.tjumlah_keluarga.setText((list.get(position).getJumlahKeluarga())+"");
        holder.tTotal_zakat.setText((list.get(position).getTotalHasil())+"");
    }

    /**
     * @return jumlah list yg akan tampil
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * ini adalah kelas ViewHolder gunanya adalah meminimalisir penggunaan memori ,
     * karena kalau tidak pakai viewholder berarti kita setiap list
     * yg kita buatharus melalukan casting. dengannya kita menghemat dgn me-recycleview
     *
     */
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tnama_kepala_kel;
        TextView tjumlah_keluarga;
        TextView tTotal_zakat;

        public ViewHolder(View itemView) {
            super(itemView);
            tnama_kepala_kel = itemView.findViewById(R.id.text_jumlahKeluarga);
            tjumlah_keluarga= itemView.findViewById(R.id.text_kepalakeluarga);
            tTotal_zakat = itemView.findViewById(R.id.text_totalZakat);
        }
    }


}
