package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.devcamp3team.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edit_id, edit_passwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        setEvent();

    }

    private void setEvent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        edit_id = (EditText)findViewById(R.id.edit_id);
        edit_passwd = (EditText)findViewById(R.id.edit_passwd);
        btn_login = (Button)findViewById(R.id.btn_login);
    }
}
