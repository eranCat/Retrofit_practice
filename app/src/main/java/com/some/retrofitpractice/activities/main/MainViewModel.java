package com.some.retrofitpractice.activities.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.some.retrofitpractice.Repo;
import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

public class MainViewModel extends ViewModel {

    private Repo repo = Repo.getInstance();

    public static MainViewModel get() {
        return new ViewModelProvider
                .NewInstanceFactory()
                .create(MainViewModel.class);
    }

    public LiveData<List<User>> getUsers() {
        return repo.getUsers();
    }

    public LiveData<List<Todo>> getTodos() {
        return repo.getTodos();
    }

    public LiveData<List<Post>> getPosts() {
        return repo.getPosts();
    }
}
