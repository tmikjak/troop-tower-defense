/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towervstower;

/**
 *
 * @author Tyler
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GameWindow 
{
    private JFrame frame;
    
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    
    public GameWindow() throws IOException
    {
        frame = new JFrame();
        frame.setTitle("Tower Genocide");
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
                
        //frame.setLayout(new BorderLayout());

        JLabel background=new JLabel(new ImageIcon((ImageIO.read(new File("tvtbg.jpg")))));

        frame.add(background);

        background.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        background.add(jButton1);
        jLabel1.setFont(new Font("STENCIl",40,90));
        jLabel2.setFont(new Font("STENCIL", 40,90));
        
        background.add(jLabel1);
        
        background.add(jButton2);
        background.add(jLabel2);
        

        jButton1.setText("Start Game");

        jButton2.setText("Exit Game");

        jLabel1.setText("Tower VS Tower ");
        jLabel2.setText("Battleground");
        
   
        
    }
    }
    