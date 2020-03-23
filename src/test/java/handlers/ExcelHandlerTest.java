package handlers;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class ExcelHandlerTest {

    String folderPath = "/src/test/resources/";
    String absPath = System.getProperty("user.dir") + folderPath;
    Map<String, Object[]> read, write;

    @Test
    public void testRead() throws IOException {
        read = ExcelHandler.read(absPath + "ExcelData.xlsx");
        System.out.println(read.get("2")[0]);
        System.out.println(read.get("2")[1]);
        System.out.println(read.get("2")[2]);
    }

    @Test
    public void testWrite() throws IOException {
        write = ExcelHandler.read(absPath + "ExcelData.xlsx");
        ExcelHandler.write(absPath + "ExcelDataWrite1.xlsx", "Employee Data", write);
    }
}