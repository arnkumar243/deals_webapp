package ds.project.deals.utils.email.controller;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Properties;

@RestController
@RequestMapping(path="sendEmail")
public class EmailController {


    @GetMapping
    public String sendEmail() throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "email-smtp.us-west-2.amazonaws.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("AKIAYJMPRFMGEHOH4PNN", "BPOK3V114JA2Xpshg8aIhQ8axmVtnpoLivq9gP8+Xmiq");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("dealsnotifier.317@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("dealsnotifier.317@gmail.com"));
        msg.setSubject("email from deals app");
        msg.setContent("email from deals app", "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);

        return "sent";

    }

}
