package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.multiSelection.MultiSelectionFragment;

import java.util.Timer;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

  //  private ImageSliderAdapter imageSliderAdapter;
    private ViewPager viewPager;
    private int currentPage=0;
    private int Num_pages=0;
    private Timer timer;
    final long Delay_time=500;
    final long Period_Ms=3000;

    private Button button;
    private FrameLayout frameLayout;


    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.selector);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNextActivity=new Intent(getApplicationContext(), SingleSelectionActivity.class);
                startActivity(toNextActivity);
            }
        });




//        imageSliderAdapter=new ImageSliderAdapter(this);
//        viewPager=findViewById(R.id.view_pager);
        frameLayout=findViewById(R.id.frame_container);


        fragmentManager=getSupportFragmentManager();

        if (findViewById(R.id.frame_container) !=null){

            if (savedInstanceState!=null){
            }
            final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            MultiSelectionFragment singleSelectionActivity=new MultiSelectionFragment();
            fragmentTransaction.add(R.id.frame_container,singleSelectionActivity,null);
            fragmentTransaction.commit();




            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                    SingleSelectionActivity selectionActivity=new SingleSelectionActivity();
                    fragmentTransaction1.replace(R.id.frame_container,selectionActivity,null);
                    fragmentTransaction1.commit();
                }
            });



        }


     //   viewPager.setAdapter(imageSliderAdapter);


//        final Handler handler=new Handler();
//        final Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//
//                if (currentPage==Num_pages){
//                    currentPage=0;
//                }
//                viewPager.setCurrentItem(currentPage++,true);
//            }
//        };
//
//        timer=new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(runnable);
//            }
//        },Delay_time,Period_Ms);
    }
}
