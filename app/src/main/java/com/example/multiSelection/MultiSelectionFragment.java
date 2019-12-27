package com.example.multiSelection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.MultiSelectorModel.MultipleData;
import com.example.imageslider.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MultiSelectionFragment extends Fragment implements MultiSelectionAdapter.MultiSelector {

    private RecyclerView multiSelectionRecycler;
    private Button bttuonOk,btnSingleSelection;
    private MultiSelectionAdapter multiSelectionAdapter;
    private List<MultipleData> multipleDataList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        final View view = layoutInflater.inflate(R.layout.activity_multi_selector, viewGroup, false);
        multiSelectionRecycler = view.findViewById(R.id.recy_multi_selection);
        bttuonOk = view.findViewById(R.id.btn_Ok);


        bttuonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (multiSelectionAdapter.getSelected().size() > 0) {

                    StringBuilder stringBuilder = new StringBuilder();

                    for (int i = 0; i < multiSelectionAdapter.getSelected().size(); i++) {

                       // stringBuilder.append(multiSelectionAdapter.getSelected().get(i).getTitle());
                       // stringBuilder.append("\n");
                    }
                  //  showToast(stringBuilder.toString().trim());
                }
                else {
                    Toast.makeText(getActivity(), "No Selection", Toast.LENGTH_LONG).show();
                }
            }
        });


        MultipleData groceryshop = new MultipleData("Grocery Shop", false);
        MultipleData MobileShop = new MultipleData("Mobile Shop", false);
        MultipleData RechargeShop = new MultipleData("Recharge Shop", false);
        MultipleData Saloon = new MultipleData("Saloon", false);
        MultipleData ElectronicShop = new MultipleData("Electronic Shop", false);
        MultipleData ComputerShop = new MultipleData("Computer  Shop", false);
        MultipleData Restaurant = new MultipleData("Restaurant", false);


        List<MultipleData> listData = new ArrayList<>();
        listData.add(groceryshop);
        listData.add(MobileShop);
        listData.add(RechargeShop);
        listData.add(Saloon);
        listData.add(ElectronicShop);
        listData.add(ComputerShop);
        listData.add(Restaurant);


        multiSelectionAdapter = new MultiSelectionAdapter(listData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        multiSelectionRecycler.setLayoutManager(linearLayoutManager);
        multiSelectionRecycler.setAdapter(multiSelectionAdapter);

        multiSelectionAdapter.setOnClickMultiSelector(this);
        return view;
    }


    private void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();

    }


    @Override
    public void setMultiSelector(int adapterPosition, View view) {
        multiSelectionAdapter.changeData(adapterPosition);
    }
}
