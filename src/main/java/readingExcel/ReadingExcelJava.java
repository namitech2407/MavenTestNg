package readingExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File-workbook-sheets-rows-cells

public class ReadingExcelJava {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/TestData/test_data_sample           2023-10-05.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1"); //workbook.getSheetAt(0);
		int totalrows = sheet.getLastRowNum();
		int totalcells = sheet.getRow(1).getLastCellNum();

		System.out.println("number of rows:" + totalrows); //5 starts from 0
		System.out.println("number of cells:" + totalcells); //4 starts from 1

		for(int r =0;r<=totalrows;r++) {

			XSSFRow currentRow = sheet.getRow(r);

			for (int c=0;c<totalcells;c++) {

				String value = currentRow.getCell(c).toString();
				System.out.print(value+ "   ");
			}
			System.out.println();
		}

		workbook.close();
		file.close();
	}

}
