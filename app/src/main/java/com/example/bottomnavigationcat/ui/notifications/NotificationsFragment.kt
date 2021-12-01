package com.example.bottomnavigationcat.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnavigationcat.MainActivity
import com.example.bottomnavigationcat.R
import com.example.bottomnavigationcat.databinding.FragmentNotificationsBinding
import com.example.bottomnavigationcat.di.MainComponent
import com.example.bottomnavigationcat.ui.blank.BlankViewModel
import javax.inject.Inject

class NotificationsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val notificationsViewModel: NotificationsViewModel by viewModels {
        viewModelFactory
    }
lateinit var mainComponent: MainComponent

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainComponent = (requireActivity() as MainActivity).mainComponent
        mainComponent.inject(this)
     //   notificationsViewModel =
      //      ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}