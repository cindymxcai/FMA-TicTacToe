package FMATicTacToe;

public class Player 
{
    public String name;
    public Boolean won;
    public Boolean currentTurn;
    
    public Player(String name, Boolean currentTurn)
    {
        this.won = false;
        this.name = name;
        this.currentTurn = currentTurn;
    }
}
