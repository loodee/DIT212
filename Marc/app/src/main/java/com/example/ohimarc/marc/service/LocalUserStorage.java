package com.example.ohimarc.marc.service;


import com.example.ohimarc.marc.model.Note;
import com.example.ohimarc.marc.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalUserStorage implements UserStorage{


    private String filePath;
    private Gson g;
    private String fileName = "/users.json";

    /**
     * Creates an LocalUserStorage object which can store and retrieve Users from .json files
     * @param filePath The path which the .json file is going to be located in
     * */
    public LocalUserStorage(String filePath) {
        this.filePath = filePath;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Note.class, new NoteClassAdapter());
        g = gsonBuilder.create();
    }



    @Override
    public boolean storeUsers(List<User> users) {
        try {
            String json = g.toJson(users);
            FileWriter fw = new FileWriter(filePath+fileName);
            fw.write(json);
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<User> getStoredUsers() {
        try {
            List<User> users = g.fromJson(new FileReader(filePath+fileName), new TypeToken<ArrayList<User>>(){}.getType());
            if(users == null){
                return new ArrayList<>();
            }
            return users;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
