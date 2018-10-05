package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.List;

public class MemorizationTrainingTool {

    private static final MemorizationTrainingTool INSTANCE = new MemorizationTrainingTool();

    public static MemorizationTrainingTool getInstance(){
        return INSTANCE;
    }

    private List<User> users = new ArrayList<>();
    private int activeUser;

    public User getActiveUser() {
        return users.get(activeUser);
    }

    public void addNewUser(String name){
        users.add(new User(name));
    }

    public void setActiveUser(int id){
        activeUser = id;
    }

}
