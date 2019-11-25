package com.example.sidenavigationexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
   ImageView img;
    int[]imgarr;


    public ViewPagerAdapter(Context context,  int[] imgarr) {
        this.context = context;
        this.imgarr = imgarr;
    }


    @Override
    public int getCount() {
        return imgarr.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.pageritem,container,false);
        img=view.findViewById(R.id.img_slider);
        img.setBackgroundResource(imgarr[position]);
        container.addView(view);
        return view;
    }
    public  void destroyItem( ViewGroup container,int position, Object object)
    {
        container.removeView((LinearLayout )object);

    }
}
