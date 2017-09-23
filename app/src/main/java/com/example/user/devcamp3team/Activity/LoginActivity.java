package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.devcamp3team.R;
import com.example.user.devcamp3team.model.Message;
import com.example.user.devcamp3team.service.RetrofitService;
import com.example.user.devcamp3team.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


                if (edit_id.length() > 0 && edit_passwd.length() > 0) {
                    loginUser(edit_id.getText().toString(), edit_passwd.getText().toString());
                } else {
                    Toast.makeText(LoginActivity.this,"빈칸을 모두 채워주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loginUser(final String strId, final String strPassword) {
        UserService userService = RetrofitService.getInstance().loginUserService();

        Call<Message> loginUserCall = userService.loginUser(strId, strPassword); // strId, strPassword
        Log.d("requestTest", "loginUserCall.toString() : " + loginUserCall.toString());
        loginUserCall.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Log.i("response", "res : " +response.toString());
                SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("login_check", "true"); //로그인 세션 저장
                editor.putString("account", strId); // 회원의  아이디
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.i("test", t.getMessage());
            }
        });
    }

    private void initView() {
        edit_id = (EditText)findViewById(R.id.edit_id);
        edit_passwd = (EditText)findViewById(R.id.edit_passwd);
        btn_login = (Button)findViewById(R.id.btn_login);
    }
}