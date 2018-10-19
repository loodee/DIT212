package com.example.ohimarc.marc.view.achievementsView;

/**
 * @author Alexander Sandberg (alexandersand on github)
 * This interface's responsibility is forcing the Activity that implements it (AchievementsActivity)
 * to implement the methods below. The methods are to be called from the Activity's Presenter
 * (AchievementsPresenter).
 */

public interface AchievementsView {
    /**
     * This method is supposed to be implemented in AchievementsActivity, to change the appearance
     * of an achievement, marking that it has been achieved. As only AchievementsPresenter knows
     * what achievement has been achieved, this method has to be called from the Presenter.
     *
     * @param index is an index to what achievement is to be unlocked.
     */
    void unlockAchievement(int index);

    /**
     * This method is supposed to be implemented in AchievementsActivity, to display a popup that
     * describes the clicked achievement. As only AchievementsPresenter knows what the description
     * of a certain achievement is, this method has to be called from the Presenter.
     *
     * @param text is a String that is the description of a certain achievement.
     */
    void showAchievementPopup(String text);

    /**
     * This method is supposed to be implemented in AchievementsActivity. The method's purpose
     * is to hide achievement-buttons that are unused. As only AchievementsPresenter knows how
     * many achievements are used, this method has to be called from the Presenter to hide
     * the correct buttons.
     *
     * @param index is an index to what achievement-button is to be hidden.
     */
    void hideAchievement(int index);
}
