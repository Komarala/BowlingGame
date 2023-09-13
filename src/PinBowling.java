//Libraries

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class for calculating Bowling Game score
public class PinBowling{
    //List<Integer> rolls = new ArrayList<>();

    //public void roll(int pins) {
    //    rolls.add(pins);
    //}
    public int calculateScore(List<Integer>TotalRolls) {
        int score = 0;
        int rollIndex = 0;
        System.out.println(TotalRolls);

        for (int frame = 1; frame <= 10; frame++) {
            if (isStrike(rollIndex, TotalRolls)) {
                score += 10 + strikeBonus(rollIndex, TotalRolls);
                rollIndex++;
            } else if (isSpare(rollIndex,TotalRolls)) {
                score += 10 + spareBonus(rollIndex, TotalRolls);
                rollIndex += 2;
            } else {
                score += frameScore(rollIndex, TotalRolls);
                rollIndex += 2;
            }
            }
            System.out.println("FrameScore "+score);
        return score;
    }
    
    //Returns Scored points of each roll in list
    public List<Integer> Board(List<Integer>TotalRolls){
        return TotalRolls;
    }

    //Check if Strike
    public boolean isStrike(int rollIndex, List<Integer>TotalRolls) {
        return TotalRolls.get(rollIndex) == 10;
    }

    //Check if Spare
    public boolean isSpare(int rollIndex,List<Integer>TotalRolls) {
        return TotalRolls.get(rollIndex) + TotalRolls.get(rollIndex+1) == 10;
    }

    //Add Strike bonus
    private int strikeBonus(int rollIndex,List<Integer>TotalRolls) {
        return TotalRolls.get(rollIndex + 1) + TotalRolls.get(rollIndex + 2); 
    }

    //Add Spare bonus
    private int spareBonus(int rollIndex,List<Integer>TotalRolls) {
        return TotalRolls.get(rollIndex + 2);
    }

    //Total score calculator
    private int frameScore(int rollIndex,List<Integer>TotalRolls) {
        return TotalRolls.get(rollIndex) + TotalRolls.get(rollIndex + 1);
    }

        //Main Source Code
    public static void main(String[] args) {
        PinBowling game = new PinBowling();
        int rollsAllowed = 2;
        List<Integer> rolls = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            for (int frame = 1; frame <= 10; frame++) {
                System.out.println("Frame " + (frame));

                for (int i = 1; i < rollsAllowed; i++){
                    System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (i)+" : ");
                    int FirstRoll = sc.nextInt();
                    rolls.add(FirstRoll);
                    if (FirstRoll==10){
                        System.out.println("Strike!");
                    }
                    else {
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (i+1)+" : ");
                        int SecondRoll = sc.nextInt();
                        rolls.add(SecondRoll);
                        if(FirstRoll + SecondRoll == 10){  
                        System.out.println("Spare!");
                        if (frame==10){
                            System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (i+2)+" : ");
                            int ThirdRoll = sc.nextInt();
                            rolls.add(ThirdRoll);
                        }
                        }
                    }
                    if (frame==10 && FirstRoll==10){
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (i+1)+" : ");
                        int SecondRoll = sc.nextInt();
                        rolls.add(SecondRoll);
                        System.out.print("Enter pins knocked down of Frame " + frame + " in roll " + (i+2)+" : ");
                        int ThirdRoll = sc.nextInt();
                        rolls.add(ThirdRoll);
                        }
                }
            }
        }
        
        System.out.println(rolls);
        int score = game.calculateScore(rolls);
        List <Integer> Board = game.Board(rolls);
        System.out.println("Score Board = " + Board);
        System.out.println("Player's score: " + score);
    }
}
