package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;


public class PropertiesUtil {

	public static String readProperties(Env env, String propertyName) {
		File propertyFile = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");
		FileReader fileReader = null;
		Properties properties = new Properties();
		try {
			fileReader = new FileReader(propertyFile);
			properties.load(fileReader);
		} catch (IOException  e) {
			e.printStackTrace();
		}

		return properties.getProperty(propertyName.toUpperCase());	
	}
}
