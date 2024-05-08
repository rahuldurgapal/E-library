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
import javax.persistence.Table;


@Entity
@Table(name="setting")
public class Setting {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="setting_id")
    private int id;

    @Override
    public String toString() {
        return "Setting{" + "id=" + id + ", return_day=" + return_day + ", fine=" + fine + '}';
    }
    
    @Column(name="return_day")
    private int return_day;
    
    @Column(name="fine")
    private int fine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReturn_day() {
        return return_day;
    }

    public void setReturn_day(int return_day) {
        this.return_day = return_day;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
}
