package in.codekamp.asynctaskdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hi There, Checkout this cool app....");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Try out CodeKamp app");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // show message that no app installed which support email sending
        }

        Intent chooserIntent = Intent.createChooser(intent, "Please choose an app to send email");
        startActivity(chooserIntent);
    }
}
