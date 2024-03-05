/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IProductDAO;
import entity.Product;
import java.util.List;

/**
 *
 * @author lunhu
 */
public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {

    public ProductDAO() {
        super(Product.class);
    }

    @Override
    public List<Product> findProductByColor(String color) {
        String jpql = "SELECT p FROM Product p WHERE p.color = '" + color + "'";
        return super.findList(jpql);
    }

    @Override
    public List<Product> findProductByName(String string) {
        String jpql = "SELECT p FROM Product p WHERE p.name LIKE ?1 ";
        return super.findList(jpql, "%" + string + "%");
    }

    @Override
    public List<Product> findProductByPrice(int min, int max) {
        String jpql = "SELECT p FROM Product p WHERE p.price >= " + min + " and p.price<=" + max;
        return super.findList(jpql);
    }

    @Override
    public List<Product> getRelatedProduct(int cateIDProductDetail) {
        String jpql = "SELECT p FROM Product p WHERE p.category.id = " + cateIDProductDetail + " order by p.id desc";
        return super.findListSetLimit(jpql, 4, 0);
    }

    @Override
    public List<Product> getProductBySellIDAndIndex(int id, int indexPage) {
        indexPage = (indexPage - 1) * 5;
        String jpql = "SELECT p FROM Product p WHERE p.sell_ID = ?1 ORDER by p.id";
        return super.findListSetLimit(jpql, 5, indexPage, id);
    }
    
    @Override
    public List<Product> getTop3() {
        String jpql = "SELECT p FROM Product p";
        return super.findListSetLimit(jpql, 3, 0);
    }

    @Override
    public List<Product> getTopBanChay(int limit) {
        String jpql = "SELECT p FROM Product p ORDER by p.soluongdaban DESC";
        return super.findListSetLimit(jpql, limit, 0);
    }
    
    @Override
    public List<Product> getLast(int limit) {
        String jpql = "SELECT p FROM Product p ORDER by p.id DESC";
        return super.findListSetLimit(jpql, limit, 0);
    }

    @Override
    public List<Product> findTopProductByCategory(int categoryId, int limit) {
        String jpql = "SELECT p FROM Product p WHERE p.category.id= " + categoryId + " ORDER BY p.id DESC";
        return super.findListSetLimit(jpql, limit, 0);
    }
    
    @Override
    public List<Product> findProductByCategory(int categoryId) {
        String jpql = "SELECT p FROM Product p WHERE p.category.id = " + categoryId + " ORDER BY p.id DESC";
        return super.findList(jpql);
    }

    @Override
    public List<Product> getProductByIndex(int indexPage, int limit) {
        indexPage = (indexPage - 1) * limit;
        String jpql = "SELECT p FROM Product p ORDER BY p.id";
        return super.findListSetLimit(jpql, limit, indexPage);
    }

    @Override
    public int countAllProductBySellID(int sell_ID) {
        String jpql = "SELECT p FROM Product p WHERE p.sell_ID="+sell_ID;
        List<Product> listProduct = super.findList(jpql);
        return listProduct.size();
        
    }

    @Override
    public void updateTinhTrang(int tinhTrang, int productId) {
        String jpql = "UPDATE Product p SET p.tinhTrang = ?1 WHERE p.id = ?2";
        super.UpdateWithJPQL(jpql, tinhTrang, productId);

    }

}
