package com.example.ohimarc.marc.Presenter;

import com.example.ohimarc.marc.Model.FlashCardGame;
import com.example.ohimarc.marc.View.ResultsView;

public class ResultPresenter implements Presenter {
    private final int amountCorret;
    private ResultsView view;

    public ResultPresenter(int amountCorrect,ResultsView view){
        this.view = view;
        this.amountCorret = amountCorrect;
        }

    @Override
    public void onCreate() {


    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
