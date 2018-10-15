package com.example.ohimarc.marc.model;

public class Stat {
    private int highScore;
    private int timesPlayed;
    private double averageScore;
    private final String gameMode;

    Stat(String gameMode){
        this.gameMode = gameMode;
        highScore = 0;
        timesPlayed = 0;
        averageScore = 0;
    }

    /**
     * Deep copy
     * */
    Stat(Stat s){
        gameMode = s.gameMode;
        highScore = s.highScore;
        averageScore = s.averageScore;
        timesPlayed = s.timesPlayed;
    }

    public void updateStat(int score){
        highScore = Math.max(highScore, score);
        averageScore = ((averageScore*timesPlayed)+score)/(timesPlayed+1);
        timesPlayed++;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public String getGameMode() {
        return gameMode;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }
}
