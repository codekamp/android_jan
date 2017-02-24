package in.codekamp.servicesdemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ServiceConnection {

    VideoDownloadService downloadService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void videoDownloadButtonClick(View v) {
        Intent intent = new Intent(this, VideoDownloadService.class);
        intent.putExtra("video_url", "https://facebook.com");

        bindService(intent, this, Service.BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        downloadService = ((VideoDownloadService.VideoDownloadServiceBinder)binder).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
