package com.codepath.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.instagram.model.Post;
import com.parse.ParseFile;

import java.util.List;


    public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

        private Context context;
        private List<Post> posts;

        public PostAdapter(Context context, List<Post> posts) {
            this.context = context;
            this.posts = posts;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Post post = posts.get(position);
            holder.bind(post);
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
                tvHandle.setText(post.getUser().getUsername());
                ParseFile image = post.getImage();
                if (image != null) {
                    Glide.with(context).load(image.getUrl()).into(ivImage);
                }
                tvDescription.setText(post.getDescription());
            }
        }
    }

