package com.hrms.testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.libs.General;

public class TC0002 {
	//public static void main (String args[]) throws Exception{
	
	@Test
	public void tc0002() {
		DOMConfigurator.configure("log4j.xml");
	General obj = new General();
	obj.openApplication();
	//Thread.sleep(2000);
	obj.login();
    obj.addEmployee("Tvtt","fff");
	//Thread.sleep(2000);
	obj.logout();
	//Thread.sleep(2000);
	obj.closeApplication();
	}

}
