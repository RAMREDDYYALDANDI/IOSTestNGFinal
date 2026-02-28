package Logics;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPOM;
import Utils.Jsonreader;

public class LoginLogic extends BaseTest{
	
	public LoginPOM lanpom;
	public LoginLogic()
	{
		super();
	}
	
	@DataProvider(name = "logindata")
	public Object[][] login() throws IOException
	{
		Jsonreader json = new Jsonreader();
		List<HashMap<String,String>> data = json.getJson();
		
		Object[][] obj = new Object[data.size()][1];
		
		for(int i=0;i<data.size();i++)
		{
			obj[i][0] = data.get(i);
		}return obj;
		
	}
	@Test(dataProvider="logindata")
	public void logintest(HashMap<String,String>input)
	{
		lanpom = new LoginPOM(driver);
		String username = input.get("username");
		String password = input.get("password");
		lanpom.user(username, password);
		lanpom.loginclick();
		
		if(username.equals("standard_user"))
		{
			System.out.println("✅ Login Success: " + username);
		}else
		{
			boolean isErrorVisible = lanpom.error();
			System.out.println("Error Message verified for:"+username+"->"+isErrorVisible);
		}
		
	}

}
