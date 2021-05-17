package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import commonLibrary.SystemConfiguration;

public class ApachePOIExcelLibrary extends SystemConfiguration 
{
	public static File src;
	public static Workbook workbook;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static Sheet sheet;

	public ApachePOIExcelLibrary(String filePath,int sheetNo)
	{
		try
		{
			src = new File (filePath);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(sheetNo);
		}
		catch(Exception e)
		{
			System.out.println("Exception Occurs In LoadWorkbook()");
			e.getMessage();
		}
	}

	public void closeWorkbook()
	{
		try
		{
			workbook.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception Occurs In CloseWorkbook()");
			e.getMessage();
		}
	}

	public int getRowCount()
	{
		int rowCount = sheet.getLastRowNum();
		rowCount = rowCount+1;
		return rowCount;
	}

	public int getColumnCount()
	{
		int columnCount = sheet.getRow(0).getLastCellNum();
		return columnCount;
	}

	public int getCellCount()
	{
		int cellCount = getColumnCount()*getRowCount();
		return cellCount;
	}

	public String getCellData(int row,int column)
	{
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
