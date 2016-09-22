/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towergenocide;

/**
 *
 * @author David Huynh
 */

import javax.swing.JFrame;

public class GameWindow 
{
    private JFrame frame;
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    
    public GameWindow()
    {
        frame = new JFrame();
        frame.setTitle("Tower Genocide");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }
    
}
