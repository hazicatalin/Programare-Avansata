/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab12;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author Hazi Catalin
 */
public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JTextField text1 = new JTextField(30);
    private final JButton createButton = new JButton("Create");  
    private final JLabel nameLabel = new JLabel("Class name");
    private final JTextField text2 = new JTextField(30);
    private final JLabel textLabel = new JLabel("component name");


    ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        text1.setBounds(10,10,200,50);
        add(nameLabel);
        add(text2);
        add(textLabel);
        add(text1);
        add(createButton);
        createButton.addActionListener(e -> {
            JComponent comp;
            comp = create(text2.getText());
            if (comp != null) {
                setText(comp);
                frame.designPanel.addAtRandomLocation(comp);
            }
        });
    }
    
    private JComponent create(String className) {
        try {
            Class myclass = Class.forName(className);
            return (JComponent) myclass.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex){}
        return null;
    }


    
    private void setText(JComponent comp) {
        String txt = text1.getText();
        Class myclass = comp.getClass();
        Method a;
        try {
            a = myclass.getMethod("setText", String.class);
            a.invoke(comp, txt);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {}
        catch (IllegalArgumentException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
}
