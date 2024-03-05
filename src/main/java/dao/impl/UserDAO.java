/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.impl;

import dao.IUserDAO;
import entity.Account;
import entity.TongChiTieuBanHang;
import java.util.List;

/**
 *
 * @author lunhu
 */
public class UserDAO extends AbstractDAO<Account> implements IUserDAO{
    
    public UserDAO() {
        super(Account.class);
    }
    
    

    @Override
    public Account login(String userName, String pass) {
        String jpql = "SELECT a FROM Account a WHERE a.user =?1 and a.pass = ?2";
        return super.findOne(jpql, userName, pass);
    }

    @Override
    public void signup(String userName, String pass, String email) {
        Account user = new Account(userName, pass, 0, 0, email);
        super.save(user);
    }

    @Override
    public Account checkAccountExist(String userName) {
        String jpql = "SELECT a FROM Account a WHERE a.user =?1";
        return super.findOne(jpql, userName);
        
//        String sql = "SELECT * FROM Account as a WHERE a.user = ? and a.password=?";
//        ps.setString(1, user);
        
    }

    @Override
    public Account checkAccountExistByUsernameAndEmail(String userName, String email) {
        String jpql = "SELECT a FROM Account a WHERE a.user =?1 AND a.email = ?2";
        return super.findOne(jpql, userName, email);
    }

    @Override
    public int checkAccountAdmin(int userID) {
        String jpql = "SELECT a FROM Account a WHERE a.id =?1";
        return super.findOne(jpql, userID).getId();
    }

    @Override
    public void updateTinhTrang(int tinhTrang, int userId) {
        String jpql = "UPDATE Account a SET a.tinhTrang = ?1 WHERE a.id = ?2";
        super.UpdateWithJPQL(jpql, tinhTrang, userId);
    }      
    
}
