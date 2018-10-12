package com.example.ohimarc.marc.view.quizView;

public interface QuizView {
    void initTexts(String[] list);

    void highlightRightAnswer(int i);

    void highlightWrongAnswer(int i);

    void changeView();
}
