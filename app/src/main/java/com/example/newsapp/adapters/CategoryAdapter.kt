package com.example.newsapp.adapters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.dataClass.Category
import com.example.newsapp.fragments.NewsWireFragment

class CategoryAdapter(private val array: ArrayList<Category>, val context: FragmentActivity):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView> (R.id.categoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameCategory
        holder.itemView.setOnClickListener {
        val bundle = Bundle()
            bundle.putInt("CATEGORY",item.id)
            context.supportFragmentManager.beginTransaction().replace(R.id.container,NewsWireFragment::class.java,bundle)
                .addToBackStack(null).commit()
            Log.d("DDD","${item.id}")
        }
    }

    override fun getItemCount(): Int {
      return array.size
    }
}