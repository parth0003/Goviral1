package com.applligent.bagoapp.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applligent.bagoapp.Adapter.FriendsAdapter;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Friends extends Fragment {


    public Friends() {
        // Required empty public constructor
    }


    View mView;
    RecyclerView mRecyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Integer> image;
    ArrayList<String> name,id,number;
    FriendsAdapter friendsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_friends, container, false);

        mRecyclerView=mView.findViewById(R.id.recyclerview);
        linearLayoutManager=new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        image=new ArrayList<>();
        name=new ArrayList<>();
        id=new ArrayList<>();
        number=new ArrayList<>();

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

        name.add("Name1");
        name.add("Name2");
        name.add("Name3");
        name.add("Name4");
        name.add("Name5");
        name.add("Name6");
        name.add("Name7");
        name.add("Name8");
        name.add("Name9");
        name.add("Name10");
        name.add("Name11");
        name.add("Name12");

        id.add("Id1");
        id.add("Id2");
        id.add("Id3");
        id.add("Id4");
        id.add("Id5");
        id.add("Id6");
        id.add("Id7");
        id.add("Id8");
        id.add("Id9");
        id.add("Id10");
        id.add("Id11");
        id.add("Id12");

        number.add("1");
        number.add("2");
        number.add("3");
        number.add("4");
        number.add("5");
        number.add("6");
        number.add("7");
        number.add("8");
        number.add("9");
        number.add("10");
        number.add("11");
        number.add("12");

        friendsAdapter=new FriendsAdapter(getContext(),image,name,id,number);
        mRecyclerView.setAdapter(friendsAdapter);
        return mView;
    }

}
