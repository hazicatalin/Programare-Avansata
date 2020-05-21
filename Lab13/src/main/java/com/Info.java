/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Hazi Catalin
 */
public class Info {
    Locale locale;
    public Info(){
        String baseName = "res.Messages";
        locale = Locale.getDefault();
        ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
        System.out.println(messages.getString("country"));
        System.out.println(messages.getString("language"));
        System.out.println(messages.getString("currency"));
        System.out.println(messages.getString("week days"));
        System.out.println(messages.getString("months"));
        System.out.println(messages.getString("today"));
        
    }
}
