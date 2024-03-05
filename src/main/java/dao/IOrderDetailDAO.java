/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.orderDetail;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface IOrderDetailDAO {
    List<orderDetail> findOrderDetailByOrder(int orderId);
}
