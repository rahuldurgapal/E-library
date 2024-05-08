/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private int id;
    
    @Column(name="book_name")
    private String name;    
    
    @Column(name="book_quantity")
    private int quantity;
    
    @Column(name="book_status")
    private boolean status;
    
    @OneToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    @OneToOne
    @JoinColumn(name="author_id")
    private Author author;
    
    @OneToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", name=" + name + ", category=" + category + ", author=" + author + ", publisher=" + publisher + '}';
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
