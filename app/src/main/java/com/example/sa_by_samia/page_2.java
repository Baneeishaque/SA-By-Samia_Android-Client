package com.example.sa_by_samia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import static androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL;
import static androidx.recyclerview.widget.LinearLayoutManager.VERTICAL;

public class page_2 extends AppCompatActivity {

    private ViewPager2 viewPager2;

    RecyclerView recyclerView;

    List<Integer> imageList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> priceList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);

        viewPager2 = findViewById(R.id.viewPager2);

        List<SliderImage_2> imageList = new ArrayList<>();
        imageList.add(new SliderImage_2(R.mipmap.ic_launcher_round));
        imageList.add(new SliderImage_2(R.drawable.ic_launcher_foreground));

        viewPager2.setAdapter(new SliderAdapter_2(imageList, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        initialize();

    }

    private void initialize() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);

        imageList.add(R.mipmap.ic_launcher);
        imageList.add(R.mipmap.ic_launcher);
        imageList.add(R.mipmap.ic_launcher);
        imageList.add(R.mipmap.ic_launcher);

        titleList.add("abc");
        titleList.add("def");
        titleList.add("ghi");
        titleList.add("jkl");

        priceList.add("100");
        priceList.add("120");
        priceList.add("140");
        priceList.add("150");

        recyclerView.setAdapter(new RecyclerViewAdapter_2(imageList,titleList,priceList));

    }

}




