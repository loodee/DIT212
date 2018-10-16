package com.example.ohimarc.marc.model;

public class ClozeNote extends Note {
    private String text;

    public ClozeNote(String text) {
        this.text = text != null ? text : "";
        generateCards();
    }

    @Override
    void generateCards() {

    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
