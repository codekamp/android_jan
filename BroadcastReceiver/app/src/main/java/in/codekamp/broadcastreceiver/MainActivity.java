package in.codekamp.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        detector = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

            }
        };


        Intent intent = new Intent("LoginStatusChanged");
        intent.putExtra("status", false);
        sendBroadcast(intent);


        EventBus.getDefault().post(new UserLogoutEvent());


        EventBus.getDefault().register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter("LoginStatusChanged");
        filter.setPriority(10);
        registerReceiver(detector, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(detector);
    }


    @Subscribe
    public void onUserLoggedOut(UserLogoutEvent logoutEvent) {

    }

    @Subscribe
    public void onUserLoggedIn(UserLoginEvent loginEvent) {
        loginEvent.loggedinUser
    }
}
