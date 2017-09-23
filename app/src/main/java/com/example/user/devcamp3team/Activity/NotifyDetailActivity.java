package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.devcamp3team.R;

public class NotifyDetailActivity extends AppCompatActivity {
    TextView deWriteDate, deWriteTime, deSubNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify_detail);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        deWriteDate = (TextView)findViewById(R.id.deWriteDate);
        deWriteTime = (TextView)findViewById(R.id.deWriteTime);
        deSubNotify = (TextView)findViewById(R.id.deSubNotify);

        Intent intent = getIntent();


        String subNotify = intent.getStringExtra("subNotify");


        deSubNotify.setText(subNotify);

    }
}
