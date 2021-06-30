package com.example.terrgym80;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(),"onCreate");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*
* 작업지시서
* 1. 툴바의 아이콘을 눌러 내비게이션 드로워를 열수 있또록 한다
* 2. ActionBarDrawerToggle클래스의 새 인스턴스를 생성하고 드로워 레이아웃에
*  추가하는 코드를 액티비티의 onCreate()에 구현해서 드로워 토글을 생성한다
* @param1 : 현재 액티비티(this, getApplicationContext(), getContext()) - 이 3개로 안되면 라이프사이클에 문제있음
* @액티비티의 drawer
* @액티비티의 툴바
* @드러워열기, 드로워닫기
* 3. 드로워토글을 생성한 다음 DrawerLayout의 addDrawerListener()메소드의 파라미터로 전달해서 드로워 레이아웃으로 추가함
* 4. 토글의 syncState()로 툴바의 아이콘과 드로워 상태 동기화한다
* */
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this
                        ,drawer
                        ,toolbar
                        ,R.string.nav_open_drawer
                        ,R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, LoginFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    @Override//부모클래스로부터 재정의
    protected void onStart(){
        super.onStart();
        Log.i(this.getClass().getName(),"onStart");
    }
    public void resList(View v){
        Log.i(this.getClass().getName(),"resList"+v);
        Intent intent = new Intent(this, ResListActivity.class);
        startActivity(intent);//다른 액티비티로 화면 이동
    }
}