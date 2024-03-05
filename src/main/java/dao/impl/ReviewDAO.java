/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IReviewDAO;
import entity.Review;
import java.util.List;

/**
 *
 * @author lunhu
 */
public class ReviewDAO extends AbstractDAO<Review> implements IReviewDAO{
    
    public ReviewDAO() {
        super(Review.class);
    }

    @Override
    public Review getNewReview(int accountID, int productID) {
        String jdql = "SELECT r FROM Review r WHERE r.account.id = "+accountID+" AND r.product.id = "+productID+" ORDER BY r.id";
        return super.findListSetLimit(jdql, 1, 0).get(0);
    }

    @Override
    public List<Review> getAllReviewByProductID(int productId) {
        String jdql = "SELECT r FROM Review r WHERE r.product.id = "+productId;
        return super.findList(jdql);
    }

    @Override
    public void deleteReviewByProductID(int productID) {
        String jdql = "DELETE FROM Review r WHERE r.product.id = "+productID;
        super.deleteManyEntity(jdql);
    }

    @Override
    public void deleteReviewByAccountID(int accountID) {
        String jdql = "DELETE FROM Review r WHERE r.account.id = "+accountID;
        super.deleteManyEntity(jdql);
    }
    
}
