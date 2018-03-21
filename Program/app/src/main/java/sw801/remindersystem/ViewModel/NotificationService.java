package sw801.remindersystem.ViewModel;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import sw801.remindersystem.ActivityView.AddEventActivity;
import sw801.remindersystem.ActivityView.MyEventsFragment;
import sw801.remindersystem.R;

public class NotificationService extends Service {
    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = intent.getStringExtra("name");
        String text = intent.getStringExtra("text");



        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "ch1")
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_add_black_18dp)
                        .setTicker("Hearty365")
                        .setPriority(Notification.PRIORITY_MAX) // this is deprecated in API 26 but you can still use for below 26. check below update for 26 API
                        .setContentTitle(name)
                        .setContentText(text)
                        .setContentInfo("Info");
        int NOTIFICATION_ID = 12345;

        //TODO Change this to mainactivity and change mainactivity to open myevents fragment
        Intent targetIntent = new Intent(this, AddEventActivity.class);


        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, targetIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManager.notify(NOTIFICATION_ID, builder.build());
        return super.onStartCommand(intent, flags, startId);
    }
}
