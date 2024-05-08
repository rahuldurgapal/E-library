/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="book_issue")
public class BookIssue {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="issue_id")
    private int id;
    
    @OneToOne
    private Book book;
    
    @OneToOne
    private Student student;
    
    @Column(name="issue_date")
    private LocalDate curr_date;
    
    
    @Column(name="return_date")
    private LocalDate return_date;
    
    @Column(name="issue_status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    @Column(name="return_day")
    private LocalDate return_day;
    
    @Column(name="fine")
    private int fine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getCurr_date() {
        return curr_date;
    }

    public void setCurr_date(LocalDate curr_date) {
        this.curr_date = curr_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public LocalDate getReturn_day() {
        return return_day;
    }

    public void setReturn_day(LocalDate return_day) {
        this.return_day = return_day;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "BookIsuue{" + "id=" + id + ", book=" + book + ", student=" + student + ", curr_date=" + curr_date + ", return_date=" + return_date + ", status=" + status + ", return_day=" + return_day + ", fine=" + fine + '}';
    }
    
    
    
    
}
