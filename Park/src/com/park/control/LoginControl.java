package com.park.control;

import java.util.List;

import org.hibernate.Session;

import com.park.dao.LoginDAO;
import com.park.factory.HibernateSessionFactory;
import com.park.model.Login;



public class LoginControl {
	

	private static LoginControl control = null; 
	public static LoginControl getLoginControl(){
		if(null==control){
			control = new LoginControl();
		}
		return control;
	}
	

	private LoginDAO LoginDAO = null;
	private Session session = null;
	
	private LoginControl(){
		LoginDAO = new LoginDAO();
		session = HibernateSessionFactory.getSession();
	}
	

	public Login saveLogin(String username,String password){
		Login Login = new Login(username,password);
		LoginDAO.save(Login);
		session.beginTransaction().commit();
		session.flush();
		return Login;
	}
    
	public Login getLoginByName(String username){
		
	  return (Login)LoginDAO.findByProperty("username",username).get(0);

	}
	public List getLoginALL()
	{
		return LoginDAO.findAll();
	}


}
