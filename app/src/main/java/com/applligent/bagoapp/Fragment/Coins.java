package com.applligent.bagoapp.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applligent.bagoapp.Adapter.Coins1Adapter;
import com.applligent.bagoapp.Adapter.Coins2Adapter;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Coins extends Fragment {


    public Coins() {
        // Required empty public constructor
    }

    View mView;
    RecyclerView RV_horizontal,RV_vertical;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    Coins1Adapter coins1Adapter;
    ArrayList<Integer> img;
    Coins2Adapter coins2Adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_coins, container, false);

        RV_horizontal=mView.findViewById(R.id.recyclerview1);
        RV_vertical=mView.findViewById(R.id.recyclerview2);

        linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        RV_horizontal.setLayoutManager(linearLayoutManager);

        gridLayoutManager=new GridLayoutManager(getContext(),2);
        RV_vertical.setLayoutManager(gridLayoutManager);

        img=new ArrayList<>();
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);
        img.add(R.drawable.itembg);

        coins1Adapter=new Coins1Adapter(getContext(),img);
        RV_horizontal.setAdapter(coins1Adapter);

        coins2Adapter=new Coins2Adapter(getContext(),img);
        RV_vertical.setAdapter(coins2Adapter);
        return mView;
    }

}
