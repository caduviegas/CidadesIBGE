package com.innaval.cidadesibge

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class CidadesBuilder {

    val cidadeApi: CidadesApi

    init{
        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl("https://servicodados.ibge.gov.br/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        cidadeApi = retrofit.create(CidadesApi::class.java)
    }
}