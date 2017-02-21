package in.codekamp.asynctaskdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cerebro on 19/02/17.
 */

public class MailChimpList {

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("name")
    private String title;

    @Expose
    @SerializedName("contact")
    private MailchimpContact contact;


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return contact.phoneNumber;
    }

    private class MailchimpContact {

        @Expose
        @SerializedName("phone")
        private String phoneNumber;
    }

}
