## Getting Started

This Code is a Bowling Game score calculator for only one player.

This is only basic CLI (no GUI)

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

## Game Rules
* A bowling game consists of 10 frames.
* Each frame, the player has two tries to knock down 10 pins with a bowling ball.
* The score for the frame is the total of knocked down pins, plus bonuses for strikes and spared.
* A Spare is when a player knocks down all 10 pins in two tries.
    * The bonus for this frame is the number of pins knocked down by the next roll.
* A Strike is when the player knocks down all 10 pins on his first try.
    * The bonus for this frame is the number of pins knocked down by the next two rolls.
* In the 10th frame, a player is allowed to throw an extra ball if she/he scores a Spare or a Strike.
    * No more than three throws are allowed for the 10th frame.
    * No bonus scores are granted for Strikes and Spares in 10th frame.
    * If a player hits a Strike / Spare, 10 pins will be available again for the next throw within the 10th frame.
