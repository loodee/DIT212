package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.EnumSet;
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
        checkIfAchiIsCompleted(gameMode);
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
            userAchievements.updateAchievements(Achievements.achievements.CREATE_YOUR_FIRST_DECK);
        }
        stats.add(new HashMap<String, Stat>());
    }

    /**
     * A checker for all achievements that a user can get for the moment
     * @param gamemode the gamemode that that particular stat object holds,
     *                 this is since there could be different achievements
     *                 for different gamemodes
     */
    private void checkIfAchiIsCompleted(String gamemode){
        boolean allachis = true;
        for(int i = 0;i<stats.size();i++) {
            if(stats.get(i).get(gamemode) != null && stats.get(i).get(gamemode).getAllCorrect()) {
                userAchievements.updateAchievements(Achievements.achievements.GET_ALL_ANSWERS_CORRECT_IN_A_DECK);
            }
        }
        if(totalTimesPlayed >= 10){
            userAchievements.updateAchievements(Achievements.achievements.PLAY_10_GAMES);
        }
        if(totalTimesPlayed >= 20){
            userAchievements.updateAchievements(Achievements.achievements.PLAY_20_GAMES);
        }
        if(totalTimesPlayed >= 50){
            userAchievements.updateAchievements(Achievements.achievements.PLAY_50_GAMES);
        }
        if(totalTimesPlayed >= 100){
            userAchievements.updateAchievements(Achievements.achievements.PLAY_100_GAMES);
        }
        if(stats.get(0).get(gamemode) != null && stats.get(0).get(gamemode).getTimesPlayed() <= 1){
            userAchievements.updateAchievements(Achievements.achievements.PLAY_YOUR_FIRST_DECK);
        }
        for(int i = 0; i<userAchievements.getEnumsAsList().size()-1; i++){
            allachis = allachis && search(userAchievements.getEnumsAsList().get(i));
        }
        if(allachis){
            userAchievements.updateAchievements(Achievements.achievements.UNLOCK_ALL_ACHIEVEMENTS);
        }

    }

    /**
     * Just a linear search for a achievement to see if a achievement is completed
     * @param a the given achievement that should be searched after
     * @return a boolean that says if the achievement is completed or not
     */
    private boolean search(Achievements.achievements a){
        for(Achievements.achievements achi : userAchievements.getCompletedAchievements()){
            if(a.equals(achi)){
                return true;
            }
        }
        return false;
    }

    /**
     * @return the achievement object that is bounded to a certain Stats object which is bounded to a User
     */
    public Achievements getAchievements() {
        return userAchievements;
    }
}