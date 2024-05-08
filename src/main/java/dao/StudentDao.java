/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;



public class StudentDao {
    
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Transactional
    public void addStudent(Student student)
    {
        hibernateTemplate.saveOrUpdate(student);
    }
    
    public List<Student> getAllStudent()
    {
        List<Student> student = hibernateTemplate.loadAll(Student.class);
        return student;
    }
    
    public Student getStudent(int id)
    {
        Student student = hibernateTemplate.get(Student.class, id);
        return student;
    }
    
    @Transactional
    public void deleteStudent(Student student)
    {
        hibernateTemplate.delete(student);
    }
    
    public long getStudentsNo()
    {
        String query = "SELECT COUNT(*) FROM Student";
        Long std = (Long)hibernateTemplate.find(query).get(0);
        
        return std;
    }
}
