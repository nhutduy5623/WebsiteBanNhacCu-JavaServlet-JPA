/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Cart;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface ICartDAO {
    List<Cart> getCartByAccountID(int accountID);
    Cart checkCartExist(int accountID, int productID);
    void deleteCartByProductID(int productID);
    void deleteCartByAccountID(int accountID);
    void deleteItemInUserCart(int accountID, int productID);
    void editAmountAndSizeCart(int accountID, int productID, int amount);
    void editAmountCart(int accountID, int productID, int amount);
    void editAmountCart(int accountID, int productID);
}
