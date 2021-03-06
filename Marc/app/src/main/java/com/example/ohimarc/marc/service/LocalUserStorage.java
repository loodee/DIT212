package com.example.ohimarc.marc.service;


import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.model.Note;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Gustav Albertsson
 * <p>
 * This class is responsible for storing and reading a MemorizationTrainingTool from local JSON storage
 */
class LocalUserStorage implements UserStorage {


    private final String filePath;
    private final Gson g;
    private final String fileName = "/users.json";

    /**
     * Creates an LocalUserStorage object which can store and retrieve Users from .json files
     *
     * @param filePath The path which the .json file is going to be located in
     */
    LocalUserStorage(String filePath) {
        this.filePath = filePath;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Note.class, new NoteClassAdapter());
        g = gsonBuilder.create();
    }

    /**
     * Stores the given MemorizationTrainingTool to a local JSON file
     *
     * @param mtt The MemorizationTrainingTool instance which should be saved
     */
    @Override
    public void storeState(MemorizationTrainingTool mtt) {
        try {
            String json = g.toJson(mtt);
            FileWriter fw = new FileWriter(filePath + fileName);
            fw.write(json);
            fw.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Retrieves the stored MemorizationTrainingTool instance from the local JSON file
     *
     * @return the stored MemorizationTrainingTool instance or a new instance if none are saved
     */
    @Override
    public MemorizationTrainingTool getStoredState() {
        try {
            MemorizationTrainingTool mtt = g.fromJson(new FileReader(filePath + fileName), new TypeToken<MemorizationTrainingTool>() {
            }.getType());
            if (mtt == null) {
                return new MemorizationTrainingTool();
            } else {
                return mtt;
            }
        } catch (FileNotFoundException e) {
            return new MemorizationTrainingTool();
        }
    }
}
