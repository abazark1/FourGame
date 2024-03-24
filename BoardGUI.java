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
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardGUI {
    private JButton[][] buttons;
    private Board board;
    private JPanel boardPanel;
    
    public BoardGUI(int boardSize) {
        board = new Board(boardSize);
        boardPanel = new JPanel();
        buttons = new JButton[board.getBoardSize()][board.getBoardSize()];
        boardPanel.setLayout(new GridLayout(board.getBoardSize(), board.getBoardSize()));
        
        for(int i = 0; i < board.getBoardSize(); i++){
            for(int j = 0; j < board.getBoardSize(); j++){
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(80, 40));
                final int x = i;
                final int y = j;
                button.addActionListener(e -> ButtonListener(x, y));
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }

    }
    
    public JPanel getBoardPanel() {
        return boardPanel;
    }
    
    private void ButtonListener(int x, int y){
        Field field = board.increaseValue(x, y);
        buttons[x][y].setText(String.valueOf(field.getValue()));
        if(field.getValue() < 4){
            increaseAdj(x, y);
        }
        
        if(field.getValue() == 4){
            buttons[x][y].setEnabled(false);
            field.setColor((board.getCurrentPlayer() == Player.RED) ? Color.RED : Color.BLUE);
            buttons[x][y].setBackground(field.getColor());
            increaseAdj(x, y);
        }
        
        if (board.isOver()) {
            Player winner = board.getWinner();
            JOptionPane.showMessageDialog(boardPanel, "The winner is " + winner + ".", "Congrats!",
                            JOptionPane.PLAIN_MESSAGE);
            resetGame();
        }
    }
    
    public void increaseAdj(int x, int y){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
       
        for(int i = 0; i < 4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
           
            if(newX >= 0 && newX < board.getBoardSize() && newY >= 0 && newY < board.getBoardSize()){
                Field adjField = board.increaseValue(newX, newY);
                buttons[newX][newY].setText(String.valueOf(adjField.getValue()));
               
                if(adjField.getValue() == 4 && adjField.getColor() == null){
                    buttons[newX][newY].setEnabled(false);
                    adjField.setColor((board.getCurrentPlayer() == Player.RED) ? Color.RED : Color.BLUE);
                    buttons[newX][newY].setBackground(adjField.getColor());
                } 
                
            }
        }
        board.changePlayer();
    }
    
    public void resetGame() {
        board = new Board(board.getBoardSize());
        
        for(int i = 0; i < board.getBoardSize(); i++){
            for(int j = 0; j < board.getBoardSize(); j++){
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setBackground(null);
            }
        }
    }
}

