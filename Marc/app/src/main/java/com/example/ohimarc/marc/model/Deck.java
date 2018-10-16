package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class is responsible for managing its Notes, as well as retrieving information about
 * the cards contained within its Notes.
 *
 * @author Thomas Li
 * @author Gustav Albertsson
 */
public class Deck {
    private final List<Note> notes;
    private final String title;

    /**
     * Creates a new Deck with a provided title.
     *
     * @param title Defaults to a preset default if null is provided as a title.
     */
    public Deck(String title) {
        this.notes = new ArrayList<>();
        this.title = title != null ? title : "Default title";
    }

    /**
     * Creates a BasicNote and generates its Card(s), then adds the note to the Deck.
     *
     * @param front The text that will go in the `front` field of the note.
     * @param back  The text that will go in the `back` field of the note.
     */
    public void addBasicNote(String front, String back) {
        notes.add(new BasicNote(front, back));
    }

    /**
     * Creates the BasicNote at index with a new Note and generates its Card(s).
     *
     * @param front The text that will go in the `front` field of the Note.
     * @param back  The text that will go in the `back` field of the Note.
     * @param index The index at which to replace the Note.
     */
    public void addBasicNote(String front, String back, int index) {
        notes.set(index, new BasicNote(front, back));
    }

    /**
     * Deletes the Note at index
     *
     * @param index The index at which to delete the Note.
     */
    public void deleteNote(int index) {
        notes.remove(index);
    }

    /**
     * Given the index of a Card in a list of Cards compiled from a Deck's Notes,
     * returns the corresponding Note's index in the Deck.
     *
     * @param index The Card's index in the list of Cards generated from the Notes of a Deck.
     * @return The index of the Card's parent Note, in its Deck.
     */
    public int getNoteIndexFromCardIndex(int index) {
        int counter = -1;
        if(index >= 0 && index < notes.size()) {
            for (int i = 0; i < notes.size(); i++) {
                counter += notes.get(index).getSize();
                if (counter >= index) return i;
            }
        }
        return -1; // should not happen
    }

    /**
     * Iterates through all the notes in the deck and returns an array of tuples of strings,
     * where each tuple contains the front and back of the Cards.
     *
     * @return Array of tuples of strings, where index 0 contains the info on the front,
     * and index 1 contains the information on the back
     */
    public String[][] getCardCopies() {
        ArrayList<String[]> copies = new ArrayList<>();
        for (Note n : notes) {
            Collections.addAll(copies, n.getCardInfo());
        }
        return copies.toArray(new String[0][]);
    }

    public Note getNote(int index) {
        return notes.size() > index ? notes.get(index) : null;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public String getTitle() {
        return title;
    }

    public int getDeckSize() {
        int size = 0;
        for (Note n : notes) size += n.getSize();
        return size;
    }
}
