import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.util.Scanner;

public class TheGame {
    public static void main(String[] args) {
        TicTacGame basicGame = new TicTacGame(4, 4, 4);
        printBoard(basicGame.cells, basicGame.getRows(), basicGame.getColumns());
        basicGame.setPlayer(cell.X);
        Scanner input = new Scanner(System.in);
        int i = 0;
        int j = 0;
        while (basicGame.board == board.INPROGRESS) {
            if (basicGame.noOfEmptyCells < (2 * basicGame.getSimilars() - 1)) basicGame.setBoardState(board.DRAW);
            System.out.printf("no of empty cells %d %n",basicGame.noOfEmptyCells);
            i = input.nextInt();
            j = input.nextInt();
            basicGame.play(i, j);
            basicGame.setBoardState(checkWin(basicGame.cells,4,4,4,i,j));
            printBoard(basicGame.cells, basicGame.getRows(), basicGame.getColumns());
        }
        System.out.printf("Board result: %s%n",basicGame.getState());


    }


    //To print the board
    static void printBoard(cell[][] cells, int rows, int columns) {
        System.out.printf(" |");
        for (int i = 0; i < columns; ++i) {
            System.out.printf("%d|", i);
        }
        System.out.printf("%n");
        for (int i = 0; i < rows; ++i) {
            System.out.printf("%d|", i);
            for (int j = 0; j < columns; ++j)
                System.out.printf(cells[i][j].state + "|");
            System.out.printf("%n");
        }

    }

    // To check if there are k similar cells aligned horizontally
    static board horizontal(int i, int j, int k, cell[][] cells)
    {

        int count = 1;
        System.out.printf("count is %s%n",count);
        while (count <= k-1) {
            if (cells[i][j+count] == cell.EMPTY) return board.INPROGRESS;
            if (cells[i][j] == cells[i][j + count]) count++;
            else {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    // To check if there are k similar cells aligned vertically
    static board vertical(int i, int j, int k, cell[][] cells) {
        int count = 1;
        if (cells[i+count][j] == cell.EMPTY) return board.INPROGRESS;
        while (count <= k-1) {
            if (cells[i][j] == cells[i+count][j]) count++;
            else {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    // To check if there are k similar cells aligned diagonally downward
    static board downDiagonal(int i, int j, int k, cell[][] cells)
    {
        int count = 1;
        while (count <= k-1)
        {
            if (cells[i + count][j + count] == cell.EMPTY) return board.INPROGRESS;
            if (cells[i][j] == cells[i + count][j + count]) count++;
            else {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    //To check if there are k similar cells aligned diagonally upward
    static board upDiagonal(int i, int j, int k, cell[][] cells)
    {
        int count = 1;
        while (count <= k-1)
        {
            if (cells[i - count][j + count] == cell.EMPTY) return board.INPROGRESS;
            if (cells[i][j] == cells[i - count][j + count]) count++;
            else
            {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    //To check if there are k similar cells aligned diagonally upward in the opposite direction
    static board oppUpDiagonal(int i, int j, int k, cell[][] cells)
    {
        int count = 1;
        while (count <= k-1)
        {
            if (cells[i - count][j - count] == cell.EMPTY) return board.INPROGRESS;
            if (cells[i][j] == cells[i - count][j - count]) count++;
            else
            {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    //To check if there are k similar cells aligned diagonally downward in the opposite direction
    static board oppDownDiagonal(int i, int j, int k, cell[][] cells)
    {
        int count = 1;
        while (count <= k-1)
        {
            if (cells[i + count][j - count] == cell.EMPTY) return board.INPROGRESS;
            if (cells[i][j] == cells[i + count][j - count]) count++;
            else
            {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    }

    //To check if there's a winner
    static board checkWin(cell[][] cells, int n, int m, int k, int i, int j)
    {
        board result = board.INPROGRESS;
        if (i<n-k+1) result = horizontal(i, j, k, cells);
        if (result != board.INPROGRESS) return result;
        if (j<m-k+1) result = vertical(i, j, k,cells);
        if (result != board.INPROGRESS) return result;
        if (n-k+1>i && m-k+1>j) result = downDiagonal(i, j, k, cells);
        if (result != board.INPROGRESS) return result;
        if (i>k-2 && j<m-k+1) result = upDiagonal(i, j, k, cells);
        if (result != board.INPROGRESS) return result;
        if (i > k-2 && j>k-2) result = oppUpDiagonal(i, j , k, cells);
        if (result != board.INPROGRESS) return result;
        if (i<n-k+1 && j>k-2) result = oppDownDiagonal(i, j ,k, cells);
        return result;


    }


}










