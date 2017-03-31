package in.codekamp.alarmservicedemo;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra("id", 10);
//
//        PendingIntent p = PendingIntent.getActivity(this, 10, i, PendingIntent.FLAG_CANCEL_CURRENT);
//
//        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
//
//        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, 20000, 10000, p);
    }

    public void fireNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);


        Intent i = new Intent(this, SecondActivity.class);
        PendingIntent p = PendingIntent.getActivity(this, 10, i, PendingIntent.FLAG_ONE_SHOT);


        builder.setContentTitle("my first notification");
        builder.setContentText("This is details of my first notification");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(p);
        builder.setAutoCancel(true);

        builder.setOngoing(true);
        builder.setProgress(450,15,true);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(10, builder.build());


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        builder.setProgress(0,0,false);
        builder.setOngoing(false);
        manager.notify(10, builder.build());
    }
}
