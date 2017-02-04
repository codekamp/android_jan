package in.codekamp.fragmentdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by cerebro on 28/01/17.
 */

public class LoginFragment extends Fragment {

    private static final String USER_ID = "user_id";
    private int userId = 0;

    private Button loginButton;

    private LoginButtonListner listner;

    public void setListner(LoginButtonListner listner) {
        this.listner = listner;
    }

    public LoginFragment() {

    }

    public static LoginFragment getNewInstance(int userId) {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(USER_ID, userId);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        userId = b.getInt(USER_ID);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(!(getActivity() instanceof LoginButtonListner)) {
            throw new RuntimeException("Please implment LoginButtonListner if you want to use LoginFragment");
        }

        this.listner = (LoginButtonListner)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginButton = (Button) view.findViewById(R.id.login_button);
        loginButton.setText(Integer.toString(userId));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listner != null) {
                    listner.onLoginButtonClicked();
                }
            }
        });

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("abcd", 100);
    }

    public static interface LoginButtonListner {
        public void onLoginButtonClicked();
    }
}
