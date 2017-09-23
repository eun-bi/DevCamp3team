package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.devcamp3team.R;

public class NotifyActivity extends AppCompatActivity {

    EditText editTitle, editSubNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        editTitle = (EditText)findViewById(R.id.titleNotify);
        editSubNotify = (EditText)findViewById(R.id.subNotify);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSchedule:
                Intent intent = new Intent(this, ScheduleDetailActivity.class);

                intent.putExtra("Title", editTitle.getText().toString());
                intent.putExtra("subNotify", editSubNotify.getText().toString());

                startActivity(intent);
                finish();

                break;
        }
    }
}
