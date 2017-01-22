package in.codekamp.recyclerviewrepeat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cerebro on 21/01/17.
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendsViewHolder> {

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.friends_row, parent, false);

        return new FriendsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsViewHolder holder, int position) {
        holder.nameTextView.setText("Friend " + position);
        holder.hometownTextView.setText("Hometown " + position);

        notifyDataSetChanged();

        notifyItemRemoved();
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
