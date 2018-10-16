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


    public AchievementsPresenter(AchievementsView view) {
        this.view = view;
        onCreate();
    }

    private void onCreate() {
        achievements = mtt.getActiveUser().getAchievements();
        achiList = achievements.getEnumsAsList();
        setAchievements();
    }

    private void setAchievements() {
        for(int i = 0; i < achiList.size() ; i++) {
            if(achievements.getCompletedAchievements().contains(achiList.get(i))) {
                System.out.println(achiList.get(i));
                view.unlockAchievement(i);
            }
        }
    }

    public void achievementClicked(int index) {

    private String parseString(String s) {
        String noUnderScore = s.replaceAll("_", " ");
        String lowerCase = noUnderScore.toLowerCase();
        String capitalized = lowerCase.substring(0, 1).toUpperCase() + lowerCase.substring(1);
        String finalString = capitalized + ".";
        return finalString;
    }
}
