package com.example.singleSelection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.imageslider.R;
import com.example.imageslider.SingleSelectionAdapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolderr> {
    private String[] mData;
    private LayoutInflater layoutInflater;
    private int currentPosition=0;





    public MainActivityAdapter(String[] list){
        this.mData=list;

    }


    @NonNull
    @Override
    public MainActivityAdapter.ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.selector_item,parent,false);
        return new MainActivityAdapter.ViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdapter.ViewHolderr holder, int position) {

        holder.textView.setText(mData[position]);
        holder.bind(mData.length);
    }


    @Override
    public int getItemCount() {
        return mData.length;
    }


    public class ViewHolderr extends RecyclerView.ViewHolder{
        TextView textView;
        CheckBox checkBox;

        public ViewHolderr(View view){
            super(view);

            textView=view.findViewById(R.id.tv_shopCategory);
            checkBox=view.findViewById(R.id.chck_box);
        }

        void bind(final int string){

            textView.setText(string);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (currentPosition!=getAdapterPosition()){
                        notifyItemChanged(currentPosition);
                        currentPosition=getAdapterPosition();

                    }
                }
            });

        }
    }

//    public String getSelected(){
//        if (currentPosition!=-1){
//            return mData.
//        }
//        return null;

}
