package com.nmims.selenium.studentportal.testCase;
import java.io.IOException;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.nmims.selenium.studentportal.baseClass.BaseClass;
import com.nmims.selenium.studentportal.data.DataProvideLogin;
import com.nmims.selenium.studentportal.pageObjectMethod.LoginPageObjectMethod;
import com.nmims.selenium.studentportal.testutil.Login;

public class LoginTest extends BaseClass{
	
//    private String username;
//    private String password;
//
//    // Constructor to receive data from the data provider
//    public LoginTest(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    // Your test logic here, you can use the received data
//   
//    
//
//    // Factory method to create test instances with different data
//    @Factory(dataProvider = "Login", dataProviderClass = DataProvideLogin.class)
//    public static Object[] createInstances(String username, String password) {
//        return new Object[] { new LoginTest(username, password) };
//    }
    
    @Test
    public void loginTest() throws IOException {
       // System.out.println("Logging in with username: " + username + " and password: " + password);
        
    	Login login = new Login(driver);
        try {
			login.commanLogin();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
        
        System.out.println("successfully test ");
        
    }
    
    
    
    
    }
}
