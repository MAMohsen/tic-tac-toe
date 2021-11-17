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
            if (basicGame.noOfEmptyCells == 0) {
                basicGame.setBoardState(board.DRAW);
                break;
            }
            System.out.printf("no of empty cells %d %n",basicGame.noOfEmptyCells);
            i = input.nextInt();
            j = input.nextInt();
            if(basicGame.cells[i][j] != cell.EMPTY)
            {
                System.out.println("Please, enter an empty cell!");
                continue;
            }
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
    static board horizontal(int i, int j, int k, int m, cell[][] cells)
    {
     int score = 1;
     //To check the number of similar cells along the horizontal line to the left
     for (int count = 1; count <= k; ++count)
     {
         if(j-count < 0 ) break;
         if(cells[i][j-count] == cell.EMPTY) break;
         if(cells[i][j] == cells[i][j-count]) score++;
         else break;
     }
     //To check the number of similar cells along the horizontal line to the right
     for (int count = 1 ;score <k; ++count )
     {
         if(j+count >= m ) break;
         if(cells[i][j+count] == cell.EMPTY) break;
         if(cells[i][j] == cells[i][j+count]) score++;
         else break;
     }
     if (score == k) return cells[i][j] == cell.X?board.WIN_X:board.WIN_O;
     return board.INPROGRESS;
    }
    /* static board horizontal(int i, int j, int k, cell[][] cells)
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
    } */

    // To check if there are k similar cells aligned vertically
    static board vertical(int i, int j, int k, int n, cell[][] cells)
    {
        int score = 1;
        // for loop to check for the similar cells moving upward along the board
        for (int count = 1; count < k; ++count)
        {
            if (i - count < 0) break;
            if(cells[i-count][j] == cell.EMPTY) break;
            if (cells[i][j] == cells[i-count][j]) score++;
            else break;
        }
        // for loop to check for the similar cells moving downward along the board
        for (int count = 1; score <k;++count)
        {
            if(i+count >= n ) break;
            if(cells[i+count][j] == cell.EMPTY) break;
            if (cells[i][j] == cells[i+count][j]) score++;
            else break;
        }
        if (score >= k) return cells[i][j] == cell.X? board.WIN_X: board.WIN_O;
        System.out.printf("Vertical score %d%n", score);
        return board.INPROGRESS;
    }
    /* static board vertical(int i, int j, int k, cell[][] cells) {
        int count = 1;
        if (cells[i+count][j] == cell.EMPTY) return board.INPROGRESS;
        while (count <= k-1) {
            if (cells[i][j] == cells[i+count][j]) count++;
            else {
                return board.INPROGRESS;
            }
        }
        return cells[i][j] == cell.X ? board.WIN_X : board.WIN_O;
    } */

    /*// To check if there are k similar cells aligned diagonally downward
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
    } */

    //To check if there are k similar cells aligned diagonally from the bottom left to the top right

    static board leftToRightDiagonal(int i, int j, int k, int n, int m,cell cells[][] )
    {
        int score = 1;
       for (int count = 1 ; count<k; ++count)
       {
           if(i-count<0 || j+count ==m) break;
           if(cells[i][j]==cells[i-count][j+count]) score++;
           else break;
       }
       for (int count = 1; score<k; ++count)
       {
           if(i+count == n || j-count<0) break;
           if(cells[i][j] == cells[i+count][j-count]) score++;
           else break;
       }
        if (score >= k) return cells[i][j] == cell.X? board.WIN_X: board.WIN_O;
        System.out.printf("leftToRightDiagonal %d%n", score);
        return board.INPROGRESS;
    }


    //To check if there a k similar cells aligned diagonally from the bottom right to the top left
    static board rightToLeftDiagonal(int i, int j, int k, int n, int m, cell cells[][])
    {
        int score = 1;
        for(int count =1; count<k; ++count)
        {
            if(i-count<0 || j-count<0) break;
            if(cells[i][j] == cells[i-count][j-count]) score++;
            else break;
        }
        for(int count = 1; score<k;++count)
        {
            if( i+count == n || j+count == m) break;
            if(cells[i][j] == cells[i+count][j+count]) score++;
            else break;
        }
        if (score >= k) return cells[i][j] == cell.X? board.WIN_X: board.WIN_O;
        System.out.printf("RightToLeft: %d%n", score);
        return board.INPROGRESS;
    }
   /* static board upDiagonal(int i, int j, int k, cell[][] cells)
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
    */


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
        //if (i<n-k+1) result = horizontal(i, j, k, cells);
        result = horizontal(i, j, k,m, cells);
        if (result != board.INPROGRESS) return result;
        //if (j<m-k+1) result = vertical(i, j, k,cells);
        result = vertical(i, j, k,n,cells);
        if (result != board.INPROGRESS) return result;
        result = leftToRightDiagonal(i,j,k,n,m,cells);
        if (result != board.INPROGRESS) return result;
        result = rightToLeftDiagonal(i,j,k,n,m,cells);
        /*if (n-k+1>i && m-k+1>j) result = downDiagonal(i, j, k, cells);
        if (result != board.INPROGRESS) return result;
        if (i>k-2 && j<m-k+1) result = upDiagonal(i, j, k, cells);
        if (result != board.INPROGRESS) return result;
        if (i > k-2 && j>k-2) result = oppUpDiagonal(i, j , k, cells);
        if (result != board.INPROGRESS) return result;
        if (i<n-k+1 && j>k-2) result = oppDownDiagonal(i, j ,k, cells);*/
        return result;


    }


}










