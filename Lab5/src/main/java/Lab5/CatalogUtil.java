/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

/**
 *
 * @author Hazi Catalin
 */
public class CatalogUtil {
    public static void save(Catalog catalog)
    throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
        catch(Exception ex){
            System.out.println("Exception is caught:");
            System.out.println(ex.toString());
        }
    }
    public static Catalog load(String path)
    throws InvalidCatalogException {
        try{
        }
        catch(Exception ex){
            System.out.println("Exception is caught:" );
            System.out.println(ex.toString());
        }
        return null;
    }
    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        //… browse or open, depending of the location type
        try{
            desktop.open(new File(doc.getLocation()));
        }
        catch(Exception ex){
            System.out.println("Exception is caught:" );
            System.out.println(ex.toString());
        }
    }

}
