package Tests;


import FMATicTacToe.TicTacToe;
import org.junit.Test;
import static org.junit.Assert.*;

public class winTest
{
    private static TicTacToe game;
   
    @Test
    public void testPlayer1WinHorizontal() 
    {
        TicTacToe game = new TicTacToe();
        int expectedResult = 1;
        
        game.board.arrayBoard[0][0] = "X";
        game.board.arrayBoard[0][1] = "X";
        game.board.arrayBoard[0][2] = "X";

        int actual = game.checkWinner();

        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[1][0] = "X";
        game.board.arrayBoard[1][1] = "X";
        game.board.arrayBoard[1][2] = "X";
        
        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();

        game.board.arrayBoard[2][0] = "X";
        game.board.arrayBoard[2][1] = "X";
        game.board.arrayBoard[2][2] = "X";
        
        assertEquals(expectedResult, actual);
    }
       
    @Test
    public void testPlayer2WinHorizontal() 
    {
        TicTacToe game = new TicTacToe();
        int expectedResult = 2;
        
        game.board.arrayBoard[0][0] = "O";
        game.board.arrayBoard[0][1] = "O";
        game.board.arrayBoard[0][2] = "O";

        int actual = game.checkWinner();

        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[1][0] = "O";
        game.board.arrayBoard[1][1] = "O";
        game.board.arrayBoard[1][2] = "O";
        
        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
   
        game.board.arrayBoard[2][0] = "O";
        game.board.arrayBoard[2][1] = "O";
        game.board.arrayBoard[2][2] = "O";
        
        assertEquals(expectedResult, actual);
    }
    
    @Test
    public void testPlayer1WinVertical() 
    {
        TicTacToe game = new TicTacToe();
        int expectedResult = 1;
        game.board.arrayBoard[0][0] = "X";
        game.board.arrayBoard[1][0] = "X";
        game.board.arrayBoard[2][0] = "X";

        int actual = game.checkWinner();
        
        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[0][1] = "X";
        game.board.arrayBoard[1][1] = "X";
        game.board.arrayBoard[2][1] = "X";
        
        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[0][2] = "X";
        game.board.arrayBoard[1][2] = "X";
        game.board.arrayBoard[2][2] = "X";
        
        assertEquals(expectedResult, actual);  
    }
    
    @Test
    public void testPlayer2WinVertical() 
    {
        TicTacToe game = new TicTacToe();
        int expectedResult = 2;
        
        game.board.arrayBoard[0][0] = "O";
        game.board.arrayBoard[1][0] = "O";
        game.board.arrayBoard[2][0] = "O";

        int actual = game.checkWinner();

        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[0][1] = "O";
        game.board.arrayBoard[1][1] = "O";
        game.board.arrayBoard[2][1] = "O";
        
        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[0][2] = "O";
        game.board.arrayBoard[1][2] = "O";
        game.board.arrayBoard[2][2] = "O";
        
        assertEquals(expectedResult, actual);
    }
    
    @Test
    public void testPlayer1WinDiag()
    {
        
        TicTacToe game = new TicTacToe();
        int expectedResult = 1;
        
        game.board.arrayBoard[0][0] = "X";
        game.board.arrayBoard[1][1] = "X";
        game.board.arrayBoard[2][2] = "X";

        int actual = game.checkWinner();

        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[2][0] = "X";
        game.board.arrayBoard[1][1] = "X";
        game.board.arrayBoard[0][2] = "X";
        
        assertEquals(expectedResult, actual);     
    }
    
    public void testPlayer2inDiag() 
    {
        TicTacToe game = new TicTacToe();
        int expectedResult = 2;
        
        game.board.arrayBoard[0][0] = "O";
        game.board.arrayBoard[1][1] = "O";
        game.board.arrayBoard[2][2] = "O";

        int actual = game.checkWinner();

        assertEquals(expectedResult, actual);
        
        game.board.resetBoard();
        
        game.board.arrayBoard[2][0] = "O";
        game.board.arrayBoard[1][1] = "O";
        game.board.arrayBoard[0][2] = "O";
        
        assertEquals(expectedResult, actual);     
    }
    
    @Test
    public void testDraw() 
    {
        TicTacToe game = new TicTacToe();
        boolean actual = false;
        boolean expectedResult = true;
         
        game.board.arrayBoard[0][0] = "X";
        game.board.arrayBoard[0][1] = "O";
        game.board.arrayBoard[0][2] = "X";
        game.board.arrayBoard[1][0] = "X";
        game.board.arrayBoard[1][1] = "O";
        game.board.arrayBoard[1][2] = "O";
        game.board.arrayBoard[2][0] = "O";
        game.board.arrayBoard[2][1] = "X";
        game.board.arrayBoard[2][2] = "X";
   
        actual = game.checkDraw();

        assertEquals(expectedResult, actual);

    }
}
