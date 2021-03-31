package com.example.home.api

import com.example.home.Bean.postInfobean
import okhttp3.RequestBody

import retrofit2.Call

import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface homeapi {

    @Headers("Content-Type:application/json")
    @POST("/rpc/2.0/ai_custom/v1/classification/getpost")
    fun getPostInfo(@Query("access_token")  token :String, @Body route: RequestBody):Call<postInfobean>

}