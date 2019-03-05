package com.example.emon.medipast;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.MyViewHolder> {
    private Context context;
    List<History> historyList;
    Fragment fragment;

    public HistoryListAdapter(Context context, List<History> historyList, Fragment fragment) {
        this.context = context;
        this.historyList = historyList;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
   View v;
   v=LayoutInflater.from(context).inflate(R.layout.history_item,viewGroup,false);
   MyViewHolder myViewHolder=new MyViewHolder(v);

   return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.nameTV.setText(historyList.get(i).getName());
        myViewHolder.phoneTV.setText(historyList.get(i).getAppointment());

        myViewHolder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,HistoryDetailsActivity.class);
                intent.putExtra("image",historyList.get(i).getImage());
                intent.putExtra("name",historyList.get(i).getName());
                intent.putExtra("details",historyList.get(i).getDetails());
                intent.putExtra("date",historyList.get(i).getAppointment());
                intent.putExtra("id",historyList.get(i).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV, phoneTV;
        CardView mCard;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        nameTV=itemView.findViewById(R.id.historynameTVid);
        phoneTV=itemView.findViewById(R.id.historyphoneTvid);
        mCard=itemView.findViewById(R.id.historyCard);
    }
    }


  }

