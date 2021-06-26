package com.example.tomcatconnect2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_receive = null;//변수선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_receive = findViewById(R.id.tv_receive);//화면구성때 같이 초기화
    }
    public void loginAction(View v){
        println("요청 보냄");
        EditText et_id = findViewById(R.id.et_id);
        String id = et_id.getText().toString();
        EditText et_pw = findViewById(R.id.et_pw);
        String pw = et_pw.getText().toString();
        //톰캣 서버에서 전송한 문자열을 받는 변수(Text, JSON)
        String receive = null;
        try {
            LoginLogic loginLogic = new LoginLogic();
            receive = loginLogic.execute(id,pw).get();
            tv_receive.setText(receive);
        }catch (Exception e){//예외처리
            Log.i(this.getClass().getName(), "Exception:"+e.toString());
        }
        Log.i(this.getClass().getName(), "톰캣 서버에서 전송한 문자열:"+receive);
    }
    public void println(String data){//테스트용 프린트 메소드 제작
        Log.i("MainActivity",data+"\n");
    }
}