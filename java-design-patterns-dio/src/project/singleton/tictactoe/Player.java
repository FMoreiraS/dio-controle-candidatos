package tictactoe;

public class Player {
    private String name;
    private boolean movesNow;
    private SpaceMark marker;

    public Player (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getMovesNow() {
        return movesNow;
    }

    public void setMovesNow(boolean movesNow) {
        this.movesNow = movesNow;
    }

    public SpaceMark getMarker() {
        return marker;
    }

    public void setMarker(SpaceMark sign) {
        this.marker = sign;
    }

}
