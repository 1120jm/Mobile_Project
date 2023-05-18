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
    Dialog changePass;
    Dialog passDialogb;
    Dialog change_good;
    Dialog notsameDialog;
    boolean check_cb = false;
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

        changePass = new Dialog(MainActivity.this);
        changePass.requestWindowFeature(Window.FEATURE_NO_TITLE);
        changePass.setContentView(R.layout.find_pass_good);

        passDialogb = new Dialog(MainActivity.this);
        passDialogb.requestWindowFeature(Window.FEATURE_NO_TITLE);
        passDialogb.setContentView(R.layout.find_pass_bad);


        change_good = new Dialog(MainActivity.this);
        change_good.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_good.setContentView(R.layout.change_pass_good);

        notsameDialog = new Dialog(MainActivity.this);
        notsameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        notsameDialog.setContentView(R.layout.notsamepass);

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
        //--------------------------로그인 버튼-----------------------------
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

        //--------------------------찾기 버튼-----------------------------
        find_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = "김한민";
                String birthh = "001120";
                findDialog.show(); // 다이얼로그 띄우기

                EditText edit_num = (EditText) findDialog.findViewById(R.id.edit_id);
                EditText edit_birth = (EditText) findDialog.findViewById(R.id.edit_birth);

                edit_num.setText("");
                edit_birth.setText("");
                //--------------------------찾기-확인 버튼-----------------------------
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
                //--------------------------찾기-찾았을경우-확인 버튼-----------------------------
                Button submit_btn_ng = findDialognum_g.findViewById(R.id.submit_btn_ng);
                submit_btn_ng.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialognum_g.dismiss();// 다이얼로그 닫기
                    }
                });
                //--------------------------찾기-못찾았을경우-확인 버튼-----------------------------
                Button submit_btn_nb = findDialognum_b.findViewById(R.id.submit_btn_nb);
                submit_btn_nb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialognum_b.dismiss();// 다이얼로그 닫기
                    }
                });
                //--------------------------취소 버튼------------------------------
                Button noBtn = findDialog.findViewById(R.id.cancel_btn);
                noBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialog.dismiss();// 다이얼로그 닫기
                    }
                });
            }
        });
//------------------------------------------------------------------------------------------------------------------------------------------------------
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p_name = "김한민";
                String p_hak = "2019081070";
                findDialog_p.show(); // 다이얼로그 띄우기

                EditText edit_num_p = (EditText) findDialog_p.findViewById(R.id.edit_id_p);
                EditText edit_hak_p = (EditText) findDialog_p.findViewById(R.id.edit_birth_p);

                edit_num_p.setText("");
                edit_hak_p.setText("");


                //--------------------------찾기-확인 버튼-----------------------------
                Button submit_btn_p = findDialog_p.findViewById(R.id.submit_btn_p);
                submit_btn_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String edit_Num_p = edit_num_p.getText().toString();
                        String edit_Birth_p = edit_hak_p.getText().toString();
                        if(edit_Num_p.equals(p_name) && edit_Birth_p.equals(p_hak)){
                            findDialog_p.dismiss();
                            changePass.show();
                        }else{
                            edit_num_p.setText("");
                            edit_hak_p.setText("");
                            passDialogb.show();
                        }
                    }
                });
                //--------------------------찾기-취소 버튼-----------------------------
                Button cancel_Btn_p = findDialog_p.findViewById(R.id.cancel_btn_p);
                cancel_Btn_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        findDialog_p.dismiss();
                    }
                });
                //////////////////////////////////////////////////////////////////////


                Button submit_btn_nb = passDialogb.findViewById(R.id.submit_btn_nb);
                submit_btn_nb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        passDialogb.dismiss();
                    }
                });

                Button submit_btn_ng = notsameDialog.findViewById(R.id.submit_btn_ng);
                submit_btn_ng.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        notsameDialog.dismiss();
                    }
                });
                //--------------------------바꾼 후 확인 버튼------------------------------
                EditText ch_pass = changePass.findViewById(R.id.ch_pass);
                EditText ch_pass_check = changePass.findViewById(R.id.ch_pass_check);
                ch_pass.setText("");
                ch_pass_check.setText("");
                Button submit_btn_c = changePass.findViewById(R.id.submit_btn_c);
                submit_btn_c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String ch_Pass = ch_pass.getText().toString();
                        String ch_Pass_check = ch_pass_check.getText().toString();
                        System.out.println(ch_Pass + ch_Pass_check + "-----------------------------------------------------------------------");
                        if(ch_Pass.equals(ch_Pass_check)){
                            changePass.dismiss();
                            change_good.show();
                        }else{
                            ch_pass.setText("");
                            ch_pass_check.setText("");
                            notsameDialog.show();
                        }
                    }
                });

                //--------------------------바꾸기 취소 버튼-----------------------------
                Button ch_nobtn = changePass.findViewById(R.id.cancel_btn_c);
                ch_nobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changePass.dismiss();// 다이얼로그 닫기
                    }
                });
                //--------------------------changePAss취소 버튼-----------------------------
                Button noBtn_p = changePass.findViewById(R.id.cancel_btn_c);
                noBtn_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changePass.dismiss();// 다이얼로그 닫기
                    }
                });
                Button submit_btn_pass = change_good.findViewById(R.id.submit_btn_pass);
                submit_btn_pass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        change_good.dismiss();
                    }
                });
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
}