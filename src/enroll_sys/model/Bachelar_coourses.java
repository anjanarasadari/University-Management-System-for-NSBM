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
public class Bachelar_coourses {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    protected String course_id;
    protected String stu_id; 
    protected String course_name; 
    protected String course_du; 

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

   public String getCourse_du() {
        return course_du;
    }

    public void setCourse_du(String course_du) {
        this.course_du = course_du;
    }
   
   public Bachelar_coourses(String course_id,String stu_id,String course_name,String course_du ){
        this.course_id=course_id;
        this.stu_id = stu_id;
        this.course_name =course_name;
        this.course_du = course_du;
   }
   
   public Bachelar_coourses(){}
   public void saveBachelar(){
        con  = MysqlConnect.ConnectDB();
        String sql = "INSERT INTO Bachelar_Courses(course_id,stu_id,course_name,Duration)"+" VALUES (?,?,?,?)";
        
        
        try{
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, this.course_id);
            pst.setString(2, this.stu_id);
            pst.setString(3, this.course_name);
            pst.setString(4, this.course_du);
           
            
           
            
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

    
    
    
    
    
    
    
    
    

