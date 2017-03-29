package in.codekamp.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by cerebro on 27/03/17.
 */

public class AirplaneModeChangeDetector extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Log.d("codekamp", "airplane mode changed");
        }
    }
}
