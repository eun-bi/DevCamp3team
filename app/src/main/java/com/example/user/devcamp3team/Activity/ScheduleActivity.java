package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.devcamp3team.R;

public class ScheduleActivity extends AppCompatActivity {

    EditText editTitle, editSubDaily, startDate, startTime, endDate, endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        editTitle = (EditText)findViewById(R.id.title);
        editSubDaily = (EditText)findViewById(R.id.subDaily);
        startDate = (EditText)findViewById(R.id.startDate);
        startTime = (EditText)findViewById(R.id.startTime);
        endDate = (EditText)findViewById(R.id.endDate);
        endTime = (EditText)findViewById(R.id.endTime);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSchedule:
                Intent intent = new Intent(this, ScheduleDetailActivity.class);

                intent.putExtra("Title", editTitle.getText().toString());
                intent.putExtra("subDaily", editTitle.getText().toString());
                intent.putExtra("startDate", startDate.getText().toString());
                intent.putExtra("startTime", startTime.getText().toString());
                intent.putExtra("endDate", endDate.getText().toString());
                intent.putExtra("endTime", endTime.getText().toString());
//                setResult(RESULT_OK, intent);
                startActivity(intent);
                finish();

                break;
        }
    }
}
