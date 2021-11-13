//Declaring cell type(enum) with its states
// O, X, EMPTY


public enum cell {
    //declare constants of cell
    O("0"),
    X("X"),
    EMPTY(" ");

    //instance fields
    public String state;

    cell(String state) {
        this.state = state;
    }
}