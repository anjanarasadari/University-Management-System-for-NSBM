/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enroll_sys.model;

import enroll_sys.db.MysqlConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anjana
 */
public class Instructor1 {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected String id; 
    protected String name; 
    protected String email; 
    protected String room; 
    protected String sub_id;
    protected String location;
    protected String duration;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   
    
     public Instructor1(String id,String name,String email, String room, String sub_id,String location,String duration){
        this.id=id;
        this.name = name;
        this.email = email;
        this.room=room;
        this.sub_id=sub_id;
        this.location=location;
        this.duration=duration;
          
}
     
    public Instructor1(){}
     public void saveInstructor(){
        
    }
    
     
    public void deleteInstrutor(){
        
       
    }
    public static Instructor1 SearchInstructor(String id)throws Exception{
        
        try {
            Connection con=MysqlConnect.ConnectDB();
            
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  instructor where Inst_id='"+id+"'");
            if(rst.next()){
                return new Instructor1(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7)
                        
                );
            }
            else{
            }
        } catch (SQLException ex) {
            Logger.getLogger(Instructor1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
       
   
 
   
        
     
   
 
