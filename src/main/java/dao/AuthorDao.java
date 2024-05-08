/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class AuthorDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public void saveAuthor(Author author)
    {
       hibernateTemplate.saveOrUpdate(author);
        
    }
    
    public List<Author> getAllAuthors()
    {
        List<Author> author = hibernateTemplate.loadAll(Author.class);
        return author;
    }
    
    public Author getAuthor(int id)
    {
        Author author = hibernateTemplate.get(Author.class, id);
        return author;
    }
    
    @Transactional 
    public void deleteAuthor(Author author)
    {
        hibernateTemplate.delete(author);
    }
    
     public long getAuthorsNo()
    {
       String query = "SELECT COUNT(*) FROM Author";
       return (Long)hibernateTemplate.find(query).get(0);
    }
}
