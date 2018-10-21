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

    /**
     * The constructor for the presenter
     *
     * @param view          what view that has created this presenter
     * @param amountCorrect A list with only two elements, the first the amount of correct answers, the second the total amount of questions
     * @param deckIndex     a index which tells what deck in list of decks that has been played
     * @param mode          A name so presenter can know what game mode that just have been played
     * @param filePath      a filepath which tells where data should be stored on the device that is running the app
     */
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
