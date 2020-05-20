/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Hazi Catalin
 */
public class DesignPanel extends JPanel{
    final MainFrame frame;
    Random rand = new Random();
    int wd = 500;
    int ht = 900;
    
    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(wd, ht));
        setLayout(null);
    }
        
    public void addAtRandomLocation(JComponent comp) {
        int x = rand.nextInt(wd-1);//create a random integer between 0 and W-1
        int y = rand.nextInt(ht-1);//create a random integer between 0 and H-1
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
    
}
