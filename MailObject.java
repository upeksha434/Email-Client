import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kasuni upeksha
 */
class MailObject extends Mailable implements java.io.Serializable {
    public String receiver;
    public String subject;
    public String body;
    public String name;
    public String time;

    void saveToDisk(MailObject mailObject){
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\temp\\mails\\" + time);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(mailObject);
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<MailObject> readAllMailsFromDisk(){
        try{
            File folder = new File("C:\\temp\\mails\\");

            File[] listOfFiles = folder.listFiles();
            System.out.println("Enter the date in the format YYYY-MM-DD ex:2022-08-14");//parameters pass to readAllmailsFromDisk gives invalidclassException
            Scanner scanner = new Scanner(System.in);
            String given = scanner.nextLine();

            ArrayList<MailObject> mailObjList = new ArrayList<>();
            assert listOfFiles != null;
            for (File listOfFile : listOfFiles) {
                FileInputStream fileIn = new FileInputStream(listOfFile.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn);
                MailObject mailObj = (MailObject) in.readObject();
                // System.out.println(mailObj.receiver);

                String[] userTypes = listOfFile.getPath().split("\\\\");
                String[] datetype = userTypes[3].split("-");
                String date_of = datetype[0] + "-" + datetype[1] + "-" + datetype[2];
                if (date_of.compareTo(given) == 0) {
                    System.out.println("recipient-> " + mailObj.name + "  subject-> " + mailObj.subject);

                }
                in.close();
                fileIn.close();
                //mailObjList.add(mailObj);
            }
            return mailObjList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public void sendMail() {
        super.sendMail(this);
    }
}


