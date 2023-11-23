package readingExcel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myFile.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook();
XSSFSheet sheet = workbook.createSheet();


/*XSSFRow row1=sheet.createRow(0);
XSSFRow row2=sheet.createRow(1);
 row1.createCell(0).setCellValue("welcome");
 row1.createCell(1).setCellValue("12345");
 row1.createCell(2).setCellValue("xyz");

 row2.createCell(0).setCellValue("abc");
 row2.createCell(1).setCellValue("4567");
 row2.createCell(2).setCellValue("testing");		
 
 workbook.write(file);
 workbook.close();
 file.close();
 System.out.println("writing is done");*/
 
 //creating rows and cells and updating data using loop
Scanner sc = new Scanner(System.in);
 for(int r=0;r<=5;r++) {
	 XSSFRow currentRow=sheet.createRow(r);
	 for(int c=0;c<3;c++) {
		 System.out.println("enter a value: ");
		 String value = sc.next();
		 currentRow.createCell(c).setCellValue("value");
	 }
	 workbook.write(file);
	 workbook.close();
	 file.close();
 }
 
 
 
	}

}
