package com.samples.notificationmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends Activity implements View.OnClickListener{

    private static final int ID_NOTIFY = 101;
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btCreate:

                manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

                Intent intent = new Intent(this, NotificationActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                Notification.Builder notification = new Notification.Builder(this);
                notification.setSmallIcon(android.R.drawable.ic_notification_overlay)
                        .setContentText("New notification")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .build();

                manager.notify(ID_NOTIFY, notification.getNotification());

                break;
            case R.id.btClear:
                manager.cancel(ID_NOTIFY);
                break;
        }
    }
}
