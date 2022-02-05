import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
//import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_2;
	private JTable table;
	private JTable table_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnUpdate;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_2;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3_1;
	private JButton btnDelete;
	private JButton addCoachBtn;
	private JTextArea textArea;
	private JTextField textField_7;
	private JTextField textField_8;
	private JButton btnNewButton_4;

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 450);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 450);
		panel.setBackground(new Color(101, 93, 138));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(50, 66, 100, 100);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("E:\\Project\\GMS\\imgs\\dumbbell.png"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(201, -24, 479, 474);
		contentPane.add(tabbedPane);
		JPanel panel1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel1, null);
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADD MEMBER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(127, 11, 219, 67);
		panel1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(71, 106, 133, 28);
		panel1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(72, 91, 46, 14);
		panel1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone No.");
		lblNewLabel_2_1.setBounds(267, 91, 67, 14);
		panel1.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 106, 133, 28);
		panel1.add(textField_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"6AM - 11AM", "4PM - 10PM"}));
		comboBox.setBounds(71, 170, 133, 28);
		panel1.add(comboBox);
		
		JLabel lblNewLabel_2_2 = new JLabel("Timings");
		lblNewLabel_2_2.setBounds(72, 156, 46, 14);
		panel1.add(lblNewLabel_2_2);
		
		btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBackground(new Color(253, 206, 185));
		btnNewButton_1.setBounds(154, 324, 165, 34);
		panel1.add(btnNewButton_1);
		
		JButton btnCoach = new JButton("COACH");
		btnCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnCoach.setBackground(new Color(120, 151, 171));
		btnCoach.setBounds(356, 401, 108, 34);
		panel1.add(btnCoach);
		
		JLabel lblNewLabel_2_4 = new JLabel("Address");
		lblNewLabel_2_4.setBounds(72, 209, 67, 14);
		panel1.add(lblNewLabel_2_4);
		
		textArea = new JTextArea();
		textArea.setBounds(71, 223, 133, 67);
		panel1.add(textArea);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_2.setBounds(267, 170, 133, 28);
		panel1.add(comboBox_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Gender");
		lblNewLabel_2_2_2.setBounds(268, 156, 46, 14);
		panel1.add(lblNewLabel_2_2_2);
		
		comboBox_3 = new JComboBox();
		coach(comboBox_3);
		comboBox_3.setBounds(267, 223, 133, 28);
		panel1.add(comboBox_3);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Coach");
		lblNewLabel_2_2_3.setBounds(268, 209, 46, 14);
		panel1.add(lblNewLabel_2_2_3);
		
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel2, null);
		panel2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("MEMBER LIST");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(124, 11, 226, 67);
		panel2.add(lblNewLabel_1_1);
		
		JButton btnCoach_1 = new JButton("COACH");
		btnCoach_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnCoach_1.setBackground(new Color(120, 151, 171));
		btnCoach_1.setBounds(356, 401, 108, 34);
		panel2.add(btnCoach_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 95, 454, 148);
		panel2.add(scrollPane_1);
		
		table = new JTable();
		table(table);
		scrollPane_1.setViewportView(table);
		
		  
		  JButton btnNewButton_3 = new JButton("Refresh");
		  btnNewButton_3.setBackground(new Color(120, 151, 171));
		  btnNewButton_3.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		 table(table);
		  	}
		  });
		  btnNewButton_3.setBounds(10, 401, 108, 34);
		  panel2.add(btnNewButton_3);
		  
		  textField_7 = new JTextField();
		  textField_7.setBounds(10, 287, 45, 20);
		  panel2.add(textField_7);
		  textField_7.setColumns(10);
		  
		  JLabel lblNewLabel_3 = new JLabel("ID");
		  lblNewLabel_3.setBounds(10, 273, 46, 14);
		  panel2.add(lblNewLabel_3);
		  
		  JButton btnUpdate = new JButton("Update");
		  btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(idCheck(textField_7)) {
						tabbedPane.setSelectedIndex(5);
					}else {
						JOptionPane.showMessageDialog(null, "INVALID ID");
						textField_7.setText("");
					}
				}
			});
		  btnUpdate.setBounds(73, 286, 89, 23);
		  panel2.add(btnUpdate);
		  
		  btnDelete = new JButton("Delete");
		  btnDelete.addActionListener(this);
		  btnDelete.setBounds(172, 286, 89, 23);
		  panel2.add(btnDelete);
		  
		JPanel panel3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel3, null);
		panel3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Manage Payments");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_2.setBounds(94, 11, 285, 67);
		panel3.add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(66, 117, 53, 28);
		panel3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(66, 100, 46, 14);
		panel3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Amount");
		lblNewLabel_4_1.setBounds(141, 99, 46, 14);
		panel3.add(lblNewLabel_4_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(141, 117, 106, 28);
		panel3.add(textField_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 176, 371, 199);
		panel3.add(scrollPane);
		
		table_2 = new JTable();
		table(table_2);
		scrollPane.setViewportView(table_2);
		
		btnNewButton_2 = new JButton("Pay");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBackground(new Color(253, 206, 185));
		btnNewButton_2.setBounds(298, 115, 73, 32);
		panel3.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Refresh");
		 btnNewButton_2_1.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  		 table(table_2);
			  	}
			  });
		btnNewButton_2_1.setBackground(new Color(253, 206, 185));
		btnNewButton_2_1.setBounds(46, 381, 106, 32);
		panel3.add(btnNewButton_2_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(120, 151, 171));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton.setBounds(46, 226, 108, 34);
		panel.add(btnNewButton);
		
		
		//Add Coach
		JPanel panel4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel4, null);
		panel4.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("ADD COACH");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_3.setBounds(143, 11, 188, 67);
		panel4.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Name");
		lblNewLabel_2_3.setBounds(72, 91, 46, 14);
		panel4.add(lblNewLabel_2_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(71, 106, 133, 28);
		panel4.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Phone No.");
		lblNewLabel_2_1_1.setBounds(267, 91, 67, 14);
		panel4.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(266, 106, 133, 28);
		panel4.add(textField_3);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Timings");
		lblNewLabel_2_2_1.setBounds(72, 156, 46, 14);
		panel4.add(lblNewLabel_2_2_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"6AM - 11AM", "4AM - 10AM"}));
		comboBox_1.setBounds(71, 170, 133, 28);
		panel4.add(comboBox_1);
		
		addCoachBtn = new JButton("ADD");
		addCoachBtn.addActionListener(this);
		addCoachBtn.setBackground(new Color(253, 206, 185));
		addCoachBtn.setBounds(133, 228, 207, 37);
		panel4.add(addCoachBtn);
		
		JButton btnStudent = new JButton("MEMBER");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnStudent.setBackground(new Color(120, 151, 171));
		btnStudent.setBounds(356, 401, 108, 34);
		panel4.add(btnStudent);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1_1.setBounds(267, 156, 67, 14);
		panel4.add(lblNewLabel_2_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(266, 171, 133, 28);
		panel4.add(textField_4);
		
		JPanel panel5 = new JPanel();
		tabbedPane.addTab("New tab", null, panel5, null);
		panel5.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("COACH LIST");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1_1.setBounds(137, 11, 199, 67);
		panel5.add(lblNewLabel_1_1_1);
		
		JButton btnStudent_1_1 = new JButton("STUDENT");
		btnStudent_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnStudent_1_1.setBackground(new Color(120, 151, 171));
		btnStudent_1_1.setBounds(356, 401, 108, 34);
		panel5.add(btnStudent_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(10, 89, 454, 264);
		panel5.add(scrollPane_1_1);
		
		table_1 = new JTable();
		table(table_1);
		scrollPane_1_1.setViewportView(table_1);
		
		JButton btnStudent_1_1_1 = new JButton("Refresh");
		btnStudent_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table(table_1);
			}
		});
		btnStudent_1_1_1.setBackground(new Color(120, 151, 171));
		btnStudent_1_1_1.setBounds(49, 401, 108, 34);
		panel5.add(btnStudent_1_1_1);
		
		JPanel panel6 = new JPanel();
		tabbedPane.addTab("New tab", null, panel6, null);
		panel6.setLayout(null);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Update Member");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_3_1.setBounds(111, 11, 252, 67);
		panel6.add(lblNewLabel_1_3_1);
		
		comboBox_3_1 = new JComboBox();
		coach(comboBox_3_1);
		comboBox_3_1.setBounds(170, 231, 133, 28);
		panel6.add(comboBox_3_1);
		
		JLabel lblNewLabel_2_2_3_1 = new JLabel("Coach");
		lblNewLabel_2_2_3_1.setBounds(214, 217, 46, 14);
		panel6.add(lblNewLabel_2_2_3_1);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"6AM - 11AM", "4AM - 10AM"}));
		comboBox_4.setBounds(170, 168, 133, 28);
		panel6.add(comboBox_4);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Timings");
		lblNewLabel_2_2_4.setBounds(214, 154, 46, 14);
		panel6.add(lblNewLabel_2_2_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(170, 104, 133, 28);
		panel6.add(textField_8);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Phone No.");
		lblNewLabel_2_1_2.setBounds(203, 89, 67, 14);
		panel6.add(lblNewLabel_2_1_2);
		
		btnNewButton_4 = new JButton("UPDATE");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(170, 302, 133, 35);
		panel6.add(btnNewButton_4);
		
		JButton btnList = new JButton("LIST");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnList.setBackground(new Color(120, 151, 171));
		btnList.setBounds(46, 270, 108, 34);
		panel.add(btnList);
		
		JButton btnPayments = new JButton("Payments");
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnPayments.setBackground(new Color(120, 151, 171));
		btnPayments.setBounds(46, 315, 108, 34);
		panel.add(btnPayments);
		
		JButton btnLogout = new JButton("EXIT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBackground(new Color(120, 151, 171));
		btnLogout.setBounds(46, 373, 108, 34);
		panel.add(btnLogout);
		
		
	}
	
	boolean mobileNomCheck(JTextField t)
	{
		boolean status = true;
		
		String mobno = t.getText();
		if(mobno.length() == 10)
		{
		   for(int i = 0;i<mobno.length();i++)
		   {
		       if(mobno.charAt(i) >= '0' && mobno.charAt(i) <= '9') 
		       {}
		       else
		       {
		    	   JOptionPane.showMessageDialog(null, "NO CHARACTER Allowed");
		    	   t.setText("");
		    	   status = false;
		    	   break;
		       }
		   }
		}
		else
		{
		   status = false;
		   JOptionPane.showMessageDialog(null, "Mobile No SHOULD BE 10 Digit");
		   t.setText("");
		}
		return status; 
	}
	
	boolean mobileNocCheck()
	{
		boolean status = true;
		
		String mobno = textField_3.getText();
		if(mobno.length() == 10)
		{
		   for(int i = 0;i<mobno.length();i++)
		   {
		       if(mobno.charAt(i) >= '0' && mobno.charAt(i) <= '9') 
		       {}
		       else
		       {
		    	   JOptionPane.showMessageDialog(null, "NO CHARACTER Allowed");
		    	   textField_1.setText("");
		    	   status = false;
		    	   break;
		       }
		   }
		}
		else
		{
		   status = false;
		   JOptionPane.showMessageDialog(null, "Mobile No SHOULD BE 10 Digit");
		   textField_1.setText("");
		}
		return status; 
	}
	
	boolean idCheck(JTextField t) {
		String id = t.getText();		
		BackEndForDBOperation dbobj = new BackEndForDBOperation();
		boolean status = dbobj.idCheck(id);
		
		if (status)
		{}
		else
		{
			status = false;
			JOptionPane.showMessageDialog(null, "INVALID ID");
			textField_5.setText("");
		}
		
		return status;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	  if(e.getSource() == btnNewButton_1)
	  {
		 if(mobileNomCheck(textField_1))
		 {	
			
			LocalDate lt = LocalDate.now();
			
		  	userModel userobj = new userModel();
		  	
		  	userobj.setDatetime(lt.toString());
		  	userobj.setName(textField.getText().trim());
		  	userobj.setPhone(textField_1.getText());
		  	userobj.setTiming((String) comboBox.getSelectedItem());
		  	userobj.setGender((String) comboBox_2.getSelectedItem());
		  	userobj.setAddress(textArea.getText());
		  	userobj.setCoach((String) comboBox_3.getSelectedItem());
			

		
		  	BackEndForDBOperation dbobj = new BackEndForDBOperation();
		
		  	int respfordboperation = dbobj.insertmRecord(userobj);
		
		  	if (respfordboperation > 0)
		  	{
		  		JOptionPane.showMessageDialog(null, "MEMBER ADDED");
		  	}
		  	else
		  	{
		  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
		  	}
		  	
		  	
		 }
		 
		 
	  }
	  
	  else if(e.getSource() == addCoachBtn)
	  {
		 if(mobileNocCheck())
		 {	 
		  	userModel userobj1 = new userModel();
		
		  	userobj1.setCname(textField_2.getText().trim());
		  	userobj1.setCphone(textField_3.getText());
		  	userobj1.setCtiming((String) comboBox_1.getSelectedItem());
		  	userobj1.setEmail(textField_4.getText());
		  	
		
		  	BackEndForDBOperation dbobj = new BackEndForDBOperation();
		
		  	int respfordboperation = dbobj.insertcRecord(userobj1);
		
		  	if (respfordboperation > 0)
		  	{
		  		JOptionPane.showMessageDialog(null, "COACH ADDED");
		  	}
		  	else
		  	{
		  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
		  	}
		  	
		  	
		 }
		 
		 
	  }
	  else if(e.getSource() == btnNewButton_2) {
		  if(idCheck(textField_5)) {
				  LocalDate lt = LocalDate.now();
				  userModel userobj1 = new userModel();
				  
				  userobj1.setDatetime(lt.toString());
				  userobj1.setID(textField_5.getText());
				  userobj1.setAmt(textField_6.getText());
				  
				  BackEndForDBOperation dbobj = new BackEndForDBOperation();
					
				  	int respfordboperation = dbobj.payment(userobj1);
				
				  	if (respfordboperation > 0)
				  	{
				  		JOptionPane.showMessageDialog(null, "PAYMENT ADDED");
				  	}
				  	else
				  	{
				  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
				  	}
		  }
	  } else if(e.getSource() == btnNewButton_4)
		  {
			 if(mobileNomCheck(textField_8))
			 {	
			  	userModel userobj = new userModel();
			  	
			  	String a = userobj.setID(textField_7.getText());
			  	userobj.setPhone(textField_8.getText());
			  	userobj.setTiming((String) comboBox_4.getSelectedItem());
			  	userobj.setCoach((String) comboBox_3_1.getSelectedItem());
				

			
			  	BackEndForDBOperation dbobj = new BackEndForDBOperation();
			
			  	int respfordboperation = dbobj.updateRecord(a, userobj);
			
			  	if (respfordboperation > 0)
			  	{
			  		JOptionPane.showMessageDialog(null, "MEMBER UPDATED");
			  	}
			  	else
			  	{
			  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
			  	}
			  	
			  	
			 }
	  }
	  else if(e.getSource() == btnDelete)
	  {
		 if(idCheck(textField_7))
		 {	
		  	userModel userobj = new userModel();
		  	
		  	String a = userobj.setID(textField_7.getText());
			

		
		  	BackEndForDBOperation dbobj = new BackEndForDBOperation();
		
		  	int respfordboperation = dbobj.deleteRecord(a);
		
		  	if (respfordboperation > 0)
		  	{
		  		JOptionPane.showMessageDialog(null, "MEMBER DELETED");
		  	}
		  	else
		  	{
		  		JOptionPane.showMessageDialog(null, "TRY AGAIN");
		  	}
		  	
		  	
		 }
  }
	}
	

	
	public void table(JTable t) {
		  Connection mysqlconnection;
		  PreparedStatement pst =null;
		  ResultSet rs = null;
		  
		  try {
				  mysqlconnection = DBMySQLConnect.getMySQLConnection();
				  
				  if(t == table) {
				  String sql = "select id, name, phone, timing, coach from memberDetails";
				  pst = mysqlconnection.prepareStatement(sql);
				  rs = pst.executeQuery();
				  t.setModel(DbUtils.resultSetToTableModel(rs));
			  }
			  
			  else if(t == table_1) {
				  String sql = "select * from coachDetails";
				  pst = mysqlconnection.prepareStatement(sql);
				  rs = pst.executeQuery();
				  t.setModel(DbUtils.resultSetToTableModel(rs));
			  }
			  else if(t == table_2) {
				  String sql = "select * from payments";
				  pst = mysqlconnection.prepareStatement(sql);
				  rs = pst.executeQuery();
				  t.setModel(DbUtils.resultSetToTableModel(rs));
			  }
		   }   
		  
		  catch(Exception ex) {
			  
		  }
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void coach(JComboBox c) {
		 Connection mysqlconnection;
		  PreparedStatement pst =null;
		  ResultSet rs = null;
		  
		  try {
		  mysqlconnection = DBMySQLConnect.getMySQLConnection();
		  
		  
			  String sql = "select name from coachDetails";
			  pst = mysqlconnection.prepareStatement(sql);
			  rs = pst.executeQuery();
			  
			  while(rs.next()) {
				  c.addItem(rs.getString("name"));
			  }
		  
		  }
		  
		  catch(Exception ex) {
			  
		  }
	}

}