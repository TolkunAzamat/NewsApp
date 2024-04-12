package com.example.newsapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.Constants
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter

class NewsWireFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_wire, container, false)
        val currentCategory = requireArguments().getInt("CATEGORY")
        val filteredCategory = Constants.news.filter { it.id == currentCategory } as ArrayList
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerNews)
        recyclerView.adapter = NewsAdapter(filteredCategory,requireActivity())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}