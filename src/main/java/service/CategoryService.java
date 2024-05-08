/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.CategoryDao;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;
    
    @Autowired
    private BookService bookService;

    public void saveCategory(Category category) {

        categoryDao.saveCategory(category);
    }
    
    public List<Category> getCategories()
    {
        return categoryDao.getAllCategory();
    }
    
    public Category getCategory(int id)
    {
        return categoryDao.getCategory(id);
    }
    
    public boolean isCategoryPresentInBook(int id)
    {
        return bookService.isCategoryPresentInBook(id);
    }
    
    public void deleteCategory(Category cat)
    {
        categoryDao.deleteCategory(cat);
    }
    
    public long getCategoriesNo()
    {
        return categoryDao.getCategoriesNo();
    }
}
