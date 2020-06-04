package com.some.retrofitpractice.interfaces;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.User;

import java.util.List;

public interface PostsFetchedCallback {
    void onPostsUpdated(List<Post> posts);
}
