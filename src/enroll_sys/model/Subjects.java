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
public class Subjects {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     protected String sub_id;
     protected String Sub_name;
     protected String credit_hours;
     protected String year;
     protected String semester_term;
     protected String Type;
     protected String fees;
     protected String Lect_id;

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return Sub_name;
    }

    public void setSub_name(String Sub_name) {
        this.Sub_name = Sub_name;
    }

    public String getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(String credit_hours) {
        this.credit_hours = credit_hours;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester_term() {
        return semester_term;
    }

    public void setSemester_term(String semester_term) {
        this.semester_term = semester_term;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getLect_id() {
        return Lect_id;
    }

    public void setLect_id(String Lect_id) {
        this.Lect_id = Lect_id;
    }
    public Subjects(String sub_id,String Sub_name,String credit_hours,String year,String semester_term,String Type,String fees,String Lect_id){
        this.sub_id=sub_id;
        this.Sub_name =Sub_name ;
        this.credit_hours=credit_hours;
        this.year=year;
        this.semester_term=semester_term;
        this.Type=Type;
        this.fees=fees;
        this.Lect_id=Lect_id;
}
    
    public Subjects(){}
     public void saveSubject(){
        con  = MysqlConnect.ConnectDB();
        String sql= "INSERT INTO subject(Sub_id,Sub_name,credit_hours,year,semester_term,Type,fees,Lect_id)"+" VALUES(?,?,?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.sub_id);
             pst.setString(2, this.Sub_name); 
            pst.setString(3, this.credit_hours);
            pst.setString(4, this.year);
            pst.setString(5, this.semester_term);
            pst.setString(6, this.Type);
            pst.setString(7, this.fees);
            pst.setString(8, this.Lect_id);
            pst.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }       //   return this;
    }
    public void deleteSubject(){
       con  = MysqlConnect.ConnectDB();
       String sql="DELETE FROM subject WHERE Sub_id=?";
        try {
            pst=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.sub_id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subject Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Undergraduate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Subject not deleted ");
        }
    }
     public static Subjects Searchsubject(String id)throws Exception{
        try {
            Connection con=MysqlConnect.ConnectDB();
            
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  subject where Sub_id='"+id+"'");
            if(rst.next()){
                return new Subjects(
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
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public static Subjects SearchsubjectL(String id)throws Exception{
        try {
            Connection con=MysqlConnect.ConnectDB();
            
            Statement stm = con.createStatement();
            ResultSet rst = stm.executeQuery("Select * From  subject where Lect_id='"+id+"'");
            if(rst.next()){
                return new Subjects(
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
            Logger.getLogger(Subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
