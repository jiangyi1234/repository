package com.momoda.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


/**
 * JXL解析excel
 * @author Ifugle2016
 *
 */
public class JxlReadExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//创建workbook并制定路径
		try {
			Workbook workbook = Workbook.getWorkbook(new File("D:/jxl_text.xls"));
			//获取第一个工作表的sheet1
			Sheet sheet = workbook.getSheet(0);
			//获取数据
			for (int i = 0; i < sheet.getRows(); i++) {//行
				for (int j = 0; j < sheet.getColumns(); j++) {//列
					Cell cell = sheet.getCell(j,i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();//循环完一行之后进行换行
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
