package com.codepath.instagram;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.codepath.instagram.model.Post;
import com.parse.ParseUser;

public class DetailsActivity extends AppCompatActivity {

    public ImageView ivImage;
    public TextView tvDescription;
    public TextView tvUser;
    public TextView tvTimeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivImage = findViewById(R.id.ivImagepost);
        tvDescription = findViewById(R.id.tvDescription);
        tvUser = findViewById(R.id.tvUsername);
        tvTimeStamp = findViewById(R.id.tvTimeStamp);

        Post detailedPost = getIntent().getParcelableExtra("post");
        ParseUser detailedUser = getIntent().getParcelableExtra("user");
        tvDescription.setText(detailedPost.getDescription());
        tvUser.setText(detailedUser.getUsername());
        tvTimeStamp.setText(detailedPost.getCreatedAt().toString());

        Glide.with(DetailsActivity.this)
                .load(detailedPost.getImage().getUrl())
                .into(ivImage);

    }
}
