package com.some.retrofitpractice.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllUsers(List<User> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllPosts(List<Post> posts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllTodos(List<Todo> todos);


    @Query("SELECT * FROM users")
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM todos")
    LiveData<List<Todo>> getTodos();

    @Query("SELECT * FROM posts")
    LiveData<List<Post>> getPosts();
}
