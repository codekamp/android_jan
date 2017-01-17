package in.codekamp.mydemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView myTextView;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextView = (TextView) findViewById(R.id.text_view_1);
        myEditText = (EditText) findViewById(R.id.edit_text_1);

    }

    public void buttonClicked(View view) {
        myTextView.setText("Button has been clicked!");
        myEditText.setText("Edit text data set");
    }
}
