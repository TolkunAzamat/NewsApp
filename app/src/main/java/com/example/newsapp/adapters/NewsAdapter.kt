package com.example.newsapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.dataClass.News
import com.example.newsapp.fragments.NewsFragment
import java.util.ArrayList

class NewsAdapter(private val array: ArrayList<News>, private val context:FragmentActivity):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
class ViewHolder( view: View):RecyclerView.ViewHolder(view){
    val image = view.findViewById<ImageView>(R.id.imageView)
    val title = view.findViewById<TextView>(R.id.title)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        Glide.with(holder.itemView).load(item.image).into(holder.image)
        holder.title.text = item.title
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("NEWS",item)
            context.supportFragmentManager.beginTransaction().replace(R.id.container,NewsFragment::class.java,bundle)
                .addToBackStack(null).commit()
        }
    }
}