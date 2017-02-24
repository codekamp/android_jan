package in.codekamp.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by cerebro on 24/02/17.
 */

public class VideoDownloadService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new VideoDownloadServiceBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void next() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class VideoDownloadServiceBinder extends Binder {

        public VideoDownloadService getService() {
            return VideoDownloadService.this;
        }
    }
}
