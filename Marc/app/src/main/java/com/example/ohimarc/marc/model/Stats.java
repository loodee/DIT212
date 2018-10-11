package com.example.ohimarc.marc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Stats {
    private int totalTimesPlayed;
    private HashMap<Integer, HashMap<String, Stat>> stats = new HashMap<>();

    public void addStatistics(int index, String gameType, int score) {

        //Gets stats for deck
        HashMap<String, Stat> deckStats = stats.get(index);

        //Dealing with a new deck
        if (deckStats == null) {
            deckStats = new HashMap<>();

            Stat stat = new Stat(gameType);
            stat.updateStat(score);
            deckStats.put(gameType, stat);
            stats.put(index, deckStats);
        } else {
            Stat gameStats = deckStats.get(gameType);
            if (gameStats == null) { //Dealing with new game mode
                Stat stat = new Stat(gameType);
                stat.updateStat(score);

                deckStats.put(gameType, stat);
            } else { //Known deck and known game mode
                gameStats.updateStat(score);
            }
        }

        totalTimesPlayed++;
    }

    public void removeDeck(int index) {
        if (0 <= index && index < stats.size()) {
            stats.remove(index);
        }
    }

    public Stat[] getStatsForDeck(int index) {
        HashMap<String, Stat> map = stats.get(index);

        if (map != null) {
            Set<String> keys = map.keySet();

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