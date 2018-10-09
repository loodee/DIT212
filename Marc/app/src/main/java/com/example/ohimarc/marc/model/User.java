package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Deck> decks = new ArrayList<>();

    /**
     * @param name The name of the user, if null the name will be set to an empty string ("")
     * */
    public User(String name){
        this.name = name != null ? name : "";
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a list of all the titles of the users decks
     * @return A list containing the titles of the users decks
     * */
    public List<String> getDeckTitles(){
        ArrayList<String> names = new ArrayList<>();

        for (Deck deck : decks) {
            names.add(deck.getTitle());
        }

        return names;
    }

    /**
     * Adds a new empty deck to the User
     * @param title The title of the deck
     * */
    public void createNewDeck(String title){
        String localTitle = title != null ? title : "";
        decks.add(new Deck(localTitle));
    }

    /**
     * Given an index of a deck returns that deck
     * @param i The index in the list of deck that the deck has
     * @return A deck matching the index give, if the index is invalid null will be returned
     * */
    public Deck getDeck(int i) {
        if(0 <= i && i < decks.size()){
            return decks.get(i);
        }
        return null;
    }
}
