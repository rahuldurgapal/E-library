/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.AuthorService;


@Controller
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    
    @RequestMapping("/author")
    public String author(HttpSession session,Model m)
    {
       
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin==null){
            session.setAttribute("error","Please Login First");
            return "redirect:/";
                    }
        List<Author> author = authorService.getAuthors();
        m.addAttribute("author", author);
        return "author";
    }
    
    @RequestMapping("/add-author")
    public String addAuthor()
    {
        
        
       return "add-author";
    }
    
    @RequestMapping("/save-author")
    public String saveAuthor(@ModelAttribute("author") Author author, RedirectAttributes rd)
    {
        System.out.println(author);
        authorService.saveAuthor(author);
        rd.addFlashAttribute("done","Author add/update successfully.");
        
        return "redirect:/author";
    }
    
   
    
    @RequestMapping("/update-author/{auth_id}")
    public String authorUpdate(@PathVariable("auth_id") int id, Model m)
    {
        
        Author author = authorService.getAuthor(id);
        m.addAttribute("author",author);
        return "update-author";
    }
    
 @RequestMapping("/delete-author/{auth_id}")
public String deleteAuthor(@PathVariable("auth_id") int id, HttpSession session) {
    boolean isAuthorPresentInBooks = authorService.isAuthorPresenetInBook(id);
    
    if (isAuthorPresentInBooks) {
        session.setAttribute("danger-msg", "Can't delete author record. This author is associated with books.");
    } else {
        Author author = authorService.getAuthor(id);
        authorService.deleteAuthor(author);
        session.setAttribute("success-msg", "Author deleted successfully.");
    }

    return "redirect:/author";
}
    
   
}
