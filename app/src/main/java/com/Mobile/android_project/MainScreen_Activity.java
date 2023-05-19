package com.Mobile.android_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreen_Activity extends AppCompatActivity {
    Dialog change_password;
    Dialog change_password_success;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button logout_btn = (Button) findViewById(R.id.logout_btn) ;
        Button change_pass_btn = (Button) findViewById(R.id.passwd_change_btn);
        TextView warning_text = (TextView) findViewById(R.id.change_pass_warning);


        change_password = new Dialog(MainScreen_Activity.this);
        change_password.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password.setContentView(R.layout.main_change_password);

        change_password_success = new Dialog(MainScreen_Activity.this);
        change_password_success.requestWindowFeature(Window.FEATURE_NO_TITLE);
        change_password_success.setContentView(R.layout.main_change_password);

        warning_text.setVisibility(View.INVISIBLE);

        change_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String p_name = "양재민";
                String p_hak = "2019081089";
                change_password.show(); // 다이얼로그 띄우기

                EditText edit_num_p = (EditText) change_password.findViewById(R.id.change_pass);
                EditText edit_hak_p = (EditText) change_password.findViewById(R.id.change_pass_check);

                edit_num_p.setText("");
                edit_hak_p.setText("");

                //--------------------------바꾼 후 확인 버튼------------------------------
                EditText ch_pass = change_password.findViewById(R.id.ch_pass);
                EditText ch_pass_check = change_password.findViewById(R.id.ch_pass_check);
                ch_pass.setText("");
                ch_pass_check.setText("");
                Button submit_btn_c = change_password.findViewById(R.id.submit_btn_c);
                submit_btn_c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String ch_Pass = ch_pass.getText().toString();
                        String ch_Pass_check = ch_pass_check.getText().toString();
                        System.out.println(ch_Pass + ch_Pass_check + "-----------------------------------------------------------------------");
                        if(ch_Pass.equals(ch_Pass_check)){
                            change_password.dismiss();
                            change_password_success.show();
                        }else{
                            ch_pass.setText("");
                            ch_pass_check.setText("");
                            warning_text.setVisibility(View.INVISIBLE);
                        }
                    }
                });

                //--------------------------바꾸기 취소 버튼-----------------------------
                Button ch_nobtn = change_password.findViewById(R.id.cancel_btn_c);
                ch_nobtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        change_password.dismiss();// 다이얼로그 닫기
                    }
                });
                //--------------------------changePAss취소 버튼-----------------------------
                Button noBtn_p = change_password.findViewById(R.id.cancel_btn_c);
                noBtn_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        change_password.dismiss();// 다이얼로그 닫기
                    }
                });
                Button submit_btn_pass = change_password_success.findViewById(R.id.submit_btn_pass);
                submit_btn_pass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        change_password_success.dismiss();
                    }
                });
            }
        });



    }
}