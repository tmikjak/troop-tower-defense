/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towergenocide;

/**
 *
 * @author Tyler Miko, David Huynh, Josh
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.awt.*;


public class GameWindow 
{
    // Declare variables
    private JFrame frame;
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private JButton startButton;
    private JButton exitButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel background;
    private ActionListener exit;
    private ActionListener start;
    
    
    public GameWindow() throws IOException
    {
        // create JFrame
        frame = new JFrame();
        frame.setTitle("Tower Genocide");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        // Main screen buttons and labels
        startButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        
        // Action listeners
        exit = new ExitListener();
        start = new StartListener();
        
        
        ImageIcon tvtbg = new ImageIcon(getClass().getResource("tvtbg.jpg"));
        background = new JLabel(tvtbg);
        
        frame.add(background);

        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        background.add(startButton);
        
        jLabel1.setFont(new Font("STENCIl",40,90));
        jLabel2.setFont(new Font("STENCIL", 40,90));
        
        background.add(jLabel1);        
        background.add(exitButton);
        background.add(jLabel2);
        

        startButton.setText("Start Game");
        startButton.addActionListener(start);

        exitButton.setText("Exit Game");
        exitButton.addActionListener(exit);

        jLabel1.setText("Tower VS Tower ");
        jLabel2.setText("Battleground");  
    }
    
    // Action listener for exit button
    class ExitListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            System.exit(0);
        }
    }
    
    // Action listener for start button
    class StartListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
        }
    }
}
    
