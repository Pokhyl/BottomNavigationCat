package com.example.bottomnavigationcat.ui.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigationcat.R
import com.example.bottomnavigationcat.databinding.BookItemBinding


import com.example.bottomnavigationcat.model.Book

class BookAdapter(): RecyclerView.Adapter<BookViewHolder> (){
    var list: MutableList<Book> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

val binding = BookItemBinding
    .inflate(LayoutInflater.from(parent.context), parent, false)
        var bookViewHolder = BookViewHolder(binding)
        return bookViewHolder
    }
fun setData(list: List<Book>){
    this.list.clear()
    this.list.addAll(list)
    notifyDataSetChanged()
}
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
var book:Book = list[position]
        holder.binding.id.text = book.id.toString()
        holder.binding.title.text = book.title.toString()
        holder.binding.author.text = book.author.toString()
        holder.binding.description.text = book.description.toString()
        holder.binding.published.text = book.published.toString()
        holder.binding.conteiner.setOnClickListener{
            var bundle = Bundle()
            bundle.putParcelable("book",book)
            it.findNavController().navigate(R.id.action_blank_fragment_to_loginFragment,bundle)
        }

    }

    override fun getItemCount(): Int {
return list.size
    }
}