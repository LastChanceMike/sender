package controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by DORDV on 17.08.2018.
 */
public class Sender {
    private String userName;
    private String password;
    private Properties properties;

    public Sender(String userName, String password) {
        this.userName = userName;
        this.password = password;

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        //properties.put("mail.smtp.host", "smtp.gmail.com");
        //properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.host", "mannatech.com.ua");
        properties.put("mail.smtp.port", "465");

    }

    public void send(String subgect, String text, String fromMail, String toMail){
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
            message.setSubject(subgect);
            //message.setText(text);
            message.setContent(text,"text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
