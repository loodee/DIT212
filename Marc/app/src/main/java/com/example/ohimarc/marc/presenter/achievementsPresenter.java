package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Achievements;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.achievementsView.AchievementsView;

import java.util.List;

public class AchievementsPresenter {

    private Achievements achievements;
    private AchievementsView view;
    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();
    private List<Achievements.achievements> achiList;
    private int achievementElements;


    public AchievementsPresenter(AchievementsView view, int achievementElements) {
        this.view = view;
        this.achievementElements = achievementElements;
        onCreate();
    }

    private void onCreate() {
        achievements = mtt.getActiveUser().getAchievements();
        achiList = achievements.getEnumsAsList();
        setAchievements();
        hideInactiveAchievements();
    }

    private void setAchievements() {
        for(int i = 0; i < achiList.size() ; i++) {
            if(achievements.getCompletedAchievements().contains(achiList.get(i))) {
                view.unlockAchievement(i);
            }
        }
    }

    private void hideInactiveAchievements() {
        for(int i = achiList.size() ; i < achievementElements ; i++) {
            view.hideAchievement(i);
        }
    }

    public void achievementClicked(int index) {
        if(index < achiList.size()) {
            String s = achiList.get(index).toString();
            view.showAchievementPopup(parseString(s));
        }
    }

    private String parseString(String s) {
        String noUnderScore = s.replaceAll("_", " ");
        String lowerCase = noUnderScore.toLowerCase();
        String capitalized = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
        String finalString = capitalized + ".";
        return finalString;
    }
}
