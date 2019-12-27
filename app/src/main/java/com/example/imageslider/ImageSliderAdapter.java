package com.example.imageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

//public class ImageSliderAdapter extends PagerAdapter {
//
//    private int[] imageResources={R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5};
//    private Context context;
//    private LayoutInflater layoutInflater;
//
//    public ImageSliderAdapter(Context context){
//        this.context=context;
//    }
//
//
//
//    @Override
//    public int getCount() {
//        return imageResources.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return (view==(LinearLayout) object);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup viewGroup,int position){
//
//        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view=layoutInflater.inflate(R.layout.image_slider_item,viewGroup,false);
//        ImageView imageView=view.findViewById(R.id.img_imageSlider);
//        imageView.setImageResource(imageResources[position]);
//        TextView textView=view.findViewById(R.id.tv_image_position);
//        textView.setText("Image :" +position);
//        viewGroup.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup viewGroup,int position,Object object){
//        viewGroup.removeView((LinearLayout) object);
//    }
//
//
//}
