/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdtest;

import java.io.*;
import java.util.*;
/**
 *
 * @author Tyler
 */
public class Save {
    public void loadSave(File loadPath){
        try {
            Scanner loadScanner = new Scanner(loadPath);
        
            while (loadScanner.hasNext()){
            for(int y=0; y < Screen.room.block.length; y++){
                for(int x=0; x < Screen.room.block[0].length; x++){
                    Screen.room.block[y][x].groundID = loadScanner.nextInt();
              }
            }
            for(int y=0; y < Screen.room.block.length; y++){
                for(int x=0; x < Screen.room.block[0].length; x++){
                    Screen.room.block[y][x].airID = loadScanner.nextInt();
              }
            }
            
        }
        loadScanner.close();
    }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
