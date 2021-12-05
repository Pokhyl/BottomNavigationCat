package com.example.bottomnavigationcat.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bottomnavigationcat.MainActivity
import com.example.bottomnavigationcat.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class BlankFragment2 : Fragment() {
    private var binding: FragmentLoginBinding? = null
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BlankFragment2ViewModel by viewModels {
        viewModelFactory
    }

    companion object {
        fun newInstance() = BlankFragment2()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as MainActivity).mainComponent.injekt(this)
        binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(BlankFragment2ViewModel::class.java)
        var author = binding!!.author
        author.addTextChangedListener(autoTextChengeListener)
        var title = binding!!.title
        title.addTextChangedListener(autoTextChengeListener)
        var description = binding!!.description
        description.addTextChangedListener(autoTextChengeListener)
        var published = binding!!.published
        published .addTextChangedListener(autoTextChengeListener)
        var button = binding!!.button
        button.setOnClickListener {
            viewModel.saveBookToDatabase()
            println("click")
        }

    }
val autoTextChengeListener = object :TextWatcher{
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//        TODO("Not yet implemented")
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//        TODO("Not yet implemented")
    }

    override fun afterTextChanged(p0: Editable?) {
//        var x =p0?.length ?:0
//        if (x>0) {
            viewModel.setBook(
                title = title.text.toString(),
                author = author.text.toString(),
                description = description.text.toString(),
                published = 0
            )
        }
//        viewModel.bookLiveData.value = Book(title = title.text.toString(),
//                author = author.text.toString(),
//                description = description.text.toString(),
//                published = 0)
    }
}
