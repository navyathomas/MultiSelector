package com.example.imageslider;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SingleSampleSelectionActivity extends AppCompatActivity implements SingleSampleSelectionAdapter.SetOnClickListener  {

    private SingleSampleSelectionAdapter singleSampleSelectionAdapter;
    private RecyclerView recyclerView;
    private String[] lists=new String[]{"Grocery Shop","Mobile Shop","Recharge Shop","Saloon","Electronic Shop","Computer  Shop","Restaurant"};



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        recyclerView=findViewById(R.id.recycler_view);

        setAdapter();



    }


    private void setAdapter(){
        singleSampleSelectionAdapter=new SingleSampleSelectionAdapter(lists);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(singleSampleSelectionAdapter);
        singleSampleSelectionAdapter.setOnClickListener(this);

    }

    @Override
    public void setSetOnClickListener(int adapterPosition, View view) {
        singleSampleSelectionAdapter.setSelectedd();
    }
}
