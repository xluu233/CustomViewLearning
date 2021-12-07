package com.example.customview.SwipeView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.VelocityTracker
import android.widget.Scroller
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * @ClassName SwipeView
 * @Description TODO
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/9/1 10:50
 */
class SwipeView@JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyle: Int = 0) : ConstraintLayout(context, attrs, defStyle) {

    // 速度追踪器
    private var mVelocityTracker: VelocityTracker? = null

    private val mScroller: Scroller = Scroller(context)

    var lastX = 0
    var lastY = 0

    init {

    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (ev == null) return false
        obtainVelocity(ev)

        val x = ev.x.toInt()
        val y = ev.y.toInt()

/*        when(ev.action){
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                val offsetX = x-lastX
                val offsetY = y-lastY
                layout(left+offsetX,top+offsetY,right+offsetX,bottom+offsetY)


                mVelocityTracker?.computeCurrentVelocity(1000)

            }
            MotionEvent.ACTION_UP -> {
                releaseVelocity()
            }
        }*/
        return super.onInterceptTouchEvent(ev)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                val offsetX = x-lastX
                val offsetY = y-lastY
                layout(left+offsetX,top,right+offsetX,bottom)


                mVelocityTracker?.computeCurrentVelocity(1000)

            }
            MotionEvent.ACTION_UP -> {
                mScroller.startScroll(0, 0, 0, 0, 300)
                releaseVelocity()
                invalidate()
            }
        }
        return true
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            invalidate()
        }
    }

    private fun releaseVelocity() {
        if (mVelocityTracker != null) {
            mVelocityTracker?.clear()
            mVelocityTracker?.recycle()
            mVelocityTracker = null
        }
    }

    private fun obtainVelocity(event: MotionEvent) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain()
        }
        mVelocityTracker?.addMovement(event)
    }

}