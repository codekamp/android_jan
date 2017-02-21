package in.codekamp.asynctaskdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cerebro on 21/02/17.
 */

public class MailChimpAPIClient {
    private static final String BASE_URL = "https://us11.api.mailchimp.com/3.0/";

    public static MailChimpAPI getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(MailChimpAPI.class);
    }
}
