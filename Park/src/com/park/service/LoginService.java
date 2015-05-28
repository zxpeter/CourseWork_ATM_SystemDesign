package com.park.service;

import java.util.List;

import javax.swing.JComboBox;

import com.park.control.LoginControl;
import com.park.model.Login;

public class LoginService {
	public static Boolean isUser(String username,String password)
	{
		Login login = LoginControl.getLoginControl().getLoginByName(username);
		if(password.equals(login.getPassword()))
			return true;
		else
			return false;
			
		
	}
	
	public static void readUser(JComboBox comboBox)
	{
		List logins = LoginControl.getLoginControl().getLoginALL();
		for(int i = 0;i<logins.size();i++)
		{
			comboBox.addItem(((Login)logins.get(i)).getUsername());
	    }
		
	}
	

}
