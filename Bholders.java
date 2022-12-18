import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author kasuni upeksha
 */
class Bholders {
    public ArrayList<String> names;

    public static void Birthday_holders(ArrayList<Recipients> recepients) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd");
        DateTimeFormatter mailDatef = DateTimeFormatter.ofPattern("yyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();

        for(int i=0; i<recepients.size();i++){
            String bDate = recepients.get(i).birthMonth+"/"+recepients.get(i).birthDate;
            if(bDate.compareTo(dtf.format(now)) == 0){

                System.out.println(recepients.get(i).name);
            }
        }
    }

}

