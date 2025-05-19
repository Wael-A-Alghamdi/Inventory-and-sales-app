/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainproject;

/**
 *
 * @author asrock
 */
public class StorageTableView {
     int id ,item_quantity;
     double item_price;
   String item_name,item_code;

  public StorageTableView(int id, String item_name, String item_code, int item_quantity, double item_price) {
        this.id = id;
        this.item_name = item_name;
        this.item_code = item_code;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
        
          
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }
   
    public int getId() {
        return id;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_code() {
        return item_code;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public Double getItem_price() {
        return item_price;
    }
     
}
