package com.example.ohimarc.marc.View;

public interface FlashcardView {
    void flipCardButton(String qora, String text);
    void correctButton();
    void incorrectButton();
    void initTexts(String deckTitleText, String cardText);
}
