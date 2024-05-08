/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class PublisherDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public void savePublisher(Publisher publisher)
    {
        hibernateTemplate.saveOrUpdate(publisher);
    }
    
    public List<Publisher> getAllPublisher()
    {
        List<Publisher> publisher = hibernateTemplate.loadAll(Publisher.class);
        return publisher;
    }
    
    public Publisher getPublisher(int id)
    {
        Publisher pub = hibernateTemplate.get(Publisher.class, id);
        return pub;
    }
    
    @Transactional
    public void deletePublisher(Publisher publisher)
    {
        hibernateTemplate.delete(publisher);
    }
    
    public long getPublishersNo()
    {
        String query = "SELECT COUNT(*) FROM Publisher";
        Long pub = (Long)hibernateTemplate.find(query).get(0);
        
        return pub;
    }
}
