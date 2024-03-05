/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Product;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface IProductDAO {
    List<Product> findProductByColor(String color);
    List<Product> findProductByName(String Name);
    List<Product> findProductByPrice(int min, int max);
    List<Product> getRelatedProduct(int cateIDProductDetail);
    List<Product> getProductBySellIDAndIndex(int id, int indexPage);
    List<Product> getTop3();
    List<Product> getTopBanChay(int limit);
    List<Product> getLast(int limit);
    List<Product> findProductByCategory(int categoryId);
    List<Product> findTopProductByCategory(int categoryId, int limit);
    List<Product> getProductByIndex(int indexPage, int limit);
    void updateTinhTrang(int tinhTrang, int productId);
    int countAllProductBySellID(int sell_ID);
    
    
}
