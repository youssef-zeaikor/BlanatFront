package com.blanat.blanatfront.Controller;

import com.blanat.blanatfront.dto.SignInRequest;
import com.blanat.blanatfront.model.UserApp;
import com.blanat.blanatfront.utils.JwtAuthenticationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("/api/authentication/signin")
    Call<JwtAuthenticationResponse> signin(@Body SignInRequest user);

    @POST("/api/authentication/signup")
    Call<JwtAuthenticationResponse> signup(@Body UserApp user);
}
