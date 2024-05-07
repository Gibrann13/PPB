package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter (
    val user: ArrayList<User.Data>
): RecyclerView.Adapter<UserAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user,parent,false)
    )

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val data= user[position]
        holder.textUser.text = data.Nama
    }

    override fun getItemCount() = user.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textUser = view.findViewById<TextView>(R.id.textuser)
        val imageProfile = view.findViewById<ImageView>(R.id.image_profile)
    }

    public fun setData(data: List<User.Data>){
        user.clear()
        user.addAll(data)
        notifyDataSetChanged()
    }
}