package Tests;

import FMATicTacToe.Board;
import FMATicTacToe.TicTacToe;
import java.awt.Point;

import org.junit.Test;
import static org.junit.Assert.*;

public class gameTest {
    
    @Test
    public void testPositionTaken() 
    {
        boolean actualTaken = false;
        boolean actualNotTaken = false;
        boolean expectedResult = true;
                
        // sets up a new game
        TicTacToe game = new TicTacToe();
        
        // sets the first position to X
        game.getBoard().arrayBoard[0][0] = "X";
        
        String inputTaken = "1,1";
        String inputNotTaken = "1,2";
        Point pointTaken = game.getPointFromString(inputTaken);
        Point pointNotTaken= game.getPointFromString(inputNotTaken);
        
        if (game.getBoard().arrayBoard[pointTaken.x][pointTaken.y] != ".") 
        {
            actualTaken = true;
        }
        
        if(game.getBoard().arrayBoard[pointNotTaken.x][pointNotTaken.y] == ".")
        {
            actualNotTaken = true;
        }
        
        assertEquals(expectedResult, actualTaken);
        assertEquals(expectedResult, actualNotTaken);
    }

    @Test
    public void testReset() 
    {
        Board board = new Board();
        boolean expectedResult = true;
        boolean actual = false;
        board.arrayBoard[0][0] = "X";
        board.resetBoard();
        
        actual = board.isEmpty();
        assertEquals(expectedResult, actual);
    }
    
   @Test
    public void testSwapPlayer() 
    {
        // player 1 is always the first player
        TicTacToe game = new TicTacToe();
        boolean expectedResult = false;
        
        // swap from player 1 to player 2
        game.swapPlayerTurn();
        
        // player 1s current turn = false
        boolean actual = game.getP1().currentTurn;
        assertEquals(expectedResult, actual);
    }
    
    @Test
    public void testOutOfBounds() 
    {
        TicTacToe game = new TicTacToe();

        boolean expectedResult = false;
        boolean actual = true;
        
        Point point = new Point(4,4);
        
        actual = game.checkBoardPosition(point);
        assertEquals(expectedResult, actual);
    }
    
}
