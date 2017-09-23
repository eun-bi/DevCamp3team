package com.example.user.devcamp3team.service;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jeongyeoeun on 2017. 9. 23..
 */

public class RetrofitService {
    static final String WemoURL = "http://wemo3.2mw3dzeaxu.ap-northeast-2.elasticbeanstalk.com";

    private static RetrofitService instance;

    private RetrofitService() {
    }

    public static RetrofitService getInstance() {
        if (instance == null) {
            instance = new RetrofitService();
        }
        return instance;
    }

    public UserService loginUserService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WemoURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UserService.class);
    }
}