package FMATicTacToe;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Program {
          
    //public static String positionChosen; 
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) 
    {
        TicTacToe game = new TicTacToe();
        game.printWelcomeMessage();
        game.startGame();

        while(game.inProgress)
        {
            String playersMove = "";
            
            // prompt for player to enter coordinate
            game.promptForPlayerInput();
            
            // allow that player to make a move
            playersMove = game.getNextMove();   
            if(playersMove.equals("q"))
            {
                // game ended
                game.endGame();
                if (game.p1.currentTurn == true )
                {
                    System.out.println("Player 1 quit, Player 2 has won the game!");
                }
                else 
                {
                    System.out.println("Player 2 quit, Player 1 has won the game!");
                }
                
                //end game
                break;
            }
            else
            {   
                // update the board with chosen position
                game.updateBoard(playersMove);
                System.out.println("Move accepted, here's the current board:\n");
                // print the current board
                game.board.currentBoard();
                // if valid move, and board is not full, then swap player turn
                game.swapPlayerTurn();              
                // update the board and check if any player has won
                int winner = game.checkWinner();
                if(winner != 0)
                {
                    //a player won
                    System.out.println("Player " + winner + " has won the game!");
                    game.setWinner(winner);    
                    game.inProgress = false;  
                }
                else
                {
                    //if no winner, check draw
                    if(game.checkDraw()){
                        System.out.println("Draw!");
                        game.endGame();
                    }
                }
            }
        }
     }
 }
