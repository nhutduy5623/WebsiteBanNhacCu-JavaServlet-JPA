/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kusod
 */

@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "nameSupplier")
    private String nameSupplier;
    
    @Column(name = "phoneSupplier")
    private String phoneSupplier;
    
    @Column(name = "emailSupplier")
    private String emailSupplier;
    
    @Column(name = "addressSupplier")
    private String addressSupplier;
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category Category;

    public Supplier() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Supplier(String nameSupplier, String phoneSupplier, String emailSupplier, String addressSupplier, int CategoryId) {
        this.nameSupplier = nameSupplier;
        this.phoneSupplier = phoneSupplier;
        this.emailSupplier = emailSupplier;
        this.addressSupplier = addressSupplier;
        this.Category = new Category();
        this.Category.setId(CategoryId);
    }

    
    
    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getPhoneSupplier() {
        return phoneSupplier;
    }

    public void setPhoneSupplier(String phoneSupplier) {
        this.phoneSupplier = phoneSupplier;
    }

    public String getEmailSupplier() {
        return emailSupplier;
    }

    public void setEmailSupplier(String emailSupplier) {
        this.emailSupplier = emailSupplier;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category Category) {
        this.Category = Category;
    }

    
    

}
