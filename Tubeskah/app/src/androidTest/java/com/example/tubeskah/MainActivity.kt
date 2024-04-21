package com.example.tubes_e_money

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tubes_e_money.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Panggil super.onCreate() terlebih dahulu
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rv_menu)

        // Set LayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        val judul = listOf("Setti", "fewfdsfsdf", "fewfewfew")
        // Data untuk ditampilkan dalam RecyclerView
        val menuItems = listOf("Profile Settings", "EzCash Points", "Linked Account")

        // Buat adapter untuk RecyclerView
        val adapter = MenuAdapter(menuItems)

        recyclerView.adapter = adapter
    }

}