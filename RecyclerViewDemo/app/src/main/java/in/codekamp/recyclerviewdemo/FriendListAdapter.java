package in.codekamp.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 19/01/17.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendDataViewHolder> {

    private List<Friend> friendList;

    public FriendListAdapter() {
        friendList = new ArrayList<>();

        friendList.add(new Friend("Bill", "Washington"));
        friendList.add(new Friend("John", "Boston"));
        friendList.add(new Friend("Jack", "New York"));
        friendList.add(new Friend("Dharam", "Mumbai"));
        friendList.add(new Friend("Sunny", "Chandigarh"));
        friendList.add(new Friend("Salman", "Mumbai"));
        friendList.add(new Friend("Arvind Kejriwal", "New Delhi"));
        friendList.add(new Friend("Modi", "New Delhi"));
        friendList.add(new Friend("Advani", "New Delhi"));
        friendList.add(new Friend("Manoj", "Ghaziabad"));
        friendList.add(new Friend("Suresh", "Meerut"));
        friendList.add(new Friend("Ramesh", "Meerut"));
        friendList.add(new Friend("Dinesh", "Agra"));
        friendList.add(new Friend("Mahesh", "Lucknow"));
        friendList.add(new Friend("Chandresh", "Mathura"));
    }



    @Override
    public FriendDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("codekamp", "onCreateViewHolder called");

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.friend_row, parent, false);

        return new FriendDataViewHolder(view);
    }


    //method to set data in row. this can be called infinite times, depending on how much
    // user is scrolling back and forth
    @Override
    public void onBindViewHolder(FriendDataViewHolder viewHolder, int position) {

        Log.d("codekamp", "onBindViewHolder called for position: " + position);

        Friend f = friendList.get(position);
        viewHolder.bindFriend(f);
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
