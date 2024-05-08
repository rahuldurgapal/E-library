/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.BookDao;
import java.util.List;
import model.Author;
import model.Book;
import model.BookIssue;
import model.Category;
import model.Publisher;
import model.Setting;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;



public class BookService {
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private StudentService studentService;
    
    public List<Category> getCategories()
    {
        return categoryService.getCategories();
    }
    
    public List<Publisher> getPublishers()
    {
        return publisherService.getPublishers();
    }
    
    public List<Author> getAuthors()
    {
        return authorService.getAuthors();
    }
    
    public void addBook(Book book)
    {
        bookDao.addBook(book);
    }
    
    public List<Book> getBooks()
    {
        return bookDao.getAllBook();
    }
    
    public Book getBook(int id)
    {
        return bookDao.getBook(id);
    }
    
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }
     
    public Setting getSetting()
    {
       return adminService.getSetting();
    }
    
    public int saveBookIssue(BookIssue bookIssue)
    {
        return bookDao.saveBookIssue(bookIssue);
    }
    
    public List<BookIssue> getBookIssues()
    {
        return bookDao.getAllBookIssue();
    }
    
    public BookIssue getBookIssue(int id)
    {
        return bookDao.getBookIssue(id);
    }
    
    public void updateBookIssue(BookIssue bi)
    {
        bookDao.updateBookIssue(bi);
    }
    
    public boolean isAuthorPresentInBook(int id)
    {
        return bookDao.isAuthorPresenetInBook(id);
    }
    
    public boolean isPublisherPresentInBook(int id)
    {
        return bookDao.isPublisherPresentInBook(id);
    }
    
    public boolean isCategoryPresentInBook(int id)
    {
        return bookDao.isCategoryPresentInBook(id);
    }
    
    public boolean isStudnetPresentInBookIssue(int id)
    {
        return bookDao.isStudentPresentInBookIssue(id);
    }
    
    public boolean isBookPresentInBookIssue(int id)
    {
        return bookDao.isBookPresentInBookIssue(id);
    }
    
    public void deleteBook(Book book)
    {
       bookDao.deleteBook(book);
    }
    
    public void deleteBookIssue(BookIssue bi)
    {
        bookDao.deleteBookIssue(bi);
    }
    
    public long getBooksNo()
    {
        return bookDao.getBooksNo();
    }
    
    public long getBookIssuesNo()
    {
       return bookDao.getBookIssuesNo();   
    }
}
