package com.example.lotto80

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker

class MainActivity4 : AppCompatActivity() {
/****
 * 선언뒤에 lazy가 오면 activity_main4.xml을 스캔할 때 까지 기다린다
    $(document).ready(function(){//<<java
      $("#dg_dept").datagrid({
      url:"xxx.jsp"
       );
    });
*****/
    private val runButton: Button by lazy {
        findViewById(R.id.runButton)
    }
    //NumberPiceker의 범위를 정해주자. 지금은 0만 보인다. 움직이지도 않는 상태
    private val numberPicker: NumberPicker by lazy {
        findViewById(R.id.numberPicker)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberPicker.minValue = 1
        numberPicker.maxValue = 45
        //자동채번 버튼 구현
        initRunButton()
    }
    private fun initRunButton(){
        runButton.setOnClickListener {
            var rbtn = it.id
            Log.i("MainActivity4","버튼 주소번지:${rbtn}")
            val list = getRandomNumber()
            Log.d("MainActivity4", list.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        //실행이 되었다가(백스택에 머물러있다가) 다시 소환될때 onCreate를 타는게 아니라 여기로 온다
        initRunButton()
    }
    //채번알고리즘
    private fun getRandomNumber():List<Int> {
        //String name[] = new String[3];
        //names = new String[]{"이순신","강감찬","이성계"};
        //List<Integer> numberList2 = new ArrayList<>(); -java version
        val numberList = mutableListOf<Int>().apply {
            for (i in 1..45) {
                this.add(i)
            }
        }///end of initialized
        numberList.shuffle()
        val newList = numberList.subList(0,6)
        return newList.sorted()//sorted-정렬
    }/////////end of getRandomNumber
}