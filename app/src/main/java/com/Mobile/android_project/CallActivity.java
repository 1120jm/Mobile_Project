package com.Mobile.android_project;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CallActivity extends AppCompatActivity {
    Spinner spin_call;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inner_call);
        spin_call = (Spinner) findViewById(R.id.spin_call);
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("철수");
        arrayList.add("영희");
        arrayList.add("람휘");
        arrayList.add("녹지");

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,arrayList);
        spin_call.setAdapter(arrayAdapter);

    }
}
