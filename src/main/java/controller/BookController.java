/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Author;
import model.Book;
import model.BookIssue;
import model.Category;
import model.Publisher;
import model.Setting;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.BookService;


@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping("/book")
    public String book(Model m)
    {
        
        
        List<Book> book = bookService.getBooks();
        m.addAttribute("book",book);
        return "book";
    }
    
    @RequestMapping("/add-book")
    public String addBook(Model m)
    {
      
        
        List<Publisher> publisher = bookService.getPublishers();
        m.addAttribute("publisher", publisher);
        
        List<Category> category = bookService.getCategories();
        m.addAttribute("category", category);
        
        List<Author> author = bookService.getAuthors();
        m.addAttribute("author",author);
        
        return "add-book";
    }
    
    @RequestMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book, RedirectAttributes rd)
    {
        if(book.getQuantity()>0)
            book.setStatus(true);
        else
            book.setStatus(false);
        System.out.println(book);
        bookService.addBook(book);
        rd.addFlashAttribute("done","Book add/update successfully.");
        
        return "redirect:/book";
    }
    
    @RequestMapping("/update-book/{book_id}")
    public String updateBook(@PathVariable("book_id") int id, Model m)
    {
        
        
       Book book = bookService.getBook(id);
       m.addAttribute("book",book);
       
        List<Publisher> publisher = bookService.getPublishers();
        m.addAttribute("publisher", publisher);
        
        List<Category> category = bookService.getCategories();
        m.addAttribute("category", category);
        
        List<Author> author = bookService.getAuthors();
        m.addAttribute("author",author);
       
       return "update-book";
    }
    
    
    @RequestMapping("/book-issue")
    public String bookIssue(Model m)
    {
        
        
        List<BookIssue> bookIssue = bookService.getBookIssues();
        m.addAttribute("bookIssue",bookIssue);
        
        return "book-issue";
        
    }
    
    @RequestMapping("/add-book-issue")
    public String addBookIssue(Model m)
    {
              
        List<Student> student = bookService.getStudents();
        m.addAttribute("student",student);
        
        List<Book> book = bookService.getBooks();
        m.addAttribute("book",book);
        
        return "add-book-issue";
    }
    
    
    @RequestMapping("/save-book-issue")
    public String saveBookIssue(@ModelAttribute("bookIssue") BookIssue bookIssue, RedirectAttributes rd)
    {
        LocalDate curr_date = LocalDate.now();
        
//        LocalDate curr_date = LocalDate.parse("2024-04-12");
        bookIssue.setCurr_date(curr_date);
        
        Setting setting = bookService.getSetting();
        int day = setting.getReturn_day();
        
        LocalDate return_date= curr_date.plusDays(day);
        bookIssue.setReturn_date(return_date);
        
        System.out.println(bookIssue);
        int id = bookService.saveBookIssue(bookIssue);
        rd.addFlashAttribute("done", "Book-Issued Successfully.");
        System.out.println(id);
        
        return "redirect:/book-issue";
    }
    
    @RequestMapping("/update-book-issue/{bi_id}")
    public String updateBookIssue(@PathVariable("bi_id")int id, Model m)
    {
        BookIssue bi =bookService.getBookIssue(id);
        m.addAttribute("bookIssue",bi);
        
        return "update-book-issue";
    }
    
    @RequestMapping("/update-issue-book")
    public String updateIssueBook(@RequestParam("id") int id)
    {
        
        BookIssue bookIssue = bookService.getBookIssue(id);
        bookIssue.setStatus(true);
        LocalDate date = LocalDate.now();
        bookIssue.setReturn_day(date);
        LocalDate return_date = bookIssue.getReturn_date();
        
        long day = ChronoUnit.DAYS.between(date,return_date);
        if(day<0)
        {
            day=day*(-1);
            day=day*5;
            bookIssue.setFine((int)day);
        }
        
        bookService.updateBookIssue(bookIssue);
        return "redirect:/book-issue";
    }
    
    @RequestMapping("/delete-book/{b_id}")
    public String deleteBook(@PathVariable("b_id") int id, HttpSession session)
    {
        boolean x = bookService.isBookPresentInBookIssue(id);
        if(x)
        {
            session.setAttribute("danger-msg", "Cant't delete book record this is used in book issue.");
        }
        else{
            Book book = bookService.getBook(id);
            bookService.deleteBook(book);
            session.setAttribute("success-msg", "Book Deleted Successfully.");
        }
        
        return "redirect:/book";
    }
    
    @RequestMapping("delete-book-issue/{bi_id}")
    public String deleteBookIssue(@PathVariable("bi_id") int id, HttpSession session)
    {
        BookIssue bi = bookService.getBookIssue(id);
        if(!bi.isStatus())
        {
           session.setAttribute("danger-msg","Can't delete the book, The Book is issue to the student");
        }
        else{
            bookService.deleteBookIssue(bi);
            session.setAttribute("success-msg","Book-Issue deleted successfully.");
        }
        
        return "redirect:/book-issue";
    }
}
