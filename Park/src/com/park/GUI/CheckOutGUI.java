package com.park.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.park.control.CustomerControl;
import com.park.control.SpaceControl;
import com.park.model.Customer;
import com.park.model.Space;
import com.park.service.MainGUIService;

public class CheckOutGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MainGUI mainGUI;
	private MainGUIService mainService;
	private Space space = null;
	private Customer customer = null;  //顾客信息

	/**
	 * Create the frame.
	 */
	public CheckOutGUI(Space r, Customer c,MainGUI main) {

        mainService = new MainGUIService(main);
		this.space = r;
		this.customer = c;
		final Space R=r;
		final String tel=customer.getTelphone();
		final Customer C=c;
		final MainGUI mAin=main;
		setTitle("车位结账");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//int space_Days=space_Date();
		String space_type=space.getSpaceType();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 10, 740, 129);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("收费车位：");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 27, 89, 22);
		panel.add(lblNewLabel);

		JLabel lable_spaceID = new JLabel(space.getSpaceId()); // /////////////////////////////////
		lable_spaceID.setForeground(Color.BLUE);
		lable_spaceID.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lable_spaceID.setBounds(91, 27, 89, 22);
		panel.add(lable_spaceID);

		JLabel label_2 = new JLabel("车主姓名：");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(10, 80, 89, 22);
		panel.add(label_2);

		JLabel label_Name = new JLabel(customer.getCustomerName()); // /////////////////////////////////
		label_Name.setForeground(Color.BLUE);
		label_Name.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_Name.setBounds(91, 80, 89, 22);
		panel.add(label_Name);

		JLabel label_3 = new JLabel("身份证号：");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(241, 27, 89, 22);
		panel.add(label_3);

		JLabel label_1 = new JLabel(customer.getCustomerId()); // /////////////////////////////////
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_1.setBounds(330, 27, 192, 22);
		panel.add(label_1);


		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 181, 740, 222);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel label_7 = new JLabel("停车费：");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_7.setBounds(10, 10, 80, 22);
		panel_2.add(label_7);

		JLabel label_SumMony2 = new JLabel(String.valueOf(space.getSpacePrice()));
		label_SumMony2.setForeground(Color.BLUE);
		label_SumMony2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_SumMony2.setBounds(94, 10, 65, 22);

		panel_2.add(label_SumMony2);

		JLabel label_9 = new JLabel("已收押金：");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_9.setBounds(10, 127, 80, 22);
		panel_2.add(label_9);

		JLabel label_PaidMoney = new JLabel(customer.getDepositCash()
				.toString());
		label_PaidMoney.setForeground(Color.BLUE);
		label_PaidMoney.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_PaidMoney.setBounds(116, 127, 93, 22);
		panel_2.add(label_PaidMoney);

		// label_10.setText(j.toString());

		JLabel label_11 = new JLabel("应收车费：");
		label_11.setForeground(Color.BLUE);
		label_11.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_11.setBounds(10, 68, 80, 22);
		panel_2.add(label_11);
		//sum = String.valueOf(space.getSpacePrice());
		JLabel label_RealMoney = new JLabel(String.valueOf(space.getSpacePrice()-customer.getDepositCash()));
		label_RealMoney.setForeground(Color.BLUE);
		label_RealMoney.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_RealMoney.setBounds(94, 68, 52, 22);
		panel_2.add(label_RealMoney);

		JButton Button_结账 = new JButton("付费");

		Button_结账.setHorizontalAlignment(SwingConstants.LEFT);
		Button_结账.setBounds(415, 35, 93, 37);
		panel_2.add(Button_结账);

		JButton Button_取消 = new JButton("取消");
		Button_取消.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Button_取消.setHorizontalAlignment(SwingConstants.LEFT);
		Button_取消.setBounds(415, 141, 93, 37);
		panel_2.add(Button_取消);


		Button_结账.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
							 CheckTel checkTel=new CheckTel(R,tel,C,mAin);
							 checkTel.setVisible(true);
							
							// 更改房间状态
							/*space.setSpaceState("可用");
							SpaceControl.getSpaceControl().update(space);
							CustomerControl.getCustomerControl().deleteCustomer(customer);
							JOptionPane.showMessageDialog(null, "结账成功！", "提示:",
									JOptionPane.CLOSED_OPTION);
							mainService.refreshSpaceButtons();
					
							mainGUI.selectedCustomer=null;
							mainGUI.selectedSpace = null;
							mainGUI.selectedButtonText = null;

							dispose();	*/
			}
		});
		setLocationRelativeTo(null);
	}
}
