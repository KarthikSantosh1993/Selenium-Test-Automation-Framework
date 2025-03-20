package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelUtility(String fileName) {

		File xlsxFile = new File(System.getProperty("user.dir") + "/testData/" + fileName);

		List<User> userList = new ArrayList<User>();
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Iterator<Row> rowIterator;
		User user;
		try {
			workbook = new XSSFWorkbook(xlsxFile);
			sheet = workbook.getSheet("LoginTestData");
			userList = new ArrayList<User>();

			rowIterator = sheet.iterator();
			rowIterator.next();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);

				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			}
			workbook.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
