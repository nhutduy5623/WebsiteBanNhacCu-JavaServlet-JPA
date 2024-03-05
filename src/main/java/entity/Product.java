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
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private double price;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "VARCHAR(500) DEFAULT 'description'")
    private String description;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "delivery")
    private String delivery;

    @Column(name = "image2")
    private String image2;

    @Column(name = "image3")
    private String image3;

    @Column(name = "image4")
    private String image4;

    @Column(name = "soluongdaban", columnDefinition = "int(2) DEFAULT 0")
    private int soluongdaban = 0;

    @Column(name = "sell_ID", columnDefinition = "int(2) DEFAULT 1")
    private int sell_ID = 1;

    @Column(name = "tinhTrang", columnDefinition = "int(2) DEFAULT 1")
    private int tinhTrang = 1;
    
     public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getSoluongdaban() {
        return soluongdaban;
    }

    public void setSoluongdaban(int soluongdaban) {
        this.soluongdaban = soluongdaban;
    }

    public Product(String name, String image, double price, String title, String description, String model, String color, String delivery, String image2, String image3, String image4, int categoryID, int tinhTrang) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.model = model;
        this.color = color;
        this.delivery = delivery;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.category = new Category();
        this.category.setId(categoryID);
        this.tinhTrang = tinhTrang;
    }

    public Product(int id, String name, String image, double price, String title, String description, String model, String color, String delivery, String image2, String image3, String image4, int categoryID, int tinhTrang) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.model = model;
        this.color = color;
        this.delivery = delivery;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.category = new Category();
        this.category.setId(categoryID);
        this.tinhTrang = tinhTrang;
    }
    
    public Product(int id, String name, String image, double price, String title, String description, String model, String color, String delivery, String image2, String image3, String image4, int categoryID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.description = description;
        this.model = model;
        this.color = color;
        this.delivery = delivery;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.category = new Category();
        this.category.setId(categoryID);
    }

    public Product() {

    }

    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", title=" + title
                + ", description=" + description + ", model=" + model + ", color=" + color + ", delivery=" + delivery
                + ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + "]";
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public int getSell_ID() {
        return sell_ID;
    }

    public void setSell_ID(int sell_ID) {
        this.sell_ID = sell_ID;
    }

}
