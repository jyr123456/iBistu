package com.example.iflab.guiyiyong.ibistu.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import com.example.iflab.guiyiyong.ibistu.R;

public class Login2Activity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public Button back_btn;
    public Button login_btn;
    public EditText password;
    public CheckBox show_password;
    public int count = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        back_btn = findViewById(R.id.back_btn_login2);
        login_btn = findViewById(R.id.login_login2);
        password = findViewById(R.id.password_login2);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_btn_login2) {
            finish();
        } else if (v.getId() == R.id.login_login2) {

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()) {
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }
}
