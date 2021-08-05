package com.hrms.testscript;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.hrms.libs.General;

public class TC001 {
	
	
	@Test
		public void tc001() {
		DOMConfigurator.configure("log4j.xml");
		General obj = new General();
		obj.openApplication();
		obj.login();
		//Thread.sleep(3000);
		obj.addEmployee("Tvtt","fffh");
		//Thread.sleep(3000);
		//obj.deleteEmployee();
		//Thread.sleep(3000);
		obj.logout();
		//Thread.sleep(3000);
		obj.closeApplication();
		
		
		
		
	}

}
