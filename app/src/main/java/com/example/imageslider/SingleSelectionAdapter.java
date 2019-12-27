package com.example.imageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SingleSelectionAdapter extends RecyclerView.Adapter<SingleSelectionAdapter.ViewHolderr> {

    private String[] mData;
    private static SingleClickListener singleClickListener;
    public Context mcontext;
    private static int selection=-1;

    public SingleSelectionAdapter(String[] list) {
        this.mData=list;
    }


    /**setting listener for adapter**/
    interface SingleClickListener{
        void onItemClickListener(int adapterPosition, View v);
    }

    void setOnItemClickListener(SingleClickListener singleClickListenerr){
        singleClickListener=singleClickListenerr;
    }



    public void selectedItem(){
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public SingleSelectionAdapter.ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_item,parent,false);
        ViewHolderr viewHolder=new ViewHolderr(view);
        //return new SingleSelectionAdapter.ViewHolderr(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {

        holder.textViewSelectorName.setText(mData[position]);


        if (selection==position){
            holder.checkBoxSelector.setChecked(true);

        }
        else {
            holder.checkBoxSelector.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }



    public static class ViewHolderr extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewSelectorName;
        CheckBox checkBoxSelector;

        public ViewHolderr(View view){
            super(view);

            textViewSelectorName=view.findViewById(R.id.tv_shopCategory);
            checkBoxSelector=view.findViewById(R.id.chck_box);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            selection=getAdapterPosition();
            singleClickListener.onItemClickListener(getAdapterPosition(),v);
        }
    }


    public String[] getSelected(){
        if (selection!=-1){
            return mData;
        }

//        String[] mdatas=new String[]{};
//
//        for (int i=0;i<mData.length;i++){
//
//
//        }

        return null;
    }

}