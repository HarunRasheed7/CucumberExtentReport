package com.extent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelperJAVA {
FileInputStream fis;
XSSFWorkbook excel;
XSSFSheet sheet;
File srcFile;
FileOutputStream fos;
XSSFWorkbook writeExcel;

public ExcelHelperJAVA(String filepath) {
	srcFile=new File(filepath);
}
public String GetCellValue(int Row,int CellIndex) throws IOException {
	fis=new FileInputStream(srcFile);
	excel=new XSSFWorkbook(fis);
	sheet=excel.getSheetAt(0);
	XSSFCell cell=sheet.getRow(Row).getCell(CellIndex);
	cell.setCellType(CellType.STRING);
	String val = cell.getStringCellValue();
	fis.close();
	return val;
}
public int getRowCount() throws IOException{
	fis=new FileInputStream(srcFile);
	excel=new XSSFWorkbook(fis);
	sheet=excel.getSheetAt(0);
	int val = sheet.getLastRowNum();
	fis.close();
	return val;
}
public int getColumnCount(int rowNum) throws IOException {
	fis=new FileInputStream(srcFile);
	excel=new XSSFWorkbook(fis);
	sheet=excel.getSheetAt(0);
	int val = sheet.getRow(rowNum).getLastCellNum();
	fis.close();
	return val;
}
public void setCellValue(int row,int cell,String value) throws IOException {
	fis=new FileInputStream(srcFile);
	excel=new XSSFWorkbook(fis);
	sheet=excel.getSheetAt(0);
	XSSFCell mycell=sheet.getRow(row).createCell(cell, CellType.STRING);
	mycell.setCellValue(value);
	fis.close();
	fos=new FileOutputStream(srcFile);
	excel.write(fos);
	fos.close();
}
public void setCellColor(int row,int cell,String color) throws IOException {
	fis=new FileInputStream(srcFile);
	excel=new XSSFWorkbook(fis);
	sheet=excel.getSheetAt(0);
	XSSFCell mycell=sheet.getRow(row).getCell(cell);
	XSSFCellStyle style=excel.createCellStyle();
	if (color.equalsIgnoreCase("red")) {
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
	}else {
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	}
	mycell.setCellStyle(style);
}
}
