/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AdminDao;
import model.Admin;
import model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class AdminService {
    
    @Autowired
    private AdminDao adminDao;
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired 
    private BookService bookService;
    
    public Admin findByUsername(String name){
        
        return adminDao.getUserByUsername(name);
    }
    
    public Setting getSetting()
    {
        return adminDao.getSetting();
    }
    
    public void updateSetting(Setting setting)
    {
        adminDao.updateSetting(setting);
    }
    
    public long getAuthorsNo()
    {
        return authorService.getAuthorsNo();
    }
    
    public long getCategoriesNo()
    {
        return categoryService.getCategoriesNo();
    }
    
    public long getPublishersNo()
    {
        return publisherService.getPublishersNo();
    }
    
    public long getStudentsNo()
    {
        return studentService.getStudentsNo();
    }
    
    public long getBooksNo()
    {
        return bookService.getBooksNo();
    }
    
    public long getBookIssuesNo()
    {
        return bookService.getBookIssuesNo();
    }
    
}
