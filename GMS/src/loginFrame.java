import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class loginFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;



	public loginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 633, 393);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 206, 185));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setForeground(new Color(216, 133, 163));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(204, 74, 225, 25);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 166, 235, 32);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(204, 149, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 234, 235, 32);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(204, 220, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(this);
		btnNewButton.setBackground(new Color(101, 93, 138));
		btnNewButton.setBounds(254, 299, 125, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_2.setBounds(602, 11, 21, 25);
		contentPane.add(lblNewLabel_2);
		
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{
		String uid = textField_1.getText();
		String pass = passwordField.getText();		
		BackEndForDBOperation dbobj = new BackEndForDBOperation();
		boolean status = dbobj.loginCheck(uid, pass);
		
		if (status)
		{
			MainFrame am = new MainFrame();
			am.setVisible(true);
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "INVALID UID OR PASSWORD");
			textField_1.setText("");
			passwordField.setText("");
		}
		
	}
}
