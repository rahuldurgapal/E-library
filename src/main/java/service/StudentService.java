/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.StudentDao;
import java.util.List;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;



public class StudentService {
    
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private BookService bookService;
    
    public void addStudent(Student student)
    {
         studentDao.addStudent(student);
    }
    
    public List<Student> getStudents()
    {
        return studentDao.getAllStudent();
    }
    
    public Student getStudent(int id)
    {
        return studentDao.getStudent(id);
    }
    
    public boolean isStudentPresentInBookIssue(int id)
    {
        return bookService.isStudnetPresentInBookIssue(id);
    }
    
    public void deleteStudent(Student student)
    {
         studentDao.deleteStudent(student);
    }
    
    public long getStudentsNo()
    {
        return studentDao.getStudentsNo();
    }
}
