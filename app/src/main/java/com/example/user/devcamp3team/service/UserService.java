package com.example.user.devcamp3team.service;

import com.example.user.devcamp3team.model.Message;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("/login")
    Call<Message> loginUser(
            @Field("account")String account,
            @Field("password")String password);

    @FormUrlEncoded
    @POST("/notice")
    Call<Message> postNotice(
            @Field("title") String title,
            @Field("description") String description,
            @Field("push_flag") boolean push_flag, //FCM 푸시 전송 여부
            @Field("always_flag") boolean always_flag //공지를 최상단에 유지할지 여부
            );
}
