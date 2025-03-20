package com.ui.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;
import com.utility.JSONUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		return JSONUtility.readJSONFile();
	}
	
	@DataProvider(name="loginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider(){
		return CSVReaderUtility.readCSVFile("LoginData.csv");
	}

	@DataProvider(name="loginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider(){
		return ExcelReaderUtility.readExcelUtility("LoginData.xlsx");
	}
}
