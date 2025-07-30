package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static List<List<Space>> rows = new ArrayList<>();

    private static Board instancia = new Board();
	
	private Board() {
		super();
	}
    
    public static void showBoard() {
        List<Space> row1 = rows.get(0);
        List<Space> row2 = rows.get(1);
        List<Space> row3 = rows.get(2);
        System.out.println("   1     2     3  ");
        System.out.printf("1  %s  |  %s  |  %s  \n",
        getSquareMark(row1, 1),
        getSquareMark(row1, 2),
        getSquareMark(row1, 3));
        System.out.println(" ---- ----- -----");
        System.out.printf("2  %s  |  %s  |  %s  \n",
        getSquareMark(row2, 1),
        getSquareMark(row2, 2),
        getSquareMark(row2, 3));
        System.out.println(" ---- ----- -----");
        System.out.printf("3  %s  |  %s  |  %s  \n",
        getSquareMark(row3, 1),
        getSquareMark(row3, 2),
        getSquareMark(row3, 3));
        // System.out.println("---1-----2-----3--");
    }
    
    public static void markSquare(int row, int column, SquareMark mark) {
        List<Space> row1 = rows.get(0);
        List<Space> row2 = rows.get(1);
        List<Space> row3 = rows.get(2);
        
        if (row == 1) {
            if (column == 1) {
                row1.get(0).setMark(mark);
            } else if (column == 2) {
                row1.get(1).setMark(mark);
            } else {
                row1.get(2).setMark(mark);
            }
        } else if (row == 2) {
            if (column == 1) {
                row2.get(0).setMark(mark);
            } else if (column == 2) {
                row2.get(1).setMark(mark);
            } else {
                row2.get(2).setMark(mark);
            }
        } else {
            if (column == 1) {
                row3.get(0).setMark(mark);
            } else if (column == 2) {
                row3.get(1).setMark(mark);
            } else {
                row3.get(2).setMark(mark);
            }
        }
    }
    
    public static void createNew () {
        List<Space> row1 = new ArrayList<>();
        List<Space> row2 = new ArrayList<>();
        List<Space> row3 = new ArrayList<>();
        row1.add(new Space());
        row1.add(new Space());
        row1.add(new Space());
        row2.add(new Space());
        row2.add(new Space());
        row2.add(new Space());
        row3.add(new Space());
        row3.add(new Space());
        row3.add(new Space());
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
    }

    public static SquareMark verifyVictory() {
        SquareMark winnerMark = SquareMark.VOID;
        List<Space> row1 = rows.get(0);

        SquareMark r1S1 = row1.get(0).getMark();
        SquareMark r1S2 = row1.get(1).getMark();
        SquareMark r1S3 = row1.get(2).getMark();
        
        List<Space> row2 = rows.get(1);
        SquareMark r2S1 = row2.get(0).getMark();
        SquareMark r2S2 = row2.get(1).getMark();
        SquareMark r2S3 = row2.get(2).getMark();
       
        List<Space> row3 = rows.get(2);
        SquareMark r3S1 = row3.get(0).getMark();
        SquareMark r3S2 = row3.get(1).getMark();
        SquareMark r3S3 = row3.get(2).getMark();

        if (r1S1.equals(r1S2) && r1S2.equals(r1S3)) {
            winnerMark = r1S1;
        } else if (r2S1.equals(r2S2) && r2S2.equals(r2S3)) {
            winnerMark = r2S1;
        } else if (r3S1.equals(r3S2) && r3S2.equals(r3S3)) {
            winnerMark = r3S1;
        } else if (r1S1.equals(r2S2) && r2S2.equals(r3S3)) {
            winnerMark = r1S1;
        } else if (r1S1.equals(r2S1) && r2S1.equals(r3S1)) {
            winnerMark = r1S1;
        } else if (r1S2.equals(r2S2) && r2S1.equals(r3S2)) {
            winnerMark = r1S2;
        } else if (r1S3.equals(r2S3) && r2S3.equals(r3S3)) {
            winnerMark = r1S3;
        } else if (r1S3.equals(r2S2) && r2S2.equals(r3S1)) {
            winnerMark = r1S3;
        }
        return winnerMark;
    }
    
    public static List<List<Space>> getRows() {
        return rows;
    }
    
    private static String getSquareMark(List<Space> row, int square) {
        return row.get(square - 1).getMark().getMark();
    }

    public static Board getInstancia() {
        return instancia;
    }
}
