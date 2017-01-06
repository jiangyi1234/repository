package com.momoda.excel;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * JXL创建excel文件
 * @author Ifugle2016
 *
 */
public class JxlExpExcel {
	public static void main(String[] args) {
		String[] title = {"id","name","sex"};//用数组装头部
		//创建excel文件
		File file = new File("D:/jxl_text.xls");
			try {
				file.createNewFile();//创建文件
				//创建工作薄
				WritableWorkbook workbook = Workbook.createWorkbook(file);
				//创建sheet
				WritableSheet sheet = workbook.createSheet("sheet1", 0);
				Label label = null;
				//第一行设置表头
				for (int i = 0; i < title.length; i++) {
					label = new Label(i, 0, title[i]);//Label(列,行,内容)
					sheet.addCell(label);
				}
				//追加数据
				for (int i = 1; i < 10; i++) {
					label = new Label(0, i, "a"+1);
					sheet.addCell(label);
					
					label = new Label(1, i, "user" + i);
					sheet.addCell(label);
					
					label = new Label(2, i, "男");
					sheet.addCell(label);
				}
				//写出文件
				workbook.write();
				workbook.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	
}
