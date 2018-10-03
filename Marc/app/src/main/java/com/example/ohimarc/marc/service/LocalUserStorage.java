package com.example.ohimarc.marc.service;

import android.content.Context;

import com.example.ohimarc.marc.model.Note;
import com.example.ohimarc.marc.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

public class LocalUserStorage implements UserStorage{


    File file;

    public LocalUserStorage(File file) {
        this.file = file;
    }

    @Override
    public void storeUsers(List<User> users) {
    }

    @Override
    public List<User> getStoredUsers() {
        return null;
    }
}
