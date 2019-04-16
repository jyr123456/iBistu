package com.example.iflab.guiyiyong.ibistu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.iflab.guiyiyong.ibistu.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public Button next;
    public EditText register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        next = findViewById(R.id.next_login);
        register = findViewById(R.id.edit_login);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_login) {
            startActivity(new Intent(LoginActivity.this, Login2Activity.class));
        }
    }
}
