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
public class Undergraduate extends Stu{
    
    
    
    protected String AL_index;
    protected String rank;

    public String getAL_index() {
        return AL_index;
    }

    public void setAL_index(String AL_index) {
        this.AL_index = AL_index;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
     public Undergraduate(String id,String name,String address,String phone,String nic,String email,String AL_index,String rank){
        this.id=id;
        this.AL_index = AL_index;
        this.rank = rank;
        this.id=id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
    
}
     
    public Undergraduate(){}
     public void saveUndergraduate(){
        con  = MysqlConnect.ConnectDB();
        String sql= "INSERT INTO undergradu_stu(Stu_id,Stu_name,Address,Mobile_Number, nic,Stu_email,AL_index,rank)"+" VALUES(?,?,?,?,?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
             pst.setString(2, this.name); 
            pst.setString(3, this.address);
            pst.setString(4, this.phone);
            pst.setString(5, this.nic);
            pst.setString(6, this.email);
            pst.setString(7, this.AL_index);
            pst.setString(8, this.rank);
            
             pst.executeUpdate();
         
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
              
//        return this;
    }
    
     
    public void deleteundergrduate(){
        
       con  = MysqlConnect.ConnectDB();
       String sql="DELETE FROM undergradu_stu WHERE Stu_id=?";
       
        try {
            pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Undergraduate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Student not deleted ");
        }
    
    }
    public static Undergraduate Searchundergraduate(String id)throws Exception{
        try {
            Connection con=MysqlConnect.ConnectDB();
            
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  undergradu_stu where Stu_id='"+id+"'");
            if(rst.next()){
                return new Undergraduate(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8)
                ); }
            else{
            }
        } catch (SQLException ex) {
            Logger.getLogger(Undergraduate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
       
   
 
   
        
     
   
 
