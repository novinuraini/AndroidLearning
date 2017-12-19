package com.example.novia.androidlearning;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bintang on 12/19/2017.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("/user/login")
    Call<ResponseLogin> doLogin(@Field("username") String username,
                                @Field("password") String password);
}
