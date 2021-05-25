import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static String readTextFromFile(FileReader file) {

        String resultString = "";
        int c;

        try {
            while((c=file.read())!=-1){
                resultString += (char)c;
            }
        }
        catch (IOException e) {
            e.getMessage();
        }

        return resultString;
    }
}
