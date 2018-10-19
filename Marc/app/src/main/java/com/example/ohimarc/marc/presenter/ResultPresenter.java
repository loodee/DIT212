package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.service.UserStorageFactory;
import com.example.ohimarc.marc.view.resultsView.ResultsView;

import java.util.ArrayList;

/**
 * @author Victor Johansson (Vroxie on github)
 */

/**
 * This class is the presenter for the resultscreen, i.e when a game is finished a result is being presented
 */
public class ResultPresenter {
    private final ArrayList<Integer> amountCorrect;
    private final ResultsView view;
    private final String deckTitle;

    public ResultPresenter(ResultsView view, ArrayList<Integer> amountCorrect, int deckIndex, String mode, String filePath) {
        this.view = view;
        this.amountCorrect = amountCorrect;
        MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
        deckTitle = mtt.getActiveUser().getDeck(deckIndex).getTitle();
        mtt.getActiveUser().addNewStatistics(deckIndex, mode, amountCorrect.get(0));
        UserStorageFactory.createLocalUserStorage(filePath).storeState(mtt);
    }

    /**
     * @return the deck that has being played title
     */
    public String getDeckTitle() {
        return deckTitle;
    }

    /**
     * Tells the view the result
     * Where the first element in amountCorrect is amount of correct answers
     * And the second element is total amount of questions
     */
    public void onCreate() {
        view.initTexts(amountCorrect.get(0), amountCorrect.get(1));
    }

}
