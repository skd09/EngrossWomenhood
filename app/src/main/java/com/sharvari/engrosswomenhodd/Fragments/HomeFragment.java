package com.sharvari.engrosswomenhodd.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sharvari.engrosswomenhodd.Adapters.HomeAdapter;
import com.sharvari.engrosswomenhodd.Pojos.home;
import com.sharvari.engrosswomenhodd.R;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

/**
 * Created by sharvari on 28-Feb-18.
 */

public class HomeFragment extends Fragment {

    private HomeAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<home> homeArrayList = new ArrayList<>();
    private BannerSlider bannerSlider;
    private ImageView downArrow;
    private LinearLayout layout_distance;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView= v.findViewById(R.id.recycler_view);
        adapter = new HomeAdapter(homeArrayList, getContext());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        bannerSlider = v.findViewById(R.id.banner);
        layout_distance = v.findViewById(R.id.layout_distance);
        downArrow = v.findViewById(R.id.img);
        downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(layout_distance.getVisibility() == View.VISIBLE){
                    layout_distance.setVisibility(View.GONE);
                }else{
                    layout_distance.setVisibility(View.VISIBLE);
                }
            }
        });
        slider();
        prepareData();
        return v;
    }

    private void slider(){
        List<Banner> banners=new ArrayList<>();
        banners.add(new RemoteBanner("https://i.pinimg.com/564x/5c/21/c2/5c21c2a2a85349377a15d7db98bc83ca.jpg"));
        banners.add(new RemoteBanner("https://i.pinimg.com/564x/c6/b7/75/c6b77598132d589c298e09fdaac34c61.jpg"));
        banners.add(new RemoteBanner("https://i.pinimg.com/564x/df/2a/cc/df2acc48779e5e67e437654e1d93e13e.jpg"));
        banners.add(new RemoteBanner("https://i.pinimg.com/564x/1c/df/e5/1cdfe582fd28f2f810c7285312ad152b.jpg"));
        bannerSlider.setBanners(banners);
    }

    private void prepareData(){
        home h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);
        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        h = new home();
        homeArrayList.add(h);

        adapter.notifyDataSetChanged();
    }

}