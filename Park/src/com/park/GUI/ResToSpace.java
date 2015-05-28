package com.park.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


//import com.hotel.control.GoodsControl;



import com.park.control.ReservationControl;
import com.park.model.Reservation;
import com.park.model.Space;
import com.park.service.MainGUIService;

public class ResToSpace extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public MainGUIService mainGUIService;
	public MainGUI mainGUI;
    private Space space;

	/**
	 * Create the frame.
	 */
	public ResToSpace(Space roomtolive,MainGUI main) {
		mainGUI=main;
		mainGUIService = new MainGUIService(main);
		space = roomtolive;
		setTitle("交付");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 323, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("停车记录");
		label.setFont(new Font("楷体", Font.PLAIN, 20));
		label.setBounds(86, 10, 80, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("车位号：");
		label_1.setBounds(15, 44, 80, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("车位类型：");
		label_2.setBounds(15, 86, 93, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("车位单价：");
		label_3.setBounds(15, 124, 111, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("车主：");
		label_4.setBounds(15, 164, 103, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("停车时间：");
		label_5.setBounds(15, 201, 92, 15);
		contentPane.add(label_5);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			int res= JOptionPane.showConfirmDialog(null,"预定车主要把车停进去？？","好的添加",JOptionPane.YES_NO_OPTION,
	               	     JOptionPane.QUESTION_MESSAGE);
	        if(res==JOptionPane.OK_OPTION)
	         {
				 CheckIn checkin = new CheckIn(space,mainGUI);
	    	     checkin.setVisible(true);
	    	     dispose();
			 }
			}
		});
		button.setBounds(56, 282, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(164, 282, 93, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(110, 44, 147, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(112, 83, 145, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(112, 121, 145, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(112, 161, 145, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(112, 198, 145, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField.setText(space.getSpaceId());
		textField_1.setText(space.getSpaceType());
		textField_2.setText(String.valueOf(space.getSpacePrice()));
	    Reservation res =(Reservation)ReservationControl.getControl().findBySpace(space).get(0);
	    //从预订单中得到车位信息，并将一行表的信息导入到界面中显示
	    textField_3.setText(res.getRname());
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String s = dateFormat.format(res.getArrivalTime());
	    
	    textField_4.setText(s);
	    setLocationRelativeTo(null);
		
	}

}
