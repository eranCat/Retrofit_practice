package com.some.retrofitpractice.interfaces;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;

import java.util.List;

public interface TodosFetchedCallback {
    void onTodosUpdated(List<Todo> todos);
}
