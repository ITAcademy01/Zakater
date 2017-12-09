package com.example.z.zakater.Adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z.zakater.Activity.List_ZFitr_Activity;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZFitr;

import java.util.ArrayList;

/**
 * Created by z on 06/12/17.
 */

public class RecyclerAdapterZfit extends RecyclerView.Adapter<RecyclerAdapterZfit.ViewHolder>  {
    ArrayList<Model_ZFitr> list ;
    List_ZFitr_Activity Zfitr_list;

    public RecyclerAdapterZfit(ArrayList<Model_ZFitr> list, List_ZFitr_Activity Zfitr_list) {
        this.list = list;
        this.Zfitr_list = Zfitr_list;
    }



    @Override
    public RecyclerAdapterZfit.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlistfitr, null );
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterZfit.ViewHolder holder, int position) {

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
     */
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tnama_kepala_kel;
        TextView tjumlah_keluarga;
        TextView tTotal_zakat;
        ImageView delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tnama_kepala_kel = itemView.findViewById(R.id.text_kepalakeluarga);
            tjumlah_keluarga= itemView.findViewById(R.id.text_jumlahKeluarga);
            tTotal_zakat = itemView.findViewById(R.id.text_totalZakat);
            delete = itemView.findViewById(R.id.imgDelete);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(Zfitr_list);
            builder.setTitle("Delete");
            builder.setMessage("Yakin mendelete data ini dari database");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Zfitr_list.delete(getItem(getAdapterPosition()));
                    Log.i("adsa", getAdapterPosition()+"");
                }
            });
            Log.i("adsa", getAdapterPosition()+"");
            builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();

        }


    }

    public Model_ZFitr getItem(int position){
        return list.get(position);
    }

}
