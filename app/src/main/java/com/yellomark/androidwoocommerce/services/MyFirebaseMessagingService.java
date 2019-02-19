package com.yellomark.androidwoocommerce.services;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.yellomark.androidwoocommerce.activities.MainActivity;
import com.yellomark.androidwoocommerce.utils.NotificationHelper;


/**
 * MyFirebaseMessagingService receives notification Firebase Cloud Messaging Server
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    
    
    //*********** Called when the Notification is Received ********//
    
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        
        String notification_title, notification_message;
    
        Log.i("VC_Shop", "firebaseMessageReceivedFrom="+remoteMessage.getFrom());
        
    
        if (remoteMessage.getData().size() > 0) {
            notification_title = remoteMessage.getData().get("title");
            notification_message = remoteMessage.getData().get("message");
        }
        else {
            notification_title = remoteMessage.getNotification().getTitle();
            notification_message = remoteMessage.getNotification().getBody();
        }
    
        if (remoteMessage.getNotification() != null) {
            notification_title = remoteMessage.getNotification().getTitle();
            notification_message = remoteMessage.getNotification().getBody();
        }
    
    
        Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        
        NotificationHelper.showNewNotification
                (
                        getApplicationContext(),
                        notificationIntent,
                        notification_title,
                        notification_message
                );
        
    }
    
}
