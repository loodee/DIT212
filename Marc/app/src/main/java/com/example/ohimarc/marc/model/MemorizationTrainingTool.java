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

    private List<User> users = new ArrayList<>();
    private Integer activeUser = null;

    /**
     * Returns the User object of the current active user
     * @return returns the User object of the active user, if no user is active null will be returned
     * */
    public User getActiveUser() {
        if(activeUser != null){
            return users.get(activeUser);
        }
        return null;
    }

    /**
     * @return Returns the id of the currently active User. If no user is active null will be returned.
     * */
    public Integer getActiveUserId(){
        return activeUser;
    }

    /**
     * Adds a new empty user with a name
     * @param name The name of the user
     * */
    public void addNewUser(String name){
        users.add(new User(name));
    }

    /**
     *Sets the id of the active user
     * @param id The id of the active user
     * */
    public void setActiveUser(Integer id){
        activeUser = id;
    }

    /**
     * Returns all the saved users
     * */
    public List<String> getUserNames(){
        List<String> usersNames = new ArrayList<>();

        for (User user : users) {
            usersNames.add(user.getName());
        }

        return usersNames;
    }


    /**
     *Removes a user with a given id, if the user is also the active user this will be set to null
     * */
    public void removeUser(int id){
        if(activeUser != null && activeUser == id){
            activeUser = null;
        }
        if(0 <= id && id < users.size()){
            users.remove(id);
        }
    }

    /**
     * Replaces the old users with new users
     * @param users The list of new users
     * */
    public void setUsers(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
    }

    /**
     * Returns a copy of the User list
     * */
    public List<User> getUsers(){
        return new ArrayList<>(users);
    }
}
