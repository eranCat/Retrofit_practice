package com.some.retrofitpractice;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("todos")
    Call<List<Todo>> getTodos();
}
