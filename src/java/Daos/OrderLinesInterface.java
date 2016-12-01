/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Order_line;
import java.util.ArrayList;

/**
 *
 * @author Conno
 */
public interface OrderLinesInterface {

    /**
     *
     * @param ol
     * @return
     */
    public boolean createOrderLine(Order_line ol);

    /**
     *
     * @param line_id
     * @return
     */
    public boolean removeOrderLine(int line_id);

    /**
     *
     * @param order_id
     * @return
     */
    public ArrayList<Order_line> getOrderLines(int order_id);
}
