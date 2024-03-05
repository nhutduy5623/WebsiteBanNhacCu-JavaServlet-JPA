/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lunhu
 */

@Entity
@Table(name = "orderdetail")
public class orderDetail implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "orderId")
    private EntityOrder entityOrder;
    
    @Column(name = "amount")
    private int amount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public EntityOrder getEntityOrder() {
        return entityOrder;
    }

    public void setEntityOrder(EntityOrder entityOrder) {
        this.entityOrder = entityOrder;
    }



   

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
    
}
