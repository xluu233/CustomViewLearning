package com.example.customview.ScrollView

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.jar.Attributes

/**
 * @ClassName ScrollView
 * @Description TODO
 * @Author AlexLu_1406496344@qq.com
 * @Date 2021/8/27 11:22
 */
class ScrollView : View {

    constructor(context:Context):super(context)

    constructor(context: Context,attr: AttributeSet):super(context,attr)

    constructor(context: Context,attr: AttributeSet,style:Int):super(context,attr,style)

    var lastX = 0
    var lastY = 0


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event==null) return super.onTouchEvent(event)

        val x = event.x.toInt()
        val y = event.y.toInt()

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_UP -> {

            }
            MotionEvent.ACTION_MOVE -> {
                val offsetX = x-lastX
                val offsetY = y-lastY
                layout(left+offsetX,top+offsetY,right+offsetX,bottom+offsetY)
            }
        }
        return true
    }

}