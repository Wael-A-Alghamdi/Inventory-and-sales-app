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
public class OrderNum {
     public static ArrayList<String> orderNumber = new ArrayList<String>();
    
    public void OrderNum(String n){
        orderNumber.add(n);
       
    }
     public ArrayList getOrderNumber() {
        return orderNumber;
    }
 public void Clear() {
         orderNumber.clear();
     
    }
    
}
