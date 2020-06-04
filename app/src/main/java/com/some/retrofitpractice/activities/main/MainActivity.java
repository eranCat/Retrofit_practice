package com.some.retrofitpractice.activities.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.some.retrofitpractice.R;
import com.some.retrofitpractice.interfaces.PostsFetchedCallback;
import com.some.retrofitpractice.interfaces.TodosFetchedCallback;
import com.some.retrofitpractice.interfaces.UsersFetchedCallback;
import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        UsersFetchedCallback,
        PostsFetchedCallback,
        TodosFetchedCallback {

    @BindView(R.id.getUserBtn)
    Button usersBtn;
    @BindView(R.id.getPostsBtn)
    Button postsBtn;
    @BindView(R.id.getTodosBtn)
    Button todosBtn;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        viewModel = MainViewModel.get();

        usersBtn.setOnClickListener(v -> {
            viewModel.getUsers()
                    .observe(this,this::onUsersUpdated);
        });
        postsBtn.setOnClickListener(v -> {
            viewModel.getPosts()
                    .observe(this,this::onPostsUpdated);
        });
        todosBtn.setOnClickListener(v -> {
            viewModel.getTodos()
                    .observe(this,this::onTodosUpdated);
        });
    }

    @Override
    public void onUsersUpdated(List<User> users) {
        Toast.makeText(this, "updated "+users.size()+" users", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostsUpdated(List<Post> posts) {
        Toast.makeText(this, "Updated "+posts.size()+" posts", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTodosUpdated(List<Todo> todos) {
        Toast.makeText(this, "updated "+todos.size()+" todos", Toast.LENGTH_SHORT).show();
    }
}
