package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.Achievements;
import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.achievementsView.AchievementsView;

import java.util.List;

public class AchievementsPresenter {

    private Achievements achievements;
    private AchievementsView view;
    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();


    public AchievementsPresenter(AchievementsView view) {
        this.view = view;
        onCreate();
    }

    private void onCreate() {
        achievements = mtt.getActiveUser().getAchievements();
        setAchievements();
    }

    private void setAchievements() {
        List<Achievements.achievements> achis = achievements.getEnumsAsList();
        for(int i = 0; i < achis.size() ; i++) {
            if(achievements.getCompletedAchievements().contains(achis.get(i))) {
                System.out.println(achis.get(i));
                view.unlockAchievement(i);
            }
        }
    }

    public void achievementClicked(int index) {

    }
}
