package com.example.kosmo_erp80;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    //로그인 성공시 톰캣 서버로 부터 받아올 이름 담기
    private static String sname = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i(this.getClass().getName(),"로그인 버튼 호출 성공");
                login();
            }
        });
    }
    public void login(){
        Log.i(this.getClass().getName(),"login() 호출 성공");
        EditText et_id = findViewById(R.id.et_id);
        EditText et_pw = findViewById(R.id.et_pw);
        final String id = et_id.getText().toString();
        final String pw = et_pw.getText().toString();
        //println("id:"+et_id.getText().toString()+", pw:"+ et_pw.getText().toString());
        String apiURL = "http://192.168.219.100:7000/login/postLogin";
        try {
            StringRequest request = new StringRequest(Request.Method.POST, apiURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    sname = response;
                    println(sname);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    println("에러 : "+error.getMessage());
                }
            }){
                //사용자로 부터 입력 받은 아이디와 비번을 넘김
                public Map<String, String> getParams() throws AuthFailureError{
                    Map<String,String> params = new HashMap<>();
                    params.put("mem_id",id);
                    params.put("mem_pw",pw);
                    return params;
                }
            };
            request.setShouldCache(false);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(request);
        }catch (Exception e){
            Log.i("Volley", e.toString());
        }
        println("요청 보내고 받아 옴."+sname);
        //로그인 처리가 성공하면
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("sname", sname);
        startActivity(intent);
    }
    //오류 체크를 위해 println 메소드 구현
    public void println(String data){
        Log.i(this.getClass().getName(),data+"\n");
    }
}