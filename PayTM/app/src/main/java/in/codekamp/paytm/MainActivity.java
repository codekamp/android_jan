package in.codekamp.paytm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    EditText userNameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameField = (EditText) findViewById(R.id.username_field);
    }














    public void openSettings(View view) {
        String enteredValue = userNameField.getText().toString();

        Intent intent = new Intent(this, SettingsActivity.class);
        intent.putExtra("username", enteredValue);
        startActivity(intent);

    }
}