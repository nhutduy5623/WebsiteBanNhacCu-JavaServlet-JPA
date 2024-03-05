/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ICartDAO;
import entity.Cart;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lunhu
 */
public class CartDAO extends AbstractDAO<Cart> implements ICartDAO {

    public CartDAO() {
        super(Cart.class);
    }

    @Override
    public List<Cart> getCartByAccountID(int accountID) {
        String jpql = "SELECT c FROM Cart c WHERE c.account.id = ?1";
        return super.findList(jpql, accountID);
    }

    @Override
    public Cart checkCartExist(int accountID, int productID) {
        String jpql = "SELECT c FROM Cart c WHERE c.account.id = ?1 AND c.product.id = ?2";
        return super.findOne(jpql, accountID, productID);
    }

    @Override
    public void deleteCartByProductID(int productID) {
        String jpql = "SELECT c FROM Cart c WHERE c.product.id = ?1";
        List<Cart> listCart = super.findList(jpql, productID);
        for (Cart c : listCart) {
            super.deleteWithEntity(c);
        }
    }

    @Override
    public void deleteCartByAccountID(int accountID) {
        String jpql = "DELETE FROM Cart c  WHERE c.account.id = "+accountID;
        super.deleteWithJPQL(jpql);
    }

    @Override
    public void deleteItemInUserCart(int accountID, int productID) {
        String jpql = "DELETE FROM Cart c  WHERE c.account.id = "+accountID+" AND c.product.id = "+productID;
        super.deleteWithJPQL(jpql);
    }

    @Override
    public void editAmountAndSizeCart(int accountID, int productID, int amount) {
        String jpql = "SELECT c FROM Cart c WHERE c.account.id = ?1 AND c.product.id = ?2";
        Cart cart = super.findOne(jpql, accountID, productID);
        cart.setAmount(amount);
        super.update(cart);
    }

    @Override
    public void editAmountCart(int accountID, int productID, int amount) {
        String jpql = "SELECT c FROM Cart c WHERE c.account.id = ?1 AND c.product.id = ?2";
        Cart cart = super.findOne(jpql, accountID, productID);
        cart.setAmount(amount);
        super.update(cart);
    }
    
    @Override
     public void editAmountCart(int accountID, int productID) {
        String jpql = "SELECT c FROM Cart c WHERE c.account.id = ?1 AND c.product.id = ?2";
        Cart cart = super.findOne(jpql, accountID, productID);
        cart.setAmount(cart.getAmount()+1);
        super.update(cart);
    }
    

}
