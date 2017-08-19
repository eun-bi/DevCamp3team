package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.devcamp3team.R;

public class ScheduleDetailActivity extends AppCompatActivity {

    TextView deTitle, deSubDaily, deStartDate, deStartTime, deEndDate, deEndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_detail);


        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        deTitle = (TextView)findViewById(R.id.deTitle);
        deSubDaily = (TextView)findViewById(R.id.deSubDaily);
        deStartDate = (TextView)findViewById(R.id.destartDate);
        deStartTime = (TextView)findViewById(R.id.deStartTime);
        deEndDate = (TextView)findViewById(R.id.deEndDate);
        deEndTime = (TextView)findViewById(R.id.deEndTime);

        Intent intent = getIntent();

        String title = intent.getStringExtra("Title");
        String subDaily = intent.getStringExtra("subDaily");
        String startDate = intent.getStringExtra("startDate");
        String startTime = intent.getStringExtra("startTime");
        String endDate = intent.getStringExtra("endDate");
        String endTime = intent.getStringExtra("endTime");

        deTitle.setText(title);
        deSubDaily.setText(subDaily);
        deStartDate.setText(startDate);
        deStartTime.setText(startTime);
        deEndDate.setText(endDate);
        deEndTime.setText(endTime);

    }
}
