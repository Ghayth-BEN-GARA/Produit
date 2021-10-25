package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginToApplication {

	private JFrame loginFrame;
	private JPanel generalLoginPanel;
	private JTextField userNameTextField, userPasswordTextField;
	private JSeparator userNameSeperator, userPasswordSeperator;
	private JLabel titreLabel, iconUserNameLabel, iconPasswordLabel, erreurUserNameLabel, erreurUserPasswordLabel;
	private JButton loginButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginToApplication window = new loginToApplication();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public loginToApplication() {
		initialize();
	}

	private void initialize() {
		loginFrame = new JFrame("Authentification");
		loginFrame.setType(Type.POPUP);
		loginFrame.setAutoRequestFocus(false);
		loginFrame.setAlwaysOnTop(true);
		loginFrame.setBounds(100, 200, 550, 500);
		loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		loginFrame.setLocationByPlatform(true);
		loginFrame.setUndecorated(true);
		loginFrame.setEnabled(true);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.getContentPane().setLayout(null);
		
		generalLoginPanel = new JPanel();
		generalLoginPanel.setBackground(Color.WHITE);
		generalLoginPanel.setBounds(0, 0, 550, 550);
		generalLoginPanel.requestFocusInWindow();
		generalLoginPanel.setLayout(null);
		
		loginFrame.getContentPane().add(generalLoginPanel);
		loginFrame.setVisible(true);
		loginFrame.requestFocusInWindow();
		composantsGraphiques(generalLoginPanel);		
	}
	
	public void composantsGraphiques(JPanel panel) {
		titreLabel = new JLabel("Login");
		titreLabel.setHorizontalAlignment(SwingConstants.LEFT);
		titreLabel.setForeground(new Color(0, 0, 51));
		titreLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		titreLabel.setBackground(Color.WHITE);
		titreLabel.setBounds(164, 106, 99, 41);
		panel.add(titreLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setEditable(true);
		userNameTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		userNameTextField.setBackground(Color.WHITE);
		userNameTextField.setBounds(177, 158, 231, 41);
		userNameTextField.setColumns(10);
		userNameTextField.setForeground(new Color(102, 102, 102));
		userNameTextField.setBorder(null);
		userNameTextField.setText("Nom d'utilisateur..");
		panel.add(userNameTextField);
		
		userNameSeperator = new JSeparator();
		userNameSeperator.setBackground(Color.LIGHT_GRAY);
		userNameSeperator.setForeground(Color.LIGHT_GRAY);
		userNameSeperator.setBounds(177, 199, 237, 8);
		panel.add(userNameSeperator);
		
		iconUserNameLabel = new JLabel("");
		iconUserNameLabel.setBackground(Color.WHITE);
		iconUserNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconUserNameLabel.setIcon(new ImageIcon(loginToApplication.class.getResource("/images/userName.png")));
		iconUserNameLabel.setBounds(149, 163, 18, 31);
		panel.add(iconUserNameLabel);
		
		userPasswordTextField = new JTextField();
		userPasswordTextField.setEditable(true);
		userPasswordTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		userPasswordTextField.setHorizontalAlignment(SwingConstants.LEFT);
		userPasswordTextField.setBackground(Color.WHITE);
		userPasswordTextField.setBounds(177, 240, 231, 41);
		userPasswordTextField.setColumns(10);
		userPasswordTextField.setForeground(new Color(102, 102, 102));
		userPasswordTextField.setBorder(null);
		userPasswordTextField.setText("Password d'utilisateur..");
		panel.add(userPasswordTextField);
		
		userPasswordSeperator = new JSeparator();
		userPasswordSeperator.setBackground(Color.LIGHT_GRAY);
		userPasswordSeperator.setForeground(Color.LIGHT_GRAY);
		userPasswordSeperator.setBounds(177, 287, 237, 8);
		panel.add(userPasswordSeperator);
		
		iconPasswordLabel = new JLabel("");
		iconPasswordLabel.setBackground(Color.WHITE);
		iconPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		iconPasswordLabel.setIcon(new ImageIcon(loginToApplication.class.getResource("/images/userPassword.png")));
		iconPasswordLabel.setBounds(149, 247, 18, 31);
		panel.add(iconPasswordLabel);
		
		loginButton = new JButton("LOGIN");
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(41, 178, 73));
		loginButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		loginButton.setBounds(300, 326, 108, 41);
		loginButton.setFocusable(false);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setBorder(null);
		panel.add(loginButton);
		
		erreurUserNameLabel = new JLabel("");
		erreurUserNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		erreurUserNameLabel.setForeground(new Color(204, 0, 0));
		erreurUserNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurUserNameLabel.setBackground(Color.WHITE);
		erreurUserNameLabel.setBounds(177, 204, 237, 25);
		panel.add(erreurUserNameLabel);
		
		erreurUserPasswordLabel = new JLabel("");
		erreurUserPasswordLabel.setHorizontalAlignment(SwingConstants.LEFT);
		erreurUserPasswordLabel.setForeground(new Color(204, 0, 0));
		erreurUserPasswordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurUserPasswordLabel.setBackground(Color.WHITE);
		erreurUserPasswordLabel.setBounds(177, 292, 237, 25);
		panel.add(erreurUserPasswordLabel);
		
		userNameTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(userNameTextField, "Nom d'utilisateur..", userNameSeperator);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(userNameTextField, "Nom d'utilisateur..", userNameSeperator);		
			} 
		});
		
		userPasswordTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(userPasswordTextField, "Password d'utilisateur..", userPasswordSeperator);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(userPasswordTextField, "Password d'utilisateur..", userPasswordSeperator);				
			} 
		});
		
		userNameTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurUserNameLabel.setText("");
			 }
		 });
		
		userPasswordTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurUserPasswordLabel.setText("");
			 }
		 });
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateForm();
			}
		});
	}
	
	public void focusLostParametres(JTextField input, String text, JSeparator ligne) {
		if(input.getText().equals("")) {
			input.setText(text);
			input.setForeground(Color.GRAY);
			ligne.setBackground(Color.LIGHT_GRAY);
			ligne.setForeground(Color.LIGHT_GRAY);
        } 
	}
	
	public void focusGainedParametres(JTextField input, String text, JSeparator ligne) {
		if(input.getText().equals(text)) {
			input.setText("");
			ligne.setBackground(new Color(41, 168, 73));
			ligne.setForeground(new Color(41, 168, 73));
        }
	}
	
	public boolean validerUserName() {
		String userName = userNameTextField.getText();
		boolean test = false;
		
		if((userName.equals("")) || (userName.equals("Nom d'utilisateur.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerUserPassword() {
	String userPassword = userPasswordTextField.getText();
	boolean test = false;
		
		if((userPassword.equals("")) || (userPassword.equals("Password d'utilisateur.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public void validateForm() {
		String userName = userNameTextField.getText();
		String userPassword = userPasswordTextField.getText();
		
		if(validerUserName() == false) {
			erreurUserNameLabel.setText("Le nom d'utilisateur est obligatoire !");
			userNameSeperator.setBackground(new Color(204, 0, 0));
			userNameSeperator.setForeground(new Color(204, 0, 0));
		}
		
		else if(validerUserPassword() == false) {
			erreurUserPasswordLabel.setText("Le password d'utilisateur est obligatoire !");
			userPasswordSeperator.setBackground(new Color(204, 0, 0));
			userPasswordSeperator.setForeground(new Color(204, 0, 0));
		}
		
					
		else if((validerUserName() == true) && (validerUserPassword() == true)) {
			erreurUserNameLabel.setText("");
			userNameSeperator.setBackground(new Color(41, 168, 73));
			userNameSeperator.setForeground(new Color(41, 168, 73));
			erreurUserPasswordLabel.setText("");
			userPasswordSeperator.setBackground(new Color(41, 168, 73));
			userPasswordSeperator.setForeground(new Color(41, 168, 73));
			
			if((userName.equals("Ghayth")) && (userPassword.equals("Admin"))) {
				loginFrame.dispose();
				new menuApplication();
			}
			
			else {
				 JOptionPane.showMessageDialog(loginFrame, "L'authentification a échoué !", "Login", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
}
