package com.example.user.devcamp3team.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class NotifyActivity extends AppCompatActivity {

    private NotifyListAdapter notifyListAdapter;
    EditText editTitleNotify, editSubNotify;
    Button btnNotify, btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        initView();
        setEvent();

    }

    private void setEvent() {


        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (editTitleNotify.length() > 0 && editSubNotify.length() > 0) {
                    notifyListAdapter.addItem(editTitleNotify.getText().toString(), editSubNotify.getText().toString());
                    Log.i("title", editTitleNotify.getText().toString() );
                    Log.i("sub", editSubNotify.getText().toString() );

                    Toast.makeText(getApplicationContext(),"공지를 등록했습니다.",Toast.LENGTH_SHORT).show();
                    NotifyActivity.this.finish();
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);

//                    postNotice(editTitleNotify.getText().toString(), editSubNotify.getText().toString());
                }
                else {
                    Toast.makeText(NotifyActivity.this,"빈칸을 모두 채워주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifyActivity.this.finish();
            }
        });

    }

    private void initView() {

        editTitleNotify = (EditText)findViewById(R.id.titleNotify);
        editSubNotify = (EditText)findViewById(R.id.subNotify);
        btnNotify = (Button)findViewById(R.id.btnNotify);
        btnCancle = (Button)findViewById(R.id.btnCancel);

        notifyListAdapter = NotifyFragment.notifyListAdapter;   // 구현 위주 (수정 필요)
    }

    private void postNotice(final String title, final String description) {
        UserService userService = RetrofitService.getInstance().userService();

        Call<Message> postNoticeCall = userService.postNotice(title, description, false, false); // strId, strPassword

        postNoticeCall.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Log.i("response", "res : " +response.toString());
                if(response.body() != null && response.body().getMessage().equals("success")) {
                    Log.i("공지등록", "success");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(NotifyActivity.this,"네트워크 연결을 확인해주세요", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.i("test", t.getMessage());
            }
        });
    }


}
