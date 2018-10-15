package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Stats {
    private int totalTimesPlayed;
    private Achievements userAchievements = new Achievements();
    private final List<HashMap<String, Stat>> stats = new ArrayList<>();

    /**
     * Given an index of an valid deck updates/adds statistics for the specified game mode
     *
     * @param index    The id that the deck has
     * @param gameMode The game mode
     * @param score    the score that the user got when playing the deck
     */
    public void addStatistics(int index, String gameMode, int score, boolean allCorrect) {
        //New deck
        if (index >= stats.size()) {
            stats.add(new HashMap<String, Stat>());
        }

        HashMap<String, Stat> deckStats = stats.get(index);


        Stat gameStats = deckStats.get(gameMode);
        if (gameStats == null) { //Dealing with new game mode
            Stat stat = new Stat(gameMode,allCorrect);
            stat.updateStat(score);

            deckStats.put(gameMode, stat);
        } else { //Known deck and known game mode
            gameStats.updateStat(score);
        }

        totalTimesPlayed++;
    }

    public void removeDeck(int index) {
        if (0 <= index && index < stats.size()) {
            stats.remove(index);
        }
    }

    public int[] getUserStats() {
        return new int[]{totalTimesPlayed};
    }

    public Stat[] getStatsForDeck(int index) {

        //Is the index valid
        if(0 > index || index >= stats.size()){
            return new Stat[]{};
        }


        HashMap<String, Stat> map = stats.get(index);

        if (map != null) {
            Set<String> keys = map.keySet();

            //Done to make sure that the stats are given in oder by their name
            List<String> sortedKeys = new ArrayList<>(keys.size());
            sortedKeys.addAll(keys);
            java.util.Collections.sort(sortedKeys);

            if (sortedKeys.size() != 0) {

                Stat[] localStats = new Stat[keys.size()];

                int arrayIndex = 0;
                for (String key : sortedKeys) {
                    localStats[arrayIndex] = new Stat(map.get(key));

                    arrayIndex++;
                }


                return localStats;
            }
        }

        return new Stat[]{};
    }

    public void addNewDeck() {
        if(stats.isEmpty()) {
            stats.add(new HashMap<String, Stat>());
            userAchievements.updateAchievements(Achievements.achievements.CREATED_YOUR_FIRST_DECK);
        }
        stats.add(new HashMap<String, Stat>());
    }

    public void checkIfAchiIsCompleted(String gamemode){
        for(int i = 0;i<stats.size();i++) {
            if(stats.get(i).get(gamemode).getAllCorrect()) {
                userAchievements.updateAchievements(Achievements.achievements.GET_ALL_ANSWERS_CORRECT_IN_A_DECK);
            }
        }
        if(totalTimesPlayed >= 10){
            userAchievements.updateAchievements(Achievements.achievements.REVIEWED_10_TIMES_IN_TOTAL);
        }
        if(totalTimesPlayed >= 20){
            userAchievements.updateAchievements(Achievements.achievements.REVIEWED_20_TIMES_IN_TOTAL);
        }
        if(totalTimesPlayed >= 50){
            userAchievements.updateAchievements(Achievements.achievements.REVIEWED_50_TIMES_IN_TOTAL);
        }
        if(totalTimesPlayed >= 100){
            userAchievements.updateAchievements(Achievements.achievements.REVIEWED_100_TIMES_IN_TOTAL);
        }
        
    }
}