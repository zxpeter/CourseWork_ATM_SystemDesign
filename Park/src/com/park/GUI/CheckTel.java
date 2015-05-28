package com.park.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.park.control.CustomerControl;
import com.park.control.SpaceControl;
import com.park.model.Customer;
import com.park.model.Space;
import com.park.service.MainGUIService;

public class CheckTel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CheckTel(Space R,String tel,Customer C,MainGUI mAin) {
		final Space r=R;
		final String Tel=tel;
		final Customer c=C;
		final MainGUI main=mAin;
		final MainGUIService mainService = new MainGUIService(mAin);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("请输入手机号：");
		label.setBounds(56, 82, 107, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(186, 79, 86, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String telIn=textField.getText();
				if(telIn.equals(Tel)){
					r.setSpaceState("可用");
					SpaceControl.getSpaceControl().update(r);
					CustomerControl.getCustomerControl().deleteCustomer(c);
					JOptionPane.showMessageDialog(null, "结账成功！", "提示:",JOptionPane.CLOSED_OPTION);
					mainService.refreshSpaceButtons();
			
					main.selectedCustomer=null;
					main.selectedSpace = null;
					main.selectedButtonText = null;
		    	     dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "输入手机号错误身份验证失败！", "提示:",JOptionPane.CLOSED_OPTION);
				}
			}
		});
		button.setBounds(56, 161, 95, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(247, 161, 95, 25);
		contentPane.add(button_1);
	}
}
