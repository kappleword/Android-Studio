package com.example.paprika;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    //프래그먼트는  xml레이아웃 파일 하나랑 자바소스 파일 하나로 정의할 수 있다.
    //이게 하나의 뷰처럼 쓸 수 있는데 뷰하고 약간 다른특성들이 있다.
    //엑티비티를 본떠 만들었기 떄문에 프래그먼트 매니저가 소스코드에서 담당한다.
    LoginFragment fragmentLogin;
    HomeFragment fragmentHome;
    ScheduleFragment fragmentSchedule;
    CourseFragment fragmentCourse;
    NaverFragment fragmentNaver;
    DaumFragment fragmentDaum;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //프래그먼트는 뷰와 다르게 context를 매개변수로 넣어줄 필요가 없다.
        fragmentLogin = new LoginFragment();
        fragmentHome = new HomeFragment();
        fragmentSchedule = new ScheduleFragment();
        fragmentCourse = new CourseFragment();
        fragmentNaver = new NaverFragment();
        fragmentDaum = new DaumFragment();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //프래그먼트 추가하거나 할떄는 여러개 명령을 한꺼번에 쓸 수 있으므로
                //beginTransaction을 사용함
                //fragment1를 R.id.container에 넣어달라(add 또는 replace, replace는 기존에있던걸 대체해줌)
                //트랜잭션안에서 수행되는것이므로 마지막에 꼭 commit을 해줘야 실행이된다.
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();/*프래그먼트 매니저가 프래그먼트를 담당한다!*/
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //처음화면
        //getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new Fragment1()).commit(); //FrameLayout에 fragment.xml 띄우기
        //바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.menuHome:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
                        break;
                    case R.id.menuSchedule:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentSchedule).commit();
                        break;
                    case R.id.menuCourse:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentCourse).commit();
                        break;
                    case R.id.menuImsi:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentNaver).commit();
                        break;
                }
                return true;
            }
        });

    }

    //프래그먼트와 프래그먼트끼리 직접접근을하지않는다. 프래그먼트와 엑티비티가 접근함
    public void onFragmentChange(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentLogin).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentHome).commit();
        } else if (index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentSchedule).commit();
        } else if (index == 3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentCourse).commit();
        } else if (index == 6) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentNaver).commit();
        } else if (index == 7) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentDaum).commit();
        }
    }
}