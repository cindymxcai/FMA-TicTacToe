package FMATicTacToe;

public class Board 
{
    public String[][] arrayBoard;
    
    public Board()
    {
        // instantiate the board's variables
        arrayBoard = new String[3][3];
        resetBoard();
    }
    
    // resets the board to all .
    public void resetBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j ++ )
            {                
                arrayBoard[i][j] = ".";
            }
        }
    }
   
    public void currentBoard()
    {
        for(int i = 0; i < 3; i ++)
        {
            for(int k = 0 ; k < 3; k++)
            {
                System.out.print(arrayBoard[i][k] +" ");
            }     
            System.out.println();
        } 
    }
    
    // sets flag to see if any position is taken on the board
    // if board empty, flag should be returned as opposite ie no positions found
    public boolean isEmpty(){
        
        boolean positionFound = false;
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j ++ )
            {                
              if(!arrayBoard[i][j].equals("."))
              {
                  positionFound = true;
              }
            }
        }
        
        return !positionFound;
    }

}
