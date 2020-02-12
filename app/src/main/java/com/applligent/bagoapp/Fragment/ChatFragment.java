package com.applligent.bagoapp.Fragment;


import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.applligent.bagoapp.Adapter.ChatAdapter;
import com.applligent.bagoapp.R;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    public ChatFragment() {
        // Required empty public constructor
    }

    View mView;
    RecyclerView mRecyclerView;
    GridLayoutManager staggeredGridLayoutManager;
    static ArrayList<Integer> image;
    static ArrayList<String> name;
    ChatAdapter chatAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_chat, container, false);
        mRecyclerView=mView.findViewById(R.id.recyclerview);

        staggeredGridLayoutManager=new GridLayoutManager(getActivity(),2);
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

        chatAdapter=new ChatAdapter(getActivity(),image,name);
        mRecyclerView.setAdapter(chatAdapter);
       
        return mView;
    }

}
