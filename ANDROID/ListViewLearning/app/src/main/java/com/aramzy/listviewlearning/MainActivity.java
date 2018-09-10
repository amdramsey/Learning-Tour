package com.aramzy.listviewlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.aramzy.listviewlearning.adapter.communityListAdapter;
import com.aramzy.listviewlearning.model.Community;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText txtFriendName;
    private ListView typesListView;
    private communityListAdapter adapter;
    private ArrayList<Community> list = new ArrayList<Community>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFriendName = (EditText) findViewById(R.id.txtFriendName);
        typesListView = (ListView)findViewById(R.id.typesListView);

        typesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                openDetails(list.get(position));

            }
        });

         Community community1 = new Community(getString(R.string.make), getString(R.string.make_description), R.mipmap.make);
         Community community2 = new Community(getString(R.string.feed), getString(R.string.eat_description), R.mipmap.eat);
         Community community3 = new Community(getString(R.string.cook), getString(R.string.cook_description), R.mipmap.cook);
         Community community4 = new Community(getString(R.string.plant), getString(R.string.grow_description), R.mipmap.grow);
         Community community5 = new Community(getString(R.string.shopping), getString(R.string.shop_description), R.mipmap.shop);
         list.add(community1);
         list.add(community2);
         list.add(community3);
         list.add(community4);
         list.add(community5);

         adapter = new communityListAdapter(list, this);

         typesListView.setAdapter(adapter);

    }

    private void openDetails(Community community) {

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(getString(R.string.friend_name), txtFriendName.getText().toString());
        intent.putExtra(getString(R.string.community_key), community);
        startActivity(intent);

    }

}