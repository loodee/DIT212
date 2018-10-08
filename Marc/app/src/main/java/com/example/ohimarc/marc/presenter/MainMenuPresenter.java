package com.example.ohimarc.marc.presenter;


import com.example.ohimarc.marc.view.mainMenu.StartMenuView;
import com.example.ohimarc.marc.model.User;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.mainMenu.StartMenuContract;
import com.example.ohimarc.marc.view.mainMenu.UserViewHolder;

import java.util.List;

public class MainMenuPresenter implements StartMenuContract.Presenter {

    private List<User> users;
    private UserStorage store;
    private StartMenuView view;


    /**
     * Creates a MainMenuPresenter which retrieve its persistent state from the given path
     * @param filePath The absolute filepath where the persistent state file is saved
     * */
    public MainMenuPresenter(StartMenuView view, String filePath) {
        store = new LocalUserStorage(filePath);
        this.view = view;
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

    @Override
    public void onUserClickedAtPosition(int adapterPosition) {
        MemorizationTrainingTool.getInstance().setActiveUser(adapterPosition);
        view.login();
    }
    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
    }
    /**
     * Given a name of a user creates a new user and saves it persistently
     * @param name The name of the user that is going to be added
     * @return returns true if the user is successfully created, otherwise returns false
     * */
    public boolean createUser(String name){
        //TODO: MTT addUser(name)
        //model.addUser();
        users.add(new User(name));
        Boolean sucess = store.storeUsers(users);
        return sucess;
    }
}
