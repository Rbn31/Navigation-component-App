package com.example.testecarrefour.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testecarrefour.databinding.ItemGitBinding
import com.example.testecarrefour.response.UsersResponse
import com.squareup.picasso.Picasso

class GitListAdapter(var callback: (Int) -> Unit) :
    RecyclerView.Adapter<GitListViewHolder>() {

    private var list: ArrayList<UsersResponse> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitListViewHolder {
        return GitListViewHolder(
            ItemGitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: ArrayList<UsersResponse>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: GitListViewHolder, position: Int) {
        holder.bind(list[position], position)
        holder.itemView.setOnClickListener {
            callback.invoke(position)
        }
    }

    override fun getItemCount() = list.size
}

class GitListViewHolder(
    val view: ItemGitBinding
) : RecyclerView.ViewHolder(view.root) {

    fun bind(data: UsersResponse, position: Int) {
        view.apply {
            tvId.text = data.id
            tvLoginName.text = data.login
            tvUserType.text = data.type

            if(data.avatar_url.isNotEmpty())
                Picasso.get().load(data.avatar_url).into(image)
        }
    }
}

