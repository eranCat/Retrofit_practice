package com.some.retrofitpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Repo repo = Repo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUsers();
        getPosts();
        getTodos();
    }

    private void getUsers() {
        repo.getUsers(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                for (User user : users) {
                    System.out.println(user);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
    private void getTodos() {
        repo.getTodos(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                List<Todo> todos = response.body();
                for (Todo user : todos) {
                    System.out.println(user);
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });
    }
    private void getPosts() {
        repo.getPosts(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                for (Post post : posts) {
                    System.out.println(post);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }
}
