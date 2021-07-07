package com.example.fcmpushnotice801;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
    }
    //메세지 받는 메소드
    @Override
    public void onMessageReceived(RemoteMessage message){
        super.onMessageReceived(message);
    }
}
