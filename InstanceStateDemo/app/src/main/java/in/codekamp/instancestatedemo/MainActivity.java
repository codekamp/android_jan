package in.codekamp.instancestatedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText numberEditText;
    TextView resultTextView;

    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            //this means activity has been recreated.
            result = savedInstanceState.getInt("result_value");
        }


        numberEditText = (EditText) findViewById(R.id.number_field);
        resultTextView = (TextView) findViewById(R.id.result_view);


        resultTextView.setText(Integer.toString(result));
    }

    public void calculate(View view) {
        int number = Integer.parseInt(numberEditText.getText().toString());

        result = number * number;
        resultTextView.setText(Integer.toString(result));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("result_value", result);
    }
}
