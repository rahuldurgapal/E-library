/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.StudentService;

@Controller
public class StudentController {
    
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping("/student")
    public String student(Model m)
    {
        
        List<Student> student = studentService.getStudents();
        m.addAttribute("student", student);
        return "student";
    }
    
    @RequestMapping("/add-student")
    public String addStudent()
    {
       
        return "add-student";
    }
    
    @RequestMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student,RedirectAttributes rd)
    {
        System.out.println(student);
        studentService.addStudent(student);
        rd.addFlashAttribute("done","Student Add/Update Successfully.");
        return "redirect:/student";
    }
    
    @RequestMapping("update-student/{st_id}")
    public String updateStudent(@PathVariable("st_id") int id , Model m)
    {
       
        
        Student student = studentService.getStudent(id);
        m.addAttribute("student",student);
        
       return "update-student";
    }
    
    @RequestMapping("/view-student")
    public String viewStudent(@RequestParam("student_id") int id, Model m)
    {
        Student student = studentService.getStudent(id);
        m.addAttribute("student",student);
        
        return "view-student";
    }
    
    @RequestMapping("/delete-student/{s_id}")
    public String deleteStudent(@PathVariable("s_id") int id, HttpSession session)
    {
        boolean st = studentService.isStudentPresentInBookIssue(id);
        if(st)
        {
            session.setAttribute("danger-msg","Cant't delete this student. Book issued to this student.");
        }
        else{
            Student student = studentService.getStudent(id);
            studentService.deleteStudent(student);
            session.setAttribute("success-msg", "Student delete successfully.");
        }
        
        return "redirect:/student";
    }
   
}
