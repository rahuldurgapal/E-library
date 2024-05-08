
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="publisher")
public class Publisher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="publisher_id")
    private int id;
    @Column(name="publisher_name")
    private String name;

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

    @Override
    public String toString() {
        return "Publisher{" + "id=" + id + ", name=" + name + '}';
    }
    
    
}
