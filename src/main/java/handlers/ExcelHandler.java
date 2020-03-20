package handlers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelHandler {

    public static Map<String, Object[]> read(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        Iterator<Row> rowIterator = sheet.iterator();
        int i = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Object[] aa = new Object[10];
            int j = 0;
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        Double da = cell.getNumericCellValue();
                        aa[j] = da;
                        break;
                    case Cell.CELL_TYPE_STRING:
                        String st = cell.getStringCellValue();
                        aa[j] = st;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cell.getCellType());
                }
                j++;
            }
            data.put(Integer.toString(i), aa);
            i++;
        }
        file.close();
        return data;
    }

    public static void write(String path, String sheetName, Map<String, Object[]> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(path));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getDocumentType() {
        //
    }

}
