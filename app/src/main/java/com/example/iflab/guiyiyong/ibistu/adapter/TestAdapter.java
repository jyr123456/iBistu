package com.example.iflab.guiyiyong.ibistu.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.iflab.guiyiyong.ibistu.R;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.VH> {
    public ArrayList<String> mData;
    public TestAdapter.OnItemClickListener mListener;

    public TestAdapter(ArrayList<String> mData) {
        this.mData = mData;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);

        void OnItemLongClick(View view, int position);
    }

    public void setOnItemClickedListener(TestAdapter.OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chat, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final VH vh, final int i) {
        vh.mText.setText(mData.get(i));

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = vh.getLayoutPosition();
                    mListener.OnItemClick(vh.itemView, position);
                }
            }
        });

        vh.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mListener != null) {
                    int position = vh.getLayoutPosition();
                    mListener.OnItemLongClick(vh.itemView, position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0: mData.size();
    }

    public static class VH extends RecyclerView.ViewHolder {
        TextView mText;

        public VH(@NonNull View itemView) {
            super(itemView);
            mText = itemView.findViewById(R.id.user_name);
        }
    }
}
