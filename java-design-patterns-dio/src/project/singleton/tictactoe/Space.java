package tictactoe;

public class Space {
    public boolean isMarked;
    public SquareMark mark;
    
    public Space () {
        this.mark = SquareMark.VOID;
    }
    
    public boolean isMarked() {
        return isMarked;
    }
    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }
    public SquareMark getMark() {
        return mark;
    }
    public void setMark(SquareMark mark) {
        this.mark = mark;
    }

    

}
