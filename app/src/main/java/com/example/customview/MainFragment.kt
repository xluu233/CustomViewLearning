package com.example.customview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.baselibrary.delegate.viewBinding
import com.example.customview.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        binding.scrollView.setOnClickListener {
            navigate(R.id.action_mainFragment_to_fragmentScrollView)
        }

        binding.swipe.setOnClickListener {
            navigate(R.id.action_mainFragment_to_swipeLayoutFragment)
        }

    }


    fun navigate(destination: Int, bundle: Bundle ?= null) = NavHostFragment.findNavController(this).apply {
        currentDestination?.getAction(destination)?.let {
            navigate(destination,bundle)
        }
    }

}