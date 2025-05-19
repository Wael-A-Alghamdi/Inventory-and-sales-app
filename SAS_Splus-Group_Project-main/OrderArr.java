/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

import java.util.ArrayList;

/**
 *
 * @author asrock
 */
public class OrderArr {
    
    public static ArrayList<String> name = new ArrayList<String>();
    public static ArrayList<Double> price = new ArrayList<Double>();
                public static ArrayList<Double> changeArr = new ArrayList<Double>();


    public void OrderDt(String n,Double p){
        name.add(n);
        price.add(p);
    }
    
     
       

     public ArrayList getName() {
        return name;
    }

    public ArrayList getPrice() {
        return price;
    }
    
     public ArrayList getChangeArr() {
        return changeArr;
    }
    public double sum() {
        double total=0;
        for (double element : price) {
            total+=element;
            
        }
        return total;
    }
    public double sumTotal() {
        double total=0;
        for (double element : price) {
            total+=element;
            
        }
        total*=1.15;
        return total;
    }
    
    
    
    public void Change(double a) {
        double total=sumTotal();
        double change=total-a;
       changeArr.add(change);
    }
    
     public void Clear() {
         name.clear();
        price.clear();
    }
     
}
