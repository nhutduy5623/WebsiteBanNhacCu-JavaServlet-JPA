/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kusod
 */

@Entity
@Table(name = "cart")
public class Cart implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    
    @Column(name = "amount")
    private int amount;
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCart", unique = true)
    private int maCart;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaCart() {
        return maCart;
    }

    public void setMaCart(int maCart) {
        this.maCart = maCart;
    }

    public Cart(Product product, Account account, int amount) {
        this.product = product;
        this.account = account;
        this.amount = amount;
    }

    public Cart() {
    }
    
    
    



    
}
