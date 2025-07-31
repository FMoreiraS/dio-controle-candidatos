package tictactoe;

public class Space {
    public boolean isMarked;
    public SpaceMark mark;
    
    public Space () {
        this.mark = SpaceMark.VOID;
    }
    
    public boolean isMarked() {
        return isMarked;
    }
    public void setMarked(boolean isMarked) {
        this.isMarked = isMarked;
    }
    public SpaceMark getMark() {
        return mark;
    }
    public void setMark(SpaceMark mark) {
        this.mark = mark;
    }

    

}
