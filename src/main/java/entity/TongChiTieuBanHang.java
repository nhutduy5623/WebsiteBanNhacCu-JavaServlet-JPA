/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kusod
 */


@Entity
@Table(name = "tongchitieubanhang")
public class TongChiTieuBanHang implements Serializable {
    
    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="userID")
    private Account user;
    
    @Column(name="tongChiTieu")
    private double tongChiTieu;
    
    @Column(name="tongBanHang")
    private double tongBanHang;

    public TongChiTieuBanHang() {
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public double getTongChiTieu() {
        return tongChiTieu;
    }

    public void setTongChiTieu(double tongChiTieu) {
        this.tongChiTieu = tongChiTieu;
    }

    public double getTongBanHang() {
        return tongBanHang;
    }

    public void setTongBanHang(double tongBanHang) {
        this.tongBanHang = tongBanHang;
    }

    
    
    
}
