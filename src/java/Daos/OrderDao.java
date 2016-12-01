/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order;
import java.util.ArrayList;

/**
 *
 * @author Conno
 */
public class OrderDao extends Dao implements OrderDaoInterface {
    
    /**
     *
     * @param database
     */
    public OrderDao(String database) {
        super(database);
    }

    /**
     *
     * @param newOrder
     * @return
     */
    @Override
    public boolean createOrder(Order newOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param order_id
     * @return
     */
    @Override
    public boolean cancelOrder(int order_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param user_id
     * @return
     */
    @Override
    public ArrayList<Order> getUserOrders(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
