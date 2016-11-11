/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdtest;

import java.awt.*;
/**
 *
 * @author Tyler
 */
public class Block extends Rectangle{
    public int groundID;
    public int airID;
    
    public Block(int x, int y, int width, int height, int groundID, int airID){
        setBounds(x, y, width, height);
        this.groundID = groundID;
        this.airID = airID;
        
        
    }
    
    public void draw(Graphics g) {
        if(groundID == Value.groundGrass){
            g.drawImage(Screen.tileset_ground[groundID], x, y, width, height,null);
        }
        else if(groundID == Value.groundRoad){
            g.drawImage(Screen.tileset_stone[groundID],x, y, width, height, null);
            
        }
        if(airID != Value.airAir){
             g.drawImage(Screen.tileset_ground[airID], x, y, width, height, null);
            
        }
        
    }
}
