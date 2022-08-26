package com.xin.camera.facedemo.camera2

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.xin.camera.facedemo.R
import kotlinx.android.synthetic.main.activity_camera2.*

class CameraActivity2 : AppCompatActivity() {

    private lateinit var mCamera2Helper: Camera2Helper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera2)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        mCamera2Helper = Camera2Helper(this, textureView)

        btnTakePic.setOnClickListener { mCamera2Helper.takePic() }
        ivExchange.setOnClickListener { mCamera2Helper.exchangeCamera() }
    }

    override fun onDestroy() {
        super.onDestroy()
        mCamera2Helper.releaseCamera()
        mCamera2Helper.releaseThread()
    }

}

