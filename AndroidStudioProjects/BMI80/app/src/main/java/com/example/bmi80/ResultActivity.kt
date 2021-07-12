package com.example.bmi80

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.AbsSavedState
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
/*
new 예약어가 없다
함수뒤에 제네릭을 사용한다
객체생성 후 즉시 초기화 할때 apply() {} let().....RecyclerView, xxxAdapter, ViewHolder
$변수이름
 */
class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        //xml, 리사이클러뷰 root, 레이아웃매니저
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)
        Log.d("ResultActivity", "height: $height, weight:$weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        //switch가 없어서 when문 사용
        val resultText = when {//수치에 대한 판정값
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }
        //insert here(let->var, const -> val)
        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}