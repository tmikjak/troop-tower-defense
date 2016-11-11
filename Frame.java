/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdtest;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Tyler
 */
public class Frame extends JFrame {

   public static String title = "Clash of Candidates";
   public static Dimension size = new Dimension(1000, 700);
    
    public Frame() {
        setTitle(title);
        setSize(size);
        setResizable(false);
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
    }
    
    
    
    public void init() {
        setLayout(new GridLayout(1,1,0,0));
        
        Screen screen = new Screen(this);
        add(screen);
        
        setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Frame frame = new Frame();
    }
    
  
    
}
