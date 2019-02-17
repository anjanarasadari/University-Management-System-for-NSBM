/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enroll_sys.model;

import enroll_sys.db.MysqlConnect;
import enroll_sys.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anjana
 */
public class Assignment {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String year;
    String student_Id;
    String subject_Id;
    String Assignment_No;
    String Assignment_Type;
    String grade;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public String getSubject_Id() {
        return subject_Id;
    }

    public void setSubject_Id(String subject_Id) {
        this.subject_Id = subject_Id;
    }

    public String getAssignment_No() {
        return Assignment_No;
    }

    public void setAssignment_No(String Assignment_No) {
        this.Assignment_No = Assignment_No;
    }

    public String getAssignment_Type() {
        return Assignment_Type;
    }

    public void setAssignment_Type(String Assignment_Type) {
        this.Assignment_Type = Assignment_Type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public Assignment(String year,String student_Id,String subject_Id,String Assignment_No,String Assignment_Type,String grade){
    
    this.year=year;
    this.student_Id=student_Id;
    this.subject_Id=subject_Id;
    this.Assignment_No=Assignment_No;
    this.Assignment_Type=Assignment_Type;
    this.grade=grade;
    
  }
    
    public Assignment(){}
    
    public void saveAssignment(){
        con = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO assignments(year,student_Id,subject_Id,Assignment_No,Assignment_Type,Grade)"+" VALUES (?,?,?,?,?,?)";
        
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
             pst.setString(1, this.year);
             pst.setString(2, this.student_Id);
             pst.setString(3, this.subject_Id);
             pst.setString(4, this.Assignment_No);
             pst.setString(5, this.Assignment_Type);
             pst.setString(6, this.grade);
             
             pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
             
        
    }  
}
