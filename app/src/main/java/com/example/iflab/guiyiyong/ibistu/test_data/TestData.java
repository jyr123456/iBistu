package com.example.iflab.guiyiyong.ibistu.test_data;

import java.util.ArrayList;

public class TestData {
    public ArrayList<String> getData() {
        ArrayList<String> mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("ITEM: " + i);
        }
        return mData;
    }
}
