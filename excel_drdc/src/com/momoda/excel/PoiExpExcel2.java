package com.momoda.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PoiExpExcel2 {

	/**POI生成excel文件(使用XSSF生成)
	 * @param args
	 */
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};
		//创建excel工作薄
		XSSFWorkbook workbook = new XSSFWorkbook();
		//创建一个工作表sheet
		XSSFSheet sheet =workbook.createSheet();
		//创建第一行
		XSSFRow row = sheet.createRow(0);
		
		XSSFCell cell = null;
		//插入第一行数据：id,name,sex
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		
		//追加数据
		for (int i = 1; i <= 10; i++) {
			XSSFRow nextrow = sheet.createRow(i);
			XSSFCell cell2 = nextrow.createCell(0);
			cell2.setCellValue("a"+i);
			
			cell2 = nextrow.createCell(1);
			cell2.setCellValue("user"+i);
			
			cell2 = nextrow.createCell(2);
			cell2.setCellValue("女");
		}
		
		File file = new File("D:/poi_test.xlsx");
		try {
			file.createNewFile();
			//将Excel内容存盘
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
