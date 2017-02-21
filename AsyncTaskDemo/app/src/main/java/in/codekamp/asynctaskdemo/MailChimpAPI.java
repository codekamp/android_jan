package in.codekamp.asynctaskdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cerebro on 21/02/17.
 */

public interface MailChimpAPI {

    @GET("lists")
    public Call<MailChimpListResponse> fetchLists(@Query("apikey") String apiKey, @Query("offset") int offset, @Query("count") int count);

    @GET("lists/{list_id}/members")
    public Call<Void> fetchContacts(@Query("apikey") String apiKey, @Path("list_id") String listId);
}