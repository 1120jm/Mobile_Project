package com.Mobile.android_project;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;

public class Main_loginFailActivity extends AppCompatActivity {
    Dialog dialog1;
    protected void onCreate(Bundle savedInstanceState) {
        dialog1 = new Dialog(Main_loginFailActivity.this);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_loginfail);



    }
}
