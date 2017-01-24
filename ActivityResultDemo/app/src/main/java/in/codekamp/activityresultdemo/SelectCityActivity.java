package in.codekamp.activityresultdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SelectCityActivity extends AppCompatActivity {

    private static final String COUNTRY_NAME = "country_name";
    private static final String SELECTED_CITY = "selected_city";

    private String countryName;

    EditText cityEditText;

    public static Intent getLaunchIntent(Context c, String countryName, boolean metroOnly) {
        Intent intent = new Intent(c, SelectCityActivity.class);
        intent.putExtra(COUNTRY_NAME, countryName);
        intent.putExtra("metro_only", countryName);
        return  intent;
    }

    public static String getCity(Intent intent) {
        return intent.getStringExtra(SELECTED_CITY);
    }

    public static int getPinCode(Intent intent) {
        return intent.getIntExtra("pin_code", 0);
    }

    @Override
    protected void onCreate(Bundle a) {
        super.onCreate(a);
        setContentView(R.layout.activity_select_city);

        cityEditText = (EditText)findViewById(R.id.city_name);

        countryName = getIntent().getStringExtra(COUNTRY_NAME);

        //code to fetch cities of this country from database or server
    }

    public void onCitySelected(View view) {
        String cityName = cityEditText.getText().toString();

        Log.d("codekamp", "selected city name is " + cityName);

        Intent intent = new Intent();
        intent.putExtra(SELECTED_CITY, cityName);
        intent.putExtra("pin_code", 250110);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void onCancel(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
