package handlers;

import org.testng.annotations.Test;

import java.io.IOException;

public class FileHandlerTest extends FileHandler {

    @Test
    public void testReadFile() throws IOException {
        String str = FileHandler.readFile(absPath + "OpFil.txt");
        System.out.println("Text in File" + str);
    }

    @Test
    public void testWriteToNewFile() throws IOException {
        String str = FileHandler.readFile(absPath + "OpFile.txt");
        FileHandler.writeToFile(absPath + "OpFile1.txt", str);
    }

    @Test
    public void testWriteToFile() throws IOException {
        String str = FileHandler.readFile(absPath + "OpFile.txt");
        FileHandler.writeToFile(absPath + "OpFile1.txt", str, true);
    }

}