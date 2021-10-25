package swing;

import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class menuApplication {

	private JFrame dashboardFrame;
	private JPanel entetePanel, bodyPanel, insidePanel, gestionProduitsPanel, gestionMagasinsPanel, gestionTypeProduitPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, activeLigneLabel, titreGestionProduitLabel, imageGestionProduitLabel,
				   imageGestionMagasinLabel, titreGestionMagasinLabel, imageGestionTypeProduitLabel, titreGestionTypeProduitLabel;
	private JScrollPane bodyPanelScrollPane;
	private JButton menuButton, commencerLesGestionButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuApplication window = new menuApplication();
					window.dashboardFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuApplication() {
		initialize();
	}

	private void initialize() {
		dashboardFrame = new JFrame("Accueil");
		dashboardFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		dashboardFrame.getContentPane().setForeground(Color.BLACK);
		dashboardFrame.getContentPane().setBackground(Color.WHITE);
		dashboardFrame.setBounds(100, 100, 450, 300);
		dashboardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dashboardFrame.setType(Type.POPUP);
		dashboardFrame.setAutoRequestFocus(false);
		dashboardFrame.setUndecorated(false);
		dashboardFrame.setEnabled(true);
		dashboardFrame.getContentPane().setLayout(null);
		dashboardFrame.setVisible(true);
		dashboardFrame.setSize(1000, 800);
		dashboardFrame.setResizable(true);
		dashboardFrame.setLocationRelativeTo(null);
		dashboardFrame.setPreferredSize(new Dimension(1000, 800));
		
		entetePanel = new JPanel();
		entetePanel.setBackground(Color.WHITE);
		entetePanel.setBounds(0, 0, 984, 180);
		dashboardFrame.getContentPane().add(entetePanel);
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
		
		bodyPanelScrollPane = new JScrollPane();
		bodyPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		bodyPanelScrollPane.setBounds(0, 179, 984, 382);
		bodyPanelScrollPane.setBorder(null);
		dashboardFrame.getContentPane().add(bodyPanelScrollPane);
		
		bodyPanel = new JPanel();
		bodyPanelScrollPane.setViewportView(bodyPanel);
		bodyPanel.setBackground(Color.WHITE);
		bodyPanel.setBorder(null);
		bodyPanel.setLayout(new CardLayout(0, 0));
		
		insidePanel = new JPanel();
		insidePanel.setBackground(Color.WHITE);
		insidePanel.setBorder(null);
		bodyPanel.add(insidePanel, "name_1427010684700");
		insidePanel.setLayout(null);
		
		menuButton = new JButton("MENU DE L'APPLICATION");
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(405, 157, 177, 23);
		menuButton.setBorder(null);
		menuButton.setContentAreaFilled(false);
		menuButton.setFocusable(false);
		menuButton.setMaximumSize(new Dimension(117, 25));
		menuButton.setMinimumSize(new Dimension(117, 25));
		menuButton.setPreferredSize(new Dimension(117,  25));
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(menuButton);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setBounds(414, 11, 164, 7);
		activeLigneLabel.setOpaque(true);
		insidePanel.add(activeLigneLabel);
		
		gestionProduitsPanel = new JPanel();
		gestionProduitsPanel.setBackground(Color.WHITE);
		gestionProduitsPanel.setBounds(22, 56, 294, 315);
		insidePanel.add(gestionProduitsPanel);
		gestionProduitsPanel.setLayout(null);
		
		imageGestionProduitLabel = new JLabel("");
		imageGestionProduitLabel.setBackground(Color.WHITE);
		imageGestionProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageGestionProduitLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/produit.png")));
		imageGestionProduitLabel.setBounds(0, 50, 294, 265);
		gestionProduitsPanel.add(imageGestionProduitLabel);
		
		titreGestionProduitLabel = new JLabel("Gestion des produits");
		titreGestionProduitLabel.setBounds(0, 0, 294, 51);
		gestionProduitsPanel.add(titreGestionProduitLabel);
		titreGestionProduitLabel.setForeground(Color.WHITE);
		titreGestionProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreGestionProduitLabel.setBackground(new Color(41, 178, 73));
		titreGestionProduitLabel.setOpaque(true);
		
		gestionMagasinsPanel = new JPanel();
		gestionMagasinsPanel.setBackground(Color.WHITE);
		gestionMagasinsPanel.setBounds(340, 56, 294, 315);
		insidePanel.add(gestionMagasinsPanel);
		gestionMagasinsPanel.setLayout(null);
		
		imageGestionMagasinLabel = new JLabel("");
		imageGestionMagasinLabel.setBackground(Color.WHITE);
		imageGestionMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageGestionMagasinLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/magasin.png")));
		imageGestionMagasinLabel.setBounds(0, 49, 294, 266);
		gestionMagasinsPanel.add(imageGestionMagasinLabel);
		
		titreGestionMagasinLabel = new JLabel("Gestion des magasins");
		titreGestionMagasinLabel.setBounds(0, 0, 294, 51);
		gestionMagasinsPanel.add(titreGestionMagasinLabel);
		titreGestionMagasinLabel.setForeground(Color.WHITE);
		titreGestionMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreGestionMagasinLabel.setBackground(new Color(41, 178, 73));
		titreGestionMagasinLabel.setOpaque(true);
		
		gestionTypeProduitPanel = new JPanel();
		gestionTypeProduitPanel.setBackground(Color.WHITE);
		gestionTypeProduitPanel.setBounds(659, 56, 294, 315);
		insidePanel.add(gestionTypeProduitPanel);
		gestionTypeProduitPanel.setLayout(null);
		
		imageGestionTypeProduitLabel = new JLabel("");
		imageGestionTypeProduitLabel.setHorizontalAlignment(SwingConstants.LEFT);
		imageGestionTypeProduitLabel.setBackground(Color.WHITE);
		imageGestionTypeProduitLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/typeProduit.png")));
		imageGestionTypeProduitLabel.setBounds(0, 49, 294, 266);
		gestionTypeProduitPanel.add(imageGestionTypeProduitLabel);
		
		titreGestionTypeProduitLabel = new JLabel("Gestion des types des produits");
		titreGestionTypeProduitLabel.setBounds(0, 0, 294, 51);
		gestionTypeProduitPanel.add(titreGestionTypeProduitLabel);
		titreGestionTypeProduitLabel.setForeground(Color.WHITE);
		titreGestionTypeProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreGestionTypeProduitLabel.setBackground(new Color(41, 178, 73));
		titreGestionTypeProduitLabel.setOpaque(true);
		
		commencerLesGestionButton = new JButton("COMMMENCER");
		commencerLesGestionButton.setBounds(339, 572, 294, 51);
		commencerLesGestionButton.setForeground(Color.WHITE);
		commencerLesGestionButton.setBorder(null);
		commencerLesGestionButton.setBackground(new Color(41, 178, 73));
		commencerLesGestionButton.setContentAreaFilled(true);
		commencerLesGestionButton.setEnabled(true);
		commencerLesGestionButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		commencerLesGestionButton.setFocusable(false);
		commencerLesGestionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dashboardFrame.getContentPane().add(commencerLesGestionButton);	
		
		logoutLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  {  
		    	deconnexion();
		    }  
		}); 
		
		commencerLesGestionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dashboardFrame.dispose();
				new menuGestionProduit();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(dashboardFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	dashboardFrame.dispose();
			new loginToApplication();
	    }
	}
}
