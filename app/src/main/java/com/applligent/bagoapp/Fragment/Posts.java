package com.applligent.bagoapp.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applligent.bagoapp.Adapter.PostAdapter;
import com.applligent.bagoapp.Adapter.PostsAdapter;
import com.applligent.bagoapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Posts extends Fragment {


    public Posts() {
        // Required empty public constructor
    }

    View mView;
    RecyclerView mRecyclerView;
    GridLayoutManager linearLayoutManager;
    ArrayList<Integer> image;
    PostsAdapter postAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView=inflater.inflate(R.layout.fragment_posts, container, false);

        mRecyclerView=mView.findViewById(R.id.recyclerview);
        linearLayoutManager=new GridLayoutManager(getContext(),3);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        image=new ArrayList<>();
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

        postAdapter=new PostsAdapter(getContext(),image);
        mRecyclerView.setAdapter(postAdapter);
        return mView;
    }

}
