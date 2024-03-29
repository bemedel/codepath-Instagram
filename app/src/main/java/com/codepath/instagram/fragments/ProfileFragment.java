package com.codepath.instagram.fragments;

import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;

import com.codepath.instagram.PostAdapter;
import com.codepath.instagram.model.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment {

    @Override
    protected void setRecyclerView() {
        whichFragment = 1;
        // Create the adapter
        adapter = new PostAdapter(getContext(), mPosts, whichFragment);
        rvPosts.setAdapter(adapter);
        // Set the layout manager on the recycler view
        rvPosts.setLayoutManager(new GridLayoutManager(getContext(), 3));
    }

    @Override
    protected void queryPosts() {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_USER);
        postQuery.setLimit(20);
        postQuery.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
        postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(imagePath, "Error with query");
                    e.printStackTrace();
                    return;
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();

                for (int i = 0; i < posts.size(); i++) {
                    Post post = posts.get(i);
                    Log.d(imagePath, "Post: " + post.getDescription() + " username: "
                            + post.getUser().getUsername());
                }
            }
        });
        ParseUser.logOut();
        ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
    }
}
