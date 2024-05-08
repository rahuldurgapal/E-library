/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.PublisherDao;
import java.util.List;
import model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;


public class PublisherService {
    
    
    @Autowired
    private PublisherDao publisherDao;
    
    @Autowired
    private BookService bookService;
    
    public void savePublisher(Publisher publisher)
    {
      publisherDao.savePublisher(publisher);
    }
    
    public List<Publisher> getPublishers()
    {
        return publisherDao.getAllPublisher();
    }
    
    public Publisher getPublisher(int id)
    {
       return publisherDao.getPublisher(id);
    }
    
    public boolean isPublisherPresentInBook(int id)
    {
        return bookService.isPublisherPresentInBook(id);
    }
    
    public void deletePublisher(Publisher publisher)
    {
         publisherDao.deletePublisher(publisher);
    }
    
    public long getPublishersNo()
    {
        return publisherDao.getPublishersNo();
    }
}
