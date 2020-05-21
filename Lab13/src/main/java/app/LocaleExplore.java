/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Hazi Catalin
 */
public class LocaleExplore {
    
    private final String baseName = "res.Messages";
    private Locale locale= Locale.getDefault();
    private ResourceBundle resourceBundle; 
    ResourceBundle messages = ResourceBundle.getBundle(baseName, locale);
    public static void main ( String [] args ){
        Scanner scanner = new Scanner(System.in);
        String commandName;
        while (true) {
            commandName = scanner.next();
            if (commandName.equalsIgnoreCase("exit")) {
                break;
            }
            if (commandName.equalsIgnoreCase("DisplayLocale")) {
                new DisplayLocales();
            }
            if (commandName.equalsIgnoreCase("SetLocale")) {
                String command2 = scanner.next();
                if (command2.equalsIgnoreCase("english")) {
                    new SetLocale(new Locale("en", "EN"));
                }
                if (command2.equalsIgnoreCase("romana")) {
                    new SetLocale(new Locale("ro", "RO"));
                }
            }
            if (commandName.equalsIgnoreCase("Info")) {
                new Info();
            }
        }
    }
    
    private String message(String key, String ... arguments) {
        String pattern = resourceBundle.getString(key);
        String message = new MessageFormat(pattern).format(arguments);
        return message;
    }
    
}
