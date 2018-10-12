package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Stats {
    private int totalTimesPlayed;
    private List<HashMap<String, Stat>> stats = new ArrayList<>();

    /**
     * Given an index of an valid deck updates/adds statistics for the specified game mode
     * @param index The id that the deck has
     * @param gameMode The game mode
     * @param score the score that the user got when playing the deck
     * */
    public void addStatistics(int index, String gameMode, int score) {
        //New deck
        if(index >= stats.size()){
            stats.add(new HashMap<String, Stat>());
        }

        HashMap<String, Stat> deckStats = stats.get(index);



        //Dealing with a new deck
        /*if (deckStats == null) {
            deckStats = new HashMap<>();

            Stat stat = new Stat(gameMode);
            stat.updateStat(score);
            deckStats.put(gameMode, stat);
            stats.put(index, deckStats);
        } else {*/
            Stat gameStats = deckStats.get(gameMode);
            if (gameStats == null) { //Dealing with new game mode
                Stat stat = new Stat(gameMode);
                stat.updateStat(score);

                deckStats.put(gameMode, stat);
            } else { //Known deck and known game mode
                gameStats.updateStat(score);
            }
        //}

        totalTimesPlayed++;
    }

    public void removeDeck(int index) {
        if (0 <= index && index < stats.size()) {
            stats.remove(index);
        }
    }

    /*public int[] getUserStats() {
        return new int[]{totalTimesPlayed};
    }*/

    public Stat[] getStatsForDeck(int index) {
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

        return null;
    }
}