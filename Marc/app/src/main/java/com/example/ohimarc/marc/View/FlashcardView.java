package com.example.ohimarc.marc.View;

public interface FlashcardView {
    void flipCardButton(String qora, String text);
    void initTexts(String deckTitleText, String cardText);
    void changeView();
}
