//TicTacToe Game

import java.util.ArrayList;

public class TicTacGame
{
    //Variables

    //rows, columns, number of similar cells required to win
    private int n;
    private int m;
    private int k;

    //Total number of cells
    private int noOfCells;

    //Total number of empty cells
    public int noOfEmptyCells;

    //Two arrays to record moves along rows and columns
    ArrayList <Integer> rowMoves = new ArrayList<>();
    ArrayList <Integer> columnsMoves =  new ArrayList<>();
    ArrayList <cell>    whichPlayer = new ArrayList<>();

    //which player's turn
    public cell player;

    // the number of turns played
    private int turn = 0;

    // array to store the state of each cell
    public cell [][] cells;

    // The board state
    public board board;

    //constructor if columns, rows and similar cells are supplied
    public TicTacGame(int n, int m, int k)
    {
        this.n = n;
        this.m = m;
        this.k = k;
        noOfCells = n*m;
        noOfEmptyCells = n*m;

        //initialize board to start
        board = board.INPROGRESS;

        //Create an array of the number of cells (n*m)
        cells = new cell[n][m];
        for (int i = 0; i<n; ++i)
            for(int j = 0; j<m; ++j)
                cells[i][j]=cell.EMPTY;
    }

    //Constructor if rows and columns are supplied, then similar cells are defaulted to 3
    public TicTacGame(int n, int m)
    {
        this.n = n;
        this.m = m;
        k = 3;
        noOfCells = n*m;
        noOfEmptyCells = n*m;

        //initialize board to start
        board = board.INPROGRESS;
        //Create an array of the number of cells (n*m)
        cells = new cell[n][m];
        //Initialize the board with empty cells
        for (int i = 0; i<n; ++i)
            for(int j = 0; j<m; ++j)
                cells[i][j]=cell.EMPTY;
    }

    //Constructor if no rows or columns supplied, then the basic 3x3 game is constructed
    public TicTacGame ()
    {
        n = m = k = 3;
        noOfCells = 9;
        noOfEmptyCells = 9;

        //Create an array of the number of cells (n*m)
        cells = new cell[n][m];

        //initialize board to start
        board = board.INPROGRESS;

        //Initialize the board with empty cells
        for (int i = 0; i<n; ++i)
            for(int j = 0; j<m; ++j)
                cells[i][j]=cell.EMPTY;
    }

    // To get number of rows(n)
    public int getRows (){
        return this.n;
    }

    // To get number of columns(k)
    public int getColumns (){
        return this.m;
    }

    // To get number of similar cells required to win(k)
    public int getSimilars (){
        return this.k;
    }

    // To get total number of cells (n*k)
    public int getCells (){
        return n*m;
    }

    // To get number of turns played
    public int getTurns (){
        return this.turn;
    }

    // To set number of rows (n)
    public void setRows (int n){
        this.n = n;
    }

    // To set number of columns (k)
    public void setColumns (int m){
        this.m = m;
    }

    // To set number of similar cells required (m)
    public void setSimilars (int k){
        this.k = k;
    }

    //returns next player
    private void nextPlayer (){
       this.player = this.player == cell.O ? cell.X : cell.O;
    }

    //set which player X or O goes first
    public void setPlayer (cell player){
        this.player = player ;

    }

    public void play (int i, int j) {
        cells[i][j] = this.player;
        nextPlayer();
        turn++;
        rowMoves.add(i);
        columnsMoves.add(j);
        whichPlayer.add(this.player);
        noOfEmptyCells--;

    }

    public void setBoardState ( board board ){
        this.board = board;
    }

    //To get state of game
    public String getState() {
        return this.board.getState();
    }
}
