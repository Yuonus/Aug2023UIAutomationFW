package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {

	String academy = "S_Tech is the best Automation academy in US";
	
	By s_techBranchnumbers = By.id("S_Tech");
	
	public void getS_TechBranches_World() {
		System.out.println("There are totally 251 branches across the world");
	}
}
