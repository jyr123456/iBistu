package com.example.iflab.guiyiyong.ibistu.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.iflab.guiyiyong.ibistu.R;
import com.example.iflab.guiyiyong.ibistu.adapter.ItemAdapter;
import com.example.iflab.guiyiyong.ibistu.adapter.TestAdapter;
import com.example.iflab.guiyiyong.ibistu.test_data.TestData;

import java.util.ArrayList;

public class MessageFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;

    private Context mContext;

    private TestData testData = new TestData();

    private ArrayList<String> mData;

    private ItemAdapter itemAdapter;

    private TestAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        mRecyclerView = view.findViewById(R.id.rv_message);
        mLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        mAdapter = new TestAdapter(testData.getData());
        mAdapter.setOnItemClickedListener(new TestAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(view.getContext(), "click " + position + " item", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {
                Toast.makeText(view.getContext(), "long click " + position + " item", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }


}
