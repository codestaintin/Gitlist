package com.example.isioyemohammed.gitlist.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.isioyemohammed.gitlist.R;
import com.squareup.picasso.Picasso;

/**
 * Created by isioyemohammed on 07/03/2018.
 */

public class DetailActivity extends AppCompatActivity {
    /**
     * TextView - username parameter.
     */
    TextView username;
    /**
     * TextView - company parameter.
     */
    TextView company;
    /**
     * TextView - gitUrl parameter.
     */
    TextView gitUrl;
    /**
     * ImageView - image parameter.
     */
    ImageView image;

    /**
     * Bundle instance for saving current state.
     * @param savedInstanceState - savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        username = findViewById(R.id.username);
        company = findViewById(R.id.company);
        gitUrl = findViewById(R.id.gitUrl);
        image = findViewById(R.id.profileImage);
        FloatingActionButton shareButton = findViewById(R.id.floatingActionButton);

        Intent intent = this.getIntent();

        final String profileLink = "https://github.com/" + intent.getStringExtra("USERNAME");
        final String message = "View the profile of this super android apps developer "
                + profileLink;

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent  = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(shareIntent);
            }
        });

        String name = intent.getStringExtra("USERNAME");
        String organisation = intent.getStringExtra("COMPANY");
        String url = intent.getStringExtra("GITURL");

        Picasso.get()
                .load(intent.getExtras().getString("IMAGE"))
                .placeholder(R.drawable.image_placeholder)
                .into(image);

        username.setText(name);
        company.setText(organisation);
        gitUrl.setText(url);

    }
}
