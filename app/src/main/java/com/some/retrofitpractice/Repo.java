package com.some.retrofitpractice;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repo {
    private static final Repo ourInstance = new Repo();
    private final JsonApi jsonApi;

    private Repo() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

        jsonApi = retrofit.create(JsonApi.class);
    }

    public static Repo getInstance() {
        return ourInstance;
    }

    void getUsers(Callback<List<User>> callback) {
        jsonApi.getUsers().enqueue(callback);
    }

    void getPosts(Callback<List<Post>> callback) {
        jsonApi.getPosts().enqueue(callback);
    }

    void getTodos(Callback<List<Todo>> callback) {
        jsonApi.getTodos().enqueue(callback);
    }
}
