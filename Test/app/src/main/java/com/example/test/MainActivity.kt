package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.adapter.ApiEndPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { ApiEndPoint().endPoint }
    private lateinit var userAdapter: UserAdapter
    private lateinit var listUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
        setContentView(R.layout.activity_main)
        setUpList()
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
        getUser()
    }

    private fun setUpList() {
        listUser = findViewById(R.id.list_user)
        userAdapter = UserAdapter(arrayListOf())
        listUser.adapter = userAdapter
        listUser.layoutManager = LinearLayoutManager(this)
    }

    private fun getUser() {
        Log.d("MainActivity", "getUser called")
        api.data().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful && response.body() != null) {
                    val responseBody = response.body()
                    Log.d("MainActivity", "Response: ${responseBody.toString()}")
                    val listData = responseBody?.user
                    if (listData != null) {
                        userAdapter.setData(listData)
                    }
                } else {
                    Log.e("MainActivity", "Failed to load data: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", t.toString())
            }
        })
    }

}
