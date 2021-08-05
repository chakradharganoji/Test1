package com.hrms.testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.libs.General;

public class TC0003{
	//public static void main (String args[]) throws Exception{
	
	@Test
	public void tc0003() throws Exception {
		DOMConfigurator.configure("log4j.xml");
	General obj = new General();
	obj.openApplication();
     Thread.sleep(3000);
	obj.login();
    obj.addEmployee("James","Bond");
    obj.deleteByEmployeeName("James","Bond");
	Thread.sleep(3000);
	obj.logout();
	Thread.sleep(3000);
	obj.closeApplication();
	}

}
