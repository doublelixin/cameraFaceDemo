package com.xin.camera.facedemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class FaceView : View {
    lateinit var mPaint: Paint
    private var mCorlor = "#42ed45"
    private var mFaces: ArrayList<RectF>? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint.color = Color.parseColor(mCorlor)
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            1f,
            context.resources.displayMetrics
        )
        mPaint.isAntiAlias = true
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mFaces?.let {
            for (face in it) {
//                face.left = face.left * width / measuredHeight + 250
//                face.right = face.right * width / measuredHeight + 500
//                face.top = face.top * height / measuredHeight - 180
//                face.bottom = face.bottom * height / measuredHeight - 100
                canvas.drawRect(face, mPaint)
            }
        }
    }

    fun setFaces(faces: ArrayList<RectF>) {
        this.mFaces = faces
        invalidate()
    }
}