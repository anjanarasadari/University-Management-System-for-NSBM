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
public class Postgraduate extends Stu {
    
    
    protected String qulifi_type;
    protected String institute; 
    protected String yr_of_complete; 
   
    public String getQulifi_type() {
        return qulifi_type;
    }

    public void setQulifi_type(String qulifi_type) {
        this.qulifi_type = qulifi_type;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYr_of_complete() {
        return yr_of_complete;
    }

    public void setYr_of_complete(String yr_of_complete) {
        this.yr_of_complete = yr_of_complete;
    }
    public Postgraduate(String id,String name,String address,String phone,String nic,String email,String qulifi_type ,String institute,String yr_of_complete){
        this.id=id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.nic = nic;
        this.email = email;
        this.qulifi_type = qulifi_type;
        this.institute = institute;
        this.yr_of_complete=yr_of_complete;
          
}
     
    public Postgraduate(){}

    /**
     *
     */
    public void savepostgraduate(){
        con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO postgradu_stu(Stu_id,Stu_name,Address,Mobile_Number,nic,Stu_email,qulifi_type,institute,yr_of_complete)"+" VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.id);
             pst.setString(2, this.name);
            pst.setString(3, this.address);
            pst.setString(4, this.phone);
            pst.setString(5, this.nic);
            pst.setString(6, this.email);
            pst.setString(7, this.qulifi_type);
            pst.setString(8, this.institute);
            pst.setString(9, this.yr_of_complete);
            
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

    void show_Postgratuates() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void deletepostgrduate(){
        
       con  = MysqlConnect.ConnectDB();
       String sql="DELETE FROM postgradu_stu WHERE Stu_id=?";
       
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
     
    public static Postgraduate Searchpostgraduate(String id) throws SQLException{
        try {
            Connection con=MysqlConnect.ConnectDB();
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  postgradu_stu where Stu_id='"+id+"'");
            if(rst.next()){
                return new Postgraduate(
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
        } catch (SQLException ex) {
            Logger.getLogger(Postgraduate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

        
           
    
    