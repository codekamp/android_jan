package in.codekamp.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginButtonListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();



        if (manager.findFragmentById(R.id.login_container) == null) {
            LoginFragment fragment = LoginFragment.getNewInstance(10);
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.login_container, fragment);
            transaction.commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onLoginButtonClicked() {
        Log.d("codekamp", "onLoginCliked of MainActivity");
    }
}
