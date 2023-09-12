//Libraries

import java.util.ArrayList;
import java.util.List;

//Class for calculating Bowling Game score
public class PinBowling{
    private List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int calculateScore() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += frameScore(rollIndex);
                rollIndex += 2;
            }
        }

        return score;
    }
    
    //Returns Scored points of each roll in list
    public List<Integer> Board(){
        return rolls;
    }

    //Check if Strike
    private boolean isStrike(int rollIndex) {
        return rolls.get(rollIndex) == 10;
    }

    //Check if Spare
    private boolean isSpare(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == 10;
    }

    //Add Strike bonus
    private int strikeBonus(int rollIndex) {
        return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2); 
    }

    //Add Spare bonus
    private int spareBonus(int rollIndex) {
        return rolls.get(rollIndex + 2);
    }

    //Total score calculator
    private int frameScore(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

    //Main Source Code
    public static void main(String[] args) {
        PinBowling game = new PinBowling();

        // Example Player's rolls
        int[] rolls = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};

        //Looping for rolls
        for (int pins : rolls) {
            game.roll(pins);
        }

        List <Integer> Board = game.Board();
        int score = game.calculateScore();
        System.out.println("Score Board = " + Board);
        System.out.println("Player's score: " + score);
    }
}

