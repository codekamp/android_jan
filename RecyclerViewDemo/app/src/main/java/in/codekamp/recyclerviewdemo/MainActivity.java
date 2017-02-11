package in.codekamp.recyclerviewdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(new FriendListAdapter());


        FriendListFragment f1 = new FriendListFragment();
        FriendListFragment f2 = new FriendListFragment();
        FriendListFragment.FriendListAdapter a =  f1.new FriendListAdapter();
        FriendListFragment.FriendListAdapter b =  f1.new FriendListAdapter();
        FriendListFragment.FriendListAdapter c =  f2.new FriendListAdapter();


        a.getItemCount(); // this will be a. FriendListFragment.this will be f1
        b.getItemCount(); // this will be b. FriendListFragment.this will be f1
        c.getItemCount(); // this will be c. FriendListFragment.this will be f2



    }
}
