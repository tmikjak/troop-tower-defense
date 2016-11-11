/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdtest;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;


/**
 *
 * @author Tyler
 */
public class Screen extends JPanel implements Runnable {
    
   public Thread thread = new Thread(this);
   
   public static Image[] tileset_ground = new Image[100];
   public static Image[] tileset_air = new Image[100];
   public static Image[] tileset_stone = new Image[100];
   public static Image[] tileset_res = new Image[100];
   public static Image[] tileset_enemy = new Image[100];
   
   public static int myWidth, myHeight;
   public static int money =10, health = 100;
   
   
   public static boolean isFirst = true;
   
   
   public static Point mse = new Point(0,0);
   
   public static Room room;
   public static Save save;
   public static Store store;
   
   public static Enemy[] enemies = new Enemy[100];
   
    public Screen(Frame frame) {
        
        frame.addMouseListener(new keyHandle());
        frame.addMouseMotionListener(new keyHandle());
        thread.start();
        
    }
    
    public void define() {
        room = new Room();
        save = new Save();
        store = new Store();
        
      
        
        for(int i=0; i < tileset_ground.length; i++){
            tileset_ground[i] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\tileset_ground.png").getImage();
            tileset_ground[i] = createImage(new FilteredImageSource(tileset_ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
             
        }
         for(int i=0; i < tileset_air.length; i++){
            tileset_air[i] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\tileset_air.png").getImage();
            tileset_air[i] = createImage(new FilteredImageSource(tileset_air[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
            
        }
          for(int i=0; i < tileset_stone.length; i++){
            tileset_stone[i] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\stoneTile.png").getImage();
            tileset_stone[i] = createImage(new FilteredImageSource(tileset_stone[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
            
        }
          
          tileset_res[0] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\cell.png").getImage(); 
          tileset_res[1] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\health.png").getImage();
          tileset_res[2] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\coins.png").getImage();
          tileset_enemy[0] = new ImageIcon("F:\\testGame\\tdTest\\src\\res\\trumpHead.png").getImage();
          
          
         try {
            save.loadSave(new File("F:\\testGame\\tdTest\\src\\save\\level1.tyler"));
         }
         catch(Exception e){
             e.printStackTrace();
         }
         
          for(int i=0; i<enemies.length; i++){
            enemies[i] = new Enemy();
            
            
        }
         
         
    }
    
   @Override
    public void paintComponent(Graphics g){
        
        if(isFirst){
            myWidth = getWidth();
            myHeight = getHeight();
            
            define();
            isFirst = false;
        }
        
        g.setColor(new Color(230,0,0));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(0,0,230)); 
        //drawing the left line border
        g.drawLine(room.block[0][0].x-1, 0, room.block[0][0].x-1, room.block[room.worldHeight-1][0].y +room.blockSize); 
        //drawing the right line border
        g.drawLine(room.block[0][room.worldWidth-1].x +room.blockSize, 0, room.block[0][room.worldWidth-1].x + room.blockSize, room.block[room.worldHeight-1][0].y +room.blockSize );
        // draw botton line border
        g.drawLine(room.block[0][0].x, room.block[room.worldHeight-1][0].y +room.blockSize,room.block[0][room.worldWidth-1].x +room.blockSize , room.block[room.worldHeight-1][0].y +room.blockSize);
      
        
        room.draw(g); //draw the room
        
        for (int i=0; i <enemies.length; i++){
            if(enemies[i].inGame){
                enemies[i].draw(g);
            }
            
            
        }
        
        store.draw(g); // draw the store
        
    }
    
    public int spawnTime = 2400, spawnFrame =0;
    public void enemySpawner(){
        if(spawnFrame >= spawnTime){
            for (int i=0; i < enemies.length; i++){
                if(!enemies[i].inGame){
                    enemies[i].spawnEnemy(Value.enemyGreen);
                    break;
                }
                
            }
            
            spawnFrame =0; 
        }
        else {
            spawnFrame +=1;
        }
        
    }
    
    
   @Override
    public void run (){
        while(true){
            if(!isFirst){
                room.physic();
                enemySpawner();
                for(int i=0; i < enemies.length;i++){
                    enemies[i].physic();
                }
            }
            repaint();
            
            try {
                Thread.sleep(1);
            }
            catch (Exception e) {
                
            }
        }
        
    }
    
}
