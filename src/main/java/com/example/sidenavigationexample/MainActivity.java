package com.example.sidenavigationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.infideap.drawerbehavior.AdvanceDrawerLayout;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
   // ViewPagerAdapter vp;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
     int[] imgarr;
     Timer timer;
    int len;
    AdvanceDrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id();

        drawerLayout.useCustomBehavior(Gravity.START);
        drawerLayout.setRadius(Gravity.START, 35);//set end container's corner radius (dimension)
        drawerLayout.setViewScale(Gravity.START, 0.9f);
        drawerLayout.setViewElevation(Gravity.START, 20);

        imgarr=new int[]{R.drawable.facebook,R.drawable.insta, R.drawable.snapchat,R.drawable.insta};
        len=imgarr.length;

        ViewPagerAdapter adapter=new ViewPagerAdapter(MainActivity.this,imgarr);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() == len - 1) {
                            viewPager.setCurrentItem(0);
                        } else {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        }
                    }
                });
            }
        };

        timer = new Timer();
        timer.schedule(timerTask, 3000, 3000);

    }

    private void id() {
        viewPager=findViewById(R.id.pager);
        circleIndicator=findViewById(R.id.cir);
        drawerLayout=findViewById(R.id.advdrawlay);
 }
}
