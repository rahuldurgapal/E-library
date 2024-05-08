

package controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CategoryService;



@Controller
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping("/category")
    public String category(Model m)
    {
        
        
        List<Category> category = categoryService.getCategories();
        m.addAttribute("category",category);
        
        return "category";
    }
    
    @RequestMapping("/add-category")
    public String addCategory()
    {
        
        return "add-category";
    }
    
    @RequestMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes rd)
    {
        System.out.println(category);
        categoryService.saveCategory(category);
        rd.addFlashAttribute("done","Category add/update successfully.");
        
        return "redirect:/category";
    }
    
    @RequestMapping("/update-category/{cat_id}")
    public String updateCategory(@PathVariable("cat_id") int id, Model m)
    {
        
        
        Category cat = categoryService.getCategory(id);
        m.addAttribute("cat",cat);
        
        return "update-category";
        
    }
    
    @RequestMapping("/delete-category/{cat_id}")
    public String deleteCategory(@PathVariable("cat_id") int id, HttpSession session)
    {
        boolean isCategoryPresentInBook = categoryService.isCategoryPresentInBook(id);
        if(isCategoryPresentInBook)
        {
            session.setAttribute("danger-msg", "Can't delete category record. This categoyr is associated with books.");
        }
        else{
            Category cat = categoryService.getCategory(id);
            categoryService.deleteCategory(cat);
            session.setAttribute("success-msg", "Publisher deleted successfully.");
        }
        
        return "redirect:/category";
    }
}
