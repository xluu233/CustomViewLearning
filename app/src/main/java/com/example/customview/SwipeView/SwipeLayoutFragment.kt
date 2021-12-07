package com.example.customview.SwipeView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.baselibrary.delegate.viewBinding
import com.example.customview.R
import com.example.customview.databinding.FragmentSwipeLayoutBinding

class SwipeLayoutFragment : Fragment(R.layout.fragment_swipe_layout) {

    private val binding by viewBinding(FragmentSwipeLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}