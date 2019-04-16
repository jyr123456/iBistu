package com.example.iflab.guiyiyong.ibistu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.iflab.guiyiyong.ibistu.R;

import java.util.List;

public abstract class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private SparseArray<View> mViews;
        private View mConvertView;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mConvertView = itemView;
            mViews = new SparseArray<>();
        }

        public static MyViewHolder get(ViewGroup parent, int layoutID){
            View convertView = LayoutInflater.from(parent.getContext()).inflate(layoutID, parent, false);
            return new MyViewHolder(convertView);
        }

        public <T extends View> T getView(int id){
            View v = mViews.get(id);
            if (v == null) {
                v = mConvertView.findViewById(id);
                mViews.put(id, v);
            }
            return (T)v;
        }

        public void setText(int id, String value) {
            TextView view = getView(id);
            view.setText(value);
        }

    }

    private List<String> mData;

    public RecyclerViewAdapter(List<String> mData) {
        this.mData = mData;
    }

    public abstract int getLayoutID(int viewType);

    public abstract void convert(MyViewHolder holder, String data, int position);
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyViewHolder.get(parent, getLayoutID(viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        convert(myViewHolder, mData.get(i), i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
