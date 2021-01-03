package com.example.androidtabbar.dataSource

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtabbar.R

class UsersAdapter (
    private val context: Context,
    private val objects: List<User>,
    private val clickListener: OnItemClickListener,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(model: User, view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_user, parent, false)
        return UserItemHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = objects[position]
        if (holder is UserItemHolder) {
            holder.bind(model, clickListener)
            holder.avatarImageView.setImageDrawable(context.resources.getDrawable(model.avatar))
            holder.nameTextView.text = "${model.firstName} ${model.lastName}"
        }
    }

    override fun getItemCount() = objects.size

    class UserItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var avatarImageView: AppCompatImageView = itemView.findViewById(R.id.avatarImageView)
        var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(model: User, listener: OnItemClickListener) {
            itemView.setOnClickListener { listener.onItemClick(model, itemView) }
        }
    }
}
