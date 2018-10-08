package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.List;

public class MemorizationTrainingTool {

    private static final MemorizationTrainingTool INSTANCE = new MemorizationTrainingTool();

    /**
     * Returns a singelton instance of MemorizationTrainingTool
     * @return a singelton instance
     * */
    public static MemorizationTrainingTool getInstance(){
        return INSTANCE;
    }

    public List<User> users = new ArrayList<>();
    private int activeUser;

    public User getActiveUser() {
        return users.get(activeUser);
    }

    public int getActiveUserId(){
        return activeUser;
    }

    public void addNewUser(String name){
        users.add(new User(name));
    }

    public void setActiveUser(int id){
        activeUser = id;
    }

    public List<User> getUsers(){
        return users;
    }


}
