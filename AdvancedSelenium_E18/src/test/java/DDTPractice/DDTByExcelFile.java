package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("C:\\Users\\Nishanth\\eclipse-workspace\\AdvancedSelenium_E18\\src\\test\\resources\\Project Hanma.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String ProdName = wb.getSheet("testTable").getRow(1).getCell(2).getStringCellValue();
		Double Qty = wb.getSheet("testTable").getRow(1).getCell(3).getNumericCellValue();
		
		System.out.println(ProdName);
		System.out.println(Qty);
		
		

	}

	
}
