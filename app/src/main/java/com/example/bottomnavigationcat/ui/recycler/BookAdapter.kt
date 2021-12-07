package com.example.bottomnavigationcat.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationcat.databinding.BookItemBinding
import com.example.bottomnavigationcat.model.Book

class BookAdapter(var list: MutableList<Book>): RecyclerView.Adapter<BookViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
val binding = BookItemBinding
    .inflate(LayoutInflater.from(parent.context), parent, false)
        var bookViewHolder = BookViewHolder(binding)
        return bookViewHolder
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
var book:Book = list[position]
        holder.binding.id.text = book.id.toString()
        holder.binding.title.text = book.title.toString()
        holder.binding.author.text = book.author.toString()
        holder.binding.description.text = book.description.toString()
        holder.binding.published.text = book.published.toString()

    }

    override fun getItemCount(): Int {
return list.size
    }
}