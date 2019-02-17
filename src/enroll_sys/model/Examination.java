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

/**
 *
 * @author Anjana
 */
public class Examination {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
  
    String year;
    String student_Id;
    String subject_Id;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public Examination(String year,String student_Id,String subject_Id,String grade ){
    this.year=year;
    this.student_Id=student_Id;
    this.subject_Id=subject_Id;
    this.grade=grade;
    
    }
    
     public Examination(){}
     public void saveExam(){
       con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO exam_results(year,student_Id,subject_Id,Grade)"+" VALUES (?,?,?,?)";
        
    
        try {
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
             pst.setString(1, this.year);
             pst.setString(2, this.student_Id);
             pst.setString(3, this.subject_Id);
             pst.setString(4, this.grade);
             
             
             pst.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(Examination.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             
             
}
}
