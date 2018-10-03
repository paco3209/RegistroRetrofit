package com.example.francisco.registrarusuario;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> crearusuario(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirm") String password_confirm
    );

    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(
            @Field("email") String email,
            @Field("password") String password

    );


}
