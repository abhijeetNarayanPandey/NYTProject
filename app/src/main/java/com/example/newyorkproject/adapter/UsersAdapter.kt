package com.example.newyorkproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.daggermvvm.models.Users
import com.example.newyorkproject.R

class UsersAdapter(private val users: List<Users>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userId: TextView = view.findViewById(R.id.user_id)
        val userName: TextView = view.findViewById(R.id.username)
        val companyName: TextView = view.findViewById(R.id.company_name)
        val companyId: TextView = view.findViewById(R.id.company_id)
        val address: TextView = view.findViewById(R.id.address)
        val latitude: TextView = view.findViewById(R.id.latitude)
        val longitude: TextView = view.findViewById(R.id.longitude)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.apply {
            userId.text = "ID: ${user.id}"
            userName.text = "UserName: ${user.name}"
            companyName.text = "Company: ${user.company.name}"
            companyId.text = "Company ID: ${user.company.bs}" //
            address.text = "Address: ${user.address.street}, ${user.address.city}, ${user.address.zipcode}"
            latitude.text = "Latitude: ${user.address.geo.lat}"
            longitude.text = "Longitude: ${user.address.geo.lng}"
        }
    }
}
