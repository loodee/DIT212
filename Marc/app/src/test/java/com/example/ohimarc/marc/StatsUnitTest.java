package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Stat;
import com.example.ohimarc.marc.model.Stats;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class StatsUnitTest {

    Stats stats;

    @Before
    public void init(){
        stats = new Stats();
    }

    @Test
    public void addNewStat(){
        stats.addStatistics(0,"A",10);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(1,stat.length);
        assertEquals(10,stat[0].getHighScore());
        assertEquals(1,stat[0].getTimesPlayed());
        assertEquals(10.0,stat[0].getAverageScore());
        assertEquals("A", stat[0].getGameMode());
    }

    @Test
    public void updateStats(){
        stats.addStatistics(0,"A",10);
        stats.addStatistics(0,"A", 5);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(1,stat.length);
        assertEquals(10,stat[0].getHighScore());
        assertEquals(2,stat[0].getTimesPlayed());
        assertEquals(7.5,stat[0].getAverageScore());
        assertEquals("A", stat[0].getGameMode());
    }

    @Test
    public void addMultipleStats(){
        stats.addStatistics(0,"A",10);
        stats.addStatistics(0,"B", 5);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(2,stat.length);

        assertEquals(10,stat[0].getHighScore());
        assertEquals(1,stat[0].getTimesPlayed());
        assertEquals(10.0,stat[0].getAverageScore());
        assertEquals("A", stat[0].getGameMode());

        assertEquals(5,stat[1].getHighScore());
        assertEquals(1,stat[1].getTimesPlayed());
        assertEquals(5.0,stat[1].getAverageScore());
        assertEquals("B", stat[1].getGameMode());
    }


    @Test
    public void addMultipleUpdate(){
        stats.addStatistics(0,"A",10);
        stats.addStatistics(0,"B", 5);
        stats.addStatistics(0, "A", 8);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(2,stat.length);

        assertEquals(10,stat[0].getHighScore());
        assertEquals(2,stat[0].getTimesPlayed());
        assertEquals(9.0,stat[0].getAverageScore());
        assertEquals("A", stat[0].getGameMode());

        assertEquals(5,stat[1].getHighScore());
        assertEquals(1,stat[1].getTimesPlayed());
        assertEquals(5.0,stat[1].getAverageScore());
        assertEquals("B", stat[1].getGameMode());
    }


    @Test
    public void multipleDecks(){
        stats.addStatistics(0,"A",10);
        stats.addStatistics(1,"B", 5);
        stats.addStatistics(0, "A", 8);

        Stat[] stat = stats.getStatsForDeck(0);
        Stat[] stat2 = stats.getStatsForDeck(1);

        assertEquals(1,stat.length);
        assertEquals(1,stat2.length);

        assertEquals(10,stat[0].getHighScore());
        assertEquals(2,stat[0].getTimesPlayed());
        assertEquals(9.0,stat[0].getAverageScore());
        assertEquals("A", stat[0].getGameMode());

        assertEquals(5,stat2[0].getHighScore());
        assertEquals(1,stat2[0].getTimesPlayed());
        assertEquals(5.0,stat2[0].getAverageScore());
        assertEquals("B", stat2[0].getGameMode());
    }


    @Test
    public void removeDeck(){
        stats.addStatistics(0,"A",10);
        stats.addStatistics(1,"B", 5);
        stats.addStatistics(0, "A", 8);

        stats.removeDeck(0);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(1,stat.length);

        assertEquals(5,stat[0].getHighScore());
        assertEquals(1,stat[0].getTimesPlayed());
        assertEquals(5.0,stat[0].getAverageScore());
        assertEquals("B", stat[0].getGameMode());
    }


    @Test
    public void getUserStat(){
        stats.addStatistics(0,"A",10);

        Stat[] stat = stats.getStatsForDeck(0);

        assertEquals(1, stats.getUserStats()[0]);

        stats.addStatistics(0,"A",2);

        assertEquals(2, stats.getUserStats()[0]);
    }


    @Test
    public void getStatsForEmptyDeck(){
        //stats.addNewDeck();

        Stat[] stat = stats.getStatsForDeck(0);

        assertNotNull(stat);
        assertEquals(0, stat.length);
    }

}
