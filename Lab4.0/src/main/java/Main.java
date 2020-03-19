/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.stream.IntStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author Hazi Catalin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Resident> residentList = new ArrayList<>();
        var r = IntStream.rangeClosed(0, 3)
                         .mapToObj(i -> new Resident("R" + i) )
                         .toArray(Resident[]::new);
        
        Hospital h0= new Hospital("H0", 1);
        Hospital h1= new Hospital("H1", 2);
        Hospital h2= new Hospital("H2", 2);
        
        TreeSet<Hospital> ts = new TreeSet<Hospital>();
        ts.add(h0);
        ts.add(h1);
        ts.add(h2);
        
        for(Resident res: r){
            residentList.add(res);
        }
        
        Collections.sort(residentList,
            Comparator.comparing(Resident::getName));
        
        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        List<Hospital> prefList1 = new ArrayList<>();
        prefList1.add(h0);
        prefList1.add(h1);
        prefList1.add(h2);
        resPrefMap.put(r[0], prefList1);
        resPrefMap.put(r[1], prefList1);
        
        List<Hospital> prefList2 = new ArrayList<>();
        prefList2.add(h0);
        prefList2.add(h1);
        resPrefMap.put(r[2], prefList2);
        
        List<Hospital> prefList3 = new ArrayList<>();
        prefList3.add(h0);
        prefList3.add(h2);
        resPrefMap.put(r[3], prefList3);
        
        Map<Hospital, List<Resident>> hosPrefMap = new HashMap<>();
        hosPrefMap.put(h0, Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h1, Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h2, Arrays.asList(r[0], r[1], r[3]));
        
        //residentList.stream()
          //  .filter(res -> resPrefMap.get(res).contains(h0))
            //.forEach(System.out::println);
        
        residentList.stream()
                .filter(res -> resPrefMap.get(res).contains(h0))
                .filter(res -> resPrefMap.get(res).contains(h2))
                .forEach(System.out::println);
        ts.stream()
              .filter(da -> hosPrefMap.get(da).get(0)==r[0])
              .forEach(System.out::println);
        
    }
}
    