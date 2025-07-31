package tictactoe;

public enum SpaceMark {
    VOID (" "),
    X ("X"),
    O ("O");

    private String mark;

    SpaceMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
