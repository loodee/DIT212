package com.example.ohimarc.marc.model;

import java.util.List;

public class User {
    private String name;
    private List<Deck> decks;

    /**
     * @param name The name of the user, if null the name will be set to an empty string ("")
     * */
    public User(String name){
        this.name = name != null ? name : "";
    }

    public String getName() {
        return name;
    }
}
