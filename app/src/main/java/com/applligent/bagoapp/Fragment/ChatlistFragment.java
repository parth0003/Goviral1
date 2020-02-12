package com.applligent.bagoapp.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applligent.bagoapp.Adapter.ChatAdapter;
import com.applligent.bagoapp.Adapter.ChatlistAdapter;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatlistFragment extends Fragment {


    public ChatlistFragment() {
        // Required empty public constructor
    }


    View mView;
    RecyclerView mRecyclerView;
    LinearLayoutManager staggeredGridLayoutManager;
    static ArrayList<Integer> image;
    static ArrayList<String> name;
    ChatlistAdapter chatAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_chatlist, container, false);

        mRecyclerView=mView.findViewById(R.id.recyclerview);

        staggeredGridLayoutManager=new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        image=new ArrayList<>();
        name=new ArrayList<>();
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
        name.add("Name1");
        name.add("Name2");
        name.add("Name3");
        name.add("Name4");
        name.add("Name5");
        name.add("Name6");
        name.add("Name1");
        name.add("Name2");
        name.add("Name3");
        name.add("Name4");
        name.add("Name5");
        name.add("Name6");

        chatAdapter=new ChatlistAdapter(getActivity(),image,name);
        mRecyclerView.setAdapter(chatAdapter);

        return mView;
    }

}
