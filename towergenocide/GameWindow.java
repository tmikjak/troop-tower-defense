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
        startButton = new JButton();
        jLabel1 = new JLabel();
        exitButton = new JButton();
        startButton.setPreferredSize(new Dimension(500, 200));
        exitButton.setPreferredSize(new Dimension(500, 200));
        
        
        // Action listeners
        exit = new ExitListener();
        start = new StartListener();
        
        
        ImageIcon tvtbg = new ImageIcon(getClass().getResource("tvtbg.jpg"));
        background = new JLabel(tvtbg);
        
        frame.add(background);

        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //background.add(startButton);
        
        jLabel1.setFont(new Font("STENCIl",40,90));
        
        //background.add(jLabel1);        
        //background.add(exitButton);
        //background.add(jLabel2);
        //background.add(startButton);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(jLabel1, BorderLayout.NORTH);
        //buttonPanel.add(jLabel2, BorderLayout.NORTH);
        buttonPanel.add(startButton, BorderLayout.CENTER);
        buttonPanel.add(exitButton, BorderLayout.SOUTH);
        background.add(buttonPanel);

        startButton.setText("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 40));
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(start);

        exitButton.setText("Exit Game");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 40));
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(exit);

        jLabel1.setText("<html>Tower VS Tower<br> Battleground</html>");
        //jLabel1.
  
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
    
