/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_p4;

import java.io.*;
import java.util.*;

/**
 *
 * @author Wladislaw
 */
public class PI_P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        int alter;
        String name;
        double groesse;
        int zeile = 0;

        boolean loop = false;
        FileReader fr = new FileReader("C:\\Users\\Wladislaw\\Documents\\NetBeansProjects\\PI_P4\\src\\pi_p4\\daten.txt");
        BufferedReader br = new BufferedReader(fr);
        br.mark(10000);
        while (br.readLine() != null) {
            zeile++;
        }
        zeile = zeile / 3;
        System.out.println(zeile);
        Mensch[] arrayMensch = new Mensch[zeile];
        br.reset();
        for (int i = 0; i < zeile; i++) {

            alter = Integer.parseInt(br.readLine());

            name = br.readLine();
            if (name != null) {
                groesse = Double.parseDouble(br.readLine());
                arrayMensch[i] = new Mensch(name, alter, groesse);
            }
        }
        for (int i = 0; i < zeile; i++) {
            System.out.println((i + 1) + ". Mensch:");
            arrayMensch[i].info();
        }

        List<Mensch> listeMensch = new LinkedList<Mensch>();
        for (int i = 0; i < zeile; i++) {
        listeMensch.add(arrayMensch[i]);
        }

        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("testaus"));
        ous.writeObject(listeMensch);

        listeMensch = null;
        System.gc();
        ObjectInputStream objInStr = new ObjectInputStream(new FileInputStream("testaus"));

//Objekte serialisiert einlesen
        listeMensch = (List<Mensch>) objInStr.readObject();
        System.out.println("EInlesen:");
        for (int i = 0; i < listeMensch.size(); i++) {

            listeMensch.get(i).info();
        }
     
    }
    

}
