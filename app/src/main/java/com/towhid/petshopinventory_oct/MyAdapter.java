package com.towhid.petshopinventory_oct;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataName());
        holder.recType.setText(dataList.get(position).getDataDesc());
        holder.recCage.setText(dataList.get(position).getDataCageno());
        holder.recSchedule.setText(dataList.get(position).getDataSchedule());


        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Description", dataList.get(holder.getAdapterPosition()).getDataDesc());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Key", dataList.get(holder.getAdapterPosition()).getKey());
                intent.putExtra("Cage No", dataList.get(holder.getAdapterPosition()).getDataCageno());
                intent.putExtra("Type",dataList.get(holder.getAdapterPosition()).getDataType());
                intent.putExtra("Seller name",dataList.get(holder.getAdapterPosition()).getDataSellerName());
                intent.putExtra("Seller Address",dataList.get(holder.getAdapterPosition()).getDataSellerAdress());
                intent.putExtra("Price",dataList.get(holder.getAdapterPosition()).getDataPetPrice());
                intent.putExtra("Purchase Date",dataList.get(holder.getAdapterPosition()).getDataPurchaseDate());
                intent.putExtra("Food Schedule",dataList.get(holder.getAdapterPosition()).getDataSchedule());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList) {
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView recImage;
    TextView recTitle, recCage, recType, recSchedule;
    CardView recCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recType = itemView.findViewById(R.id.recType);
        recTitle = itemView.findViewById(R.id.recTitle);
        recCage = itemView.findViewById(R.id.recCage);
        recSchedule = itemView.findViewById(R.id.recSchedule);


    }
}