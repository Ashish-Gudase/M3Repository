package readExceldata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testData/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);// To make the file ready to read
		Sheet sheet = wb.getSheet("IPL");// To get into the desired sheet
		Row row1 = sheet.getRow(1);// to get into the row
		Cell cell1 = row1.createCell(2);// to create new column
		cell1.setCellValue("Pune");// to set value of a column
		Row row2 = sheet.createRow(10);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("Punjab_Kings");
		FileOutputStream fos = new FileOutputStream("./testData/testData.xlsx");
		wb.write(fos);// to write data into excel file
	}

}
