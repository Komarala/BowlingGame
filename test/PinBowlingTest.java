import static org.junit.Assert.*;
// import org.junit.runner.JUnitCore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PinBowlingTest {

    private PinBowling pinBowling;

    @Before
    public void setUp() {
        pinBowling = new PinBowling();
    }

    @Test
    public void testCalculateScore_AllStrikes() {
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            rolls.add(10); // 12 strikes
        }
        pinBowling.roll(rolls);
        int score = pinBowling.calculateScore();
        assertEquals(300, score);
    }

    @Test
    public void testCalculateScore_AllSpares() {
        List<Integer> rolls = Arrays.asList(5,5,6,4,7,3,8,2,9,1,5,5,4,6,3,7,2,8,1,9,10);
        pinBowling.roll(rolls);
        int score = pinBowling.calculateScore();
        assertEquals(155, score);
    }

    @Test
    public void testCalculateScore_MixedGame() {
        List<Integer> rolls_Test1 = Arrays.asList(1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6); //With Spare in 10th Frame
        pinBowling.roll(rolls_Test1);
        int score_Test1 = pinBowling.calculateScore();
        assertEquals(133, score_Test1);
        List<Integer> rolls_Test2 = Arrays.asList(1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6); //Without Spare in 10th Frame
        pinBowling.roll(rolls_Test2);
        int score_Test2 = pinBowling.calculateScore();
        assertEquals(133, score_Test2);
    
    }

    // Other test methods for different scenarios

    @Test
    public void testIsStrike() {
        List<Integer> rolls = Arrays.asList(10, 5, 3);
        pinBowling.roll(rolls);
        boolean isStrike = pinBowling.isStrike(0);
        assertEquals(true, isStrike);
    }

    @Test
    public void testIsSpare() {
        List<Integer> rolls = Arrays.asList(5, 5, 3);
        pinBowling.roll(rolls);
        boolean isSpare = pinBowling.isSpare(0);
        assertEquals(true, isSpare);
    }

    @Test
    public void testStrikeBonus() {
        List<Integer> rolls = Arrays.asList(10, 5, 3);
        pinBowling.roll(rolls);
        int bonus = pinBowling.strikeBonus(0);
        assertEquals(8, bonus);
    }

    @Test
    public void testSpareBonus() {
        List<Integer> rolls = Arrays.asList(7, 3, 5, 2);
        pinBowling.roll(rolls);
        int bonus = pinBowling.spareBonus(0);
        assertEquals(5, bonus);
    }

    @Test
    public void testFrameScore() {
        List<Integer> rolls = Arrays.asList(4, 5, 6, 3);
        pinBowling.roll(rolls);
        int frameScore = pinBowling.frameScore(0);
        assertEquals(9, frameScore);
    }
}