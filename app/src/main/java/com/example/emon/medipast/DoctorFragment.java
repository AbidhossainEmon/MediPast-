package com.example.emon.medipast;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Person;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.content.ContentValues.TAG;

public class DoctorFragment extends Fragment {

    private List<person> personList;
    RecyclerView myrecyclerView;
    private DBmanager manager;
    private View rootView, v;
    TextView textView;






    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View V;
        manager = new DBmanager(getActivity());
        personList = manager.getAllStudent();


        if (personList.size()<1) ;
        {

            rootView = inflater.inflate(R.layout.startup_activity, container, false);

            V =rootView;
        }


 if (personList.size()>0){
            rootView = inflater.inflate(R.layout.activity_doctor, container, false);
            myrecyclerView = rootView.findViewById(R.id.recyclerview);
            ListAdapter mAdapter = new ListAdapter(getContext(), personList, this);
            myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            myrecyclerView.setAdapter(mAdapter);
            V =rootView;

        }
        return V;
        }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
                       super.onCreate(savedInstanceState);


                       }


}
