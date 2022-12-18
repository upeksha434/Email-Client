import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

class FileReadWrite {
    private static final String filename="C:\\temp\\clientList.txt";
    public static void writeToFile(String address) {


        try {
            File outFile = new File(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile,true));
            bufferedWriter.append(address).append("\n");
            bufferedWriter.close();

        }
        catch(IOException e) {
            System.err.println(e.getMessage());
        }

    }



    public static ArrayList<Recipients> ReadFile() {
        ArrayList<Recipients> recipients = new ArrayList<>();
        try{
            Stream<String> stream = Files.lines(Paths.get(filename));
            Object[] lines = stream.toArray();
            for (Object line : lines) {
                recipients.add(new Recipients(line.toString()));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return recipients;
    }
}

