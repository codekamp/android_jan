package in.codekamp.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 09/02/17.
 */

public class FriendListFragment extends Fragment {

    List<Friend> friendList;

    private Listner l;

    public FriendListFragment() {

    }

    public int someVar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //code to load data.

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.friend_list_rv);

        rv.setVisibility(View.GONE);

        FriendListAdapter a = new FriendListAdapter();
        rv.setAdapter(a);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Listner) {
            l = (Listner) context;
        } else {
            throw new RuntimeException("Please implement Listner interface");
        }
    }

    public static interface Listner {
        public void onFriendClicked(Friend f);
    }

    public static class FriendListAdapter extends RecyclerView.Adapter<FriendDataViewHolder> {

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


            return FriendListFragment.this.friendList.size();
        }
    }

    private class FriendDataViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView homeTownTextView;
        private Friend currentFriend;

        public FriendDataViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            homeTownTextView = (TextView) itemView.findViewById(R.id.hometown_text_view);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    FriendListFragment.this.l.onFriendClicked(currentFriend);
                }
            });
        }

        public void bindFriend(Friend friend) {
            currentFriend = friend;
            nameTextView.setText(friend.name);
            homeTownTextView.setText(friend.homeTown);
        }
    }
}
