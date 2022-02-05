import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class splashScreen extends JFrame {

	private JPanel contentPane;
	
	public splashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 290, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(120, 151, 171));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GMS GYM ");
		lblNewLabel.setForeground(new Color(253, 206, 185));
		lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 40));
		lblNewLabel.setBounds(45, 110, 199, 80);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{Thread.sleep(100);}catch(Exception ex) {}
				dispose();
				loginFrame frame2 = new loginFrame();
				frame2.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(216, 133, 163));
		btnNewButton.setBounds(94, 254, 101, 34);
		contentPane.add(btnNewButton);


		}
	}
