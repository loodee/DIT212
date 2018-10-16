package com.example.ohimarc.marc.model;

/**
 * @author Gustav Albertsson
 *
 * Class for holding the statistics for a single deck/game mode combintaion
 */
public class Stat {
    private int highScore;
    private int timesPlayed;
    private final boolean allCorrect;
    private double averageScore;
    private final String gameMode;


    /**
     * TODO: should allCorrect be here, should it not be in updateStats?, Now we can not change it once it is created
     * */
    Stat(String gameMode, boolean allCorrect) {
        this.gameMode = gameMode;
        highScore = 0;
        timesPlayed = 0;
        averageScore = 0;
        this.allCorrect = allCorrect;
    }

    /**
     * Creates a Stat object that is an deep copy of the given stat object
     * @param s The Stat object to make a deep copy of
     */
    Stat(Stat s) {
        gameMode = s.gameMode;
        highScore = s.highScore;
        averageScore = s.averageScore;
        timesPlayed = s.timesPlayed;
        allCorrect = s.allCorrect;
    }

    /**
     * Updates the statistics that that is saved based on the given score
     * @param score The score that the user got
     * */
    public void updateStat(int score) {
        highScore = Math.max(highScore, score);
        averageScore = ((averageScore * timesPlayed) + score) / (timesPlayed + 1);
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

    public boolean getAllCorrect() {
        return allCorrect;
    }
}
