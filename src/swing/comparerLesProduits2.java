package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import tn.XXX.gestionmagasin.Magasin;
import tn.XXX.gestionmagasin.ProduitAlimentaire;

public class comparerLesProduits2 {

	private JFrame comparerLesProduits2Frame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, form1ComparerLesProduits2Panel, form2ComparerLesProduits2Panel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, resultatComparaisonDesProduits2Label, activeLigneLabel, bgImagelabel, identifiant1ProduitComparerLesProduits2Label,
				   erreurIdentifiant1ProduitComparerLesProduits2Label, libelle1ProduitComparerLesProduits2Label, erreurLibelle1ProduitComparerLesProduits2Label, prix1ProduitComparerLesProduits2Label, erreurPrix1ProduitComparerLesProduits2Label,
				   identifiant2ProduitComparerLesProduits2Label, erreurIdentifiant2ProduitComparerLesProduits2Label, libelle2ProduitComparerLesProduits2Label, prix2ProduitComparerLesProduits2Label, erreurPrix2ProduitComparerLesProduits2Label,
				   erreurLibelle2ProduitComparerLesProduits2Label;
	private JButton menuButton, comparerLesProduits2Button;
	private JTextField identifiant1ProduitComparerLesProduits2TextField, libelle1ProduitComparerLesProduits2TextField, prix1ProduitComparerLesProduits2TextField, identifiant2ProduitComparerLesProduits2TextField, libelle2ProduitComparerLesProduits2TextField,
					   prix2ProduitComparerLesProduits2TextField;
	private JSeparator deuxBlocksSeperateur;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comparerLesProduits2 window = new comparerLesProduits2();
					window.comparerLesProduits2Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public comparerLesProduits2() {
		initialize();
	}

	private void initialize() {
		comparerLesProduits2Frame = new JFrame("Comparer les produits");
		comparerLesProduits2Frame.setBackground(Color.WHITE);
		comparerLesProduits2Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		comparerLesProduits2Frame.getContentPane().setForeground(Color.BLACK);
		comparerLesProduits2Frame.getContentPane().setBackground(Color.WHITE);
		comparerLesProduits2Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		comparerLesProduits2Frame.setType(Type.POPUP);
		comparerLesProduits2Frame.setAutoRequestFocus(true);
		comparerLesProduits2Frame.setUndecorated(false);
		comparerLesProduits2Frame.setEnabled(true);
		comparerLesProduits2Frame.getContentPane().setLayout(null);
		comparerLesProduits2Frame.setVisible(true);
		comparerLesProduits2Frame.setSize(1000, 800);
		comparerLesProduits2Frame.setResizable(true);
		comparerLesProduits2Frame.setLocationRelativeTo(null);
		comparerLesProduits2Frame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		comparerLesProduits2Frame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		comparerLesProduits2Frame.requestFocusInWindow();
		
		entetePanel = new JPanel();
		entetePanel.setBackground(Color.WHITE);
		entetePanel.setBounds(0, 0, 984, 147);
		generalFramePanel.add(entetePanel);
		entetePanel.setLayout(null);
		
		infoLabel = new JLabel("Vous êtes connectés en tant qu'admin,");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoLabel.setBackground(Color.WHITE);
		infoLabel.setBounds(667, 0, 227, 36);
		infoLabel.setForeground(new Color(159, 165, 166));
		entetePanel.add(infoLabel);
		
		logoutLabel = new JLabel("Déconnexion ?");
		logoutLabel.setBackground(Color.WHITE);
		logoutLabel.setForeground(new Color(41, 178, 73));
		logoutLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutLabel.setBounds(885, 0, 99, 36);
	    logoutLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(logoutLabel);	
		logoutLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  {  
		    	deconnexion();
		    }  
		});
		
		photoProfilLabel = new JLabel("");
		photoProfilLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/photoProfil.png")));
		photoProfilLabel.setHorizontalAlignment(SwingConstants.CENTER);
		photoProfilLabel.setBackground(Color.WHITE);
		photoProfilLabel.setBounds(20, 43, 119, 80);
		entetePanel.add(photoProfilLabel);
		
		nomPrenomLabel = new JLabel("Ghayth Ben Gara");
		nomPrenomLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 20));
		nomPrenomLabel.setBackground(Color.WHITE);
		nomPrenomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nomPrenomLabel.setBounds(134, 51, 164, 28);
		entetePanel.add(nomPrenomLabel);
		
		metierLabel = new JLabel("Développeur web |");
		metierLabel.setHorizontalAlignment(SwingConstants.CENTER);
		metierLabel.setForeground(new Color(159, 165, 166));
		metierLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		metierLabel.setBackground(Color.WHITE);
		metierLabel.setBounds(124, 74, 107, 36);
		entetePanel.add(metierLabel);
		
		etudiantLabel = new JLabel("Etudiant à Sesame");
		etudiantLabel.setHorizontalAlignment(SwingConstants.CENTER);
		etudiantLabel.setForeground(new Color(41, 178, 73));
		etudiantLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etudiantLabel.setBackground(Color.WHITE);
		etudiantLabel.setBounds(231, 74, 107, 36);
		entetePanel.add(etudiantLabel);
		
		villeLabel = new JLabel("Ghar El Melh, Bizerte, Tunisie");
		villeLabel.setForeground(new Color(159, 165, 166));
		villeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		villeLabel.setBackground(Color.WHITE);
		villeLabel.setBounds(124, 100, 214, 36);
		entetePanel.add(villeLabel);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.WHITE);
		bodyPanel.setBorder(null);
		bodyPanel.setBounds(0, 158, 984, 535);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		resultatComparaisonDesProduits2Label = new JLabel("");
		resultatComparaisonDesProduits2Label.setBounds(405, 62, 294, 34);
		resultatComparaisonDesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		resultatComparaisonDesProduits2Label.setForeground(new Color(41, 178, 73));
		resultatComparaisonDesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatComparaisonDesProduits2Label.setBackground(Color.WHITE);
		entetePanel.add(resultatComparaisonDesProduits2Label);
		
		menuButton = new JButton("COMPARAISON DES PRODUITS");
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(405, 100, 263, 23);
		menuButton.setBorder(null);
		menuButton.setContentAreaFilled(false);
		menuButton.setFocusable(false);
		menuButton.setMaximumSize(new Dimension(117, 25));
		menuButton.setMinimumSize(new Dimension(117, 25));
		menuButton.setPreferredSize(new Dimension(117,  25));
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(menuButton);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBounds(439, 125, 196, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBackground(Color.WHITE);
		backgroundImagePanel.setBounds(10, 11, 406, 559);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgImagelabel.setIcon(new ImageIcon(comparerLesProduits1.class.getResource("/images/comparerProduit1.png")));
		bgImagelabel.setBounds(0, 0, 404, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		form1ComparerLesProduits2Panel = new JPanel();
		form1ComparerLesProduits2Panel.setBackground(Color.WHITE);
		form1ComparerLesProduits2Panel.setBounds(415, 11, 273, 366);
		bodyPanel.add(form1ComparerLesProduits2Panel);
		form1ComparerLesProduits2Panel.setLayout(null);
		
		form2ComparerLesProduits2Panel = new JPanel();
		form2ComparerLesProduits2Panel.setLayout(null);
		form2ComparerLesProduits2Panel.setBackground(Color.WHITE);
		form2ComparerLesProduits2Panel.setBounds(706, 11, 273, 366);
		bodyPanel.add(form2ComparerLesProduits2Panel);
		
		identifiant1ProduitComparerLesProduits2Label = new JLabel("IDENTIFIANT");
		identifiant1ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		identifiant1ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiant1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		identifiant1ProduitComparerLesProduits2Label.setBounds(0, 0, 273, 41);
		form1ComparerLesProduits2Panel.add(identifiant1ProduitComparerLesProduits2Label);
		
		identifiant1ProduitComparerLesProduits2TextField = new JTextField();
		identifiant1ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiant1ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiant1ProduitComparerLesProduits2TextField.setEditable(true);
		identifiant1ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiant1ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		identifiant1ProduitComparerLesProduits2TextField.setBounds(0, 42, 273, 41);
		identifiant1ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		identifiant1ProduitComparerLesProduits2TextField.setText("Identifiant de produit..");
		form1ComparerLesProduits2Panel.add(identifiant1ProduitComparerLesProduits2TextField);
		identifiant1ProduitComparerLesProduits2TextField.setColumns(10);
		
		identifiant1ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiant1ProduitComparerLesProduits2TextField, "Identifiant de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiant1ProduitComparerLesProduits2TextField, "Identifiant de produit..");		
			} 
		});
		
		identifiant1ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiant1ProduitComparerLesProduits2TextField, erreurIdentifiant1ProduitComparerLesProduits2Label, e);
			 }
		 });
		
		erreurIdentifiant1ProduitComparerLesProduits2Label = new JLabel("");
		erreurIdentifiant1ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiant1ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurIdentifiant1ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiant1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurIdentifiant1ProduitComparerLesProduits2Label.setBounds(0, 83, 273, 36);
		form1ComparerLesProduits2Panel.add(erreurIdentifiant1ProduitComparerLesProduits2Label);
		
		libelle1ProduitComparerLesProduits2Label = new JLabel("LIBELLE");
		libelle1ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		libelle1ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		libelle1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		libelle1ProduitComparerLesProduits2Label.setBounds(0, 119, 273, 41);
		form1ComparerLesProduits2Panel.add(libelle1ProduitComparerLesProduits2Label);
		
		libelle1ProduitComparerLesProduits2TextField = new JTextField();
		libelle1ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelle1ProduitComparerLesProduits2TextField.setEditable(true);
		libelle1ProduitComparerLesProduits2TextField.setEnabled(true);
		libelle1ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		libelle1ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		libelle1ProduitComparerLesProduits2TextField.setBounds(0, 160, 273, 41);
		libelle1ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		libelle1ProduitComparerLesProduits2TextField.setText("Libellé de produit..");
		form1ComparerLesProduits2Panel.add(libelle1ProduitComparerLesProduits2TextField);
		libelle1ProduitComparerLesProduits2TextField.setColumns(10);
		
		libelle1ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(libelle1ProduitComparerLesProduits2TextField, "Libellé de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(libelle1ProduitComparerLesProduits2TextField, "Libellé de produit..");		
			} 
		});
		
		libelle1ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurLibelle1ProduitComparerLesProduits2Label.setText("");
			 }
		 });
		
		erreurLibelle1ProduitComparerLesProduits2Label = new JLabel("");
		erreurLibelle1ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurLibelle1ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurLibelle1ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurLibelle1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurLibelle1ProduitComparerLesProduits2Label.setBounds(0, 201, 273, 36);
		form1ComparerLesProduits2Panel.add(erreurLibelle1ProduitComparerLesProduits2Label);
		
		prix1ProduitComparerLesProduits2Label = new JLabel("PRIX");
		prix1ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		prix1ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		prix1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		prix1ProduitComparerLesProduits2Label.setBounds(0, 232, 273, 41);
		form1ComparerLesProduits2Panel.add(prix1ProduitComparerLesProduits2Label);
		
		prix1ProduitComparerLesProduits2TextField = new JTextField();
		prix1ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		prix1ProduitComparerLesProduits2TextField.setEditable(true);
		prix1ProduitComparerLesProduits2TextField.setEnabled(true);
		prix1ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		prix1ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		prix1ProduitComparerLesProduits2TextField.setBounds(0, 274, 273, 41);
		prix1ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		prix1ProduitComparerLesProduits2TextField.setText("Prix de produit..");
		form1ComparerLesProduits2Panel.add(prix1ProduitComparerLesProduits2TextField);
		prix1ProduitComparerLesProduits2TextField.setColumns(10);
		
		erreurPrix1ProduitComparerLesProduits2Label = new JLabel("");
		erreurPrix1ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurPrix1ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurPrix1ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurPrix1ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurPrix1ProduitComparerLesProduits2Label.setBounds(0, 316, 273, 36);
		form1ComparerLesProduits2Panel.add(erreurPrix1ProduitComparerLesProduits2Label);
		
		prix1ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(prix1ProduitComparerLesProduits2TextField, "Prix de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(prix1ProduitComparerLesProduits2TextField, "Prix de produit..");		
			} 
		});
		
		prix1ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType2(prix1ProduitComparerLesProduits2TextField, erreurPrix1ProduitComparerLesProduits2Label, e);
			 }
		 });
		
		deuxBlocksSeperateur = new JSeparator();
		deuxBlocksSeperateur.setOrientation(SwingConstants.VERTICAL);
		deuxBlocksSeperateur.setBounds(696, 11, 1, 355);
		deuxBlocksSeperateur.setForeground(new Color(41, 178, 73));
		deuxBlocksSeperateur.setBackground(new Color(41, 178, 73));
		bodyPanel.add(deuxBlocksSeperateur);
		
		identifiant2ProduitComparerLesProduits2Label = new JLabel("IDENTIFIANT");
		identifiant2ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		identifiant2ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiant2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		identifiant2ProduitComparerLesProduits2Label.setBounds(0, 0, 273, 41);
		form2ComparerLesProduits2Panel.add(identifiant2ProduitComparerLesProduits2Label);
		
		identifiant2ProduitComparerLesProduits2TextField = new JTextField();
		identifiant2ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiant2ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiant2ProduitComparerLesProduits2TextField.setEditable(true);
		identifiant2ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiant2ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		identifiant2ProduitComparerLesProduits2TextField.setBounds(0, 42, 273, 41);
		identifiant2ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		identifiant2ProduitComparerLesProduits2TextField.setText("Identifiant de produit..");
		form2ComparerLesProduits2Panel.add(identifiant2ProduitComparerLesProduits2TextField);
		identifiant2ProduitComparerLesProduits2TextField.setColumns(10);
		
		erreurIdentifiant2ProduitComparerLesProduits2Label = new JLabel("");
		erreurIdentifiant2ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiant2ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurIdentifiant2ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiant2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurIdentifiant2ProduitComparerLesProduits2Label.setBounds(0, 83, 273, 36);
		form2ComparerLesProduits2Panel.add(erreurIdentifiant2ProduitComparerLesProduits2Label);
		
		identifiant2ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiant2ProduitComparerLesProduits2TextField, "Identifiant de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiant2ProduitComparerLesProduits2TextField, "Identifiant de produit..");		
			} 
		});
		
		identifiant2ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiant2ProduitComparerLesProduits2TextField, erreurIdentifiant2ProduitComparerLesProduits2Label, e);
			 }
		 });
		
		libelle2ProduitComparerLesProduits2Label = new JLabel("LIBELLE");
		libelle2ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		libelle2ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		libelle2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		libelle2ProduitComparerLesProduits2Label.setBounds(0, 119, 273, 41);
		form2ComparerLesProduits2Panel.add(libelle2ProduitComparerLesProduits2Label);
		
		libelle2ProduitComparerLesProduits2TextField = new JTextField();
		libelle2ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelle2ProduitComparerLesProduits2TextField.setEditable(true);
		libelle2ProduitComparerLesProduits2TextField.setEnabled(true);
		libelle2ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		libelle2ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		libelle2ProduitComparerLesProduits2TextField.setBounds(0, 160, 273, 41);
		libelle2ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		libelle2ProduitComparerLesProduits2TextField.setText("Libellé de produit..");
		form2ComparerLesProduits2Panel.add(libelle2ProduitComparerLesProduits2TextField);
		libelle2ProduitComparerLesProduits2TextField.setColumns(10);
		
		libelle2ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(libelle2ProduitComparerLesProduits2TextField, "Libellé de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(libelle2ProduitComparerLesProduits2TextField, "Libellé de produit..");		
			} 
		});
		
		libelle2ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurLibelle2ProduitComparerLesProduits2Label.setText("");
			 }
		 });
		
		erreurLibelle2ProduitComparerLesProduits2Label = new JLabel("");
		erreurLibelle2ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurLibelle2ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurLibelle2ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurLibelle2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurLibelle2ProduitComparerLesProduits2Label.setBounds(0, 201, 273, 36);
		form2ComparerLesProduits2Panel.add(erreurLibelle2ProduitComparerLesProduits2Label);
		
		prix2ProduitComparerLesProduits2Label = new JLabel("PRIX");
		prix2ProduitComparerLesProduits2Label.setForeground(new Color(0, 0, 51));
		prix2ProduitComparerLesProduits2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		prix2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		prix2ProduitComparerLesProduits2Label.setBounds(0, 232, 273, 41);
		form2ComparerLesProduits2Panel.add(prix2ProduitComparerLesProduits2Label);
		
		prix2ProduitComparerLesProduits2TextField = new JTextField();
		prix2ProduitComparerLesProduits2TextField.setHorizontalAlignment(SwingConstants.CENTER);
		prix2ProduitComparerLesProduits2TextField.setEditable(true);
		prix2ProduitComparerLesProduits2TextField.setEnabled(true);
		prix2ProduitComparerLesProduits2TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		prix2ProduitComparerLesProduits2TextField.setBackground(Color.WHITE);
		prix2ProduitComparerLesProduits2TextField.setBounds(0, 274, 273, 41);
		prix2ProduitComparerLesProduits2TextField.setForeground(new Color(102, 102, 102));
		prix2ProduitComparerLesProduits2TextField.setText("Prix de produit..");
		form2ComparerLesProduits2Panel.add(prix2ProduitComparerLesProduits2TextField);
		prix2ProduitComparerLesProduits2TextField.setColumns(10);
		
		erreurPrix2ProduitComparerLesProduits2Label = new JLabel("");
		erreurPrix2ProduitComparerLesProduits2Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurPrix2ProduitComparerLesProduits2Label.setForeground(new Color(204, 0, 0));
		erreurPrix2ProduitComparerLesProduits2Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurPrix2ProduitComparerLesProduits2Label.setBackground(Color.WHITE);
		erreurPrix2ProduitComparerLesProduits2Label.setBounds(0, 316, 273, 36);
		form2ComparerLesProduits2Panel.add(erreurPrix2ProduitComparerLesProduits2Label);
		
		prix2ProduitComparerLesProduits2TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(prix2ProduitComparerLesProduits2TextField, "Prix de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(prix2ProduitComparerLesProduits2TextField, "Prix de produit..");		
			} 
		});
		
		prix2ProduitComparerLesProduits2TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType2(prix2ProduitComparerLesProduits2TextField, erreurPrix2ProduitComparerLesProduits2Label, e);
			 }
		 });

		comparerLesProduits2Button = new JButton("COMPARER LES PRODUITS");
		comparerLesProduits2Button.setBounds(706, 382, 273, 51);
		bodyPanel.add(comparerLesProduits2Button);
		comparerLesProduits2Button.setFont(new Font("Dialog", Font.BOLD, 12));
		comparerLesProduits2Button.setFocusable(false);
		comparerLesProduits2Button.setEnabled(true);
		comparerLesProduits2Button.setContentAreaFilled(true);
		comparerLesProduits2Button.setBorder(null);
		comparerLesProduits2Button.setForeground(Color.WHITE);
		comparerLesProduits2Button.setHorizontalAlignment(SwingConstants.CENTER);
		comparerLesProduits2Button.setBackground(new Color(41, 178, 73));
		comparerLesProduits2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comparerLesProduits2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateFormComparerLesProduits();			
				form1ComparerLesProduits2Panel.requestFocusInWindow();
				form2ComparerLesProduits2Panel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesProduits2Frame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesProduits2Frame.dispose();
			new loginToApplication();
	    }
	}
	
	public void focusLostParametres(JTextField input, String text) {
		if(input.getText().equals("")) {
			input.setText(text);
			input.setForeground(Color.GRAY);
        } 
	}
	
	public void focusGainedParametres(JTextField input, String text) {
		if(input.getText().equals(text)) {
			input.setText("");
        }
	}
	
	public void keyPressedParametresType1(JTextField input, JLabel text, KeyEvent e) {
		 char c = e.getKeyChar();
		 if (c >= '0' && c <= '9') {
			 input.setEditable(true);
			 text.setText("");
		 }
		 
		 else {
				input.setEditable(false);
				text.setText("Seulement les chiffres sont acceptés !");
			}
   } 
	
	public void keyPressedParametresType2(JTextField input, JLabel text, KeyEvent e) {
		 char c = e.getKeyChar();
		 if ((c >= '0' && c <= '9') || (c == '.')) {
			 input.setEditable(true);
			 text.setText("");
		 } 
		 
		else {
			input.setEditable(false);
			text.setText("Seulement les chiffres et le virgule sont acceptés !");
		}
	}
	
	public boolean validerIdentifiant(String identifiant) {
		boolean test = false;
		
		if((identifiant.equals("")) || (identifiant.equals("Identifiant de produit.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerIdentifiantNull(String identifiant) {
		boolean test = false;
		
		if(Integer.parseInt(identifiant) == 0) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerLibelle(String libelle) {
		boolean test = false;
		
		if((libelle.equals("")) || (libelle.equals("Libellé de produit.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerPrix(String prix) {
		boolean test = false;
		
		if((prix.equals("")) || (prix.equals("Prix de produit.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerPrixNull(String prix) {
		boolean test = false;
		
		if((Double.parseDouble(prix) == 0.0)) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public void validateFormComparerLesProduits() {
		String identifiant1 = identifiant1ProduitComparerLesProduits2TextField.getText();
		String libelle1 = libelle1ProduitComparerLesProduits2TextField.getText();
		String prix1 = prix1ProduitComparerLesProduits2TextField.getText();
		String identifiant2 = identifiant2ProduitComparerLesProduits2TextField.getText();
		String libelle2 = libelle2ProduitComparerLesProduits2TextField.getText();
		String prix2 = prix2ProduitComparerLesProduits2TextField.getText();
		
		if(validerIdentifiant(identifiant1) == false) {
			erreurIdentifiant1ProduitComparerLesProduits2Label.setText("L'identifiant de produit est obligatoire !");
		}
		 
		else if(validerIdentifiant(identifiant2) == false) {
			erreurIdentifiant2ProduitComparerLesProduits2Label.setText("L'identifiant de produit est obligatoire !");
		}
		
		else if(validerIdentifiantNull(identifiant1) == false) {
			erreurIdentifiant1ProduitComparerLesProduits2Label.setText("L'identifiant de produit est nul !");
		}
		
		else if(validerIdentifiantNull(identifiant2) == false) {
			erreurIdentifiant2ProduitComparerLesProduits2Label.setText("L'identifiant de produit est nul !");
		}
		
		else if(validerLibelle(libelle1) == false) {
			erreurLibelle1ProduitComparerLesProduits2Label.setText("La libellé de produit est obligatoire !");
		}
		
		else if(validerLibelle(libelle2) == false) {
			erreurLibelle2ProduitComparerLesProduits2Label.setText("La libellé de produit est obligatoire !");
		}
		
		else if(validerPrix(prix1) == false) {
			erreurPrix1ProduitComparerLesProduits2Label.setText("Le prix de produit est obligatoire !");
		}
		
		else if(validerPrix(prix2) == false) {
			erreurPrix2ProduitComparerLesProduits2Label.setText("Le prix de produit est obligatoire !");
		}
		
		else if(validerPrixNull(prix1)== false) {
			erreurPrix1ProduitComparerLesProduits2Label.setText("Le prix de produit est null !");
		}
		
		else if(validerPrixNull(prix2)== false) {
			erreurPrix2ProduitComparerLesProduits2Label.setText("Le prix de produit est null !");
		}
		
		else {
			comparerLesProduitsAlimentaires2();
			identifiant1ProduitComparerLesProduits2TextField.setText("Identifiant de produit..");
			libelle1ProduitComparerLesProduits2TextField.setText("Libellé de produit..");
			prix1ProduitComparerLesProduits2TextField.setText("Prix de produit..");
			identifiant2ProduitComparerLesProduits2TextField.setText("Identifiant de produit..");
			libelle2ProduitComparerLesProduits2TextField.setText("Libellé de produit..");
			prix2ProduitComparerLesProduits2TextField.setText("Prix de produit..");
		}
	}
	
	public void comparerLesProduitsAlimentaires2() {
		ProduitAlimentaire p1 = new ProduitAlimentaire(Integer.parseInt(identifiant1ProduitComparerLesProduits2TextField.getText()), libelle1ProduitComparerLesProduits2TextField.getText(), null, Double.parseDouble(prix1ProduitComparerLesProduits2TextField.getText()), null);
		ProduitAlimentaire p2 = new ProduitAlimentaire(Integer.parseInt(identifiant2ProduitComparerLesProduits2TextField.getText()), libelle2ProduitComparerLesProduits2TextField.getText(), null, Double.parseDouble(prix2ProduitComparerLesProduits2TextField.getText()), null);
		boolean test = false;
		
		test = Magasin.comparerProduitMethode2(p1, p2);
		if(test == true) {
			resultatComparaisonDesProduits2Label.setForeground(new Color(41, 178, 73));
			resultatComparaisonDesProduits2Label.setText("Les deux produits sont conformes.");
		}
		
		else {
			resultatComparaisonDesProduits2Label.setForeground(new Color(204, 0, 0));
			resultatComparaisonDesProduits2Label.setText("Les deux produits ne sont pas conformes.");
		}
		
		Timer t = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatComparaisonDesProduits2Label.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesProduits2Frame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesProduits2Frame.dispose();
			new menuGestionMagasin();
	    }
	}
}
