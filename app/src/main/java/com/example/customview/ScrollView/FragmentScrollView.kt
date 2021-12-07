package com.example.customview.ScrollView

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.example.baselibrary.delegate.viewBinding
import com.example.customview.R
import com.example.customview.databinding.FragmentMainBinding
import com.example.customview.databinding.FragmentScrollViewBinding

class FragmentScrollView : Fragment(R.layout.fragment_scroll_view) {

    private val TAG = "FragmentScrollView"
    private val binding by viewBinding(FragmentScrollViewBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClick()
    }

    private fun initClick() {
        //利用属性动画移动
        binding.view.startAnimation(AnimationUtils.loadAnimation(requireContext(),R.anim.move))


        binding.view.setOnClickListener {
            Log.d(TAG, "initClick: binding view")
        }

        val valueAnimator = ValueAnimator.ofInt(0,100)
        valueAnimator.duration = 10000

        valueAnimator.addUpdateListener {
            val value :Int = it.animatedValue as Int
            binding.view.apply {
                layout(value,value,width+value,height+value)
            }
        }

        //valueAnimator.start()

        val objectAnimator = ObjectAnimator.ofFloat(binding.view,"alpha",0.1f,1.0f,0.5f)
        objectAnimator.apply {
            duration = 3000
            start()
        }

    }


}