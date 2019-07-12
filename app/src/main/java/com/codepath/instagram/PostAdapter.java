package com.codepath.instagram;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.instagram.model.Post;
import com.parse.ParseFile;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;
    public int whichFragment;

    public PostAdapter(Context context, List<Post> posts, int whichFragment) { //add an int whichFragment
        this.context = context;
        this.posts = posts;
        this.whichFragment = whichFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Post post = posts.get(position);
        holder.bind(post);
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Post selectedPost = post;
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("post", selectedPost);
                intent.putExtra("user", selectedPost.getUser());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHandle;
        private TextView tvDescription;
        private ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvHandle = itemView.findViewById(R.id.tvHandle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);
        }

        public void bind(Post post) {
            // bind the view elements to the post
            //String userName= post.getUser().getUsername().toString();
            ParseFile image = post.getImage();
            if (whichFragment == 0) {
                tvHandle.setText(post.getUser().getUsername());
                if (image != null) {
                    Glide.with(context).load(image.getUrl()).into(ivImage);
                }
                tvDescription.setText(post.getDescription());

            } else if (whichFragment == 1) {
                tvHandle.setVisibility(View.GONE);
                tvDescription.setVisibility(View.GONE);

                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int pxWidth = displayMetrics.widthPixels;

                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                        pxWidth / 3, pxWidth / 3);
                if (image != null) {
                    Glide.with(context).load(image.getUrl()).into(ivImage);
                }
            }
        }
    }

}


