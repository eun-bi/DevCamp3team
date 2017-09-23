package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.util.AsyncListUtil;
import android.widget.TextView;

import com.example.user.devcamp3team.R;

import org.json.JSONException;
import org.json.JSONObject;

public class AccountingDetailActivity extends AppCompatActivity{

    TextView deAccTitle, deAccSub, deAccDate, deAccMoney, deAccLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting_detail);

        deAccTitle = (TextView)findViewById(R.id.deAccTitle);
        deAccSub = (TextView)findViewById(R.id.deAccSub);
        deAccDate = (TextView)findViewById(R.id.deAccDate);
        deAccMoney = (TextView)findViewById(R.id.deAccLast);
        deAccLast = (TextView)findViewById(R.id.deAccLast);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String sub = intent.getStringExtra("sub");
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");
        int money = intent.getIntExtra("money", 0);

        deAccTitle.setText(title);
        deAccSub.setText(sub);
        deAccDate.setText(date + " " + time);
        deAccMoney.setText(Integer.toString(money));
        deAccLast.setText("남은 돈 표시");
    }
}
