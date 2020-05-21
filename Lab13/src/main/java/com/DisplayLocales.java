/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.Locale;

/**
 *
 * @author Hazi Catalin
 */
public class DisplayLocales {
    public DisplayLocales(){
        System.out.println("Available locales:");
        Locale available[] = Locale.getAvailableLocales();
        for(Locale locale : available) {
            locale.getDisplayCountry();
            locale.getDisplayLanguage(locale);
        }
    }

}
