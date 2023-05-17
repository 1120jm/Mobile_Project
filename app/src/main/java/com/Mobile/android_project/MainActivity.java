package com.Mobile.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Dialog findDialog;
    Dialog findDialog_p;
    Dialog findDialognum_g;
    Dialog findDialognum_b;
    Dialog findDialogpass_g;
    boolean check_cb = false;
    boolean check_edit_id = false;
    boolean check_edit_birth = false;
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
        Button auto_login_fill = (Button) findViewById(R.id.auto_login_fill);
        EditText edit_id = (EditText) findViewById(R.id.edit_id);
        EditText edit_birth = (EditText) findViewById(R.id.edit_birth);


        findDialog = new Dialog(MainActivity.this);
        findDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        findDialog.setContentView(R.layout.findnumber);

        findDialog_p = new Dialog(MainActivity.this);
        findDialog_p.requestWindowFeature(Window.FEATURE_NO_TITLE);
        findDialog_p.setContentView(R.layout.findpass);

        findDialognum_g = new Dialog(MainActivity.this);
        findDialognum_g.requestWindowFeature(Window.FEATURE_NO_TITLE);
        findDialognum_g.setContentView(R.layout.findnum_good);

        findDialognum_b = new Dialog(MainActivity.this);
        findDialognum_b.requestWindowFeature(Window.FEATURE_NO_TITLE);
        findDialognum_b.setContentView(R.layout.findnum_bad);

        failText.setVisibility(View.INVISIBLE);
        login_btn.setEnabled(false);
        login_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 9) {
                    login_btn.setEnabled(true);
                    login_btn.setBackgroundResource(R.drawable.login_btn_enable);
                } else {
                    login_btn.setEnabled(false);
                    login_btn.setBackgroundResource(R.drawable.login_btn_design);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "2019081070";
                String password = "1234";
                String login_hak = login_et.getText().toString();
                String login_pass = pass_et.getText().toString();
                if (name.equals(login_hak) && password.equals(login_pass)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
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

                String name = "김한민";
                System.out.println(name + "-----------------------------");
                String birthh = "001120";
                findDialog.show(); // 다이얼로그 띄우기

                EditText edit_num = (EditText) findDialog.findViewById(R.id.edit_id);
                EditText edit_birth = (EditText) findDialog.findViewById(R.id.edit_birth);
                edit_num.setText("");
                edit_birth.setText("");
                Button submit_btn = findDialog.findViewById(R.id.submit_btn);
                submit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String edit_Num = edit_num.getText().toString();
                        String edit_Birth = edit_birth.getText().toString();

                        if(edit_Num.equals(name) && edit_Birth.equals(birthh)){
                            findDialog.dismiss();
                            findDialognum_g.show();
                        }else{
                            edit_num.setText("");
                            edit_birth.setText("");
                            findDialognum_b.show();
                        }
                    }
                });
                Button submit_btn_ng = findDialognum_g.findViewById(R.id.submit_btn_ng);
                submit_btn_ng.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialognum_g.dismiss();// 다이얼로그 닫기
                    }
                });
                Button submit_btn_nb = findDialognum_b.findViewById(R.id.submit_btn_nb);
                submit_btn_nb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialognum_b.dismiss();// 다이얼로그 닫기
                    }
                });
                Button noBtn = findDialog.findViewById(R.id.cancel_btn);
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialog.dismiss();// 다이얼로그 닫기
                    }
                });
            }
        });
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog_pass();
            }
        });
        auto_login_fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_cb == false){
                    ch_auto.setChecked(true);
                    check_cb = true;
                }else if(check_cb == true){
                    ch_auto.setChecked(false);
                    check_cb = false;
                }
            }
        });
    }


    public void showDialog_pass() {
        findDialog_p.show(); // 다이얼로그 띄우기

        Button noBtn = findDialog_p.findViewById(R.id.cancel_btn_p);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findDialog_p.dismiss();// 다이얼로그 닫기
            }
        });

    }
}