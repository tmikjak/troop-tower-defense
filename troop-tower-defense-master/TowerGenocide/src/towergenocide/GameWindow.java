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
import sun.audio.*;


public class GameWindow 
{
    // Declare variables
    private JFrame frame;
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private JButton startButton;
    private JButton exitButton;
    private JLabel jLabel1, jLabel2;
    private JLabel background;
    private ActionListener exit;
    private ActionListener start;
    private JLabel gameBackground;
    private JButton allies;
    private JButton axis;
    
    
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
        jLabel2 = new JLabel();
        exitButton = new JButton();
        startButton.setPreferredSize(new Dimension(500, 200));
        exitButton.setPreferredSize(new Dimension(500, 200));
        
        //For the Second Game Menu
        allies = new JButton();
        allies.setPreferredSize(new Dimension(500, 200));
        
        //allies.setBackground(Color.red)
        
        axis = new JButton();
        axis.setPreferredSize(new Dimension(500, 200));
        
        
        // Action listeners
        exit = new ExitListener();
        start = new StartListener();
        
        // play menu music
        music();
        
        ImageIcon tvtbg = new ImageIcon(getClass().getResource("tvtbg.jpg"));
        background = new JLabel(tvtbg);
        
        ImageIcon gbg = new ImageIcon(getClass().getResource("warGround.png"));
        gameBackground = new JLabel(gbg);
        
        frame.add(background);

        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        gameBackground.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //background.add(startButton);
        
        jLabel1.setFont(new Font("STENCIl",40,90));
        
        jLabel1.setText("<html>Tower VS Tower<br> Battleground</html>");
        //jLabel1.
        
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
        
        /*FACTION BUTTONS
         *
         * Will Need to set them to Start Game
         * Spawn Tower Graphics
         * Open Game Menu for Troops
         *
         */
        
        jLabel2.setFont(new Font("STENCIl",40,90));
        jLabel2.setText("<html>Choose Your Faction<br></html>");
        
        allies.setText("ALLIES");
        allies.setFont(new Font("Arial", Font.PLAIN, 40));
        allies.setContentAreaFilled(false);
        allies.setBorderPainted(false);
        allies.setFocusPainted(false);
        
        axis.setText("AXIS");
        axis.setFont(new Font("Arial", Font.PLAIN, 40));
        axis.setContentAreaFilled(false);
        axis.setBorderPainted(false);
        axis.setFocusPainted(false);
       
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        gamePanel.add(jLabel2, BorderLayout.NORTH);
        gamePanel.add(allies, BorderLayout.CENTER);
        gamePanel.add(axis, BorderLayout.SOUTH);
        gameBackground.add(gamePanel);

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
            frame.add(gameBackground);
            frame.revalidate();
            frame.repaint();
        }
    }

    
     public static void music() {
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
            ContinuousAudioDataStream loop = null;
            
            try {
                
                InputStream test = new FileInputStream("battleTheme.wav");
                BGM = new AudioStream(test);
                AudioPlayer.player.start(BGM);
                MD = BGM.getData();
                loop = new ContinuousAudioDataStream(MD);
                
            }
            catch(FileNotFoundException e){
                System.out.printf(e.toString());
            }
            
            catch (IOException error){
                System.out.print(error.toString());
            }
            MGP.start(loop);
            
        };
}