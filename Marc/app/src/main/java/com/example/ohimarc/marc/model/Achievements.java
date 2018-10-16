package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author Victor Johansson (Vroxie on github)
 */
public class Achievements {

    /**
     * Here are all the achievements that for the moment exists in the app
     */
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

    /**
     * Every time this object is created i.e every time a new user gets created
     * It automatically inserts every achievement to the list of uncompleted achievements
     */
    public Achievements() {
        for (achievements a : EnumSet.allOf(achievements.class)) {
            uncompletedAchievements.add(a);
        }
    }

    /**
     * Moving a achievement from uncompleted to completed list if it is not in there already
     * Given a completed achievement that stats says have checked and syas it is done
     *
     * @param achi the completed achievement
     */
    public void updateAchievements(achievements achi) {
        for (achievements a : completedAchievements) {
            if (a.equals(achi)) {
                return;
            }
        }
        uncompletedAchievements.remove(achi);
        completedAchievements.add(achi);
    }

    /**
     * @return the list of completed achievements
     */
    public List<achievements> getCompletedAchievements() {
        return completedAchievements;
    }

    /**
     * @return the list of uncompleted achievements
     */
    public List<achievements> getUncompletedAchievements() {
        return uncompletedAchievements;
    }

    /**
     * Translates the enum to a list of all achievements
     *
     * @return the list of all achievements
     */
    public List<achievements> getEnumsAsList() {
        List<achievements> list = new ArrayList<>();
        for (achievements a : EnumSet.allOf(achievements.class)) {
            list.add(a);
        }
        return list;
    }

}
