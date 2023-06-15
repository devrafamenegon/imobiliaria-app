package com.example.imobiliariaapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imobiliariaapp.Domain.ItemsDomain;
import com.example.imobiliariaapp.R;
import com.example.imobiliariaapp.View.DetailActivity;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    ArrayList<ItemsDomain> items;
    NumberFormat formatter;
    Context context;

    public ItemsAdapter(ArrayList<ItemsDomain> items) {
        this.items = items;
        formatter = NumberFormat.getInstance(new Locale("pt", "BR"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position).getTitle());
        holder.addressTxt.setText(items.get(position).getAddress());
        holder.priceTxt.setText("R$" + formatter.format(items.get(position).getPrice()));

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageView);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("propertyValues", items.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTxt, addressTxt, priceTxt;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.itemTxtViewTitle);
            addressTxt = itemView.findViewById(R.id.itemTxtViewAddress);
            priceTxt = itemView.findViewById(R.id.itemTxtViewPrice);
            imageView = itemView.findViewById(R.id.itemImage);
        }
    }
}
