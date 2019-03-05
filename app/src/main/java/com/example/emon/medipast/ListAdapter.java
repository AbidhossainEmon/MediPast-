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
import android.widget.Toast;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {
   Context mContext;
   List<person> personList;
   Fragment mFragment;


    public ListAdapter(Context mContext, List<person> personList, Fragment fragment) {
        this.mContext = mContext;
        this.personList = personList;
        this.mFragment=fragment;

    }




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v=LayoutInflater.from(mContext).inflate(R.layout.item_layout,viewGroup,false);
        CustomViewHolder vHolder=new CustomViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder myViewHolder, final int i) {

        myViewHolder.nameTV.setText(personList.get(i).getName());
        myViewHolder.phoneTV.setText(personList.get(i).getPhoneNumber());



         myViewHolder.mCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DoctorDetail.class);
                intent.putExtra("name",personList.get(i).getName());
                intent.putExtra("details",personList.get(i).getDetails());
                intent.putExtra("date",personList.get(i).getAppointment());
                intent.putExtra("phone",personList.get(i).getPhoneNumber());
                intent.putExtra("email",personList.get(i).getEmail());
                intent.putExtra("id",personList.get(i).getId());

                mContext.startActivity(intent);




                }
        });



    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView nameTV, phoneTV;
          CardView mCard;


        public CustomViewHolder(@NonNull View itemView) {

            super(itemView);

            nameTV=itemView.findViewById(R.id.nameTVid);
            phoneTV=itemView.findViewById(R.id.phoneTvId);
            mCard=itemView.findViewById(R.id.myCard);

        }

    }
}
