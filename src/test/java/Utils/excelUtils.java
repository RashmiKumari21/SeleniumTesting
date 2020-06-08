package Utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtils {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;


	public excelUtils(String excelPath,String sheetName) {
		try {
			projectpath=System.getProperty("user.dir");
			workbook =new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

	public static void getRowCount()
	{
		try {
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows is"+rowCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}


	}
	public static String getCellData(int row,int col) {

		String cellVal="";
		try {
			cellVal= sheet.getRow(row).getCell(col).getStringCellValue();

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellVal;
	}


	public static double getCellDataNumber(int row,int col) {

		double cellVal=0;
		try {
			cellVal= sheet.getRow(row).getCell(col).getNumericCellValue();

		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellVal;
	}
}

