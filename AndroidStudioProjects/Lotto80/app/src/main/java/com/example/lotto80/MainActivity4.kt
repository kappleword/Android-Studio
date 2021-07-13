package com.example.lotto80

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker

class MainActivity4 : AppCompatActivity() {
    //NumberPiceker의 범위를 정해주자. 지금은 0만 보인다. 움직이지도 않는 상태
    private val numberPicker: NumberPicker by lazy {
        findViewById(R.id.numberPicker)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberPicker.minValue = 1
        numberPicker.maxValue = 45
    }
}