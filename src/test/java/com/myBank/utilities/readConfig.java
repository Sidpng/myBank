package com.myBank.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readConfig {

	private final Properties properties = new Properties();

	public readConfig() {
		try (FileInputStream fis = new FileInputStream("./Configuration/config.properties")) {
			properties.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Could not load ./Configuration/config.properties", e);
		}
	}

	public String getPropertyName(String key) {
		return properties.getProperty(key);
	}
}
