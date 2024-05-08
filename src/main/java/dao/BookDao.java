/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Book;
import model.BookIssue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class BookDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public void addBook(Book book)
    {
        hibernateTemplate.saveOrUpdate(book);
    }
    
    public List<Book> getAllBook()
    {
        List<Book> book = hibernateTemplate.loadAll(Book.class);
        return book;
    }
    
    public Book getBook(int id)
    {
        Book book = hibernateTemplate.get(Book.class, id);
        return book;
    }
    
    @Transactional
    public int saveBookIssue(BookIssue bookIssue)
    {
        int id = (Integer)hibernateTemplate.save(bookIssue);
        return id;
    }
    
    public List<BookIssue> getAllBookIssue()
    {
        List<BookIssue> bi = hibernateTemplate.loadAll(BookIssue.class);
        return bi;
    }
    
    public BookIssue getBookIssue(int id)
    {
        BookIssue bi = hibernateTemplate.get(BookIssue.class, id);
        return bi;
    }
    
    @Transactional
    public void updateBookIssue(BookIssue bi)
    {
        hibernateTemplate.update(bi);
    }
    
    
    public boolean isAuthorPresenetInBook(int id)
    {
        Long count = (Long) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(Book.class)
                .createAlias("author", "a")
                .add(Restrictions.eq("a.id", id))
                .setProjection(Projections.rowCount())
        ).get(0);
        return count > 0;
        
//         String queryString = "select count(*) from model.Book b where b.author.id = ?1";
//        List<Long> result = (List<Long>) hibernateTemplate.find(queryString, id);
//        return !result.isEmpty() && result.get(0) > 0;
        
        
    }
    
    public boolean isPublisherPresentInBook(int id)
    {
        Long count = (Long) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(Book.class)
                .createAlias("publisher", "p")
                .add(Restrictions.eq("p.id", id))
                .setProjection(Projections.rowCount())
        ).get(0);
        return count > 0;
    }
    
    public boolean isCategoryPresentInBook(int id)
    {
        Long count = (Long) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(Book.class)
                .createAlias("category", "c")
                .add(Restrictions.eq("c.id", id))
                .setProjection(Projections.rowCount())
        ).get(0);
        return count > 0;
    }
    
    public boolean isStudentPresentInBookIssue(int id)
    {
        Long count = (Long) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(BookIssue.class)
                .createAlias("student", "s")
                .add(Restrictions.eq("s.id", id))
                .setProjection(Projections.rowCount())
        ).get(0);
        return count > 0;
    }
    
    public boolean isBookPresentInBookIssue(int id)
    {
        Long count = (Long) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(BookIssue.class)
                .createAlias("book", "b")
                .add(Restrictions.eq("b.id", id))
                .setProjection(Projections.rowCount())
        ).get(0);
        return count > 0;
    }
    
    @Transactional
    public void deleteBook(Book book)
    {
        hibernateTemplate.delete(book);
    }
    
    @Transactional
    public void deleteBookIssue(BookIssue bi)
    {
        hibernateTemplate.delete(bi);
    }
    
    public long getBooksNo()
    {
        String query = "SELECT COUNT(*) FROM Book";
        Long book = (Long)hibernateTemplate.find(query).get(0);
        
        return book;
    }
    
    public long getBookIssuesNo()
    {
        String query = "SELECT COUNT(*) FROM BookIssue";
        Long bi = (Long)hibernateTemplate.find(query).get(0);
        
        return bi;
    }
}
