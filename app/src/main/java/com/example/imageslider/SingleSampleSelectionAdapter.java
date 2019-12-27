package com.example.imageslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SingleSampleSelectionAdapter extends RecyclerView.Adapter<SingleSampleSelectionAdapter.ViewHolder> {

    private String[] mData;
    private LayoutInflater layoutInflater;
    private SetOnClickListener setOnClickListener;
    private int selection=0;

    public SingleSampleSelectionAdapter(String[] lists) {
        mData=lists;
    }


    interface SetOnClickListener{
        void setSetOnClickListener(int adapterPosition,View view);
    }

    void setOnClickListener(SetOnClickListener setOnClickListener1){
        setOnClickListener=setOnClickListener1;

    }

    public void setSelectedd(){
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.selector_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        CheckBox checkBox;

        public ViewHolder(View view){
            super(view);

            textView=view.findViewById(R.id.tv_shopCategory);
            checkBox=view.findViewById(R.id.chck_box);

            view.setOnClickListener(this);

        }


        @Override
        public void onClick(View view){
            selection=getAdapterPosition();
            setOnClickListener.setSetOnClickListener(getAdapterPosition(),view);
        }

    }
}
