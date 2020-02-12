package com.applligent.bagoapp.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applligent.bagoapp.Adapter.BadgesAdapter;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Badges extends Fragment {


    public Badges() {
        // Required empty public constructor
    }


    View mView;
    RecyclerView mRecyclerView;
    GridLayoutManager linearLayoutManager;
    ArrayList<Integer> image;
    ArrayList<String> text;
    BadgesAdapter badgesAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_badges, container, false);

        mRecyclerView=mView.findViewById(R.id.recyclerview);
        linearLayoutManager=new GridLayoutManager(getContext(),2);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        image=new ArrayList<>();
        text=new ArrayList<>();

        image.add(R.drawable.p1);
        image.add(R.drawable.p2);
        image.add(R.drawable.p3);
        image.add(R.drawable.p4);
        image.add(R.drawable.p5);
        image.add(R.drawable.p6);
        image.add(R.drawable.p1);
        image.add(R.drawable.p2);
        image.add(R.drawable.p3);
        image.add(R.drawable.p4);
        image.add(R.drawable.p5);
        image.add(R.drawable.p6);

        text.add("Text1");
        text.add("Text2");
        text.add("Text3");
        text.add("Text4");
        text.add("Text5");
        text.add("Text6");
        text.add("Text7");
        text.add("Text8");
        text.add("Text9");
        text.add("Text10");
        text.add("Text11");
        text.add("Text12");

        badgesAdapter=new BadgesAdapter(getContext(),image,text);
        mRecyclerView.setAdapter(badgesAdapter);
        return mView;
    }

}
