/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import FMATicTacToe.Board;
import FMATicTacToe.TicTacToe;
import FMATicTacToe.Player;
import FMATicTacToe.Program;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class boardTest
{

    private static Board board;
    private static TicTacToe game;
    private static Player player;
    private static Program program;

    @BeforeClass
    public static void setUpClass() 
    {
        board = new Board();
        program = new Program();
        game = new TicTacToe();      
    }

    @Test
    public void testIfBoardNull() 
    {
        boolean expectedResult = true;
        boolean actual = false;

        if (board != null) 
        {
            actual = true;
        }
        assertEquals(expectedResult, actual);
    }

    @Test
    public void testBoardSize() 
    {
        assertEquals(3, board.arrayBoard.length);
        assertEquals(3, board.arrayBoard[0].length);
    }

    @Test
    public void testSpacesInBoard() 
    {
        boolean expectedResult = true;
        boolean actual = true;
        for (int i = 3; i < 3; i++) 
        {
            for (int j = 3; j < 3; j++) 
            {
                if (board.arrayBoard[i][j] != ".") 
                {
                    actual = false;
                    break;
                }
            }
        }
        assertEquals(expectedResult, actual);
    }
   

}
