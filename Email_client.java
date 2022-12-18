import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Email_Client  {
    public static void main(String[] args) throws Exception{
        int flag=0;
        ArrayList<Recipients> recipients = FileReadWrite.ReadFile();

        Bmail.sendMail(recipients);//this sends mails to birthday holders
        while(flag!=-1){

            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                           Enter option type: 
                           1 - Adding a new recipient
                           2- Sending an email
                           3 - Printing out all the recipients who have birthdays today
                           4 - Printing out details of all the emails sent on a given date
                           5 - Printing out the number of recipient objects in the application
                           6 - to terminate and exit the application""");
            int option = scanner.nextInt();

            switch(option){
                case 1 -> {
                    System.out.println("Enter Recipient:");
                    System.out.println("Personal -> Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10");
                    System.out.println("0ffice _friend-> Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12");
                    System.out.println("0ffice-> Official: nimal,nimal@gmail.com,ceo");

                    String recipient = scanner.next();
                    FileReadWrite.writeToFile(recipient);
                }
                case 2 -> {
                    System.out.println("Enter email,recipient name,subject and body");
                    String reciver = scanner.next();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String subject = scanner.nextLine();
                    String body=  scanner.nextLine();
                    System.out.println("Your email sent successfully....");
                    DateTimeFormatter mailDatef = DateTimeFormatter.ofPattern("yyy-MM-dd-HH-mm-ss");
                    LocalDateTime now = LocalDateTime.now();
                    MailObject mObj = new MailObject();
                    mObj.receiver = reciver;
                    mObj.name=name;
                    mObj.subject = subject;
                    mObj.body = body;
                    mObj.time = mailDatef.format(now);
                    mObj.saveToDisk(mObj);
                    mObj.sendMail();
                }
                case 3 -> {
                    System.out.println("Birthday Celebrators today : ");
                    Bholders.Birthday_holders(recipients);
                }
                case 4 -> MailObject.readAllMailsFromDisk();
                case 5 -> System.out.println(recipients.size()+" recipients are in the application");
                case 6->
                {
                    System.out.println("terminating.................");
                    flag=-1;
                    break;
                }
            }

        }
    }}
