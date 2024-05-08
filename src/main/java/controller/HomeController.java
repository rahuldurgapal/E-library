/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.AdminService;

@Controller
public class HomeController {

    @Autowired
    private AdminService service;

    @RequestMapping("/")
    public String index() {
        
        return "index";
    }

    @RequestMapping(path = "/login-process", method = RequestMethod.POST)
    public String adminLogin(@RequestParam("username") String name,
            @RequestParam("password") String password,
            HttpSession session, RedirectAttributes rd) {
        Admin admin = service.findByUsername(name);

        if (admin != null) {
            if (admin.getPassword().equals(password)) {
                session.setAttribute("admin", admin);
                
                
                return "redirect:/dashboard";
            } else {
                session.setAttribute("error", "wrong password");
            }
        } else {
            session.setAttribute("error", "wrong username");
        }

        return "redirect:/";
    }

    @RequestMapping("/dashboard")
    public String dashBoard(Model m) {
        
                long auth = service.getAuthorsNo();
                m.addAttribute("auth",auth);
                
                long cat = service.getCategoriesNo();
                m.addAttribute("cat",cat);
                
                long pub = service.getPublishersNo();
                m.addAttribute("pub",pub);
                
                long std = service.getStudentsNo();
                m.addAttribute("std",std);
                
                long book = service.getBooksNo();
                m.addAttribute("book",book);
                
                long bi = service.getBookIssuesNo();
                m.addAttribute("bi",bi);
        return "dashboard";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        session.invalidate();

        return "redirect:/";
    }
    
    @RequestMapping("/setting")
    public String setting(Model m)
    {
        
        
        Setting setting = service.getSetting();
        m.addAttribute("setting",setting);
        return "setting";
    }
    
    
    @RequestMapping("/update-setting")
    public String updateSetting(@ModelAttribute("setting") Setting setting,RedirectAttributes rd)
    {
        service.updateSetting(setting);
        rd.addFlashAttribute("msg","Updated Successfully");
        return "redirect:/setting";
    }

}
