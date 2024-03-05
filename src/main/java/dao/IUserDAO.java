/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.Account;
import entity.TongChiTieuBanHang;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface IUserDAO {
    Account login(String userName, String pass);
    void signup(String userName, String pass, String email);
    Account checkAccountExist(String userName); 
    Account checkAccountExistByUsernameAndEmail(String username, String email);
    int checkAccountAdmin(int userID);
    void updateTinhTrang(int tinhTrang, int userId);
}
