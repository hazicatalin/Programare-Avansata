/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.util.*;
/**
 *
 * @author Hazi Catalin
 */
public class InvalidCatalogException extends Exception{
    public InvalidCatalogException(Exception ex) {
        super("Invalid catalog file.", ex);
    }

    
}
