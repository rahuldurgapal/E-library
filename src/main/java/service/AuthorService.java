
package service;

import dao.AuthorDao;
import model.Author;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class AuthorService {
    
    @Autowired
    private AuthorDao authorDao;
    
    @Autowired
    private BookService bookService;
    
    public void saveAuthor(Author author)
    {
        authorDao.saveAuthor(author);
    }
    
    public List<Author> getAuthors()
    {
        return authorDao.getAllAuthors();
    }
    
    public Author getAuthor(int id)
    {
        return authorDao.getAuthor(id);
    }
    
    public boolean isAuthorPresenetInBook(int id)
    {
        return bookService.isAuthorPresentInBook(id);
    }
    
    public void deleteAuthor(Author author)
    {
        authorDao.deleteAuthor(author);
    }
    
    public long getAuthorsNo()
    {
        return authorDao.getAuthorsNo();
    }
}
