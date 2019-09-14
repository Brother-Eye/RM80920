package com.nac.rm80920
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SWAPICALL{

    @GET("people/{pessoa}/")
    fun buscarPessoa(@Path("pessoa")pessoa:String):Call<Personagem>
}