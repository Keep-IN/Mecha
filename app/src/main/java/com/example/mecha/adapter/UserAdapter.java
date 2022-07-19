package com.example.mecha.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mecha.R;
import com.example.mecha.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context context;
    private List<User> list;
    private Dialog dialog;



    public interface Dialog{
        void onClick(int pos);
    }

    public Dialog getDialog() {
        return dialog;
    }

    public UserAdapter(Context context,List<User>list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_accepting_services,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(list.get(position).getNama());
        holder.alamat.setText(list.get(position).getAlamat());
        holder.harga.setText(list.get(position).getHarga());
        holder.jenisorderan.setText(list.get(position).getJenisorderan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama,alamat,harga,jenisorderan;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.nama);
            alamat = itemView.findViewById(R.id.alamat);
            harga = itemView.findViewById(R.id.harga);
            jenisorderan = itemView.findViewById(R.id.jenisorderan);
        }
    }
}
