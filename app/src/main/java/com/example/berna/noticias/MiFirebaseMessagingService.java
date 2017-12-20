package com.example.berna.noticias;



import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.NotificationCompatExtras;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by BERNA on 13/12/2017.
 */

public class MiFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = "NOTICIAS";
    private Map<String, String> getData;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String from = remoteMessage.getFrom();
        getData = remoteMessage.getData();


        Log.d(TAG, "Mensaje recibido de: "+ from);
        if (remoteMessage.getNotification() != null){
            Log.d(TAG, "Notificacion: "+ remoteMessage.getNotification().getBody());
            mostrarNotificacion(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
        }
    }

    private void mostrarNotificacion(String title, String body) {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        String url = getData.get("image");
        i.putExtra("title", title);
        i.putExtra("body", body);
        i.putExtra("image", url);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_ONE_SHOT);

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(uri)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());
    }


}
