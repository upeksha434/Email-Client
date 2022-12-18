import com.sun.jdi.connect.Transport;

import javax.jms.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;



abstract class Mailable {
    private static final String userName = "upeksha434@gmail.com";
    private static final String password = "5E0F92E55836980B1E3AD0CA5085D216A4C5";

    private static Properties getProps(){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "smtp.elasticemail.com");
        prop.put("mail.smtp.port", "2525");
        prop.put("mail.smtp.ssl.trust", "smtp.elasticemail.com");
        return prop;
    }



    public void sendMail(MailObject mailObject) {
        try {
            Properties prop = getProps();

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailObject.receiver));
            message.setSubject(mailObject.subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(mailObject.body, "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            message.setContent(multipart);
            Transport.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public abstract void sendMail();
}

