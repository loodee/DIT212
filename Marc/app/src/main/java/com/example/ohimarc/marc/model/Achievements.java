package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Victor Johansson (Vroxie on github)
 */
public class Achievements {

    public enum achievements {
        GET_ALL_ANSWERS_CORRECT_IN_A_DECK,
        REVIEWED_10_TIMES_IN_TOTAL,
        REVIEWED_20_TIMES_IN_TOTAL,
        REVIEWED_50_TIMES_IN_TOTAL,
        REVIEWED_100_TIMES_IN_TOTAL,
        CREATED_YOUR_FIRST_DECK,
        PLAYED_YOUR_FIRST_DECK,
        UNLOCKED_ALL_ACHIEVEMENTS
    }

    private List<achievements> completedAchievements = new ArrayList<>();
    private List<achievements> uncompletedAchievements = new ArrayList<>();

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

    public List<achievements> getCompletedAchievements(){
        return completedAchievements;
    }

    public List<achievements> getUncompletedAchievements(){
        return uncompletedAchievements;
    }

    public List<achievements> getEnumsAsList(){
        List<achievements> list = new ArrayList<>();
        for (achievements a : EnumSet.allOf(achievements.class)){
            list.add(a);
        }
        return list;
    }

}
