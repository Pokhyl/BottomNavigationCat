package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bottomnavigationcat.MainActivity
import com.example.bottomnavigationcat.MainApp
import com.example.bottomnavigationcat.R
import com.example.bottomnavigationcat.databinding.BlankFragmentBinding
import com.example.bottomnavigationcat.di.MainComponent
import com.example.bottomnavigationcat.model.Book
import com.example.bottomnavigationcat.ui.recycler.BookAdapter
import kotlinx.coroutines.NonDisposableHandle.parent
import javax.inject.Inject

class BlankFragment : Fragment() {
    private var _binding: BlankFragmentBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BlankViewModel by viewModels {
        viewModelFactory
    }
    lateinit var mainComponent: MainComponent

    companion object {
        fun newInstance() = BlankFragment()
    }

  //  private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BlankFragmentBinding.inflate(inflater, container, false)

        mainComponent = (requireActivity() as MainActivity).mainComponent
        mainComponent.inject(this)
    return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
     //   viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
      //  val creator:ViewModelProvider = creators[modelClass] ?: creators.entries.firstOrNull {
//            modelClass.isAssignableFrom(it.key)
//        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
//        @Suppress("UNCHECKED_CAST")
//        return creator.get() as T
        (requireContext() as MainActivity).mainComponent.inject(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL, false)
        var bookAdapter = BookAdapter()
        binding.recyclerView.adapter = bookAdapter



        viewModel.loadBookListFromDatabase()
        viewModel.liveData.observe(viewLifecycleOwner,{  bookAdapter.setData(it) })
        viewModel.liveData.observe(viewLifecycleOwner,{ println(it.size)})



    }

}