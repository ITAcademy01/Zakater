package com.example.z.zakater.Adapter;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z.zakater.Activity.List_Zmal_Acitivity;
import com.example.z.zakater.R;
import com.example.z.zakater.model.Model_ZMal;

import java.util.ArrayList;

/**
 * Created by z on 06/12/17.
 */

public class RecyclerAdapterZmal extends RecyclerView.Adapter<RecyclerAdapterZmal.ViewHolder>  {
    ArrayList<Model_ZMal> list ;
    List_Zmal_Acitivity activity;

    public RecyclerAdapterZmal(ArrayList<Model_ZMal> list, List_Zmal_Acitivity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public RecyclerAdapterZmal.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlistmal, null );
        ViewHolder holder = new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapterZmal.ViewHolder holder, int position) {

        holder.tnama_pemilik.setText(list.get(position).getNamaPemilik());
        holder.tHargaEmas.setText((list.get(position).getHargaEmas()));
        holder.tTotalZakatMal.setText((list.get(position).getTotalZakatMal()));
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
        TextView tnama_pemilik;
        TextView tHargaEmas;
        TextView tTotalZakatMal;
        ImageView delete;

        public ViewHolder(View itemView) {
            super(itemView);
            tnama_pemilik = itemView.findViewById(R.id.text_kepalakeluarga);
            tHargaEmas = itemView.findViewById(R.id.text_jumlahKeluarga);
            tTotalZakatMal = itemView.findViewById(R.id.text_totalZakat);
            delete = itemView.findViewById(R.id.imgDelete);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Delete");
            builder.setMessage("Yakin mendelete data ini dari database");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    activity.delete(getItem(getAdapterPosition()));
                }
            });
            builder.setNeutralButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();

        }


    }

    public Model_ZMal getItem(int position){
        return list.get(position);
    }

}
