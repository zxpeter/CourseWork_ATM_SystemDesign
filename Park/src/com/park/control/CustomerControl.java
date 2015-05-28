package com.park.control;

import java.util.List;

import org.hibernate.Session;

import com.park.dao.CustomerDAO;
import com.park.factory.HibernateSessionFactory;
import com.park.model.Customer;
import com.park.model.Reservation;
import com.park.model.Space;


public class CustomerControl {
	

	private static CustomerControl control = null; 
	public static CustomerControl getCustomerControl(){
		if(null==control){
			control = new CustomerControl();
		}
		return control;
	}
	

	private CustomerDAO CustomerDAO = null;

	private Session session = null;
	private CustomerControl(){ 
		CustomerDAO = new CustomerDAO();

		session = HibernateSessionFactory.getSession();
	}
	
    
	public Customer getCustomerByCustomerID(String CustomerID){
		Customer temp;
		try
		{
			temp= CustomerDAO.findById(CustomerID);
		}
		catch(Exception e)
		{
			temp=null;
		}
		return temp;
		
		
	}

	public Customer getCustomerBySpaceID(Space room){
		
		  List list= CustomerDAO.findByProperty("space",room);
		  if(list==null)
			  return null;
		  return (Customer)(list.get(0));

		}
	  public Boolean save(Customer temp)
	    {
	    	try{
	    		CustomerDAO.save(temp);
	    		session.beginTransaction().commit();
	    		session.flush();
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		return false;
	    	}
	    }
		public Boolean update(Customer customer)
		{
			try
			{
				CustomerDAO.merge(customer);
				session.beginTransaction().commit();
				session.flush();
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		public Boolean deleteCustomer(Customer c)
		  {
 
			  try{
		    		CustomerDAO.delete(c);
		    		session.beginTransaction().commit();
		    		session.flush();
		    		return true;
		    	}
		    	catch(Exception e)
		    	{
		    		return false;
		    	}
			  
		 }


}
