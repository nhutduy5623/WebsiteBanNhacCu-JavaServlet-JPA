/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kusod
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "user")
    private String user;
    
    @Column(name = "pass")
    private String pass;
    
    @Column(name = "isSell")
    private int isSell;
    
    @Column(name = "isAdmin")
    private int isAdmin;
    
    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "account")
    private List<EntityOrder> listOrder;
    
    @Column(name = "tinhTrang", columnDefinition = "int(2) DEFAULT 1")
    private int tinhTrang = 1;

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
        
    
    
    public List<EntityOrder> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<EntityOrder> listOrder) {
        this.listOrder = listOrder;
    }
    
    

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsSell() {
        return isSell;
    }

    public Account(int id, String user, String pass, int isSell, int isAdmin, String email) {

        this.id = id;
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.email = email;
    }

    public Account(String user, String pass, int isSell, int isAdmin, String email) {
        this.user = user;
        this.pass = pass;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
        this.email = email;
    }
    
    

    public Account() {

    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", isSell=" + isSell + ", isAdmin=" + isAdmin
                + ", email=" + email + "]";
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }
}
