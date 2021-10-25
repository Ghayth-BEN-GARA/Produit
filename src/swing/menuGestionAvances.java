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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import tn.XXX.gestionmagasin.ProduitFruit;
import tn.XXX.gestionmagasin.ProduitLegume;

public class menuGestionAvances {

	private JFrame menuGestionAvancesFrame;
	private JScrollPane generalFrameScrollPane;
	private JPanel generalFramePanel, entetePanel, bodyPanel, informationsDesGestionsPanel, nombreProduitPanel, nombreMagasinPanel, creerProduitNonVidePanel, creerMagasinNonVidePanel, afficherMagasinPanel, determinerTypeProduitAgricolePanel, calculeStockMagasinPanel, verificationSaisonPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, titreInterfaceLabel, activeLigneLabel, nbrProduitLabel, chiffreNbrProduitLabel, informationsNbrProduitsLabel, nbrMagasinLabel,
				   chiffreNbrMagasinLabel, imageCreerProduitNonVideLabel, imageCreerMagasinNonVideLabel, imageAfficherMagasinLabel, imageDeterminerTypeProduitAgricoleLabel, imageCalculeStockMagasinLabel, imageVerificationSaisonLabel;
	private JButton titreCreerProduitNonVideButton, titreCreerMagasinNonVideButton, titreAfficherMagasinButton, titreDeterminerTypeProduitAgricoleButton, titreCalculeStockMagasinButton, titreVerificationSaisonButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuGestionAvances window = new menuGestionAvances();
					window.menuGestionAvancesFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuGestionAvances() {
		initialize();
	}

	private void initialize() {
		menuGestionAvancesFrame = new JFrame("Gestion des magasins et des produits");
		menuGestionAvancesFrame.setBackground(Color.WHITE);
		menuGestionAvancesFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		menuGestionAvancesFrame.getContentPane().setForeground(Color.BLACK);
		menuGestionAvancesFrame.getContentPane().setBackground(Color.WHITE);
		menuGestionAvancesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuGestionAvancesFrame.setType(Type.POPUP);
		menuGestionAvancesFrame.setAutoRequestFocus(true);
		menuGestionAvancesFrame.setUndecorated(false);
		menuGestionAvancesFrame.setEnabled(true);
		menuGestionAvancesFrame.getContentPane().setLayout(null);
		menuGestionAvancesFrame.setVisible(true);
		menuGestionAvancesFrame.setSize(1000, 1200);
		menuGestionAvancesFrame.setResizable(true);
		menuGestionAvancesFrame.setLocationRelativeTo(null);
		menuGestionAvancesFrame.setMinimumSize(new Dimension(1000, 1500));
		
		generalFrameScrollPane = new JScrollPane();
		generalFrameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		generalFrameScrollPane.setBounds(0, 0, 985, 800);
		
		generalFramePanel = new JPanel();
		generalFrameScrollPane.setViewportView(generalFramePanel);
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setPreferredSize(new Dimension(1000, 1200));
		generalFramePanel.setSize(1000, 1050);
		generalFramePanel.setBorder(null);
		generalFramePanel.setLayout(null);
		
		menuGestionAvancesFrame.getContentPane().add(generalFrameScrollPane);
		menuGestionAvancesFrame.setVisible(true);
		menuGestionAvancesFrame.requestFocusInWindow();
		
		entetePanel = new JPanel();
		entetePanel.setBackground(Color.WHITE);
		entetePanel.setBounds(0, 0, 965, 180);
		generalFramePanel.add(entetePanel);
		entetePanel.setLayout(null);
		
		infoLabel = new JLabel("Vous êtes connectés en tant qu'admin,");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		infoLabel.setBackground(Color.WHITE);
		infoLabel.setBounds(646, 0, 227, 36);
		infoLabel.setForeground(new Color(159, 165, 166));
		entetePanel.add(infoLabel);
		
		logoutLabel = new JLabel("Déconnexion ?");
		logoutLabel.setBackground(Color.WHITE);
		logoutLabel.setForeground(new Color(41, 178, 73));
		logoutLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoutLabel.setBounds(866, 0, 99, 36);
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
		bodyPanel.setBounds(0, 196, 964, 1210);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		titreInterfaceLabel = new JLabel("GESTION DES MAGASINS ET DES PRODUITS");
		titreInterfaceLabel.setBounds(0, 0, 964, 86);
		bodyPanel.add(titreInterfaceLabel);
		titreInterfaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreInterfaceLabel.setForeground(Color.BLACK);
		titreInterfaceLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		titreInterfaceLabel.setBackground(Color.WHITE);
		titreInterfaceLabel.setBorder(null);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setBounds(350, 57, 264, 8);
		activeLigneLabel.setOpaque(true);
		bodyPanel.add(activeLigneLabel);
		
		informationsDesGestionsPanel = new JPanel();
		informationsDesGestionsPanel.setBackground(Color.WHITE);
		informationsDesGestionsPanel.setBounds(172, 76, 638, 86);
		bodyPanel.add(informationsDesGestionsPanel);
		informationsDesGestionsPanel.setLayout(null);
		
		nombreProduitPanel = new JPanel();
		nombreProduitPanel.setBackground(Color.WHITE);
		nombreProduitPanel.setBounds(10, 11, 239, 75);
		nombreProduitPanel.setBorder(new LineBorder(new Color(0, 0, 51), 1));
		informationsDesGestionsPanel.add(nombreProduitPanel);
		nombreProduitPanel.setLayout(null);
		
		nbrProduitLabel = new JLabel("Nombre des produits :");
		nbrProduitLabel.setBounds(0, 6, 239, 20);
		nbrProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitLabel.setForeground(new Color(0, 0, 51));
		nbrProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		nbrProduitLabel.setBackground(Color.WHITE);
		nombreProduitPanel.add(nbrProduitLabel);
		
		chiffreNbrProduitLabel = new JLabel("0");
		chiffreNbrProduitLabel.setBounds(0, 31, 239, 20);
		chiffreNbrProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chiffreNbrProduitLabel.setForeground(new Color(41, 178, 73));
		chiffreNbrProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		chiffreNbrProduitLabel.setBackground(Color.WHITE);
		nombreProduitPanel.add(chiffreNbrProduitLabel);
		remplirLabelParNombreDesProduits();
		
		informationsNbrProduitsLabel = new JLabel("(" + ProduitFruit.getNombreProduitFruit() + " fruit(s), " + ProduitLegume.getNombreProduitLegume() + " légume(s))");
		informationsNbrProduitsLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 11));
		informationsNbrProduitsLabel.setBackground(Color.WHITE);
		informationsNbrProduitsLabel.setBounds(0, 51, 239, 20);
		informationsNbrProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informationsNbrProduitsLabel.setForeground(new Color(41, 178, 73));
		nombreProduitPanel.add(informationsNbrProduitsLabel);
		
		nombreMagasinPanel = new JPanel();
		nombreMagasinPanel.setBackground(Color.WHITE);
		nombreMagasinPanel.setBounds(388, 11, 239, 75);
		nombreMagasinPanel.setBorder(new LineBorder(new Color(0, 0, 51), 1));
		informationsDesGestionsPanel.add(nombreMagasinPanel);
		nombreMagasinPanel.setLayout(null);
		
		nbrMagasinLabel = new JLabel("Nombre des magasins :");
		nbrMagasinLabel.setBounds(0, 6, 239, 20);
		nbrMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrMagasinLabel.setForeground(new Color(0, 0, 51));
		nbrMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		nbrMagasinLabel.setBackground(Color.WHITE);
		nombreMagasinPanel.add(nbrMagasinLabel);
		
		chiffreNbrMagasinLabel = new JLabel("0");
		chiffreNbrMagasinLabel.setBounds(0, 31, 239, 20);
		chiffreNbrMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chiffreNbrMagasinLabel.setForeground(new Color(41, 178, 73));
		chiffreNbrMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		chiffreNbrMagasinLabel.setBackground(Color.WHITE);
		nombreMagasinPanel.add(chiffreNbrMagasinLabel);
		remplirLabelParNombreDesMgasins();
		
		creerProduitNonVidePanel = new JPanel();
		creerProduitNonVidePanel.setBackground(new Color(204, 255, 255));
		creerProduitNonVidePanel.setBounds(21, 190, 294, 248);
		bodyPanel.add(creerProduitNonVidePanel);
		creerProduitNonVidePanel.setLayout(null);
		
		imageCreerProduitNonVideLabel = new JLabel("");
		imageCreerProduitNonVideLabel.setBackground(Color.WHITE);
		imageCreerProduitNonVideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCreerProduitNonVideLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/produitNonVide.png")));
		imageCreerProduitNonVideLabel.setBounds(0, 0, 294, 200);
		creerProduitNonVidePanel.add(imageCreerProduitNonVideLabel);
		
		titreCreerProduitNonVideButton = new JButton("CREER UN PRODUIT AGRICOLE NON VIDE");
		titreCreerProduitNonVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreCreerProduitNonVideButton.setFocusable(false);
		titreCreerProduitNonVideButton.setEnabled(true);
		titreCreerProduitNonVideButton.setContentAreaFilled(true);
		titreCreerProduitNonVideButton.setBorder(null);
		titreCreerProduitNonVideButton.setBounds(0, 197, 294, 51);
		creerProduitNonVidePanel.add(titreCreerProduitNonVideButton);
		titreCreerProduitNonVideButton.setForeground(Color.WHITE);
		titreCreerProduitNonVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreCreerProduitNonVideButton.setBackground(new Color(41, 178, 73));
		titreCreerProduitNonVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreCreerProduitNonVideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new creerProduitAgricoleNonVide();
			}
		});
		
		creerMagasinNonVidePanel = new JPanel();
		creerMagasinNonVidePanel.setBackground(new Color(204, 255, 255));
		creerMagasinNonVidePanel.setBounds(335, 190, 294, 248);
		bodyPanel.add(creerMagasinNonVidePanel);
		creerMagasinNonVidePanel.setLayout(null);
		
		imageCreerMagasinNonVideLabel = new JLabel("");
		imageCreerMagasinNonVideLabel.setBackground(Color.WHITE);
		imageCreerMagasinNonVideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCreerMagasinNonVideLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/creerMagasin.png")));
		imageCreerMagasinNonVideLabel.setBounds(0, 0, 294, 200);
		creerMagasinNonVidePanel.add(imageCreerMagasinNonVideLabel);
		
		titreCreerMagasinNonVideButton = new JButton("CREER UN MAGASIN NON VIDE");
		titreCreerMagasinNonVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreCreerMagasinNonVideButton.setFocusable(false);
		titreCreerMagasinNonVideButton.setEnabled(true);
		titreCreerMagasinNonVideButton.setContentAreaFilled(true);
		titreCreerMagasinNonVideButton.setBorder(null);
		titreCreerMagasinNonVideButton.setBounds(0, 197, 294, 51);
		creerMagasinNonVidePanel.add(titreCreerMagasinNonVideButton);
		titreCreerMagasinNonVideButton.setForeground(Color.WHITE);
		titreCreerMagasinNonVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreCreerMagasinNonVideButton.setBackground(new Color(41, 178, 73));
		titreCreerMagasinNonVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreCreerMagasinNonVideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new creerMagasinProduitAgricoleNonVide();
			}
		});
		
		afficherMagasinPanel = new JPanel();
		afficherMagasinPanel.setBackground(new Color(204, 255, 255));
		afficherMagasinPanel.setBounds(649, 190, 294, 248);
		bodyPanel.add(afficherMagasinPanel);
		afficherMagasinPanel.setLayout(null);
		
		imageAfficherMagasinLabel = new JLabel("");
		imageAfficherMagasinLabel.setBackground(Color.WHITE);
		imageAfficherMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageAfficherMagasinLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/afficherLesProduits.png")));
		imageAfficherMagasinLabel.setBounds(0, 0, 294, 200);
		afficherMagasinPanel.add(imageAfficherMagasinLabel);
		
		titreAfficherMagasinButton = new JButton("AFFICHER LA MAGASIN");
		titreAfficherMagasinButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreAfficherMagasinButton.setFocusable(false);
		titreAfficherMagasinButton.setEnabled(true);
		titreAfficherMagasinButton.setContentAreaFilled(true);
		titreAfficherMagasinButton.setBorder(null);
		titreAfficherMagasinButton.setBounds(0, 197, 294, 51);
		afficherMagasinPanel.add(titreAfficherMagasinButton);
		titreAfficherMagasinButton.setForeground(Color.WHITE);
		titreAfficherMagasinButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreAfficherMagasinButton.setBackground(new Color(41, 178, 73));
		titreAfficherMagasinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreAfficherMagasinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new afficherListeDesMagasinsProduitsAgricoles();
			}
		});
		
		determinerTypeProduitAgricolePanel = new JPanel();
		determinerTypeProduitAgricolePanel.setBackground(new Color(204, 255, 255));
		determinerTypeProduitAgricolePanel.setBounds(21, 490, 294, 248);
		bodyPanel.add(determinerTypeProduitAgricolePanel);
		determinerTypeProduitAgricolePanel.setLayout(null);
		
		imageDeterminerTypeProduitAgricoleLabel = new JLabel("");
		imageDeterminerTypeProduitAgricoleLabel.setBackground(Color.WHITE);
		imageDeterminerTypeProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageDeterminerTypeProduitAgricoleLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/type.png")));
		imageDeterminerTypeProduitAgricoleLabel.setBounds(0, 0, 294, 200);
		determinerTypeProduitAgricolePanel.add(imageDeterminerTypeProduitAgricoleLabel);
		
		titreDeterminerTypeProduitAgricoleButton = new JButton("DETERMINER LE TYPE DES PRODUITS AGRICOLES");
		titreDeterminerTypeProduitAgricoleButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreDeterminerTypeProduitAgricoleButton.setFocusable(false);
		titreDeterminerTypeProduitAgricoleButton.setEnabled(true);
		titreDeterminerTypeProduitAgricoleButton.setContentAreaFilled(true);
		titreDeterminerTypeProduitAgricoleButton.setBorder(null);
		titreDeterminerTypeProduitAgricoleButton.setBounds(0, 197, 294, 51);
		determinerTypeProduitAgricolePanel.add(titreDeterminerTypeProduitAgricoleButton);
		titreDeterminerTypeProduitAgricoleButton.setForeground(Color.WHITE);
		titreDeterminerTypeProduitAgricoleButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreDeterminerTypeProduitAgricoleButton.setBackground(new Color(41, 178, 73));
		titreDeterminerTypeProduitAgricoleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreDeterminerTypeProduitAgricoleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new determinerTypeProduitAgricole();
			}
		});
		
		calculeStockMagasinPanel = new JPanel();
		calculeStockMagasinPanel.setBackground(new Color(204, 255, 255));
		calculeStockMagasinPanel.setBounds(335, 490, 294, 248);
		bodyPanel.add(calculeStockMagasinPanel);
		calculeStockMagasinPanel.setLayout(null);
		
		imageCalculeStockMagasinLabel = new JLabel("");
		imageCalculeStockMagasinLabel.setBackground(Color.WHITE);
		imageCalculeStockMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCalculeStockMagasinLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/quantite.png")));
		imageCalculeStockMagasinLabel.setBounds(0, 0, 294, 200);
		calculeStockMagasinPanel.add(imageCalculeStockMagasinLabel);
		
		titreCalculeStockMagasinButton = new JButton("CALCULER LA QUANTITE DE STOCK DE MAGASIN");
		titreCalculeStockMagasinButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreCalculeStockMagasinButton.setFocusable(false);
		titreCalculeStockMagasinButton.setEnabled(true);
		titreCalculeStockMagasinButton.setContentAreaFilled(true);
		titreCalculeStockMagasinButton.setBorder(null);
		titreCalculeStockMagasinButton.setBounds(0, 197, 294, 51);
		calculeStockMagasinPanel.add(titreCalculeStockMagasinButton);
		titreCalculeStockMagasinButton.setForeground(Color.WHITE);
		titreCalculeStockMagasinButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreCalculeStockMagasinButton.setBackground(new Color(41, 178, 73));
		titreCalculeStockMagasinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreCalculeStockMagasinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new calculerQuantiteDeStockDeMagasin();
			}
		});
		
		verificationSaisonPanel = new JPanel();
		verificationSaisonPanel.setBackground(new Color(204, 255, 255));
		verificationSaisonPanel.setBounds(649, 490, 294, 248);
		bodyPanel.add(verificationSaisonPanel);
		verificationSaisonPanel.setLayout(null);
		
		imageVerificationSaisonLabel = new JLabel("");
		imageVerificationSaisonLabel.setBackground(Color.WHITE);
		imageVerificationSaisonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageVerificationSaisonLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/saision.png")));
		imageVerificationSaisonLabel.setBounds(0, 0, 294, 200);
		verificationSaisonPanel.add(imageVerificationSaisonLabel);
		
		titreVerificationSaisonButton = new JButton("VERIFICATION DES SAISONS");
		titreVerificationSaisonButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreVerificationSaisonButton.setFocusable(false);
		titreVerificationSaisonButton.setEnabled(true);
		titreVerificationSaisonButton.setContentAreaFilled(true);
		titreVerificationSaisonButton.setBorder(null);
		titreVerificationSaisonButton.setBounds(0, 197, 294, 51);
		verificationSaisonPanel.add(titreVerificationSaisonButton);
		titreVerificationSaisonButton.setForeground(Color.WHITE);
		titreVerificationSaisonButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreVerificationSaisonButton.setBackground(new Color(41, 178, 73));
		titreVerificationSaisonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreVerificationSaisonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionAvancesFrame.dispose();
				new verificationDesSaisonsDesProduits();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(menuGestionAvancesFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	menuGestionAvancesFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirLabelParNombreDesProduits() {
		chiffreNbrProduitLabel.setText(String.valueOf(creerProduitAgricoleNonVide.getListeDesProduitsAgricoles().size()));
	}
	
	public void remplirLabelParNombreDesMgasins() {
		chiffreNbrMagasinLabel.setText(String.valueOf(creerMagasinProduitAgricoleNonVide.getListeDesMagasins().size()));
	}
	
	

}
