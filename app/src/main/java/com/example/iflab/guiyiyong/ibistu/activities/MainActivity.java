package com.example.iflab.guiyiyong.ibistu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.iflab.guiyiyong.ibistu.R;
import com.example.iflab.guiyiyong.ibistu.fragments.AddressbookFragment;
import com.example.iflab.guiyiyong.ibistu.fragments.MessageFragment;
import com.example.iflab.guiyiyong.ibistu.fragments.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MineFragment mineFragment = new MineFragment();

    private MessageFragment messageFragment = new MessageFragment();

    private AddressbookFragment addressbookFragment = new AddressbookFragment();

    private TextView top_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ly_content, messageFragment)
                .add(R.id.ly_content, mineFragment)
                .add(R.id.ly_content, addressbookFragment)
                .hide(mineFragment)
                .hide(addressbookFragment)
                .commit();
        top_bar.setText("Home");
    }

    private void initView() {
        Button homepage_btn = findViewById(R.id.message_btn_main);
        Button people_btn = findViewById(R.id.people_btn_main);
        Button brush_btn = findViewById(R.id.addressbook_btn_main);
        top_bar = findViewById(R.id.title_main);
        homepage_btn.setOnClickListener(this);
        people_btn.setOnClickListener(this);
        brush_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.message_btn_main:
//                Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(messageFragment)
                        .hide(mineFragment)
                        .hide(addressbookFragment)
                        .commit();
                top_bar.setText("Message");
                break;
            case R.id.addressbook_btn_main:
//                Toast.makeText(MainActivity.this, "Address Book", Toast.LENGTH_SHORT).show();
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(messageFragment)
                        .hide(mineFragment)
                        .show(addressbookFragment)
                        .commit();
                top_bar.setText("Address Book");
                break;
            case R.id.people_btn_main:
//                Toast.makeText(MainActivity.this, "Mine", Toast.LENGTH_SHORT).show();
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(messageFragment)
                        .show(mineFragment)
                        .hide(addressbookFragment)
                        .commit();
                top_bar.setText("Mine");
                break;
        }
    }
}
