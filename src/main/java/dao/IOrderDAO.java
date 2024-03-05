/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.EntityOrder;
import entity.orderDetail;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface IOrderDAO {
    List<EntityOrder> searcByNgayXuat(String ngayXuat);
    double sumAllOrder();
    double totalMoneyDay(int day);
    double totalMoneyMonth(int month);
    void saveOrder(EntityOrder order); //save Order + OrderDetail
    List<EntityOrder> findOrderByTinhTrang(int tinhTrang);
    List<EntityOrder> findOrderByTinhTrang_ngayXuat(int tinhTrang, Date ngayXuat);
    List<EntityOrder> getOrderByUserId(int userId);
    List<orderDetail> getOrderDetail(int orderId);
    void xulyOrder(int orderId);
    void DeleteOrderByUserId(int UserId);
    void DeleteOrderByProductId(int ProductId);
    
}
