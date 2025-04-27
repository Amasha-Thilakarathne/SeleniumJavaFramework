package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReadXLSData {
//just to test and read the data we get here
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		ReadXLSData rxd = new ReadXLSData();
//		rxd.getData("login");
//
//	}
//	
	@DataProvider(name = "testingdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
	    String excelSheetName = m.getName();
	    File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
	    FileInputStream fis = new FileInputStream(f);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet(excelSheetName);

	    int totalRows = sheet.getLastRowNum();
	    int totalCols = sheet.getRow(1).getLastCellNum(); // get from first data row (not 0)

	    DataFormatter format = new DataFormatter();
	    List<String[]> dataList = new ArrayList<>();

	    for (int i = 1; i <= totalRows; i++) { // start from 1, skip header
	        Row row = sheet.getRow(i);
	        if (row == null || row.getCell(0) == null || row.getCell(0).toString().trim().isEmpty()) {
	            continue; // 🔥 Skip empty rows
	        }

	        String[] rowData = new String[totalCols];
	        for (int j = 0; j < totalCols; j++) {
	            rowData[j] = format.formatCellValue(row.getCell(j));
	            System.out.println(rowData[j]);
	        }
	        dataList.add(rowData);
	    }

	    String[][] dataArray = new String[dataList.size()][totalCols];
	    return dataList.toArray(dataArray);
	}


}
