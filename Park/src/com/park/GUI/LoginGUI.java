package com.park.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat; 

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//import com.jtattoo.plaf.smart.SmartLookAndFeel;
//import com.jtattoo.plafacryl.AcrylLookAndFeel; 
import com.jtattoo.plaf.mcwin.McWinLookAndFeel; 
import com.park.service.LoginService;


public class LoginGUI {

	private JFrame frame;
	private JPasswordField passwordField;
	private JComboBox comboBox1;
	private JFrame mainForm = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	    JFrame.setDefaultLookAndFeelDecorated(true); 
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
           
           javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登陆");
		frame.setBounds(100, 100, 321, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("停车场系统");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("锟斤拷锟斤拷", Font.PLAIN, 33));
		label.setBounds(52, 33, 214, 43);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\u79F0\uFF1A");
		label_1.setBounds(42, 116, 60, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		label_2.setBounds(42, 179, 60, 15);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LoginService.isUser(comboBox1.getSelectedItem().toString(),String.valueOf(passwordField.getPassword())))
				{
					frame.setVisible(false);//登陆界面消失
				    mainForm = new MainGUI(comboBox1.getSelectedItem().toString());
					mainForm.setVisible(true);
				}
				else 
				{      
					JOptionPane.showConfirmDialog(null, "用户名和密码错误","提示:", JOptionPane.CLOSED_OPTION);	
				}
				
				
			}
		});
		button.setBounds(37, 244, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
				
			}
		});
		button_1.setBounds(153, 244, 93, 23);
		frame.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		LoginService.readUser(comboBox);
		comboBox.setBounds(131, 116, 115, 21);
		comboBox1=comboBox;
		frame.getContentPane().add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(131, 175, 115, 23);
		frame.getContentPane().add(passwordField);
		frame.setLocationRelativeTo(null);
	}
}
