package com.example.bottomnavigationcat.ui.blank

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bottomnavigationcat.MainActivity
import com.example.bottomnavigationcat.R
import javax.inject.Inject

class BlankFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: BlankViewModel by viewModels {
        viewModelFactory
    }

    companion object {
        fun newInstance() = BlankFragment()
    }

  //  private lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
     //   viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        (requireContext() as MainActivity).mainComponent.inject(this)
        viewModel.liveData.observe(viewLifecycleOwner,{ println(it)})
    }

}