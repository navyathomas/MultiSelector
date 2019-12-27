package com.example.multiSelection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.MultiSelectorModel.MultipleData;
import com.example.imageslider.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MultiSelectionAdapter extends RecyclerView.Adapter<MultiSelectionAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private List<MultipleData> multipleData;
    private MultiSelector multiSelector;
    private int selection = 0;


    public MultiSelectionAdapter(List<MultipleData> multipleData1) {
        this.multipleData = multipleData1;
    }

    //listener//
    interface MultiSelector {
        void setMultiSelector(int adapterPosition, View view);
    }

    void setOnClickMultiSelector(MultiSelector multiSelector1) {
        multiSelector = multiSelector1;
    }

    public void setSelected() {
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.multi_selection_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.textViewItem.setText(multipleData.get(position).getTitle());
        holder.checkmultiChecked.setChecked(multipleData.get(position).isaBoolean());

    }

    @Override
    public int getItemCount() {
        return multipleData.size();
    }



    void changeData(int position) {

        if (multipleData.get(position).isaBoolean()) {
            multipleData.get(position).setaBoolean(false);
        } else {
            multipleData.get(position).setaBoolean(true);
            multipleData.remove(getSelected());
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewItem;
        CheckBox checkmultiChecked;
        RelativeLayout reltselected;

        public ViewHolder(final View view) {
            super(view);

            textViewItem = view.findViewById(R.id.tv_multiSelection_text);
            checkmultiChecked = view.findViewById(R.id.check_multiChecked);

            checkmultiChecked.setOnClickListener(this);

            checkmultiChecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                    checkmultiChecked.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            if (checkmultiChecked.isChecked()){
                                Toast.makeText(view.getContext(),textViewItem.getText(), Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(v.getContext(),textViewItem.getText() +"  removed",Toast.LENGTH_LONG).show();
                            }



                        }
                    });

                }
            });
        }


        @Override
        public void onClick(View v) {

            notifyItemChanged(selection);
            selection = getAdapterPosition();
            multiSelector.setMultiSelector(getAdapterPosition(), v);
            notifyItemChanged(selection);
        }
    }


    public List<MultipleData> getSelected() {
        List<MultipleData> multipleData1 = new ArrayList<>();
        for (int i = 0; i < multipleData.size(); i++) {
            if (multipleData.get(i).isaBoolean()) {
                multipleData1.add(multipleData.get(i));
            }
        }
        return multipleData1;
    }
}
