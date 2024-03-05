/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Review;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface IReviewDAO {
    Review getNewReview(int accountID, int productID);
    List<Review> getAllReviewByProductID(int productId);
    void deleteReviewByProductID(int productID);
    void deleteReviewByAccountID(int accountID);
    
}
