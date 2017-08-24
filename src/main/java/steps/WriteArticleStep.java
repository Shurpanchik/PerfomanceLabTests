package steps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteArticleStep {
    public WriteArticleStep(String text,String fileName){
        try {
            FileWriter writer = new FileWriter(fileName, false);
            try {
                writer.write(text);
                writer.flush();
            } finally {
                writer.close();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
