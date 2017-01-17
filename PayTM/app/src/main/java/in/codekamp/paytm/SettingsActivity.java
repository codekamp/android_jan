package in.codekamp.paytm;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by cerebro on 14/01/17.
 */

public class SettingsActivity extends AppCompatActivity {

    TextView usernameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        usernameTextView = (TextView) findViewById(R.id.passed_username);

        Intent intent = getIntent();

        String username = intent.getStringExtra("username");

        usernameTextView.setText(username);
    }

    @Override
    protected void onRestart() {
        super.onRestart();


        Log.d("codekamp", "On restart of SettingsActivity called");
    }

    @Override
    protected void onPause() {
        super.onPause();


    }
}
