/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fourgame;

/**
 *
 * @author user
 */

import java.awt.Color;

public class Board {
    
    private Field board[][];
    private final int boardSize;
    private Player currentPlayer;
    
    public Board(int boardSize){
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                board[i][j] = new Field();
            }
        }
        currentPlayer = Player.RED;
    }
    
    public boolean isOver() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j].getValue() != 4) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Player getWinner(){
        int countRed = 0;
        int countBlue = 0;
        
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if(board[i][j].getColor() == Color.RED){
                    countRed++;
                } else {
                    countBlue++;
                }
            }
        }
        return (countRed > countBlue) ? Player.RED : Player.BLUE;
    }
    
    public Field increaseValue(int x, int y){
        if(board[x][y].getValue() < 4){
            board[x][y].setValue();
        }
        return board[x][y];
    }
    
    public Field get(int x, int y) {
        return board[x][y];
    }
    
    public int getBoardSize() {
        return boardSize;
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public void changePlayer(){
        currentPlayer = (currentPlayer == Player.RED) ? Player.BLUE : Player.RED;
    }
}
