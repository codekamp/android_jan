package in.codekamp.activityresultdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_CITY_REQUEST = 10;
    private static final int SELECT_COUNTRY_REQUEST = 20;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = (TextView)findViewById(R.id.result_textview);
    }

    public void showCitySelectScreen(View view) {
        Intent intent = SelectCityActivity.getLaunchIntent(this, "india", false);
        startActivityForResult(intent, SELECT_CITY_REQUEST);
    }

    public void showCountrySelectScreen(View view) {
        Intent intent = new Intent(this, SelectCityActivity.class);
        startActivityForResult(intent, SELECT_COUNTRY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent a) {
        super.onActivityResult(requestCode, resultCode, a);

        if(requestCode == SELECT_CITY_REQUEST) {

            if(resultCode == Activity.RESULT_OK) {
                String s = SelectCityActivity.getCity(a);

            } else if (requestCode == Activity.RESULT_CANCELED) {

            }
        } else {

        }
    }
}
