package com.example.emon.medipast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MedicalHitoryFragment extends Fragment {

    DBmanager mymanager;
    List<History> namelist;
    RecyclerView myrecyclerView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_history, container, false);
       myrecyclerView=rootView.findViewById(R.id.listViewId);
       mymanager=new DBmanager(getActivity());
       namelist=mymanager.getAllHistoryDoctor();
       HistoryListAdapter historyListAdapter=new HistoryListAdapter(getContext(),namelist,this);
       myrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
       myrecyclerView.setAdapter(historyListAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}