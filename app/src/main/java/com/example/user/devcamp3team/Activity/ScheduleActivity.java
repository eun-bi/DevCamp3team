package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.devcamp3team.R;

public class ScheduleActivity extends AppCompatActivity {

    EditText editTitle, editSubDaily, startDate, startTime, endDate, endTime;
    Button btnSchedule, btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        editTitle = (EditText)findViewById(R.id.title);
        editSubDaily = (EditText)findViewById(R.id.subDaily);
        btnSchedule = (Button)findViewById(R.id.btnSchedule);
        btnCancle = (Button)findViewById(R.id.btnCancel);
//        startDate = (EditText)findViewById(R.id.startDate);
//        startTime = (EditText)findViewById(R.id.startTime);
//        endDate = (EditText)findViewById(R.id.endDate);
//        endTime = (EditText)findViewById(R.id.endTime);

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScheduleDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleActivity.this.finish();
            }
        });
    }


}
