/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Hazi Catalin
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
 
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        
 
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("G:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    BufferedImage img = null;
    private void load(ActionEvent e) {
        try {
            img = ImageIO.read(new File("G:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        try {
            frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
            frame.canvas.graphics.fillRect(0, 0, 800, 600);
        } catch (Exception ex) { System.err.println(ex); }
    }

    private void exit(ActionEvent e) {
        System.exit(0);
       
    }
}
