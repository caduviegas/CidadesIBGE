package com.innaval.cidadesibge

import retrofit2.http.GET
import rx.Single

interface CidadesApi {


    @GET("localidades/distritos")
    fun getCidades(): Single<RespostaCidade>
}