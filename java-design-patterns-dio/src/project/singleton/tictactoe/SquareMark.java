package tictactoe;

public enum SquareMark {
    VOID (" "),
    X ("X"),
    O ("O");

    private String mark;

    SquareMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
