package com.example.ohimarc.marc.presenter;

import android.support.v7.widget.RecyclerView;

import com.example.ohimarc.marc.model.User;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.mainMenu.StartMenuActivity;
import com.example.ohimarc.marc.view.mainMenu.StartMenuContract;
import com.example.ohimarc.marc.view.mainMenu.UserViewHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainMenuPresenter implements StartMenuContract.Presenter {

    List<User> users;
    UserStorage store;


    public MainMenuPresenter(String filePath) {
        store = new LocalUserStorage(filePath);
        users = store.getStoredUsers();
    }

    @Override
    public void start() {

    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(UserViewHolder rowView, int index) {
        rowView.setUsername(users.get(index).getName());
    }

    @Override
    public int getUserRowsCount() {
        return users != null ? users.size() : 0;
    }

    public void createUser(String name){
        //TODO: MTT addUser(name)
        //model.addUser();
        users.add(new User(name));
        store.storeUsers(users);
    }
}
