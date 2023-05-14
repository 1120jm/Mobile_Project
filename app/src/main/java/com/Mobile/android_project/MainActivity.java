package com.Mobile.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText login_et = (EditText) findViewById(R.id.Login_num);
        EditText pass_et = (EditText) findViewById(R.id.pas_num);
        CheckBox ch_auto = (CheckBox) findViewById(R.id.check_login);
        Button find_id = (Button) findViewById(R.id.text_find_hak);
        Button find_pass = (Button) findViewById(R.id.text_find_pas);
        Button login_btn = (Button) findViewById(R.id.login_btn);
        TextView failText = (TextView) findViewById(R.id.login_fail_text);

        failText.setVisibility(View.INVISIBLE);
        login_btn.setEnabled(false);
        login_btn.setBackgroundColor(Color.BLACK);
        login_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 9) {
                    login_btn.setEnabled(true);
                    login_btn.setBackgroundColor(Color.GREEN);
                } else {
                    login_btn.setEnabled(false);
                    login_btn.setBackgroundColor(Color.BLACK);
                }
            }@Override
            public void afterTextChanged(Editable s) {}
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "2019081070";
                String password = "1234";
                String login_hak = login_et.getText().toString();
                String login_pass = pass_et.getText().toString();
                if(name.equals(login_hak) && password.equals(login_pass)){
                    Intent intent = new Intent(getApplicationContext(), Main_loginFailActivity.class);
                    startActivity(intent);
                }else{
                    failText.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            failText.setVisibility(View.INVISIBLE); // 3초뒤 실행할 작업
                        }
                    }, 3000); // 3000==3초
                }
            }
        });
        find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main_loginFailActivity.class);
                startActivity(intent);
            }
        });

    }


}