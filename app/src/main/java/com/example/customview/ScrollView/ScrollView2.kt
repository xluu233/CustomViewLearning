package com.example.customview.ScrollView

import android.R.attr
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller
import java.util.jar.Attributes
import android.R.attr.startY

import android.R.attr.startX




/**
 * @ClassName ScrollView
 * @Description TODO
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/8/27 11:22
 */
class ScrollView2 : View {

    constructor(context:Context):super(context)

    constructor(context: Context,attr: AttributeSet):super(context,attr)

    constructor(context: Context,attr: AttributeSet,style:Int):super(context,attr,style)

    var lastX = 0
    var lastY = 0

    private var scroller : Scroller = Scroller(context)


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event==null) return super.onTouchEvent(event)

        val x = event.x.toInt()
        val y = event.y.toInt()

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                lastX = event.rawX.toInt()
                lastY = event.rawY.toInt()
            }
            MotionEvent.ACTION_UP -> {
            }
            MotionEvent.ACTION_MOVE -> {
                //scroller.startScroll(-lastX,-lastY, -x,-y)
                smoothScroll(-x,-y)
                Log.d("TAG", "onTouchEvent: lastX:${lastX},lastY:$lastY,x:$x,y:$y")
                invalidate()
            }
        }
        return true
    }

    fun smoothScroll(dx: Int, dy: Int) {
        //获取滑动起点坐标
        val startX = scrollX
        val startY = scrollY
        //设置滑动参数
        scroller.startScroll(startX, startY, dx, dy)
        //重新绘制View
        invalidate()
    }


    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.d("TAG", "onLayout: ")
    }

    override fun computeScroll() {
        super.computeScroll()
        //判断Scroller是否执行完毕
        if (scroller.computeScrollOffset()) {
            (this.parent as View).scrollTo(
                scroller.currX,
                scroller.currY
            )
            //通过重绘来不断调用computeScroll
            invalidate()
        }
    }

}