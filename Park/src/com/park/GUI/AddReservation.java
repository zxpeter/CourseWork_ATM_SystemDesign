package com.park.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import com.park.control.ReservationControl;
import com.park.dao.SpaceDAO;
import com.park.factory.HibernateSessionFactory;
import com.park.model.Reservation;
import com.park.model.Space;
import com.park.service.MainGUIService;

public class AddReservation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public MainGUIService mainGUIService;
	public MainGUI mainGUI;
	public Space space;

	/**
	 * Create the frame.
	 */
	public AddReservation(Space roomtoreserve,MainGUI main) {
		setTitle("抢车位");
	    mainGUIService=new MainGUIService(main);
	    mainGUI=main;
	    space = roomtoreserve;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("车位号：");
		label_1.setBounds(15, 25, 54, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel(space.getSpaceId());
		lblNewLabel.setBounds(81, 25, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("车位类型：");
		label_2.setBounds(145, 25, 60, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel(space.getSpaceType());
		
		lblNewLabel_1.setBounds(204, 25, 64, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("车位单价：");
		label_3.setBounds(283, 25, 72, 15);
		contentPane.add(label_3);

		JLabel label = new JLabel(String.valueOf(space.getSpacePrice()));
		label.setBounds(354, 25, 64, 15);
		contentPane.add(label);

		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 62, 398, 269);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("详细信息", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_4 = new JLabel("选定时间：");
		label_4.setBounds(53, 26, 66, 15);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(150, 23, 158, 21);
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		textField.setText(df.format( new Date(System.currentTimeMillis())));
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_5 = new JLabel("车牌号：");
		label_5.setBounds(53, 66, 66, 15);
		panel.add(label_5);
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(150, 63, 158, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_6 = new JLabel("联系电话：");
		label_6.setBounds(53, 106, 66, 15);
		panel.add(label_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 103, 158, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_7 = new JLabel("停车时间：");
		label_7.setBounds(53, 151, 66, 15);
		panel.add(label_7);
		
		textField_3 = new JTextField();
		textField_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				textField_3.setText(textField.getText().substring(0,10));
			}
		});
		textField_3.setBounds(150, 148, 158, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "车主姓名不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField_1.getText().length()>20)
						throw new Exception();
					
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, " 车主姓名应少于10个汉字或20个英文字符","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "联系电话不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField_2.getText().length()!=11)
						throw new Exception();
					Long.parseLong(textField_2.getText());
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "手机号码只能为11位数字","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				if(textField_3.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null,"请按格式yy-MM-dd输入\n 比如2014-05-21","提示",JOptionPane.CLOSED_OPTION);			
				    return;			
					
				}
				else
				{
					String time = textField_3.getText();
					if(time.length()!=10)
					{
						JOptionPane.showConfirmDialog(null,"请按格式yy-MM-dd输入\n 比如2014-05-21","提示",JOptionPane.CLOSED_OPTION);			
					    return;
					}
				
						String[] temp = time.split("-");
						if(temp.length!=3|temp[0].length()!=4|temp[1].length()!=2|temp[2].length()!=2)
						{
							JOptionPane.showConfirmDialog(null,"请按格式yy-MM-dd输入\n 比如2014-05-21","提示",JOptionPane.CLOSED_OPTION);			
						    return;
						}
				}
				String name = textField_1.getText();
				String PhoneNum = textField_2.getText();
				Date date = null;
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try
				{
		    		date = format.parse(textField_3.getText());
				}
				catch(Exception f)
				{
					JOptionPane.showConfirmDialog(null,"异常","提示",JOptionPane.CLOSED_OPTION);
					return;
				}
				Timestamp ts = null;
				try
		    	{
		    		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    		Date date1;
		    		try {
		    			date1 = format.parse(textField.getText());
		    			ts = new Timestamp(date1.getTime());
		    		} catch (ParseException c) {
		    			// TODO Auto-generated catch block
		    			c.printStackTrace();
		    		}	    		
		    	}
		    	catch(Exception d)
		    	{
		    		JOptionPane.showConfirmDialog(null,"异常","提示",JOptionPane.CLOSED_OPTION);
		    		return;
		    	}   
				
                space.setSpaceState("已预约");
                
			    int res= JOptionPane.showConfirmDialog(null,"您是否要定该车位？","抢占",JOptionPane.YES_NO_OPTION,
               	     JOptionPane.QUESTION_MESSAGE);
               if(res==JOptionPane.OK_OPTION)
               {/*******************************************************************/
            	   Reservation reservation = new Reservation(ts,space,name,PhoneNum,space.getSpaceType(),date,1);
            	   Session session = HibernateSessionFactory.getSession();
				   new SpaceDAO().merge(space);
				   session.beginTransaction().commit();
				   session.flush();
				   ReservationControl.getControl().save(reservation);
				   mainGUIService.refreshSpaceButtons();
				   JOptionPane.showConfirmDialog(null,"成功抢车位","提示",JOptionPane.CLOSED_OPTION);
				   dispose();
				   /*******************************************************************/
               }
			    
			}
				
			     
		});
		btnNewButton.setBounds(80, 354, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(256, 354, 93, 23);
		contentPane.add(btnNewButton_1);
		
	
	}
}
