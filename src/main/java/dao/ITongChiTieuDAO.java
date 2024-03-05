/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import entity.TongChiTieuBanHang;
import java.util.List;

/**
 *
 * @author lunhu
 */
public interface ITongChiTieuDAO{
    
    List<TongChiTieuBanHang> findTopKhachHang(int limit);
    TongChiTieuBanHang checkTCT(int userId);
    
}
