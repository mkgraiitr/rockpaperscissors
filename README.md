# rockpaperscissors

The program is created to let user play Rock Paper Scissors game with computer or another user.

How to run:
It is a simple commmand line application, which can be run from main method of RockpaperscissorsApplication.

Language, external libraries and dependencies:
Language - Java 1.8
Libraries - Jupitor API for Junit

Assumptions:

1) Number of players, type of the user - whether human or computer, and number of rounds to be played will be the user inputs.
2) Human player will have default strategy to get next moves from command line
3) Computer player will have default random selection strategy to get next moves
4) Scoring Logic - 
   i) If both the players selected same shape, each player will be awarded score zero.
   ii) In other cases, the winner will score +1 and the loser will score -1
   iii) In multiplayer game, each player will be scored against all the remaining players. For eaxmple, in a three player game, if player A selected ROCK, player B selected PAPER and player C selected SCISSORS, player A will score -1 against player B, but score +1 against player C. In total, player A will have zero score in this round.
   iV) The scores will be accumulated after each round. After last round (user input), the highest scorer will be declared as winnner. In case, two players scored same score, the game will be tied.

Design considerations and project issues:
The following components are extendable and loosely coupled with other components
1) Strategy to select shapes Rock, Paper and Scissors. Different strategies (such as select learned move from historical moves of the opponents or moves that use AI) can be made in future by implementing NextMoveStrategy interface.
2) The program can be extended to make player change its strategy dynamically during the game
3) Scoreboard has round wise information about players, their selections and scores. This histroy can be used for learned selections.
4) Scoring Engine has the logic to calculate the scores of the players. This logic can be independently modified to accomodate new rules if any.
5) CommandLineHandler that handles commands from users can be easily replaced with any other controller and the backend service can be integrated with UI application to receive user inputs from UI

Quality Assurance:
1) In addition to method level test cases, integration test cases have been written to ensure that end to end functionlaiy can be tested using test cases
2) The code has been tested with fixed move strategy and also randomly selected moves






