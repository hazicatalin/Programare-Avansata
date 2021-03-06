/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Hazi Catalin
 */
public class DrawingPanel extends JPanel{
    final MainFrame frame;
    final static int W = 800, H = 600;
    
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(180); //generate a random number
        int sides = (int) frame.configPanel.sidesField.getValue(); //get the value from UI (in ConfigPanel)
          Color color;//create a transparent random Color.
        if(frame.configPanel.colorCombo.getSelectedItem() != "Black"){
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
        else
            color = new Color(0, 0, 0);
            
            graphics.setColor(color);
        if(frame.configPanel.shapeCombo.getSelectedItem() == "Regular Polygon"){
            RegularPolygon rp = new RegularPolygon(x, y, radius, sides);
            graphics.fill(rp);
        }
        if(frame.configPanel.shapeCombo.getSelectedItem() == "Node Shape"){
            NodeShape ns = new NodeShape(x, y, radius);
            graphics.fill(ns);
        }
        if(frame.configPanel.shapeCombo.getSelectedItem() == "Elipse"){
            Elipse el = new Elipse(x, y, radius);
            graphics.fill(el);
        }
    }
    @Override
    public void update(Graphics g) { } //Why did I do that?

    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

