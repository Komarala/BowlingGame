//Libraries

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class for calculating Bowling Game score
public class PinBowling{

    public static int strike = 10;

    private List<Integer> TotalRolls = new ArrayList<Integer>();

    public void roll(List<Integer> rolls){
        TotalRolls = rolls;
    }
    
    public int calculateScore() {
        int score = 0;
        int rollIndex = 0;

        for (int frame = 1; frame <= 10; frame++) {
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
            System.out.println("Frame "+frame+" Score "+score);
            }
        return score;
    }
    
    //Check if Strike
    public boolean isStrike(int rollIndex) {
        return TotalRolls.get(rollIndex) == strike;
    }

    //Check if Spare
    public boolean isSpare(int rollIndex) {
        return TotalRolls.get(rollIndex) + TotalRolls.get(rollIndex+1) == strike;
    }

    //Add Strike bonus
    public int strikeBonus(int rollIndex) {
        return TotalRolls.get(rollIndex + 1) + TotalRolls.get(rollIndex + 2); 
    }

    //Add Spare bonus
    public int spareBonus(int rollIndex) {
        return TotalRolls.get(rollIndex + 2);
    }

    //Total score calculator
    public int frameScore(int rollIndex) {
        return TotalRolls.get(rollIndex) + TotalRolls.get(rollIndex + 1);
    }

    //Main Source Code
    public static void main(String[] args) {
        PinBowling game = new PinBowling();
        int rollsAllowed = 2;
        List<Integer> rolls = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            for (int frame = 1; frame <= strike; frame++) {
                System.out.println("Frame " + (frame));

                for (int numOfRolls = 1; numOfRolls < rollsAllowed; numOfRolls++){
                    System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (numOfRolls)+" : ");
                    int FirstRoll = sc.nextInt();
                    rolls.add(FirstRoll);
                    if (FirstRoll==strike){
                        System.out.println("Strike!");
                    }
                    else {
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (numOfRolls+1)+" : ");
                        int SecondRoll = sc.nextInt();
                        rolls.add(SecondRoll);
                        if(FirstRoll + SecondRoll == strike){  
                        System.out.println("Spare!");
                        if (frame==10){
                            System.out.println("You earned a bonus roll!");
                            System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (numOfRolls+2)+" : ");
                            int ThirdRoll = sc.nextInt();
                            rolls.add(ThirdRoll);
                        }
                        }
                    }
                    if (frame==10 && FirstRoll==strike){
                        System.out.println("You earned a bonus roll!");
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (numOfRolls+1)+" : ");
                        int SecondRoll = sc.nextInt();
                        rolls.add(SecondRoll);
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (numOfRolls+2)+" : ");
                        int ThirdRoll = sc.nextInt();
                        rolls.add(ThirdRoll);
                        }
                }
            }
        }
        game.roll(rolls);
        int score = game.calculateScore();
        System.out.println("Score Board = " + rolls);
        System.out.println("Player's score: " + score);
    }
}
