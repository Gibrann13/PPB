package com.example.test.adapter


import com.example.test.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiRetrofit {
    @GET("retriveUser.php")
    fun data() : Call<User>

}