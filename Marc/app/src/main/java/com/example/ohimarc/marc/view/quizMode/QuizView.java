package com.example.ohimarc.marc.view.quizMode;

public interface QuizView {
    void initTexts(String q, String a1, String a2, String a3, String a4);
    void highlightRightA(int i);
    void highlightWrongA(int i);
    void changeView();
}
