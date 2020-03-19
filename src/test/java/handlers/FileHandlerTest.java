package handlers;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.testng.Assert.*;

public class FileHandlerTest {
    String pat = System.getProperty("user.dir");

    @Test
    public void testReadFile() throws IOException {

       String str = FileHandler.readFile(pat+"/src/main/resources/OpFil.txt");
       System.out.println("Text in File"+str);

    }

    @Test
    public void testWriteToNewFile() throws IOException {
        String str = FileHandler.readFile(pat+"/src/main/resources/OpFile.txt");
        FileHandler.writeToFile(pat+"/src/main/resources/OpFile1.txt",str);

    }
    @Test
    public void testWriteToFile() throws IOException {
        String str = FileHandler.readFile(pat+"/src/main/resources/OpFile.txt");
        FileHandler.writeToFile(pat+"/src/main/resources/OpFile1.txt",str,true);

    }

}