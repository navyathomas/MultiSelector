package com.example.singleSelection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.imageslider.R;
import com.example.imageslider.SingleSelectionActivity;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button buttonOk;
    private MainActivityAdapter mainActivityAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        recyclerView=findViewById(R.id.recycler_view);
        buttonOk=findViewById(R.id.btn_ok);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toNextActivity=new Intent(getApplicationContext(), SingleSelectionActivity.class);
                startActivity(toNextActivity);
            }
        });


        String[] list=new String[]{"Grocery Shop","Mobile Shop","Recharge Shop","Saloon","Electronic Shop","Computer  Shop","Restaurant"};


        mainActivityAdapter=new MainActivityAdapter(list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainActivityAdapter);

    }

}
