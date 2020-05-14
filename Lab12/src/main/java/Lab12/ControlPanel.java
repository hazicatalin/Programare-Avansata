/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;


/**
 *
 * @author Hazi Catalin
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JTextField text = new JTextField("Enter class name");
    JButton createButton = new JButton("Create");  

    ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        text.setBounds(5,5,200,50);
        add(text);
        add(createButton);
        createButton.addActionListener(this::create);
    }

    private void create(ActionEvent e) {
        String string = text.getText();
        JButton btn = new JButton();
        try{
            frame.designPanel.addAtRandomLocation( btn);
        }catch(Exception ex){
            System.out.println("Exceptie");
        }
    }
    
    
}
