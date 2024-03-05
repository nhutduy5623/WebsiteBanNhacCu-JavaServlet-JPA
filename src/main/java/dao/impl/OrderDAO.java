/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IOrderDAO;
import entity.EntityOrder;
import entity.orderDetail;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lunhu
 */
public class OrderDAO extends AbstractDAO<EntityOrder> implements IOrderDAO {

    public OrderDAO() {
        super(EntityOrder.class);
    }

    @Override
    public List<EntityOrder> searcByNgayXuat(String ngayXuat) {
        String jpql = "SELECT o FROM EntityOrder o WHERE o.ngayXuat = ?1";
        return super.findList(jpql, ngayXuat);
    }

    @Override
    public double sumAllOrder() {
        String jpql = "SELECT SUM(o.tongGia) FROM EntityOrder o";
        return super.sumByColumn(jpql);
    }

    @Override
    public double totalMoneyDay(int day) {
        String jpql = "SELECT SUM(o.tongGia) FROM EntityOrder o WHERE FUNCTION('DAYOFWEEK', o.ngayXuat) = " + day + " GROUP BY o.ngayXuat";
        return super.sumByColumn(jpql);
    }

    @Override
    public double totalMoneyMonth(int month) {
        String jpql = "SELECT SUM(o.tongGia) FROM EntityOrder o WHERE MONTH(o.ngayXuat) = " + month + " GROUP BY MONTH(o.ngayXuat)";
        return super.sumByColumn(jpql);
    }

    @Override
    public void saveOrder(EntityOrder order) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        order.setNgayXuat(super.getCurrentDate());
        super.save(order);
        for (orderDetail orderDetail : order.getListOrderDetail()) {
            orderDetail.setEntityOrder(order);
            orderDetailDAO.save(orderDetail);
        }

    }

    @Override
    public List<EntityOrder> getOrderByUserId(int userId) {
        String jpql = "SELECT o FROM EntityOrder o WHERE o.account.id = ?1";
        return super.findList(jpql, userId);
    }

    @Override
    public List<orderDetail> getOrderDetail(int orderId) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        return orderDetailDAO.findOrderDetailByOrder(orderId);
        
    }

    @Override
    public void xulyOrder(int orderId) {
        EntityOrder order = super.findById(orderId);
        order.setTinhTrang(1);
        super.update(order);        
    }

    @Override
    public List<EntityOrder> findOrderByTinhTrang(int tinhTrang) {
        String jpql = "SELECT o FROM EntityOrder o WHERE o.tinhTrang = ?1";
        if(tinhTrang==2)
            return super.findAll();
        return super.findList(jpql, tinhTrang);    
    }

    @Override
    public List<EntityOrder> findOrderByTinhTrang_ngayXuat(int tinhTrang, Date ngayXuat) {
        String jpql = "SELECT o FROM EntityOrder o WHERE o.tinhTrang ="+tinhTrang+" and o.ngayXuat = ?1";
        if(tinhTrang==2)
            jpql = "SELECT o FROM EntityOrder o WHERE o.ngayXuat = ?1";
        return super.findList(jpql, ngayXuat);            
    }
    
    @Override
    public void DeleteOrderByUserId(int UserId) {
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        String jpql = "SELECT o FROM EntityOrder o WHERE o.account.id = "+UserId;
        List<EntityOrder> listOrder = findList(jpql);
        String jpqlDetail = "DELETE FROM orderDetail od WHERE od.order.id = ?1";
        for(EntityOrder order : listOrder) 
            orderDetailDAO.deleteManyEntity(jpqlDetail, order.getId());
        jpql = "DELETE FROM order o WHERE o.account.id = "+UserId;
        super.deleteManyEntity(jpql);
    }

    @Override
    public void DeleteOrderByProductId(int ProductId) {
        String jpqlDetail = "SELECT od FROM orderDetail od WHERE od.product.id ="+ProductId;
        EntityOrder order = new EntityOrder();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        List<orderDetail> listOrderDetail = orderDetailDAO.findList(jpqlDetail);
        jpqlDetail = "DELETE FROM orderDetail od WHERE o.EntityOrder.id = ?1";
        int orderId;
        for(orderDetail od : listOrderDetail) {
            orderId = od.getEntityOrder().getId();
            orderDetailDAO.deleteManyEntity(jpqlDetail, orderId);
            super.delete(orderId);            
        }
    
    }

}
