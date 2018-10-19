package com.example.ohimarc.marc;

import com.example.ohimarc.marc.model.Achievements;

import org.junit.Test;

import static org.junit.Assert.*;

public class AchievementsUnitTest {

    @Test
    public void checkAchiUpdate(){
        Achievements testachievements = new Achievements();
        testachievements.updateAchievements(testachievements.getEnumsAsList().get(0));
        boolean isachi = testachievements.getCompletedAchievements().get(testachievements.getCompletedAchievements().size()-1)
                == testachievements.getEnumsAsList().get(0);
        boolean isGone = true;
        for(int i = 0;i<testachievements.getUncompletedAchievements().size();i++ ){
            if(testachievements.getUncompletedAchievements().get(i) == testachievements.getEnumsAsList().get(0)){
                isGone = false;
                break;
            }
        }
        assertTrue(isachi);
        assertTrue(isGone);
    }

    @Test
    public void addingExistingAchi(){
        boolean notDuplicate = true;
        Achievements testachievements = new Achievements();
        testachievements.updateAchievements(testachievements.getEnumsAsList().get(0));
        testachievements.updateAchievements(testachievements.getEnumsAsList().get(0));
        for(int i = 0;i<testachievements.getCompletedAchievements().size()-1;i++){
            if(testachievements.getCompletedAchievements().get(i) == testachievements.getCompletedAchievements().get(i+1)){
                notDuplicate = false;
            }
        }
        assertTrue(notDuplicate);
    }
}
