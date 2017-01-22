package in.codekamp.recyclerviewrepeat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cerebro on 21/01/17.
 */

public class FriendsViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView;
    public TextView hometownTextView;

    public FriendsViewHolder(View itemView) {
        super(itemView);

        nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        hometownTextView = (TextView) itemView.findViewById(R.id.hometown_text_view);
    }
}
