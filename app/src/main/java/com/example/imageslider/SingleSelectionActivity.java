package com.example.imageslider;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SingleSelectionActivity extends Fragment implements SingleSelectionAdapter.SingleClickListener {

    private RecyclerView recyclerView;
    private SingleSelectionAdapter singleSelectionAdapter;
    public  Context context;
    private Button bttunSelector;
    private SingleSelectionAdapter.SingleClickListener interfaceListener;


    public SingleSelectionActivity(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup,Bundle savedInstanceState){
        final View view=layoutInflater.inflate(R.layout.activity_selector,viewGroup,false);
        recyclerView=view.findViewById(R.id.recycler_view);
        String[] list=new String[]{"Grocery Shop","Mobile Shop","Recharge Shop","Saloon","Electronic Shop","Computer  Shop","Restaurant"};

        bttunSelector=view.findViewById(R.id.btn_ok);

        bttunSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (singleSelectionAdapter.getSelected().length>0){

                    StringBuilder stringBuilder=new StringBuilder();

                    for (int i=0;i<singleSelectionAdapter.getSelected().length;i++){

                        stringBuilder.append(singleSelectionAdapter.getSelected().length);
                    }
                    Toast.makeText(getContext(),stringBuilder.toString().trim(),Toast.LENGTH_LONG).show();
                }

                else {

                }
            }
        });


        singleSelectionAdapter=new SingleSelectionAdapter(list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(singleSelectionAdapter);
//      RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration();
//      recyclerView.addItemDecoration(itemDecoration);
        singleSelectionAdapter.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClickListener(int adapterPosition, View v) {
        singleSelectionAdapter.selectedItem();
    }
}
