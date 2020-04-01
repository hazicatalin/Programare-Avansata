/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

import javax.swing.*;

/**
 *
 * @author Hazi Catalin
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    public JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JLabel sidesLabel;
    JComboBox shapeCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String[] x = {"Random", "Black"};
        colorCombo= new JComboBox(x);
        String[] y = {"Regular Polygon", "Node Shape", "Elipse"};
        shapeCombo = new JComboBox(y);
        //create the colorCombo, containing the values: Random and Black
 
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        add(shapeCombo);
    }
}

