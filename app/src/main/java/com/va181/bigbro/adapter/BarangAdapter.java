package com.va181.bigbro.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.va181.bigbro.InputActivity;
import com.va181.bigbro.R;
import com.va181.bigbro.TampilActivity;
import com.va181.bigbro.model.Barang;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder>  {

    private List<Barang> dataBarang;
    private Context context;

    public BarangAdapter(List<Barang> dataBarang, Context context) {
        this.dataBarang = dataBarang;
        this.context = context;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        Barang tempBarang = dataBarang.get(position);
        holder.id = tempBarang.getId();
        holder.namaBarang = tempBarang.getNamaBarang();
        holder.jenis = tempBarang.getJenis();
        holder.tvName.setText(holder.namaBarang);
        holder.tvJumlah.setText(tempBarang.getJumlah());
        String imgLocation = tempBarang.getGambar();
        if(!imgLocation.equals(null)) {
            //Picasso.get().load(imgLocation).resize(64, 64).into(holder.imgAvatar);
            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imgAvatar);
        }
        holder.imgAvatar.setContentDescription(tempBarang.getGambar());
    }

    @Override
    public int getItemCount() {
        return dataBarang.size();
    }

    public class BarangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvName, tvJumlah;
        private CircleImageView imgAvatar;
        private int id;
        private String namaBarang, jenis;

        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvJumlah = itemView.findViewById(R.id.tv_jumlah);
            imgAvatar = itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent openDisplay = new Intent(context, TampilActivity.class);
            openDisplay.putExtra("NAMA_BARANG", namaBarang);
            openDisplay.putExtra("JUMLAH", tvJumlah.getText());
            openDisplay.putExtra("IMAGE", imgAvatar.getContentDescription());
            openDisplay.putExtra("JENIS", jenis);
            itemView.getContext().startActivity(openDisplay);
        }

        @Override
        public boolean onLongClick(View v) {
            Intent openInput = new Intent(context, InputActivity.class);
            openInput.putExtra("OPERATION", "update");
            openInput.putExtra("ID", id);
            openInput.putExtra("NAMA_BARANG", namaBarang);
            openInput.putExtra("JUMLAH", tvJumlah.getText());
            openInput.putExtra("IMAGE", imgAvatar.getContentDescription());
            openInput.putExtra("JENIS", jenis);
            itemView.getContext().startActivity(openInput);
            return true;
        }
    }
}
