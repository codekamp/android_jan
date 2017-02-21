package in.codekamp.asynctaskdemo;

import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 04/02/17.
 */

public class FetchLists extends AsyncTask<Integer, Void, List<MailChimpList>> {

    private FetchListListner listner;

    public void setListner(FetchListListner listner) {
        this.listner = listner;
    }

    @Override
    protected List<MailChimpList> doInBackground(Integer... params) {
        int count = params[0];
        int offset = params[1];

        String urlString = "https://us11.api.mailchimp.com/3.0/lists?apikey=YOUR_API_KEY";
        urlString = urlString + "&count=" + count + "&offset=" + offset;

        List<MailChimpList> listTitles = new ArrayList<>();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = reader.readLine();
            String response = "";
            while(line != null){
                response += line;
                line = reader.readLine();
            }

            JSONObject object = new JSONObject(response);

            int itemCount = object.getInt("total_items");
            Log.d("codekamp", "total item count is " + itemCount);
            JSONArray lists = object.getJSONArray("lists");

            for (int i = 0; i < lists.length(); i++) {
                JSONObject listData = (JSONObject) lists.get(i);
                MailChimpList mailChimpList = new MailChimpList();
                listTitles.add(mailChimpList);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("codekamp",  listTitles.toString());

        return listTitles;
    }

    @Override
    protected void onPostExecute(List<MailChimpList> mailChimpLists) {

    }

    public interface FetchListListner {
        public void listsFetchedSuccessfully(List<MailChimpList> lists);
        public void listsFetchedFailed(String errorMessage);
    }
}
