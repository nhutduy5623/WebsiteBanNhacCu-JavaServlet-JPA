/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.ICartDAO;
import dao.ICategoryDAO;
import entity.Category;

/**
 *
 * @author lunhu
 */
public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO{
    
    public CategoryDAO() {
        super(Category.class);
    }
    
    
    
}
