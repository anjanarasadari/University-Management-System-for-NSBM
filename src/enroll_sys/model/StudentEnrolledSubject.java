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
import java.sql.Statement;

/**
 *
 * @author Anjana
 */
public class StudentEnrolledSubject {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
     
   protected String stu_id;
   protected String sub_id;
   protected int credit;
   protected int fee;

    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public int getFee() {
        return fee;
    }
    public void setFee(int fee) {
        this.fee = fee;
    }
    public String getStu_id() {
        return stu_id;
    }
    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
    public String getSub_id() {
        return sub_id;
    }
    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }
    
    public StudentEnrolledSubject(String stu_id,String sub_id,int credit,int fee){
      this.stu_id=stu_id;
      this.sub_id=sub_id;
      this.credit=credit;
      this.fee=fee;
    
    }
    
    public StudentEnrolledSubject(){}
      public void saveSOC(){
       con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO student_subject(student_id,subject_id,fee,Credit)"+" VALUES (?,?,?,?)";
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.stu_id);
             pst.setString(2, this.sub_id);
             pst.setInt(3, this.fee);
              pst.setInt(4, this.credit);
             
             
      
      
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
     
    
    
    
}
