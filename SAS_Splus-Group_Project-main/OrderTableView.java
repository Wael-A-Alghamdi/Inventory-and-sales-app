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
public class OrderTableView {
     int order_no ;
     
  
  public OrderTableView(int order_no) {
      
        this.order_no = order_no;           
    }
  
    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public int getOrder_no() {
        return order_no;
    }

}
