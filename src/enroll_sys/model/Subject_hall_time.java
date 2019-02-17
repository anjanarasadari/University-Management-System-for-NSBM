/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enroll_sys.model;

import enroll_sys.db.MysqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anjana
 */
public class Subject_hall_time {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     protected String sub_id;
     protected String Hall_id;
     protected String Start_time;
     protected String End_time;
     protected String Date;

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getHall_id() {
        return Hall_id;
    }

    public void setHall_id(String Hall_id) {
        this.Hall_id = Hall_id;
    }

    public String getStart_time() {
        return Start_time;
    }

    public void setStart_time(String Start_time) {
        this.Start_time = Start_time;
    }

    public String getEnd_time() {
        return End_time;
    }

    public void setEnd_time(String End_time) {
        this.End_time = End_time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public Subject_hall_time(){}
    
    public Subject_hall_time(String sub_id,String Hall_id,String Start_time,String End_time,String Date){
    
    this.sub_id=sub_id;
    this.Hall_id=Hall_id;
    this.Start_time=Start_time;
    this.End_time=End_time;
    this.Date=Date;
     }
    
    public void save(){
        con  = MysqlConnect.ConnectDB();
        String sql= "INSERT INTO sub_hall_time(Sub_id,Hall_id,Start_time,End_time,Date)"+" VALUES(?,?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.sub_id);
             pst.setString(2, this.Hall_id); 
            pst.setString(3, this.Start_time);
            pst.setString(4, this.End_time);
            pst.setString(5, this.Date);
           
            pst.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }       //   return this;
    }
     public void delete(){
       con  = MysqlConnect.ConnectDB();
       String sql="DELETE FROM sub_hall_time WHERE Sub_id=?";
        try {
            pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.sub_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Time slots are Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Undergraduate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Time slots aren't deleted ");
        }
    }
      
}
