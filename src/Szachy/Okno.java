

package Szachy;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mack
 */
public class Okno extends JFrame {

   private Szachownica szachownica=new Szachownica();


    public Okno(){

        setLayout(new GridLayout(2,3));
        setSize(500,1000);
        szachownica.StworzIUstawFigury();
        szachownica.setListenerForAll();
        this.setResizable(false);
        add(szachownica);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        repaint();

    }

}


