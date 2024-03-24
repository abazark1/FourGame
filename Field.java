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
public class Field {
    
    private Color color;
    private int value;
    
    public Field(){
        color = null;
        value = 0;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue() {
        this.value += 1;
    }
    
}
