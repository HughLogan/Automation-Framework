package handlers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelHandler {

    public static Map<String, Object[]> read(String path) throws IOException {
        try (FileInputStream file = new FileInputStream(path); XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            Map<String, Object[]> data = new HashMap<>();
            Iterator<Row> rowIterator = sheet.iterator();
            int i = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                Object[] values = new Object[10];
                int j = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            values[j] = cell.getNumericCellValue();
                            break;
                        case STRING:
                            values[j] = cell.getStringCellValue();
                            break;
                        default:
                            values[j] = cell.toString();
                            break;
                    }
                    j++;
                }
                data.put(Integer.toString(i), values);
                i++;
            }
            return data;
        }
    }

    public static void write(String path, String sheetName, Map<String, Object[]> data) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); FileOutputStream out = new FileOutputStream(path)) {
            XSSFSheet sheet = workbook.createSheet(sheetName);
            Set<String> keyset = data.keySet();
            int rownum = 0;
            for (String key : keyset) {
                Row row = sheet.createRow(rownum++);
                Object[] objArr = data.get(key);
                int cellnum = 0;
                for (Object obj : objArr) {
                    if (obj == null) {
                        continue;
                    }
                    Cell cell = row.createCell(cellnum++);
                    if (obj instanceof String) {
                        cell.setCellValue((String) obj);
                    } else if (obj instanceof Double) {
                        cell.setCellValue((Double) obj);
                    } else if (obj instanceof Number) {
                        cell.setCellValue(((Number) obj).doubleValue());
                    } else {
                        cell.setCellValue(String.valueOf(obj));
                    }
                }
            }
            workbook.write(out);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to write Excel file: " + path, e);
        }
    }

}
