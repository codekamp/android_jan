package in.codekamp.asynctaskdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cerebro on 21/02/17.
 */

public class MailChimpListResponse {

    @Expose
    @SerializedName("total_items")
    public int totalItems;

    @Expose
    @SerializedName("lists")
    public List<MailChimpList> lists;
}
