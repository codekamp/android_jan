package in.codekamp.servicesdemo;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by cerebro on 24/02/17.
 */

public class VideoUploadService extends IntentService {

    public VideoUploadService(String name) {
        super("upload video thread");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        
    }
}
