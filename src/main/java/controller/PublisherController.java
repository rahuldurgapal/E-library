/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.PublisherService;



@Controller
public class PublisherController {
    
    @Autowired
    PublisherService publisherService;
    
    @RequestMapping("/publisher")
    public String publisher(Model m)
    {
       
        
        List<Publisher> publisher = publisherService.getPublishers();
        m.addAttribute("publisher",publisher);
        
        return "publisher";
    }
    
    @RequestMapping("/add-publisher")
    public String addPublisher()
    {
        return "add-publisher";
    }
    
    @RequestMapping("/save-publisher")
    public String savaPubliser(@ModelAttribute("publisher") Publisher publisher, RedirectAttributes rd)
    {
        System.out.println(publisher);
        publisherService.savePublisher(publisher);
        rd.addFlashAttribute("done", "Publisher add/update successfully.");
        
        return "redirect:/publisher";
    }
    
    @RequestMapping("/update-publisher/{pub_id}")
    public String updatePublisher(@PathVariable("pub_id") int id, Model m)
    {
        System.out.println(id);
        
        
        Publisher pub = publisherService.getPublisher(id);
        m.addAttribute("pub",pub);
        
        return "update-publisher";
    }
    
    @RequestMapping("/delete-publisher/{p_id}")
    public String deletePublisher(@PathVariable("p_id") int id, HttpSession session)
    {
        boolean isPublisherPresentInBook = publisherService.isPublisherPresentInBook(id);
        if(isPublisherPresentInBook)
        {
            session.setAttribute("danger-msg", "Can't delete publisher record. This publisher is associated with books.");
        }
        else{
            Publisher publisher = publisherService.getPublisher(id);
            publisherService.deletePublisher(publisher);
            session.setAttribute("success-msg", "Publisher deleted successfully.");
        }
        
        return "redirect:/publisher";
    }
   
}
