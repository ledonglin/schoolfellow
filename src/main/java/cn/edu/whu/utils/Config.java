package cn.edu.whu.utils;

import java.beans.ConstructorProperties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import cn.edu.whu.model.SMSValidatePair;

public class Config {
	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	private static final Properties properties= new Properties();

	@ConstructorProperties("file")
	private Config(String file) throws FileNotFoundException, IOException {
		properties.load(getClass().getClassLoader().getResourceAsStream(file));
	}

	public static synchronized Config getConfig(String filename) {
		try {
			return new Config(filename);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		//TODO return some value;
		return null;
	}

	public static String get(String key) {
		return (String) properties.get(key);
	}

	public static int getInt(String key) {
		return Integer.parseInt(get(key));
	}

	public static boolean getBoolean(String key) {
		Date date = new Date();
		date.toString();
		return Boolean.parseBoolean(get(key));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Set<Object> keySet = properties.keySet();
		for (Object key : keySet) {
			sb.append(key);
			sb.append(":");
			sb.append(properties.get(key));
			sb.append(",");
		}
		return sb.toString();
	}

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		Config config = new Config("schoolFellow.properties");
		System.out.println(config.toString());

	}

}
