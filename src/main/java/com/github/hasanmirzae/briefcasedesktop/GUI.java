package com.github.hasanmirzae.briefcasedesktop;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JButton shutdownBtn = new JButton("Shutdown");
    private JButton launchBtn = new JButton("Open in browser");


    public GUI(String title, String icon) throws HeadlessException {
        super(title);
        setPreferredSize(new Dimension(500, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon(icon);
        setIconImage(img.getImage());

        getContentPane().setLayout( new FlowLayout());

        getContentPane().add(shutdownBtn);
        getContentPane().add(launchBtn);

    }


    public void showWindow(){
        //Display the window.
        pack();
        setVisible(true);
    }


    public JButton getShutdownBtn(){
        return shutdownBtn;
    }

    public  JButton getLaunchBtn(){
        return launchBtn;
    }
}
