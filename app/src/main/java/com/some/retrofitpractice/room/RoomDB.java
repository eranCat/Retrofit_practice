package com.some.retrofitpractice.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.some.retrofitpractice.models.Post;
import com.some.retrofitpractice.models.Todo;
import com.some.retrofitpractice.models.User;

@Database(entities = {User.class, Post.class, Todo.class},
        version = 1, exportSchema = false)
@TypeConverters(Converters.class)
public abstract class RoomDB extends RoomDatabase {

    private static final String DB_NAME = "JsonDB";
    private static final Object LOCK = new Object();
    private volatile static RoomDB instance;

    public static RoomDB create(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                instance = Room.databaseBuilder(
                        context, RoomDB.class, DB_NAME)
                        .build();
            }
        }

        return instance;
    }

    public abstract MyDao dao();
}