package com.some.retrofitpractice;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;
import com.some.retrofitpractice.room.MyDao;
import com.some.retrofitpractice.room.RoomDB;

import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repo {
    private static final Repo ourInstance = new Repo();
    private final JsonApi jsonApi;
    private RoomDB database;
    private MyDao dao;

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

    public LiveData<List<User>> getUsers() {

        LiveData<List<User>> liveData = dao.getUsers();
        List<User> users = liveData.getValue();
        if (users == null || users.isEmpty()) {
            fetchUsers();
        }
        return liveData;
    }

    private void fetchUsers() {
        jsonApi.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                Executors.newCachedThreadPool().submit(() -> dao.addAllUsers(users));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }

    public LiveData<List<Post>> getPosts() {
        LiveData<List<Post>> liveData = dao.getPosts();
        List<Post> posts = liveData.getValue();

        if (posts == null || posts.isEmpty()) {
            fetchPosts();
        }

        return liveData;
    }

    private void fetchPosts() {
        jsonApi.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                Executors.newCachedThreadPool().submit(() -> dao.addAllPosts(posts));
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

    public LiveData<List<Todo>> getTodos() {
        LiveData<List<Todo>> liveData = dao.getTodos();
        List<Todo> todos = liveData.getValue();
        if (todos == null || todos.isEmpty()) {
            fetchTodos();
        }
        return liveData;
    }

    private void fetchTodos() {
        jsonApi.getTodos().enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todos = response.body();
                Executors.newCachedThreadPool().submit(()-> dao.addAllTodos(todos));
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }

    public void init(Context context) {
        database = RoomDB.create(context);
        dao = database.dao();
    }
}
