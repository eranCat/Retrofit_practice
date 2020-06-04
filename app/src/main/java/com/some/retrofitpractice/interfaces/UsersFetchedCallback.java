package com.some.retrofitpractice.interfaces;

import com.some.retrofitpractice.models.User;

import java.util.List;

public interface UsersFetchedCallback {
    void onUsersUpdated(List<User> users);
}
