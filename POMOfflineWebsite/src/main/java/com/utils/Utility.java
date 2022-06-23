package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	public static String readProperties(String key) throws Exception
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(fis);
		return properties.getProperty(key);
	}
	
	public static String[][] getDataFromAnyExcelSheet(String filePath, String sheetName) throws Exception
	{
		DataFormatter df  = new DataFormatter();
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rows = sheet.getLastRowNum(); 		// 2 [actual 3 but gives 2] row count starts with 0
		int cols = sheet.getRow(0).getLastCellNum(); 	// 8 [actual 8 and gives 8] column count starts with 1
		String[][] data = new String[rows][cols];	// [2][8]--->[0,1]x[0,1,2,3,4,5,6,7]
		for (int i = 0; i < rows; i++) 	// (i=0; i<2; i++)---> i = 0,1
		{
			for (int j = 0; j < cols; j++) // (j=0; j<8; j++)---> j = 0,1,2,3,4,5,6,7
			{
				Cell cell = sheet.getRow(i+1).getCell(j);	// 0+1, 1+1
				String value = df.formatCellValue(cell);
				data[i][j] = value;		
			}
		}
		return data;
		//				2D array
		// 		0	1	2	3	4	5	6	7
		// 0	x	x	x	x	x	x	x	x
		// 1	x	x	x	x	x	x	x	x
	}
}
