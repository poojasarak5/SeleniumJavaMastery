package org.example;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {

            FileInputStream fs = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum(); // Returns total data rows (e.g., 2)
            int colCount = sheet.getRow(0).getLastCellNum(); // Returns total columns
            DataFormatter formatter = new DataFormatter();

            // 1. Initialize array size using rowCount directly
            Object[][] data = new Object[rowCount][colCount];

            // 2. Loop through row 1 to rowCount inclusive
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);

                    // 3. Map Excel row i (starts at 1) to Java index [i - 1] (starts at 0)
                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }

           return data;
        }
    }

//    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
//        FileInputStream fs = new FileInputStream(filePath);
//        XSSFWorkbook wb = new XSSFWorkbook(fs);
//        XSSFSheet sheet = wb.getSheet(sheetName);
//
//        int rowCount = sheet.getLastRowNum();
//        int colCount = sheet.getRow(0).getLastCellNum();
//        DataFormatter formatter = new DataFormatter();
//
//        List<Object[]> validRows = new ArrayList<>();
//
//        for (int i = 1; i <= rowCount; i++) {
//            Row row = sheet.getRow(i);
//            if (row == null) continue;
//
//            // Check if first cell (username) is null or empty
//            Cell firstCell = row.getCell(0);
//            String firstVal = (firstCell == null) ? "" : formatter.formatCellValue(firstCell).trim();
//
//            // Skip empty ghost rows completely
//            if (firstVal.isEmpty()) continue;
//
//            Object[] rowData = new Object[colCount];
//            for (int j = 0; j < colCount; j++) {
//                Cell cell = row.getCell(j);
//                rowData[j] = (cell == null) ? "" : formatter.formatCellValue(cell);
//            }
//            validRows.add(rowData);
//        }
//
//        wb.close();
//        fs.close();
//
//        // Convert dynamic list to 2D array
//        return validRows.toArray(new Object[0][0]);
//    }


