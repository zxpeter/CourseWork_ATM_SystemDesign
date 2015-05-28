package com.park.service;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

//import com.hotel.control.ConsumeControl;
//import com.hotel.control.GoodsControl;
//import com.hotel.control.VipControl;

import com.park.GUI.MainGUI;
import com.park.control.LoginControl;
import com.park.control.SpaceControl;
import com.park.model.Customer;
import com.park.model.Login;
import com.park.model.Space;

public class MainGUIService {
	private MainGUI mainGUI = null;
	private int occupiedNum=0;
	private int reservedNum=0;
	private int emptyNum=60;
	public MainGUIService(MainGUI mainGUI)
	{
		this.mainGUI = mainGUI;
		
	}
	public  void refreshSpaceButtons()
	{
		System.out.println("刷新按钮");
		List BSRooms = SpaceControl.getSpaceControl().getSpaceBySpaceType("贵宾停车位");//？？？？？？？？？？？？？？？？？？？
		setButtonIcon(BSRooms,mainGUI.BSButtons);
		List BDRooms = SpaceControl.getSpaceControl().getSpaceBySpaceType("标准停车位");//？？？？？？？？？？？？？？？？？？？
		setButtonIcon(BDRooms,mainGUI.BDButtons);
	}
	public void setButtonIcon(List Rooms,ArrayList<JButton> buttons)
	{
		
		JButton tempButton = null;
		String tempRoomState;
		for(int i = 0;i<Rooms.size();i++)
		{   
			tempRoomState=((Space)Rooms.get(i)).getSpaceState();
			tempButton=(JButton)buttons.get(i);
			if(tempRoomState.equals("可用"))
			{  
				tempButton.setIcon(new ImageIcon(MainGUI.class.getResource("/com/park/image/green.png")));
			}
			if(tempRoomState.equals("已占用"))
			{
				tempButton.setIcon(new ImageIcon(MainGUI.class.getResource("/com/park/image/Red.png")));
			}
			if(tempRoomState.equals("已预约"))
			{  
				tempButton.setIcon(new ImageIcon(MainGUI.class.getResource("/com/park/image/blue.jpg")));
			}
			
		}
	}
	

}
