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
public class OrderDetailsTableView {
     String item_name,order_no;
     int id,item_quantity ;
     double item_price;
  
  public OrderDetailsTableView(String order_no,String item_name,int item_quantity, double item_price) {
       this.order_no = order_no;
        this.item_name = item_name;
        this.item_quantity = item_quantity;
        this.item_price = item_price;
               
    }
  public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public void setItem_price(Double item_price) {
        this.item_price = item_price;
    }
   
 
public String getItem_name() {
        return item_name;
    }

    public String getOrder_no() {
        return order_no;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public Double getItem_price() {
        return item_price;
    }
}
