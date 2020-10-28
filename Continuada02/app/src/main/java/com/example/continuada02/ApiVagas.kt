package com.example.continuada02

import retrofit2.Call
import retrofit2.http.GET

interface ApiVagas {

    @GET("/vagas")
    fun getVagas() : Call<List<Vagas>>
}