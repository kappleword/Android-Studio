package com.example.tomcatconnect2021;

import android.os.AsyncTask;

import java.net.URI;

/*
새로 만든 스레드에서 UI객체에 직접 접근하는 것은 불가능하다
스레드를 위한 동작 코드와 UI 접근 코드를 한꺼번에 구현할 수 있다
 */
public class LoginLogic extends AsyncTask<String,Void,String> {
    String receiveMsg = null;
    @Override
    public String doInBackground(String... strings){
        String apiURL = "";
        try {
            URI url = new URI(apiURL);

        }catch (Exception e){

        }
        return receiveMsg;
    }
}
