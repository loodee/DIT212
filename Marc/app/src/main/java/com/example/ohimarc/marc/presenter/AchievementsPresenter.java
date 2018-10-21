package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Achievements;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.achievementsView.AchievementsView;

import java.util.List;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * The purpose of this Presenter is to handle any interaction with the model, for the Activity.
 * Whenever data needs to be extracted or edited in the model by AchievementsActivity, it is
 * supposed to be handled by this Presenter.
 */

public class AchievementsPresenter {

    private Achievements achievements;
    private final AchievementsView view;
    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private List<Achievements.achievements> achievementList;
    private final int achievementElements;

    /**
     * This is the constructor of AchievementsPresenter.
     *
     * @param view                is the interface AchievementsView, which is implemented by AchievementsActivity.
     *                            This instance is used to call methods in AchievementsActivity.
     * @param achievementElements is the number of achievements Buttons in AchievementsActivity,
     *                            given by AchievementsActivity.
     */
    public AchievementsPresenter(AchievementsView view, int achievementElements) {
        this.view = view;
        this.achievementElements = achievementElements;
        onCreate();
    }

    /**
     * This method initializes a few variables. It also initializes the view to display the
     * achievements correctly.
     */

    private void onCreate() {
        achievements = mtt.getActiveUser().getAchievements();
        achievementList = achievements.getEnumsAsList();
        setAchievementsTrophy();
        setAchievementsInvisible();
    }

    /**
     * This method makes all unlocked achievements display a trophy, instead of a lock, marking the
     * achievements that have been achieved.
     */

    private void setAchievementsTrophy() {
        for (int i = 0; i < achievementList.size(); i++) {
            if (achievements.getCompletedAchievements().contains(achievementList.get(i))) {
                view.unlockAchievement(i);
            }
        }
    }

    /**
     * This method sets all unused achievements to be hidden from the user.
     */

    private void setAchievementsInvisible() {
        for (int i = achievementList.size(); i < achievementElements; i++) {
            view.hideAchievement(i);
        }
    }

    /**
     * This method handles the click of an achievement. A popup will be displayed by
     * AchievementsActivity, which needs an informative text for the specific achievement. Thereby,
     * this method checks if the achievement is active, creates a string out of the achievement enum,
     * calls for a parsing of this string and sending it to the view.
     *
     * @param index
     */
    public void achievementClicked(int index) {
        if (index < achievementList.size()) {
            String s = achievementList.get(index).toString();
            view.showAchievementPopup(parseString(s));
        }
    }

    /**
     * This method parses a given String. Here, a enum is expected of a certain form, i.e a text
     * made out of all uppercase letters while containing underscores instead of spaces.
     * Thereby, the parser removes all underscores with spaces, makes the whole text into lowercase,
     * making the first letter of the string into uppercase and adds a dot in the end.
     *
     * @param s is the String to be parsed.
     * @return a parsed version of the parameter s.
     */
    private String parseString(String s) {
        String noUnderScore = s.replaceAll("_", " ");
        String lowerCase = noUnderScore.toLowerCase();
        String capitalized = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
        return capitalized + ".";
    }
}
