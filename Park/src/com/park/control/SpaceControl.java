package com.park.control;

import java.util.List;

import org.hibernate.Session;

import com.park.dao.SpaceDAO;
import com.park.factory.HibernateSessionFactory;
import com.park.model.Space;

public class SpaceControl {
	
	private static SpaceControl control = null; 
	public static SpaceControl getSpaceControl(){
		if(null==control){
			control = new SpaceControl();
		}
		return control;
	}
	

	private SpaceDAO SpaceDAO = null;

	private Session session = null;
	private SpaceControl(){
		SpaceDAO = new SpaceDAO();

		session = HibernateSessionFactory.getSession();
	}
	
    
	public Space getSpaceBySpaceID(String roomID){
		
		Space room= SpaceDAO.findById(roomID);
	   return room;
	}
	public List getSpaceALL()
	{
		return SpaceDAO.findAll();
	}
    
	public List getSpaceBySpaceType(String roomType)
	{
		return SpaceDAO.findBySpaceType(roomType);
		
	}
	public Boolean update(Space room)
	{
		try
		{
			SpaceDAO.merge(room);
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
