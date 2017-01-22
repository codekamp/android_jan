package in.codekamp.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cerebro on 19/01/17.
 */

public class FriendDataViewHolder extends RecyclerView.ViewHolder {

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
                Log.d("codekamp", "friend clicked " + currentFriend.name);
            }
        });
    }

    public void bindFriend(Friend friend) {
        currentFriend = friend;
        nameTextView.setText(friend.name);
        homeTownTextView.setText(friend.homeTown);
    }
}
