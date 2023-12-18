package com.qa.opencart.factory;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			co.addArguments("--incognito");
		}
		return co;
		
		// Note: If the if condition is only having if part not the else part, then you can write it in one single line.
		// 		 this will look much prettier.
//		
//		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
//		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
//		return co;
	}
	
	// Options returning for Firefox Driver
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) fo.addArguments("--incognito");
		return fo;
	}
	
	// Options for edge driver
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) eo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) eo.addArguments("--inPrivate");
		return eo;
	}
	
	// Options for Safari --> Safari does not support headless
	

}
