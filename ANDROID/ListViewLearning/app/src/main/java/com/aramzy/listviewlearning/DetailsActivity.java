package com.aramzy.listviewlearning;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.aramzy.listviewlearning.model.Community;

public class DetailsActivity extends AppCompatActivity {

    private String friendName;

    private ImageView typeImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private Button shareButton;
    private Community community;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        friendName = getIntent().getStringExtra(getString(R.string.friend_name));
        community = (Community)getIntent().getSerializableExtra(getString(R.string.community_key));

        typeImageView = (ImageView) findViewById(R.id.typeImageView);

        typeImageView.setImageResource(community.getImg());

        titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText(community.getTitle());

        descriptionTextView = (TextView) findViewById(R.id.descTextView);
        descriptionTextView.setText(community.getDescription());

        shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setText(String.format("%s %s", getString(R.string.share_with), friendName));

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");

                String msg = String.format("%s: %s", friendName, community.getDescription());
                shareIntent.putExtra(Intent.EXTRA_TEXT, msg);

                startActivity(Intent.createChooser(shareIntent, getString(R.string.app_name)));
            }
        });
    }

    private int getTypeDrawable(String type) {
        if (type.equals(getString(R.string.make))) {
            return R.mipmap.make;

        } else if (type.equals(getString(R.string.cook))) {
            return R.mipmap.cook;

        } else if (type.equals(getString(R.string.feed))) {
            return R.mipmap.eat;

        } else if (type.equals(getString(R.string.plant))) {
            return R.mipmap.grow;

        } else {
            return R.mipmap.shop;

        }

    }

    private String getDescription(String type) {
        if (type.equals(getString(R.string.make))) {
            return getString(R.string.make_description);

        } else if (type.equals(getString(R.string.cook))) {
            return getString(R.string.cook_description);

        } else if (type.equals(getString(R.string.feed))) {
            return getString(R.string.eat_description);

        } else if (type.equals(getString(R.string.plant))) {
            return getString(R.string.grow_description);

        } else {
            return getString(R.string.shop_description);

        }
    }

}
