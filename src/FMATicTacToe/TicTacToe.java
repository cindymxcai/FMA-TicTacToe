package FMATicTacToe;

import java.awt.Point;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TicTacToe 
{
    private Boolean inProgress;
    private Board board;
    private Player p1, p2;
    private Scanner scan;
    private final Pattern pattern = Pattern.compile( "\\d,\\d");
    private final Pattern patternQuit = Pattern.compile("q");
    
    public TicTacToe()
    {
        this.scan = new Scanner(System.in);
        this.inProgress = false;
        this.board = new Board();
        this.p1 = new Player("1", true);
        this.p2 = new Player("2", false);
    }
    
    public void startGame()
    {   
        this.inProgress = true;
    }
    
    public void endGame()
    {
        this.inProgress = false;
        this.board = null;
    }
    
    // swaps back and forth between player turns
    public void swapPlayerTurn()
    {
        if(getP1().currentTurn)
        {
            p1.currentTurn = getP2().currentTurn;
            p2.currentTurn = true;
        }
        else
        {
            p2.currentTurn = getP1().currentTurn;
            p1.currentTurn = true;
        }
    }
    
    public void promptForPlayerInput()
    {
        if(getP1().currentTurn)
        {
            System.out.println("\nPlayer 1 enter a coord x,y to place your X or enter 'q' to give up: ");
        }
        else
        {
            System.out.println("\nPlayer 2 enter a coord x,y to place your O or enter 'q' to give up: ");
        }
    }
    
    // returns either a valid and not-taken coordinate position or 'q' to quit the game
    public String getNextMove()
    {
        boolean valid;
        String positionChosen = "";
        Point point;
        
        do
        {
            valid = true;
            // get input from user
            positionChosen = scan.nextLine();
            // check valid co-ordinate or 'q'
            if(!pattern.matcher(positionChosen).matches() && !patternQuit.matcher(positionChosen).matches())
            {
                System.out.println("Oh no, please enter a valid coordinate!  Try again...");
                valid = false;
            }
            else if(positionChosen.charAt(0) == 'q')
            {
                return "q";
            }
            else
            {
               point = getPointFromString(positionChosen);
               valid = checkBoardPosition(point);
            }
            
        } while (!valid);

        return positionChosen;
    }
    
    public boolean checkBoardPosition(Point point)
    {
         // check position chosen exists on the board between 0-2 x and y
        if(point.x > 2 || point.y > 2 || point.x < 0 || point.y < 0)
            {
                System.out.println("Oh no, please enter a valid coordinate!  Try again...");
                return false;
            }
            else
            {
                if(!getBoard().arrayBoard[point.x][point.y].equals("."))
                {
                    System.out.println("Oh no, a piece is already at this place! Try again...");
                    return false;
                }
            }
        return true;
    }
    
    public void updateBoard(String playersMove)
    {              
       Point point = getPointFromString(playersMove);
       
       if (getP1().currentTurn == true )
       {
           board.arrayBoard[point.x][point.y] = "X";
       }
       else if (getP2().currentTurn == true)
       {
           board.arrayBoard[point.x][point.y] = "O";
       }
    } 
     
     public int checkWinner()
     {
        for(int column = 0; column < 3; column++)
        {
             //if player 1 wins a column
            if(getBoard().arrayBoard[column][0].equals("X") && getBoard().arrayBoard[column][1].equals("X") && getBoard().arrayBoard[column][2].equals("X"))
            {
                return 1;
            }            
            // if player 2 wins a column
            if(getBoard().arrayBoard[column][0].equals("O") && getBoard().arrayBoard[column][1].equals("O") && getBoard().arrayBoard[column][2].equals("O"))
            {
                return 2;
            }  
        }
        
        for(int row = 0; row < 3; row++)
        {
            // if player 1 wins a row
            if(getBoard().arrayBoard[0][row].equals("X") && getBoard().arrayBoard[1][row].equals("X") && getBoard().arrayBoard[2][row].equals("X"))
            {
                return 1;
            }
            
            // if player 2 wins a row
            if(getBoard().arrayBoard[0][row].equals("O") && getBoard().arrayBoard[1][row].equals("O") && getBoard().arrayBoard[2][row].equals("O"))
            {
                return 2;
            }  
        }
        //if player 1 wins diagonally
        if (getBoard().arrayBoard[0][0].equals("X") && getBoard().arrayBoard[1][1].equals("X") && getBoard().arrayBoard[2][2].equals("X") || (getBoard().arrayBoard[0][2].equals("X") && getBoard().arrayBoard[1][1].equals("X") && getBoard().arrayBoard[2][0].equals("X")))
        {
            return 1;
        }
        //if player 2 wins diagonally
        if (getBoard().arrayBoard[0][0].equals("0") && getBoard().arrayBoard[1][1].equals("O") && getBoard().arrayBoard[2][2].equals("O") || (getBoard().arrayBoard[0][2].equals("O") && getBoard().arrayBoard[1][1].equals("O") && getBoard().arrayBoard[2][0].equals("O")))
        {
            return 2;
        }
        //else return 0 = no one won
        return 0;
     }
   

    public void printBoard()
    {
        this.getBoard().currentBoard();
    }
    
    public void printWelcomeMessage() 
    {
        System.out.println("Welcome to Tic Tac Toe!\n");        
        System.out.println("Here's the current board:\n");
        printBoard();
    }
    
    // takes in the input string as eg (1,1) and returns a new point (0,0)
    public Point getPointFromString(String input)
    {
        return new Point(Character.getNumericValue(input.charAt(0) - 1), Character.getNumericValue(input.charAt(2) - 1));
    }
    
    public boolean checkDraw(){
        boolean draw = true; 
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j ++ )
            {                
              if(getBoard().arrayBoard[i][j].equals("."))
              {
                  draw = false;
              }
            }
        }
       return draw;
    }
    
    //1 for player 1 win, 2 for player 1 win to be used in check winner
    public void setWinner(int winner)
    {
        if(winner == 1)
        {
            p1.won = true;
        }
        else if(winner == 2)
        {
            p2.won = true;
        }
    }

    public Boolean getInProgress() 
    {
        return inProgress;
    }

    public Board getBoard() 
    {
        return board;
    }
    
    public Player getP1() 
    {
        return p1;
    }

    public Player getP2()
    {
        return p2;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}