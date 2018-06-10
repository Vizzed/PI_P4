/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi_p4;

import java.io.*;

/**
 *
 * @author Wladislaw
 */
public class Mensch implements Serializable{
    protected String name;
    protected int alter;
    protected double groesse;
    Mensch next;
    
    public Mensch(String n,int a, double g){
    name=n;
    alter=a;
    groesse=g;
    next=null;
    }
    public void info(){
        System.out.println("Name: "+name+"   Alter: "+alter+"   Groesse: "+groesse);
    }
    
    
}
