package com.Mobile.android_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScheduleActivity extends AppCompatActivity {
    Button march_btn;
    Button april_btn;
    Button may_btn;
    Button june_btn;
    Button july_btn;
    Button august_btn;
    TextView month_text;
    TextView text_sche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_one);

        march_btn = (Button) findViewById(R.id.march_btn);
        april_btn = (Button) findViewById(R.id.april_btn);
        may_btn = (Button) findViewById(R.id.may_btn);
        june_btn = (Button) findViewById(R.id.june_btn);
        july_btn = (Button) findViewById(R.id.july_btn);
        august_btn = (Button) findViewById(R.id.august_btn);
        month_text = (TextView) findViewById(R.id.month_text);
        text_sche = (TextView) findViewById(R.id.text_sche);

        march_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 3월";
            @Override
            public void onClick(View view) {
                month_text.setText("3월");
                text_sche.setText("안녕하세요");
            }
        });
        april_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 4월";
            @Override
            public void onClick(View view) {
                month_text.setText("4월");
                text_sche.setText("감사해요");
            }
        });
        may_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 5월";
            @Override
            public void onClick(View view) {
                month_text.setText("5월");
                text_sche.setText("잘있어요");
            }
        });
        june_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 6월";
            @Override
            public void onClick(View view) {
                month_text.setText("6월");
                text_sche.setText("다시만나요");
            }
        });
        july_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 7월";
            @Override
            public void onClick(View view) {
                month_text.setText("7월");
                text_sche.setText("아침해가뜨면");
            }
        });
        august_btn.setOnClickListener(new View.OnClickListener() {
            String sche1 = "공지내용 8월";
            @Override
            public void onClick(View view) {
                month_text.setText("8월");
                text_sche.setText("아침해가뜨면 ~ ");
            }
        });
        /*
            for or while 사용, 데이터베이스[i]값이 null이 아닐때
            String text = "";

            while(데이터베이스[i] != null){
                text += 데이터베이스[i] + "/n";
                ~.setText(데이터베이스[i]);
                i++;
            }
         */
    }
}
