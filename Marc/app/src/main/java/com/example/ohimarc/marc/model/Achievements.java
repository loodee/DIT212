package com.example.ohimarc.marc.model;

import java.util.EnumSet;
import java.util.List;

public class Achievements {

    private enum achievements {
        GET_ALL_ANSWERS_CORRECT_IN_A_DECK,
        REVIEWED_10_TIMES_IN_TOTAL,
        REVIEWED_20_TIMES_IN_TOTAL,
        REVIEWED_50_TIMES_IN_TOTAL,
        REVIEWED_100_TIMES_IN_TOTAL,
        CREATED_YOUR_FIRST_DECK,
        PLAYED_YOUR_FIRST_DECK,
        ONEHUNDRED_PERCENT_AVERAGE_SCORE_FLASHCARD,
        ONEHUNDRED_PERCENT_AVERAGE_SCORE_QUIZ
    }

    private List<achievements> completedAchievements;
    private List<achievements> uncompletedAchievements;

    public Achievements(){
        for(achievements a : EnumSet.allOf(achievements.class)){
            uncompletedAchievements.add(a);
        }
    }

    public void updateAchievements(achievements achi){
        for(achievements a : completedAchievements){
            if(a.equals(achi)){
                return;
            }
        }
        uncompletedAchievements.remove(achi);
        completedAchievements.add(achi);
    }
}
