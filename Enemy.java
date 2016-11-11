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
public class Enemy extends Rectangle{
    public int enemySize = 52;
    public int enemyID = Value.enemyAir; 
    public boolean inGame = false;
    public int xC, yC;
    public int enemyWalk = 0;
    public boolean hasUp = false;
    public boolean hasDown = false;
    public boolean hasRight = false;
    public boolean hasLeft = false;
            
   
    public int up =0, down=1, right=2, left =3;
    public int direction = right;
    
    
    public Enemy(){
       
        
    }
    
    public void spawnEnemy(int enemyID){
         for (int y=0; y <Screen.room.block.length; y++){
             if(Screen.room.block[y][0].groundID == Value.groundRoad){
                 setBounds(Screen.room.block[y][0].x, Screen.room.block[y][0].y, enemySize, enemySize);
                 xC = 0;
                 yC =y;
             }
            
        }
         
         this.enemyID = enemyID;
         inGame = true;
    }
    
    public int walkFrame =0, walkSpeed= 40;
    public void physic(){
        if(walkFrame >= walkSpeed){
            if(direction == right){
                x += 1;
            } else if (direction == up){
                y -= 1;   
            } else if (direction == down){
                y +=1;   
            } else if (direction == left){
                x -=1;
            }
    
            enemyWalk += 1;
            
            if(enemyWalk == Screen.room.blockSize){
                if(direction == right){
                    xC += 1;
                    hasRight = true;
                 } else if (direction == up){
                     yC -= 1;
                     hasUp = true;
                 } else if (direction == down){
                     yC +=1;
                     hasDown = true;
                 }else if(direction == left){
                     xC -= 1;
                     hasLeft = true;
                }
                if(!hasUp){
                    try {
                         if(Screen.room.block[yC+1][xC].groundID == Value.groundRoad){
                            direction = down;
                        }
                    } catch(Exception e){e.printStackTrace();}
                }
                if( !hasDown) {
                     try {
                         if(Screen.room.block[yC-1][xC].groundID == Value.groundRoad){
                            direction = up;
                    
                         }
                     } catch(Exception e){e.printStackTrace();}
                }
                
                if (!hasLeft){
                    try {
                        if(Screen.room.block[yC][xC+1].groundID == Value.groundRoad){
                            direction = right;
                    
                        }
                    } catch(Exception e){e.printStackTrace();}
                }
                 if (!hasRight){
                       try {
                            if(Screen.room.block[yC][xC-1].groundID == Value.groundRoad){
                                direction = right;
                    
                             }
                    } catch(Exception e){e.printStackTrace();}
                }
                 
                hasUp = false;
                hasDown = false;
                hasLeft = false;
                hasRight = false;
                enemyWalk=0;
                
            }
            
            walkFrame =0;
        } else {
            walkFrame += 1;
        }
    }
    
         
         public void draw(Graphics g){
             if(inGame){
                 g.drawImage(Screen.tileset_enemy[enemyID], x, y, width, height, null);
             }
              
         }
        
    
            
            
            
}
