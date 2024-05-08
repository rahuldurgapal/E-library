/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import model.Setting;



public class AdminDao {
    
    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    
    public Admin getUserByUsername(String username) {
        List<Admin> admin = (List<Admin>) hibernateTemplate.findByNamedParam(
                "from Admin where username = :username", "username", username);
        return admin.isEmpty() ? null : admin.get(0);
}
    
    public Setting getSetting()
    {
        Setting setting = hibernateTemplate.get(Setting.class, 1);
        return setting;
    }
    
    @Transactional
    public void updateSetting(Setting setting)
    {
        hibernateTemplate.update(setting);
    }
    
   
    
}
