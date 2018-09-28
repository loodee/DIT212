package com.example.ohimarc.marc.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing groups of Card objects and functions for retrieving information from the cards.
 */
public class Deck {
    private List<Note> notes;
    private String title;

    /**
     * Creates a new Deck with a provided title.
     * @param title Defaults to a preset default if null is provided as a title.
     */
    public Deck(String title) {
        this.notes = new ArrayList<>();
        this.title = title != null ? title : "Default title";
    }

    /**
     * Creates a BasicNote and generates its Card(s), then adds the note to the Deck.
     * @param front The text that will go in the `front` field of the note.
     * @param back The text that will go in the `back` field of the note.
     */
    public void addBasicNote(String front, String back) {
        notes.add(new BasicNote(front, back));
    }

    /**
     * Iterates through all the notes in the deck and returns an array of tuples of strings,
     * where each tuple contains the front and back of the Cards.
     * @return Array of tuples of strings, where index 0 contains the info on the front,
     * and index 1 contains the information on the back
     */
    public String[][] getCardCopies() {
        ArrayList<String[]> copies = new ArrayList<>();
        for (Note n : notes) {
            for (String[] cardInfo : n.getCardInfo()) {
                copies.add(cardInfo);
            }
        }
        return copies.toArray(new String[0][]);
    }

    public String getTitle() {
        return title;
    }

    public int getDeckSize() {
        int size = 0;
        for (Note n : notes) {
            size += n.getSize();
        }
        return size;
    }
}
