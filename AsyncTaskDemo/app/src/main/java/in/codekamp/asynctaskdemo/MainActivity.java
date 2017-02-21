package in.codekamp.asynctaskdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Callback<MailChimpListResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchLists(View view) {

        Call<MailChimpListResponse> call = MailChimpAPIClient.getClient().fetchLists("51da3098e5b066041e5771990895d1f0-us11", 0, 10);

        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MailChimpListResponse> call, Response<MailChimpListResponse> response) {
        MailChimpListResponse listResponse = response.body();

        Log.d("codekamp", "total items " + listResponse.totalItems);

        for(MailChimpList list:listResponse.lists) {
            Log.d("codeakamp", list.getTitle());
        }

    }

    @Override
    public void onFailure(Call<MailChimpListResponse> call, Throwable t) {

    }
}
