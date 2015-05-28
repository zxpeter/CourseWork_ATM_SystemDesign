package com.park.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Timestamp;
import java.util.List;

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

import com.park.model.Customer;
import com.park.model.Reservation;
import com.park.model.Space;
import com.park.service.MainGUIService;
//import com.hotel.control.GoodsControl;
//import com.hotel.control.VipControl;
import com.park.control.CustomerControl;
import com.park.control.ReservationControl;
import com.park.control.SpaceControl;

public class CheckIn extends JFrame {

	private JPanel contentPane;
	private Space space;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	public MainGUIService mainGUIService;
	public MainGUI mainGUI;

	/**
	 * Create the frame.
	 */
	public CheckIn(Space roomtolive,MainGUI main) {
		mainGUI=main;
		mainGUIService = new MainGUIService(main);
		space = roomtolive;
		setTitle("停车");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("停车信息");
		label.setFont(new Font("楷体", Font.BOLD, 20));
		label.setBounds(151, 10, 109, 25);
		contentPane.add(label);
		
		
		JLabel label_1 = new JLabel("车位号:");
		label_1.setBounds(24, 39, 54, 15);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("车位类型：");
		lblNewLabel.setBounds(151, 39, 65, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("车位单价：");
		lblNewLabel_1.setBounds(304, 39, 79, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(space.getSpaceId());
		lblNewLabel_2.setBounds(77, 39, 79, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(space.getSpaceType());
		lblNewLabel_3.setBounds(226, 39, 79, 15);
		contentPane.add(lblNewLabel_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 83, 377, 367);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("车主信息", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("车主ID：");
		lblid.setBounds(42, 21, 76, 15);
		panel.add(lblid);
		
		JLabel label_2 = new JLabel("车主姓名：");
		label_2.setBounds(42, 63, 76, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("车主性别：");
		label_3.setBounds(42, 102, 76, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("车主电话：");
		label_4.setBounds(42, 152, 76, 15);
		panel.add(label_4);
		
		JLabel label_6 = new JLabel("押金数量：");
		label_6.setBounds(42, 228, 76, 15);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "车主ID不能为空","提示:", JOptionPane.CLOSED_OPTION);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					comboBox.setEditable(true);
					return;
				}
				try
				{
					if(textField.getText().length()!=18)
						throw new Exception();
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "车主ID只能为18位身份证号","提示:", JOptionPane.CLOSED_OPTION);
					textField_1.setEditable(true);
					textField_2.setEditable(true);
					comboBox.setEditable(true);
					return;
				}
				String id = textField.getText();
			}
			@Override
			public void focusGained(FocusEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				comboBox.setEnabled(true);
			}
		});
		textField.setBounds(133, 18, 183, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 60, 183, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
        comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBounds(178, 99, 82, 21);
		panel.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(133, 149, 183, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_7 = new JLabel("预计停的时间：");
		label_7.setBounds(42, 287, 76, 15);
		panel.add(label_7);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox_1.setBounds(187, 284, 69, 21);
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "50", "100"}));
		comboBox_2.setBounds(178, 225, 82, 21);
		panel.add(comboBox_2);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "车主ID不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				try
				{
					if(textField.getText().length()!=18)
						throw new Exception();
					
				}
				catch(Exception b)
				{
					JOptionPane.showConfirmDialog(null, "车主ID只能为18位身份证号","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				String id = textField.getText();
				Customer customertemp = CustomerControl.getCustomerControl().getCustomerByCustomerID(id);
				if(customertemp!=null)
				{
					JOptionPane.showConfirmDialog(null, "一辆车只能占用一个车位","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				
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
					JOptionPane.showConfirmDialog(null, "车主姓名应少于10个汉字或20个英文字符","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				String name = textField_1.getText();
				if(textField_2.getText().equals(""))
				{
					JOptionPane.showConfirmDialog(null, "车主电话不能为空","提示:", JOptionPane.CLOSED_OPTION);
					return;
				}
				String tel;
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
				tel=textField_2.getText();
				List <Reservation> list=ReservationControl.getControl().findByTel(tel);
				try{
				if(list.get(0).getRtel()==tel){
					JOptionPane.showConfirmDialog(null, "手机号与预定信息手机号不匹配，请重新输入！！","提示:", JOptionPane.CLOSED_OPTION);
				}
				else{
					String sex;
					if(comboBox.getSelectedItem().toString().equals("男"))
						sex="M";
					else
						sex = "F";
			//
					double depositCash=Double.parseDouble(comboBox_2.getSelectedItem().toString());
					int days = Integer.parseInt(comboBox_1.getSelectedItem().toString());
				    int res= JOptionPane.showConfirmDialog(null,"确定要在此处停车吗?","是的",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	                if(res!=JOptionPane.OK_OPTION)
	                {
	                	return;
	                }
					space.setSpaceState("已占用");// 更改状态
					
					Timestamp arrivalTime=new Timestamp(System.currentTimeMillis());
					
					Customer customer = new Customer(id,space,name,
							sex, tel,depositCash,
							arrivalTime,days);
					
					CustomerControl.getCustomerControl().save(customer);//记录顾客信息
			        ReservationControl.getControl().delete(space);      //从预订中将其删除  
					SpaceControl.getSpaceControl().update(space); //修改space State 
					
					JOptionPane.showConfirmDialog(null, "停车成功","提示:", JOptionPane.CLOSED_OPTION);
					mainGUIService.refreshSpaceButtons();
					dispose();
				}
				}
				catch(Exception a){
					JOptionPane.showConfirmDialog(null, "手机号与预定信息手机号不匹配，请重新输入！！","提示:", JOptionPane.CLOSED_OPTION);
				}
				
				
				String sex;
				if(comboBox.getSelectedItem().toString().equals("男"))
					sex="M";
				else
					sex = "F";
		//
//				double depositCash=Double.parseDouble(comboBox_2.getSelectedItem().toString());
//				int days = Integer.parseInt(comboBox_1.getSelectedItem().toString());
//			    int res= JOptionPane.showConfirmDialog(null,"确定要在此处停车吗?","是的",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//                if(res!=JOptionPane.OK_OPTION)
//                {
//                	return;
//                }
//				space.setSpaceState("已占用");// 更改状态
//				
//				Timestamp arrivalTime=new Timestamp(System.currentTimeMillis());
//				
//				Customer customer = new Customer(id,space,name,
//						sex, tel,depositCash,
//						arrivalTime,days);
//				
//				CustomerControl.getCustomerControl().save(customer);//记录顾客信息
//		        ReservationControl.getControl().delete(space);      //从预订中将其删除  
//				SpaceControl.getSpaceControl().update(space); //修改space State 
//				
//				JOptionPane.showConfirmDialog(null, "停车成功","提示:", JOptionPane.CLOSED_OPTION);
//				mainGUIService.refreshSpaceButtons();
//				dispose();

			}
		});
		btnNewButton.setBounds(102, 460, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(275, 460, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label_5 = new JLabel(String.valueOf(space.getSpacePrice()));
		label_5.setBounds(360, 39, 79, 15);
		contentPane.add(label_5);
		setLocationRelativeTo(null);

		
	}
}
