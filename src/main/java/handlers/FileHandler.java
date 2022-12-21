package handlers;

import java.io.*;

public class FileHandler {

    String folderPath = "/src/test/resources/";
    String absPath;

    public FileHandler() {
        absPath = System.getProperty("user.dir") + folderPath;
    }


    public static String readFile(String path) throws IOException {
        File ex = new File(path);
        boolean exists = ex.exists();
        if (exists) {
            BufferedReader rd = new BufferedReader(new FileReader(ex));
            String st1;
            StringBuilder sd = new StringBuilder();
            while ((st1 = rd.readLine()) != null) {
                sd.append("\n");
                sd.append(st1);
            }
            return sd.toString();
        } else {
            System.out.println("File not exists");
            return null;
        }

    }


    public static void writeToFile(String fName, String data) throws IOException {
        writeToFile(fName, data, false);
    }

    public static void writeToFile(String fName, String data, boolean app) throws IOException {
        FileWriter ex1 = new FileWriter(fName, app);
        BufferedWriter bd = new BufferedWriter(ex1);
        bd.write(data);
        bd.close();
    }

}
