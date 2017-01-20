package in.codekamp.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cerebro on 19/01/17.
 */

public class FriendDataViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView homeTownTextView;

    public FriendDataViewHolder(View itemView) {
        super(itemView);

        nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
        nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
    }
}
