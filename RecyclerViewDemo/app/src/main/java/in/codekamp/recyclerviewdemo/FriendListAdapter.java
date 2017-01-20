package in.codekamp.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cerebro on 19/01/17.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendDataViewHolder> {

    //method to create new rows. Will be called only 8 times.
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
    public void onBindViewHolder(FriendDataViewHolder holder, int position) {
        Log.d("codekamp", "onBindViewHolder called for position " + position);
    }

    @Override
    public int getItemCount() {
        return 5000;
    }
}
