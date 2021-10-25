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
import java.util.ArrayList;
import java.util.List;
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
import tn.XXX.gestionmagasin.Magasin;

public class menuGestionMagasin {

	private JFrame menuGestionMagasinFrame;
	private JScrollPane generalFrameScrollPane;
	private JPanel generalFramePanel, entetePanel, bodyPanel, informationsDesGestionsPanel, nombreProduitPanel, nombreMagasinPanel, creerMagasinNonVidePanel, comparerMagasinMethode1Panel, comparerMagasinMethode2Panel,
				   afficherMagasinPanel, chercherProduitDansMagasinPanel, supprimerProduitPanel, maxCapaciteDeuxMagasinPanel;
	private Dimension screenSizeDimension;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, titreInterfaceLabel, activeLigneLabel, nbrProduitLabel, chiffreNbrProduitLabel, nbrMagasinLabel,
			       chiffreNbrMagasinLabel, imageCreerMagasinNonVideLabel, imageComparerMagasinMethode1Label, imageComparerMagasinMethode2Label, seperateurDesBlocsLabel, imageAfficherMagasinLabel, imageChercherProduitDansMagasinLabel,
			       imageSupprimerProduitLabel, seperateurDesBlocs2Label, imageMaxCapaciteDeuxMagasinLabel;
	private JButton titreCreerMagasinNonVideButton, titreComparerMagasinMethode1Button, titreComparerMagasinMethode2Button, titreAfficherMagasinButton, titreChercherProduitDansMagasinButton, titreSupprimerProduitButton, titreMaxCapaciteDeuxMagasinButton,
					continuerButton;
	
	private static List<Magasin> listeDesMagasins = new ArrayList<Magasin>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuGestionMagasin window = new menuGestionMagasin();
					window.menuGestionMagasinFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuGestionMagasin() {
		initialize();
	}

	private void initialize() {
		menuGestionMagasinFrame = new JFrame("Gestion des magasins");
		menuGestionMagasinFrame.setBackground(Color.WHITE);
		menuGestionMagasinFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		menuGestionMagasinFrame.getContentPane().setForeground(Color.BLACK);
		menuGestionMagasinFrame.getContentPane().setBackground(Color.WHITE);
		menuGestionMagasinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuGestionMagasinFrame.setType(Type.POPUP);
		menuGestionMagasinFrame.setAutoRequestFocus(true);
		menuGestionMagasinFrame.setUndecorated(false);
		menuGestionMagasinFrame.setEnabled(true);
		menuGestionMagasinFrame.getContentPane().setLayout(null);
		menuGestionMagasinFrame.setVisible(true);
		screenSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
		menuGestionMagasinFrame.setSize(1000, screenSizeDimension.height);
		menuGestionMagasinFrame.setResizable(true);
		menuGestionMagasinFrame.setLocationRelativeTo(null);
		menuGestionMagasinFrame.setMinimumSize(new Dimension(1000, screenSizeDimension.height));
		
		generalFrameScrollPane = new JScrollPane();
		generalFrameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		generalFrameScrollPane.setBounds(0, 0, 985, 700);
		
		generalFramePanel = new JPanel();
		generalFrameScrollPane.setViewportView(generalFramePanel);
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setPreferredSize(new Dimension(1000, screenSizeDimension.height*2));
		generalFramePanel.setSize(1000, screenSizeDimension.height);
		generalFramePanel.setBorder(null);
		generalFramePanel.setLayout(null);
		
		menuGestionMagasinFrame.getContentPane().add(generalFrameScrollPane);
		menuGestionMagasinFrame.setVisible(true);
		menuGestionMagasinFrame.requestFocusInWindow();
		
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
		
		titreInterfaceLabel = new JLabel("GESTION DES MAGASINS");
		titreInterfaceLabel.setBounds(0, 0, 964, 86);
		bodyPanel.add(titreInterfaceLabel);
		titreInterfaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreInterfaceLabel.setForeground(Color.BLACK);
		titreInterfaceLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		titreInterfaceLabel.setBackground(Color.WHITE);
		titreInterfaceLabel.setBorder(null);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setBounds(408, 57, 153, 8);
		activeLigneLabel.setOpaque(true);
		bodyPanel.add(activeLigneLabel);
		
		informationsDesGestionsPanel = new JPanel();
		informationsDesGestionsPanel.setBackground(Color.WHITE);
		informationsDesGestionsPanel.setBounds(172, 76, 638, 86);
		bodyPanel.add(informationsDesGestionsPanel);
		informationsDesGestionsPanel.setLayout(null);
		
		nombreProduitPanel = new JPanel();
		nombreProduitPanel.setBackground(Color.WHITE);
		nombreProduitPanel.setBounds(10, 11, 239, 68);
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
		
		nombreMagasinPanel = new JPanel();
		nombreMagasinPanel.setBackground(Color.WHITE);
		nombreMagasinPanel.setBounds(388, 11, 239, 68);
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
		
		creerMagasinNonVidePanel = new JPanel();
		creerMagasinNonVidePanel.setBackground(new Color(204, 255, 255));
		creerMagasinNonVidePanel.setBounds(21, 190, 294, 248);
		bodyPanel.add(creerMagasinNonVidePanel);
		creerMagasinNonVidePanel.setLayout(null);
		
		imageCreerMagasinNonVideLabel = new JLabel("");
		imageCreerMagasinNonVideLabel.setBackground(Color.WHITE);
		imageCreerMagasinNonVideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCreerMagasinNonVideLabel.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/creerMagasin.png")));
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
				menuGestionMagasinFrame.dispose();
				new creerMagasinNonVide();
			}
		});
		
		comparerMagasinMethode1Panel = new JPanel();
		comparerMagasinMethode1Panel.setBackground(new Color(204, 255, 255));
		comparerMagasinMethode1Panel.setBounds(335, 190, 294, 248);
		bodyPanel.add(comparerMagasinMethode1Panel);
		comparerMagasinMethode1Panel.setLayout(null);
		
		imageComparerMagasinMethode1Label = new JLabel("");
		imageComparerMagasinMethode1Label.setBackground(Color.WHITE);
		imageComparerMagasinMethode1Label.setHorizontalAlignment(SwingConstants.CENTER);
		imageComparerMagasinMethode1Label.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/comparerMagasin.png")));
		imageComparerMagasinMethode1Label.setBounds(0, 0, 294, 200);
		comparerMagasinMethode1Panel.add(imageComparerMagasinMethode1Label);
		
		titreComparerMagasinMethode1Button = new JButton("COMPARER DES PRODUITS : PREMIERE METHODE");
		titreComparerMagasinMethode1Button.setFont(new Font("Dialog", Font.BOLD, 12));
		titreComparerMagasinMethode1Button.setFocusable(false);
		titreComparerMagasinMethode1Button.setEnabled(true);
		titreComparerMagasinMethode1Button.setContentAreaFilled(true);
		titreComparerMagasinMethode1Button.setBorder(null);
		titreComparerMagasinMethode1Button.setBounds(0, 197, 294, 51);
		comparerMagasinMethode1Panel.add(titreComparerMagasinMethode1Button);
		titreComparerMagasinMethode1Button.setForeground(Color.WHITE);
		titreComparerMagasinMethode1Button.setHorizontalAlignment(SwingConstants.CENTER);
		titreComparerMagasinMethode1Button.setBackground(new Color(41, 178, 73));
		titreComparerMagasinMethode1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreComparerMagasinMethode1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new comparerLesProduits1();
			}
		});
		
		comparerMagasinMethode2Panel = new JPanel();
		comparerMagasinMethode2Panel.setBackground(new Color(204, 255, 255));
		comparerMagasinMethode2Panel.setBounds(649, 190, 294, 248);
		bodyPanel.add(comparerMagasinMethode2Panel);
		comparerMagasinMethode2Panel.setLayout(null);
		
		imageComparerMagasinMethode2Label = new JLabel("");
		imageComparerMagasinMethode2Label.setBackground(Color.WHITE);
		imageComparerMagasinMethode2Label.setHorizontalAlignment(SwingConstants.CENTER);
		imageComparerMagasinMethode2Label.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/comparerMagasin.png")));
		imageComparerMagasinMethode2Label.setBounds(0, 0, 294, 200);
		comparerMagasinMethode2Panel.add(imageComparerMagasinMethode2Label);
		
		titreComparerMagasinMethode2Button = new JButton("COMPARER DES PRODUITS : DEUXIEME METHODE");
		titreComparerMagasinMethode2Button.setFont(new Font("Dialog", Font.BOLD, 12));
		titreComparerMagasinMethode2Button.setFocusable(false);
		titreComparerMagasinMethode2Button.setEnabled(true);
		titreComparerMagasinMethode2Button.setContentAreaFilled(true);
		titreComparerMagasinMethode2Button.setBorder(null);
		titreComparerMagasinMethode2Button.setBounds(0, 197, 294, 51);
		comparerMagasinMethode2Panel.add(titreComparerMagasinMethode2Button);
		titreComparerMagasinMethode2Button.setForeground(Color.WHITE);
		titreComparerMagasinMethode2Button.setHorizontalAlignment(SwingConstants.CENTER);
		titreComparerMagasinMethode2Button.setBackground(new Color(41, 178, 73));
		titreComparerMagasinMethode2Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreComparerMagasinMethode2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new comparerLesProduits2();
			}
		});
		
		seperateurDesBlocsLabel = new JLabel("");
		seperateurDesBlocsLabel.setOpaque(true);
		seperateurDesBlocsLabel.setForeground(Color.LIGHT_GRAY);
		seperateurDesBlocsLabel.setBackground(Color.LIGHT_GRAY);
		seperateurDesBlocsLabel.setBounds(335, 460, 299, 2);
		bodyPanel.add(seperateurDesBlocsLabel);
		
		afficherMagasinPanel = new JPanel();
		afficherMagasinPanel.setLayout(null);
		afficherMagasinPanel.setBackground(new Color(204, 255, 255));
		afficherMagasinPanel.setBounds(21, 490, 294, 248);
		bodyPanel.add(afficherMagasinPanel);
		
		imageAfficherMagasinLabel = new JLabel("");
		imageAfficherMagasinLabel.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/afficherLesProduits.png")));
		imageAfficherMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageAfficherMagasinLabel.setBackground(Color.WHITE);
		imageAfficherMagasinLabel.setBounds(0, 0, 294, 200);
		afficherMagasinPanel.add(imageAfficherMagasinLabel);
		
		titreAfficherMagasinButton = new JButton("AFFICHER LES MAGASINS");
		titreAfficherMagasinButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreAfficherMagasinButton.setForeground(Color.WHITE);
		titreAfficherMagasinButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreAfficherMagasinButton.setFocusable(false);
		titreAfficherMagasinButton.setEnabled(true);
		titreAfficherMagasinButton.setContentAreaFilled(true);
		titreAfficherMagasinButton.setBorder(null);
		titreAfficherMagasinButton.setBackground(new Color(41, 178, 73));
		titreAfficherMagasinButton.setBounds(0, 197, 294, 51);
		titreAfficherMagasinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		afficherMagasinPanel.add(titreAfficherMagasinButton);
		titreAfficherMagasinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new afficherListeDesMagasins();
			}
		});
		
		chercherProduitDansMagasinPanel = new JPanel();
		chercherProduitDansMagasinPanel.setLayout(null);
		chercherProduitDansMagasinPanel.setBackground(new Color(204, 255, 255));
		chercherProduitDansMagasinPanel.setBounds(335, 490, 294, 248);
		bodyPanel.add(chercherProduitDansMagasinPanel);
		
		imageChercherProduitDansMagasinLabel = new JLabel("");
		imageChercherProduitDansMagasinLabel.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/chercherProduit.png")));
		imageChercherProduitDansMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageChercherProduitDansMagasinLabel.setBackground(Color.WHITE);
		imageChercherProduitDansMagasinLabel.setBounds(0, 0, 294, 200);
		chercherProduitDansMagasinPanel.add(imageChercherProduitDansMagasinLabel);
		
		titreChercherProduitDansMagasinButton = new JButton("CHERCHER UN PRODUIT DANS UN MAGASIN");
		titreChercherProduitDansMagasinButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreChercherProduitDansMagasinButton.setForeground(Color.WHITE);
		titreChercherProduitDansMagasinButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreChercherProduitDansMagasinButton.setFocusable(false);
		titreChercherProduitDansMagasinButton.setEnabled(true);
		titreChercherProduitDansMagasinButton.setContentAreaFilled(true);
		titreChercherProduitDansMagasinButton.setBorder(null);
		titreChercherProduitDansMagasinButton.setBackground(new Color(41, 178, 73));
		titreChercherProduitDansMagasinButton.setBounds(0, 197, 294, 51);
		titreChercherProduitDansMagasinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		chercherProduitDansMagasinPanel.add(titreChercherProduitDansMagasinButton);
		titreChercherProduitDansMagasinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new rechercherProduitDansMagasin();
			}
		});
		
		supprimerProduitPanel = new JPanel();
		supprimerProduitPanel.setLayout(null);
		supprimerProduitPanel.setBackground(new Color(204, 255, 255));
		supprimerProduitPanel.setBounds(649, 490, 294, 248);
		bodyPanel.add(supprimerProduitPanel);
		
		imageSupprimerProduitLabel = new JLabel("");
		imageSupprimerProduitLabel.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/supprimerProduit.png")));
		imageSupprimerProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageSupprimerProduitLabel.setBackground(Color.WHITE);
		imageSupprimerProduitLabel.setBounds(0, 0, 294, 200);
		supprimerProduitPanel.add(imageSupprimerProduitLabel);
		
		titreSupprimerProduitButton = new JButton("SUPPRIMER UN PRODUIT DE MAGASIN");
		titreSupprimerProduitButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreSupprimerProduitButton.setForeground(Color.WHITE);
		titreSupprimerProduitButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreSupprimerProduitButton.setFocusable(false);
		titreSupprimerProduitButton.setEnabled(true);
		titreSupprimerProduitButton.setContentAreaFilled(true);
		titreSupprimerProduitButton.setBorder(null);
		titreSupprimerProduitButton.setBackground(new Color(41, 178, 73));
		titreSupprimerProduitButton.setBounds(0, 197, 294, 51);
		titreSupprimerProduitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		supprimerProduitPanel.add(titreSupprimerProduitButton);
		titreSupprimerProduitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new supprimerProduitDeMagasin();
			}
		});
		
		seperateurDesBlocs2Label = new JLabel("");
		seperateurDesBlocs2Label.setOpaque(true);
		seperateurDesBlocs2Label.setForeground(Color.LIGHT_GRAY);
		seperateurDesBlocs2Label.setBackground(Color.LIGHT_GRAY);
		seperateurDesBlocs2Label.setBounds(335, 760, 299, 2);
		bodyPanel.add(seperateurDesBlocs2Label);
		
		maxCapaciteDeuxMagasinPanel = new JPanel();
		maxCapaciteDeuxMagasinPanel.setLayout(null);
		maxCapaciteDeuxMagasinPanel.setBackground(new Color(204, 255, 255));
		maxCapaciteDeuxMagasinPanel.setBounds(335, 790, 294, 248);
		bodyPanel.add(maxCapaciteDeuxMagasinPanel);
		
		imageMaxCapaciteDeuxMagasinLabel = new JLabel("");
		imageMaxCapaciteDeuxMagasinLabel.setIcon(new ImageIcon(menuGestionMagasin.class.getResource("/images/comparerCapaciteMagasin.png")));
		imageMaxCapaciteDeuxMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageMaxCapaciteDeuxMagasinLabel.setBackground(Color.WHITE);
		imageMaxCapaciteDeuxMagasinLabel.setBounds(0, 0, 294, 200);
		maxCapaciteDeuxMagasinPanel.add(imageMaxCapaciteDeuxMagasinLabel);
		
		titreMaxCapaciteDeuxMagasinButton = new JButton("COMPARER DEUX MAGASINS");
		titreMaxCapaciteDeuxMagasinButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreMaxCapaciteDeuxMagasinButton.setForeground(Color.WHITE);
		titreMaxCapaciteDeuxMagasinButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreMaxCapaciteDeuxMagasinButton.setFocusable(false);
		titreMaxCapaciteDeuxMagasinButton.setEnabled(true);
		titreMaxCapaciteDeuxMagasinButton.setContentAreaFilled(true);
		titreMaxCapaciteDeuxMagasinButton.setBorder(null);
		titreMaxCapaciteDeuxMagasinButton.setBackground(new Color(41, 178, 73));
		titreMaxCapaciteDeuxMagasinButton.setBounds(0, 197, 294, 51);
		titreMaxCapaciteDeuxMagasinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		maxCapaciteDeuxMagasinPanel.add(titreMaxCapaciteDeuxMagasinButton);
		titreMaxCapaciteDeuxMagasinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new comparerLesMagasins();
			}
		});
		
		continuerButton = new JButton("CONTINUER");
		continuerButton.setForeground(Color.WHITE);
		continuerButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		continuerButton.setFocusable(false);
		continuerButton.setEnabled(true);
		continuerButton.setContentAreaFilled(true);
		continuerButton.setBorder(null);
		continuerButton.setBackground(new Color(41, 178, 73));
		continuerButton.setBounds(335, 1080, 294, 51);
		continuerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bodyPanel.add(continuerButton);
		continuerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionMagasinFrame.dispose();
				new menuGestionAvances();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(menuGestionMagasinFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	menuGestionMagasinFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirLabelParNombreDesProduits() {
		chiffreNbrProduitLabel.setText(String.valueOf(menuGestionProduit.getListeDesProduits().size()));
	}
	
	public void remplirLabelParNombreDesMgasins() {
		chiffreNbrMagasinLabel.setText(String.valueOf(listeDesMagasins.size()));
	}
	
	public static List<Magasin> getListeDesMagasins() {
		return listeDesMagasins;
	}
}
