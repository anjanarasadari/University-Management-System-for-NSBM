/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enroll_sys.model;
import static java.lang.ProcessBuilder.Redirect.to;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Anjana
 */
public class Email {
    public static void sendmail(String msgtext,String Stu_id) throws SQLException{
        try{
             String host ="smtp.gmail.com" ;
             String user = "anjanarasadari21@gmail.com"; //"receievmail@gmail.com";
             String pass = "fmsucscg5";//"receiev123";
             String to ="roshanisrr@gmail.com";
            //System.out.println(Stu.get);
            //String to =Stu.getEmailAddress(Stu_id);
            String from = "anjanarasadari21@gmail.com";//"receievmail@gmail.com";
            String subject = "NSBM Green University";
            String messageText = msgtext;
            boolean sessionDebug = false;
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);
           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(MessagingException ex)
        {
            System.out.println(ex);
        }
    }

    
}


