package com.example.ohimarc.marc.presenter;



import com.example.ohimarc.marc.view.startMenuView.StartMenuView;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.LocalUserStorage;
import com.example.ohimarc.marc.service.UserStorage;
import com.example.ohimarc.marc.view.startMenuView.StartMenuContract;
import com.example.ohimarc.marc.view.startMenuView.UserViewHolder;

import java.util.List;


public class StartMenuPresenter implements StartMenuContract.Presenter{

    private List<String> users;
    private UserStorage store;
    private StartMenuView view;

    /**
     * Creates a StartMenuPresenter which retrieve its persistent state from the given path
     * @param filePath The absolute filepath where the persistent state file is saved
     * */
    public StartMenuPresenter(StartMenuView view, String filePath) {
        store = new LocalUserStorage(filePath);
        this.view = view;

        //Set up the MemorizationTrainingTool with stored values
        MemorizationTrainingTool global = MemorizationTrainingTool.getInstance();
        MemorizationTrainingTool mtt = store.getStoredState();
        global.setActiveUser(mtt.getActiveUserId());
        global.setUsers(mtt.getUsers());

        users = global.getUserNames();
    }

    @Override
    public void onBindBasicNoteRowViewAtPosition(UserViewHolder rowView, int index) {
        rowView.setUsername(users.get(index));
    }

    @Override
    public int getUserRowsCount() {
        return users != null ? users.size() : 0;
    }

    @Override
    public void onUserClickedAtPosition(int adapterPosition) {
        MemorizationTrainingTool.getInstance().setActiveUser(adapterPosition);
        store.storeState(MemorizationTrainingTool.getInstance());
        view.login();
    }

    @Override
    public void onUserLongClickedAtPosition(int adapterPosition) {
        view.promptForDeletion(adapterPosition, users.get(adapterPosition));
    }

    /**
     * @return Returns true if a user is currently logged in, otherwise returns false
     * */
    public boolean loggedIn() {
        return MemorizationTrainingTool.getInstance().getActiveUser() != null;
    }

    /**
     * Given a name of a user creates a new user and saves it persistently
     * @param name The name of the user that is going to be added
     * */
    public void createUser(String name){
        MemorizationTrainingTool.getInstance().addNewUser(name);
        store.storeState(MemorizationTrainingTool.getInstance());
        users = MemorizationTrainingTool.getInstance().getUserNames();
    }

    /**
     * Method used to confirm the deletion of a user with a specific index, when this method is called with a valid
     * index the user will be removed, if the index is invalid no changes will be made
     * @param index The index with the user has in the list of users
     * */
    public void confirmDeletion(int index) {
        MemorizationTrainingTool.getInstance().removeUser(index);
        store.storeState(MemorizationTrainingTool.getInstance());
        users = MemorizationTrainingTool.getInstance().getUserNames();
    }
}
