/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


public class CategoryDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public void saveCategory(Category category)
    {
        hibernateTemplate.saveOrUpdate(category);
        
    }
    
    public List<Category> getAllCategory()
    {
        List<Category> category = hibernateTemplate.loadAll(Category.class);
        return category;
    }
    
    public Category getCategory(int id)
    {
        Category cat = hibernateTemplate.get(Category.class, id);
        return cat;
    }
    
    @Transactional
    public void deleteCategory(Category cat)
    {
        hibernateTemplate.delete(cat);
    }
    
    public long getCategoriesNo()
    {
        String query = "SELECT COUNT(*) FROM Category";
        Long cat = (Long)hibernateTemplate.find(query).get(0);
        
        return cat;
    }
}
