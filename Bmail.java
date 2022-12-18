import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
/*this is where I am constructing the personal and official friend emails. Then we direct contents to MailObject. MailObject then send the mail.*/
class Bmail extends MailObject{


    public static void sendMail(ArrayList<Recipients> recipients) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
        DateTimeFormatter mailDatef = DateTimeFormatter.ofPattern("yyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        for (Recipients recipient : recipients) {
            String bDate = recipient.birthMonth + "/" + recipient.birthDate;
            if (bDate.compareTo(dtf.format(now)) == 0) {

                MailObject mailObj = new MailObject();
                mailObj.subject = "Happy birth day";
                String type = recipient.type;
                if (type.compareTo("Personal") == 0) {
                    mailObj.body = "hugs and love on your birthday  from Upeksha Jayawickrama";
                } else {
                    mailObj.body = "Wish you a Happy Birthday from Upeksha Jayawickrama";

                }
                mailObj.receiver = recipient.email;
                mailObj.name = recipient.name;
                mailObj.time = mailDatef.format(now);

                mailObj.saveToDisk(mailObj);
                mailObj.sendMail();
            }
        }

    }


}
