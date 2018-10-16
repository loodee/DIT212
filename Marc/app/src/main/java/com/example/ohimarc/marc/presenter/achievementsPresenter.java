package com.example.ohimarc.marc.presenter;

import com.example.ohimarc.marc.model.MemorizationTrainingTool;
import com.example.ohimarc.marc.view.achievementsView.AchievementsView;

public class AchievementsPresenter {

    private AchievementsView view;
    private final MemorizationTrainingTool mtt = MemorizationTrainingTool.getInstance();


    public AchievementsPresenter(AchievementsView view) {
        this.view = view;
        onCreate();
    }

    private void onCreate() {
    }
}
