package com.park.control;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.park.dao.ReservationDAO;
import com.park.factory.HibernateSessionFactory;
import com.park.model.Reservation;
import com.park.model.Space;

public class ReservationControl {
	
	public static ReservationControl reservation = null;
	public static ReservationControl getControl()
	{
		if(reservation ==null)
		  reservation = new ReservationControl();
		return reservation;
	}
	private Session session;
	private ReservationDAO reservationDao;
	public ReservationControl()
	{
		session = HibernateSessionFactory.getSession();
		reservationDao = new ReservationDAO();
	}
	
	public List findByRName(String name)
	{
		try{
			return reservationDao.findByRname(name);
		}
		catch(Exception e)
		{
			return null;
		}
	}
    public Boolean save(Reservation temp)
    {
    	try{
    		reservationDao.save(temp);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
   

    public Boolean delete(Space room)
    {
    	try{
    		Reservation temp =(Reservation)reservationDao.findByProperty("space",room);
    		reservationDao.delete(temp);
    		session.beginTransaction().commit();
    		session.flush();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    public List findBySpace(Space room)
	{
		try{
			return reservationDao.findByProperty("space",room);
		}
		catch(Exception e)
		{
			return null;
		}
	}
    public List findByTel(String Tel)
  	{
  		try{
  			return reservationDao.findByRtel(Tel);
  		}
  		catch(Exception e)
  		{
  			return null;
  		}
  	}
   
}
