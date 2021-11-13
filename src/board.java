//Declaring board type(enum) with its states
//INPROGRESS, DRAW, WIN_X, WIN_O


public enum board {
    //declare constants of board
    INPROGRESS("The game is being played"),
    DRAW("The result of the game is draw"),
    WIN_X("Player X won the game"),
    WIN_O("Player O won the game");

    public String state;
    //instance fields


    board(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
