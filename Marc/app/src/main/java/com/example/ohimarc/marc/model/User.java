package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gustav Albertsson
 *
 * This Class is responsible for holding the information about a user, sush as the users Decks, The users statistics and their name
 * */
public class User {
    private final String name;
    private final List<Deck> decks = new ArrayList<>();
    private final Stats stats = new Stats();

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
        stats.addNewDeck();
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

    /**
     * Given an index of a deck deletes a deck.
     * @param i The index of the deck you wish to delete
     */
    public void deleteDeck(int i){
        if(0 <= i && i < decks.size()){
            decks.remove(i);
            stats.removeDeck(i);
        }
    }

    /**
     * Returns a list of Stat objects which contains the statistics for the deck
     * @param index The index of the deck
     * */
    public Stat[] getStatsForDeck(int index){
        return stats.getStatsForDeck(index);
    }

    /**
     * Adds/updates the statistics for a deck/game mode combination
     * @param index The index of the deck that the statistics is for
     * @param gameMode The game mode that the statistics is for
     * @param score The score that the user scored
     * */
    public void addNewStatistics(int index, String gameMode, int score) {
        stats.addStatistics(index ,gameMode, score);
    }
}
