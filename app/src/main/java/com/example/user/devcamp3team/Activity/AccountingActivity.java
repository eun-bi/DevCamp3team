package com.example.user.devcamp3team.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.user.devcamp3team.R;


public class AccountingActivity extends AppCompatActivity {

    EditText titleAcc, subAcc, dateAcc, timeAcc, moenyAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);

        titleAcc = (EditText)findViewById(R.id.titleAcc);
        subAcc = (EditText)findViewById(R.id.subAcc);
        dateAcc = (EditText)findViewById(R.id.dateAcc);
        timeAcc = (EditText)findViewById(R.id.timeAcc);
        moenyAcc = (EditText)findViewById(R.id.moneyAcc);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnAcc:
                Intent intent = new Intent(this, AccountingDetailActivity.class);

//                int money = Integer.parseInt(moenyAcc.getText().toString());

                intent.putExtra("title", titleAcc.getText().toString());
                intent.putExtra("sub", subAcc.getText().toString());
                intent.putExtra("date", dateAcc.getText().toString());
                intent.putExtra("time", timeAcc.getText().toString());
                intent.putExtra("money", moenyAcc.getText().toString());

                startActivity(intent);

                finish();


                break;
        }
    }

}

