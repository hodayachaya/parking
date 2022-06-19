/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverparking;

/**
 *
 * @author student
 */
public class Place {

    private int row;
    private char col;
    boolean isCatch;

    public Place() {
        
    }

    public Place(int row, char col, boolean isCatch) {
        this.row = row;
        this.col = col;
        this.isCatch = isCatch;
    }

    public int getRow() {
        return row;
    }

    public char getCol() {
        return col;
    }

    public boolean isIsCatch() {
        return isCatch;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public void setIsCatch(boolean isCatch) {
        this.isCatch = isCatch;
    }
    

}
