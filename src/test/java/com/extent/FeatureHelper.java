package com.extent;

import java.io.IOException;
import java.util.HashMap;
import 	org.testng.Assert;


public class FeatureHelper{

	public HashMap<String,String> getExcelData(String testDataKey,String TestDataPath) throws IOException{
		HashMap<String,String> map=new HashMap<>();
		ExcelHelperJAVA helper=new ExcelHelperJAVA(TestDataPath);
		int totalRow = helper.getRowCount();
		int tdIndex=-1;
		for (int i = 1; i <=totalRow; i++) {
			String tcValue=helper.GetCellValue(i, 0);
			if (tcValue.equalsIgnoreCase(testDataKey)) {
				tdIndex=-1;
				break;
			}
		}
		if (tdIndex==-1) {
		Assert.assertEquals(tdIndex, "given key not matched in excel data and key is "+testDataKey);
		}else {
			map.put("TestLab",helper.GetCellValue(tdIndex, 1));
			map.put("Date",helper.GetCellValue(tdIndex, 2));
		}
		return map;
	}
}
