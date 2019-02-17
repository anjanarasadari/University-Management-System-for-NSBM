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


 
 
public class Stu {
    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    protected String id;
    protected String name; 
    protected String email; 
    protected String address; 
    protected String phone; 
    protected String nic; 


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public Stu(String id,String name,String address,String phone,String nic,String email){
        this.id=id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        }
    public Stu(){}
     public Stu saveStu(){
        con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO student(Stu_id, Stu_name,Stu_email, address, phone, nic)"+" VALUES (?,?, ?, ?, ?, ?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
            pst.setString(2, this.name);
            pst.setString(3, this.address);
            pst.setString(4, this.phone);
            pst.setString(5, this.nic);
            pst.setString(6, this.email);
            
           
            
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
              
       return this;
    }
    public static String GetExamR(String student_Id){
       
            Connection con=MysqlConnect.ConnectDB();
           
        try {
             Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM exam_results");
            if(rst.next()){
            return rst.getString(5);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stu.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return null;
         
    }
     
}
