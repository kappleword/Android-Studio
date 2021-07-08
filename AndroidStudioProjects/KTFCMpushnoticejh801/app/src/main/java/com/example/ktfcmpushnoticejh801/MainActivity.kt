package com.example.ktfcmpushnoticejh801

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    //게으른 초기화
    private val resultTextView: TextView by lazy{
        findViewById(R.id.resultTextView)
    }
    private val firebaseToken: TextView by lazy{
        findViewById(R.id.firebaseTokenText)
    }
    //기존의 자바방식

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun initFirebase() {
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener{task ->
                if(task.isSuccessful){
                    firebaseToken.text = task.result
                }
            }
    }//코틀린에서는 ?/?가 하나면 람다식으로 처리한다
}