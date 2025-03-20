package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class JSONUtility {

	public static Environment readJSONConfig(Env env) {
		File jsonFile = new File(System.getProperty("user.dir")+"/config/config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson= new Gson();
		Config config= gson.fromJson(fileReader, Config.class);
		return config.getEnvironments().get(env.toString());
	}
	
	public static Iterator<Object[]> readJSONFile() {
		File testDataFile= new File(System.getProperty("user.dir")+ "/testData/loginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Gson gson= new Gson();
		TestData data= gson.fromJson(fileReader, TestData.class);
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for(User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();	
	}
}
