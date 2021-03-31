package com.example.common.net

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RemoteProvider {
    private const val ACCESS_TOKEN="24.ffa9fa286034c766879c584ae7be2128.2592000.1619618196.282335-23895106"

    private const val URL_SERVER ="https://aip.baidubce.com/"


   private val retrofit=Retrofit.Builder()
       .baseUrl(URL_SERVER)
       .addConverterFactory(GsonConverterFactory.create())
       .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
       .build()

    fun <T> create(serviceClass:Class<T>) :T= retrofit.create(serviceClass)
}