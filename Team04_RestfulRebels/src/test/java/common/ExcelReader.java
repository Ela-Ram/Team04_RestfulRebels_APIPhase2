package common;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelReader {

    private static final String FILE_PATH = ConfigReader.getProperty("Excel_Path");

    // Thread-local storage for FileInputStream and Workbook to ensure thread safety
    private static ThreadLocal<FileInputStream> threadLocalFileInputStream = ThreadLocal.withInitial(() -> {
        try {
            return new FileInputStream(FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error opening Excel file", e);
        }
    });

    private static ThreadLocal<Workbook> threadLocalWorkbook = ThreadLocal.withInitial(() -> {
        try {
            return new XSSFWorkbook(threadLocalFileInputStream.get());
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel workbook", e);
        }
    });

    // Caching test data to improve performance when multiple threads access the same data
    private static final Map<String, Map<String, String>> cachedTestData = new ConcurrentHashMap<>();

    // Fetch test data for a specific test case ID as a Map
    public static Map<String, String> getTestData(String sheetName, String testCaseID) throws IOException {
        // Check the cache first
        if (cachedTestData.containsKey(testCaseID)) {
            return cachedTestData.get(testCaseID);
        }

        try (FileInputStream file = threadLocalFileInputStream.get();
             Workbook workbook = threadLocalWorkbook.get()) {

            Sheet sheet = workbook.getSheet(sheetName);
            Map<String, String> testData = new HashMap<>();
            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next();  // First row as headers

            while (rowIterator.hasNext()) {
                Row currentRow = rowIterator.next();
                Cell firstCell = currentRow.getCell(0);  // TestCaseID column

                if (firstCell != null && firstCell.getStringCellValue().equalsIgnoreCase(testCaseID)) {
                    // Loop through each cell in the row and map the data to the header
                    for (int i = 0; i < currentRow.getLastCellNum(); i++) {
                        String header = headerRow.getCell(i).getStringCellValue();
                        Cell cell = currentRow.getCell(i);
                        String value = (cell == null) ? "" : cell.toString();
                        testData.put(header, value);
                    }
                    break;
                }
            }
            // Cache the data for future use
            cachedTestData.put(testCaseID, testData);
            return testData;
        }
    }

    // Fetch all values for a specific header across all rows
    public static List<String> getValuesForHeader(String sheetName, String headerName) throws IOException {
        try (FileInputStream file = threadLocalFileInputStream.get();
             Workbook workbook = threadLocalWorkbook.get()) {

            Sheet sheet = workbook.getSheet(sheetName);
            List<String> values = new ArrayList<>();
            Iterator<Row> rowIterator = sheet.iterator();
            Row headerRow = rowIterator.next();  // First row as headers

            // Find the column index for the specified header
            int columnIndex = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                if (headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(headerName)) {
                    columnIndex = i;
                    break;
                }
            }

            // Collect values for the specified header
            if (columnIndex != -1) {
                while (rowIterator.hasNext()) {
                    Row currentRow = rowIterator.next();
                    Cell cell = currentRow.getCell(columnIndex);  // Get the value in the specified column
                    if (cell != null && cell.getCellType() == CellType.STRING) {
                        values.add(cell.getStringCellValue());  // Add value to the list
                    }
                }
            } else {
                System.out.println("Header '" + headerName + "' not found in the sheet.");
            }

            return values;  // Return the list of values
        }
    }
}
