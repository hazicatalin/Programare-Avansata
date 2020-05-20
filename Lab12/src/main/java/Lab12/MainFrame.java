/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Hazi Catalin
 */
public class MainFrame extends JFrame {
    public static void main(String[] args){
        new MainFrame().setVisible(true);
    }
    ControlPanel controlPanel;
    DesignPanel designPanel;

    public MainFrame() {
        super("Dynamic Swing Designer");
        init();
    }
     private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        designPanel = new DesignPanel(this);
        controlPanel= new ControlPanel(this);
        add(controlPanel, BorderLayout.NORTH);
        add(designPanel, BorderLayout.CENTER);
        pack();
    }
}
