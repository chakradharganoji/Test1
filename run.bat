set projectLocation=D:\AutomationFramework\ol_hrms_frw16
cd %projectLocation%
set classpath=%projectLocation%\out;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testng.xml
