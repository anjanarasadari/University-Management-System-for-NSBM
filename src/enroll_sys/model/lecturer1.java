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
public class lecturer1 {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected String id; 
    protected String name; 
    protected String email; 
    protected String address;
    protected String phone; 
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

   
    
     public lecturer1(String id,String name,String email,String address,String phone, String room, String sub_id,String location,String duration){
        this.id=id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.room=room;
        this.sub_id=sub_id;
        this.location=location;
        this.duration=duration;
          
}
     
    public lecturer1(){}
     public void savelecturer(){
        con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO lecturer(Lect_id,Lect_name,Lect_email,Address,Mobile_Number,Room,Sub_id,Location_id,Duration)"+" VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
             pst.setString(2,this.name); 
            pst.setString(3, this.email);
            pst.setString(4, this.address);
            pst.setString(5, this.phone);
            pst.setString(6, this.room);
            pst.setString(7, this.sub_id);
            pst.setString(8, this.location);
            
             pst.executeUpdate();
           // rs = pst.getGeneratedKeys();
            //if(rs.next()){
               //this.id = rs.getString(1);
//                return this;
            //}
            
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
              
//        return this;
    }
     
    public void deletelecturer(){
          con  = MysqlConnect.ConnectDB();
       String sql="DELETE FROM lecturer WHERE Lect_id=?";
       
        try {
            pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lecturer Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(lecturer1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Lecturer not deleted ");
        }



    }
    public static lecturer1 Searchlecturer(String id)throws Exception{
        
        try {
            Connection con=MysqlConnect.ConnectDB();
            
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  lecturer where Lect_id='"+id+"'");
            if(rst.next()){
                return new lecturer1(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8),
                        rst.getString(9)
                );
            }
            else{
            }
        } catch (SQLException ex) {
            Logger.getLogger(lecturer1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
       
   
 
   
        
     
   
 
