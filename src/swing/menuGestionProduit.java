package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
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
import javax.swing.Timer;
import tn.XXX.gestionmagasin.ProduitAlimentaire;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuGestionProduit {

	private JFrame menuGestionProduitFrame;
	private Dimension screenSizeDimension;
	private JPanel generalFramePanel, entetePanel, bodyPanel, creerProduitVidePanel, creerProduitNonVidePanel, afficherLesProduits1Panel, attribuerPrixAuxProduitsLaitPanel, completerInformationsPanel, affecterDatesAuxProduitsPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, titreInterfaceLabel, nbrProduitVideCreerLabel, imageCreerProduitVideLabel, imageCreerProduitNonVideLabel, activeLigneLabel,
				   imageAfficherLesProduits1Label, seperateurDesBlocsLabel, nbrProduitLaitLabel, imageAttribuerPrixAuxProduitsLaitLabel, nbrProduitsCompleterLabel, imageCompleterInformationsLabel, nbrDatesAffecterAuxProduitsLabel,
				   imageAffecterDatesAuxProduitsLabel;
	private JScrollPane generalFrameScrollPane;
	private JButton titreCreerProduitVideButton, titreCreerProduitNonVideButton, titreAfficherLesProduits1Button, titreAttribuerPrixAuxProduitsLaitButton, titreCompleterInformationsButton, titreAffecterDatesAuxProduitsButton, continuerButton;

	private static List<ProduitAlimentaire> listeDesProduits = new ArrayList<ProduitAlimentaire>();	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuGestionProduit window = new menuGestionProduit();
					window.menuGestionProduitFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuGestionProduit() {
		initialize();
	}

	private void initialize() {
		menuGestionProduitFrame = new JFrame("Gestion des produits");
		menuGestionProduitFrame.setBackground(Color.WHITE);
		menuGestionProduitFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		menuGestionProduitFrame.getContentPane().setForeground(Color.BLACK);
		menuGestionProduitFrame.getContentPane().setBackground(Color.WHITE);
		menuGestionProduitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuGestionProduitFrame.setType(Type.POPUP);
		menuGestionProduitFrame.setAutoRequestFocus(true);
		menuGestionProduitFrame.setUndecorated(false);
		menuGestionProduitFrame.setEnabled(true);
		menuGestionProduitFrame.getContentPane().setLayout(null);
		menuGestionProduitFrame.setVisible(true);
		screenSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
		menuGestionProduitFrame.setSize(1000, screenSizeDimension.height);
		menuGestionProduitFrame.setResizable(true);
		menuGestionProduitFrame.setLocationRelativeTo(null);
		menuGestionProduitFrame.setMinimumSize(new Dimension(1000, screenSizeDimension.height));
		
		generalFrameScrollPane = new JScrollPane();
		generalFrameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		generalFrameScrollPane.setBounds(0, 0, 985, 800);
		
		generalFramePanel = new JPanel();
		generalFrameScrollPane.setViewportView(generalFramePanel);
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setPreferredSize(new Dimension(1000, screenSizeDimension.height*2));
		generalFramePanel.setSize(1000, screenSizeDimension.height);
		generalFramePanel.setBorder(null);
		generalFramePanel.setLayout(null);
		
		menuGestionProduitFrame.getContentPane().add(generalFrameScrollPane);
		menuGestionProduitFrame.setVisible(true);
		menuGestionProduitFrame.requestFocusInWindow();
		
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
		bodyPanel.setBounds(0, 196, 964, 1000);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		titreInterfaceLabel = new JLabel("GESTION DES PRODUITS");
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
		
		nbrProduitVideCreerLabel = new JLabel("");
		nbrProduitVideCreerLabel.setBounds(21, 80, 294, 34);
		nbrProduitVideCreerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitVideCreerLabel.setForeground(new Color(41, 178, 73));
		nbrProduitVideCreerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrProduitVideCreerLabel.setBackground(Color.WHITE);
		bodyPanel.add(nbrProduitVideCreerLabel);
		
		creerProduitVidePanel = new JPanel();
		creerProduitVidePanel.setBackground(new Color(204, 255, 255));
		creerProduitVidePanel.setBounds(21, 134, 294, 248);
		bodyPanel.add(creerProduitVidePanel);
		creerProduitVidePanel.setLayout(null);
		
		imageCreerProduitVideLabel = new JLabel("");
		imageCreerProduitVideLabel.setBackground(Color.WHITE);
		imageCreerProduitVideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCreerProduitVideLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/produitVide.png")));
		imageCreerProduitVideLabel.setBounds(0, 0, 294, 200);
		creerProduitVidePanel.add(imageCreerProduitVideLabel);
		
		titreCreerProduitVideButton = new JButton("CREER UN PRODUIT VIDE");
		titreCreerProduitVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreCreerProduitVideButton.setFocusable(false);
		titreCreerProduitVideButton.setEnabled(true);
		titreCreerProduitVideButton.setContentAreaFilled(true);
		titreCreerProduitVideButton.setBorder(null);
		titreCreerProduitVideButton.setBounds(0, 197, 294, 51);
		creerProduitVidePanel.add(titreCreerProduitVideButton);
		titreCreerProduitVideButton.setForeground(Color.WHITE);
		titreCreerProduitVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreCreerProduitVideButton.setBackground(new Color(41, 178, 73));
		titreCreerProduitVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreCreerProduitVideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creerProduitAlimentaireVide();
				nbrProduitVideCreerLabel.setText("+ " + ProduitAlimentaire.getNombreProduitVide() + " " + "produit(s) vide(s) créé(s).");
				Timer t = new Timer(3000, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                nbrProduitVideCreerLabel.setText(null);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
			}
		});
		
		creerProduitNonVidePanel = new JPanel();
		creerProduitNonVidePanel.setBackground(new Color(204, 255, 255));
		creerProduitNonVidePanel.setBounds(335, 134, 294, 248);
		bodyPanel.add(creerProduitNonVidePanel);
		creerProduitNonVidePanel.setLayout(null);
		
		imageCreerProduitNonVideLabel = new JLabel("");
		imageCreerProduitNonVideLabel.setBackground(Color.WHITE);
		imageCreerProduitNonVideLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCreerProduitNonVideLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/produitNonVide.png")));
		imageCreerProduitNonVideLabel.setBounds(0, 0, 294, 200);
		creerProduitNonVidePanel.add(imageCreerProduitNonVideLabel);
		
		titreCreerProduitNonVideButton = new JButton("CREER UN PRODUIT NON VIDE");
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
				menuGestionProduitFrame.dispose();
				new creerProduitNonVide();
			}
		});
		
		afficherLesProduits1Panel = new JPanel();
		afficherLesProduits1Panel.setBackground(new Color(204, 255, 255));
		afficherLesProduits1Panel.setBounds(649, 134, 294, 248);
		bodyPanel.add(afficherLesProduits1Panel);
		afficherLesProduits1Panel.setLayout(null);
		
		imageAfficherLesProduits1Label = new JLabel("");
		imageAfficherLesProduits1Label.setBackground(Color.WHITE);
		imageAfficherLesProduits1Label.setHorizontalAlignment(SwingConstants.CENTER);
		imageAfficherLesProduits1Label.setIcon(new ImageIcon(menuApplication.class.getResource("/images/afficherLesProduits.png")));
		imageAfficherLesProduits1Label.setBounds(0, 0, 294, 200);
		afficherLesProduits1Panel.add(imageAfficherLesProduits1Label);
		
		titreAfficherLesProduits1Button = new JButton("AFFICHER LES PRODUITS");
		titreAfficherLesProduits1Button.setFont(new Font("Dialog", Font.BOLD, 12));
		titreAfficherLesProduits1Button.setFocusable(false);
		titreAfficherLesProduits1Button.setEnabled(true);
		titreAfficherLesProduits1Button.setContentAreaFilled(true);
		titreAfficherLesProduits1Button.setBorder(null);
		titreAfficherLesProduits1Button.setBounds(0, 197, 294, 51);
		afficherLesProduits1Panel.add(titreAfficherLesProduits1Button);
		titreAfficherLesProduits1Button.setForeground(Color.WHITE);
		titreAfficherLesProduits1Button.setHorizontalAlignment(SwingConstants.CENTER);
		titreAfficherLesProduits1Button.setBackground(new Color(41, 178, 73));
		titreAfficherLesProduits1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreAfficherLesProduits1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuGestionProduitFrame.dispose();
				new afficherListeDesProduits();
			}
		});
		
		seperateurDesBlocsLabel = new JLabel("");
		seperateurDesBlocsLabel.setOpaque(true);
		seperateurDesBlocsLabel.setForeground(Color.LIGHT_GRAY);
		seperateurDesBlocsLabel.setBackground(Color.LIGHT_GRAY);
		seperateurDesBlocsLabel.setBounds(335, 408, 299, 2);
		bodyPanel.add(seperateurDesBlocsLabel);
		
		nbrProduitLaitLabel = new JLabel("");
		nbrProduitLaitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitLaitLabel.setForeground(new Color(41, 178, 73));
		nbrProduitLaitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrProduitLaitLabel.setBackground(Color.WHITE);
		nbrProduitLaitLabel.setBounds(21, 427, 294, 34);
		bodyPanel.add(nbrProduitLaitLabel);
		
		attribuerPrixAuxProduitsLaitPanel = new JPanel();
		attribuerPrixAuxProduitsLaitPanel.setBackground(new Color(204, 255, 255));
		attribuerPrixAuxProduitsLaitPanel.setBounds(21, 472, 294, 248);
		bodyPanel.add(attribuerPrixAuxProduitsLaitPanel);
		attribuerPrixAuxProduitsLaitPanel.setLayout(null);
		
		imageAttribuerPrixAuxProduitsLaitLabel = new JLabel("");
		imageAttribuerPrixAuxProduitsLaitLabel.setBackground(Color.WHITE);
		imageAttribuerPrixAuxProduitsLaitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageAttribuerPrixAuxProduitsLaitLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/prixDeLait.png")));
		imageAttribuerPrixAuxProduitsLaitLabel.setBounds(0, 0, 294, 200);
		attribuerPrixAuxProduitsLaitPanel.add(imageAttribuerPrixAuxProduitsLaitLabel);
		
		titreAttribuerPrixAuxProduitsLaitButton = new JButton("ATTRIBUER DES PRIX AUX PRODUITS DE LAIT");
		titreAttribuerPrixAuxProduitsLaitButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreAttribuerPrixAuxProduitsLaitButton.setFocusable(false);
		titreAttribuerPrixAuxProduitsLaitButton.setEnabled(true);
		titreAttribuerPrixAuxProduitsLaitButton.setContentAreaFilled(true);
		titreAttribuerPrixAuxProduitsLaitButton.setBorder(null);
		titreAttribuerPrixAuxProduitsLaitButton.setBounds(0, 197, 294, 51);
		attribuerPrixAuxProduitsLaitPanel.add(titreAttribuerPrixAuxProduitsLaitButton);
		titreAttribuerPrixAuxProduitsLaitButton.setForeground(Color.WHITE);
		titreAttribuerPrixAuxProduitsLaitButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreAttribuerPrixAuxProduitsLaitButton.setBackground(new Color(41, 178, 73));
		titreAttribuerPrixAuxProduitsLaitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreAttribuerPrixAuxProduitsLaitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attribuerDesPrixDeLaitAuxProduits();
				if(ProduitAlimentaire.getNombreProduitLait() > 0) {
					nbrProduitLaitLabel.setText("+ " + ProduitAlimentaire.getNombreProduitLait() + " " + "produit(s) de lait trouvé(s).");
					nbrProduitLaitLabel.setForeground(new Color(41, 178, 73));
					ProduitAlimentaire.setNombreProduitLait(0);
		    	}
		    	
		    	else {
		    		nbrProduitLaitLabel.setText("+ " + ProduitAlimentaire.getNombreProduitLait() + " " + "produit(s) de lait trouvé(s).");
		    		nbrProduitLaitLabel.setForeground(new Color(204, 0, 0));
		    	}
				Timer t = new Timer(3000, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	nbrProduitLaitLabel.setText(null);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
			}
		});
		
		
		
		nbrProduitsCompleterLabel = new JLabel("");
		nbrProduitsCompleterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitsCompleterLabel.setForeground(new Color(41, 178, 73));
		nbrProduitsCompleterLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrProduitsCompleterLabel.setBackground(Color.WHITE);
		nbrProduitsCompleterLabel.setBounds(335, 431, 294, 34);
		bodyPanel.add(nbrProduitsCompleterLabel);
		
		completerInformationsPanel = new JPanel();
		completerInformationsPanel.setBackground(new Color(204, 255, 255));
		completerInformationsPanel.setBounds(335, 474, 294, 248);
		bodyPanel.add(completerInformationsPanel);
		completerInformationsPanel.setLayout(null);
		
		imageCompleterInformationsLabel = new JLabel("");
		imageCompleterInformationsLabel.setBackground(Color.WHITE);
		imageCompleterInformationsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageCompleterInformationsLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/completerInformations.png")));
		imageCompleterInformationsLabel.setBounds(0, 0, 294, 200);
		completerInformationsPanel.add(imageCompleterInformationsLabel);
		
		titreCompleterInformationsButton = new JButton("COMPLETER LES INFORMATIONS DES PRODUITS");
		titreCompleterInformationsButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreCompleterInformationsButton.setFocusable(false);
		titreCompleterInformationsButton.setEnabled(true);
		titreCompleterInformationsButton.setContentAreaFilled(true);
		titreCompleterInformationsButton.setBorder(null);
		titreCompleterInformationsButton.setBounds(0, 197, 294, 51);
		completerInformationsPanel.add(titreCompleterInformationsButton);
		titreCompleterInformationsButton.setForeground(Color.WHITE);
		titreCompleterInformationsButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreCompleterInformationsButton.setBackground(new Color(41, 178, 73));
		titreCompleterInformationsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreCompleterInformationsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				completerLesInformationsManquantesDesProduitAlimentaires();
				if(ProduitAlimentaire.getNombreProduitCompleter() > 0) {
					nbrProduitsCompleterLabel.setText("+ " + ProduitAlimentaire.getNombreProduitCompleter() + " " + "produit(s) complété(s).");
					nbrProduitsCompleterLabel.setForeground(new Color(41, 178, 73));
		    	}
		    	
		    	else {
		    		nbrProduitsCompleterLabel.setText("+ " + ProduitAlimentaire.getNombreProduitCompleter() + " " + "produit(s) complété(s).");
		    		nbrProduitsCompleterLabel.setForeground(new Color(204, 0, 0));
		    	}
				Timer t = new Timer(3000, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	nbrProduitsCompleterLabel.setText(null);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
			}
		});
		
		nbrDatesAffecterAuxProduitsLabel = new JLabel("");
		nbrDatesAffecterAuxProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrDatesAffecterAuxProduitsLabel.setForeground(new Color(41, 178, 73));
		nbrDatesAffecterAuxProduitsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrDatesAffecterAuxProduitsLabel.setBackground(Color.WHITE);
		nbrDatesAffecterAuxProduitsLabel.setBounds(649, 431, 294, 34);
		bodyPanel.add(nbrDatesAffecterAuxProduitsLabel);
		
		affecterDatesAuxProduitsPanel = new JPanel();
		affecterDatesAuxProduitsPanel.setBackground(new Color(204, 255, 255));
		affecterDatesAuxProduitsPanel.setBounds(649, 474, 294, 248);
		bodyPanel.add(affecterDatesAuxProduitsPanel);
		affecterDatesAuxProduitsPanel.setLayout(null);
		
		imageAffecterDatesAuxProduitsLabel = new JLabel("");
		imageAffecterDatesAuxProduitsLabel.setBackground(Color.WHITE);
		imageAffecterDatesAuxProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageAffecterDatesAuxProduitsLabel.setIcon(new ImageIcon(menuApplication.class.getResource("/images/datesAffecter.png")));
		imageAffecterDatesAuxProduitsLabel.setBounds(0, 0, 294, 200);
		affecterDatesAuxProduitsPanel.add(imageAffecterDatesAuxProduitsLabel);
		
		titreAffecterDatesAuxProduitsButton = new JButton("AFFECTER DES DATES AUX PRODUITS");
		titreAffecterDatesAuxProduitsButton.setFont(new Font("Dialog", Font.BOLD, 12));
		titreAffecterDatesAuxProduitsButton.setFocusable(false);
		titreAffecterDatesAuxProduitsButton.setEnabled(true);
		titreAffecterDatesAuxProduitsButton.setContentAreaFilled(true);
		titreAffecterDatesAuxProduitsButton.setBorder(null);
		titreAffecterDatesAuxProduitsButton.setBounds(0, 197, 294, 51);
		affecterDatesAuxProduitsPanel.add(titreAffecterDatesAuxProduitsButton);
		titreAffecterDatesAuxProduitsButton.setForeground(Color.WHITE);
		titreAffecterDatesAuxProduitsButton.setHorizontalAlignment(SwingConstants.CENTER);
		titreAffecterDatesAuxProduitsButton.setBackground(new Color(41, 178, 73));
		titreAffecterDatesAuxProduitsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		titreAffecterDatesAuxProduitsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affecterDatesAuxProduitsAlimentaires();
				if(ProduitAlimentaire.getNombreDatesAffecter() > 0) {
					nbrDatesAffecterAuxProduitsLabel.setText("+ " + ProduitAlimentaire.getNombreDatesAffecter() + " " + "date(s) affecté(s) aux produit(s).");
					nbrDatesAffecterAuxProduitsLabel.setForeground(new Color(41, 178, 73));
					ProduitAlimentaire.setNombreDatesAffecter(0);
		    	}
		    	
		    	else {
		    		nbrDatesAffecterAuxProduitsLabel.setText("+ " + ProduitAlimentaire.getNombreDatesAffecter() + " " + "date(s) affecté(s) aux produit(s).");
		    		nbrDatesAffecterAuxProduitsLabel.setForeground(new Color(204, 0, 0));
		    	}
				Timer t = new Timer(3000, new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	nbrDatesAffecterAuxProduitsLabel.setText(null);
		            }
		        });
		        t.setRepeats(false);
		        t.start();
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
		continuerButton.setBounds(335, 752, 294, 51);
		continuerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bodyPanel.add(continuerButton);
		continuerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuGestionProduitFrame.dispose();
				new menuGestionMagasin();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(menuGestionProduitFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	menuGestionProduitFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void creerProduitAlimentaireVide() {
		ProduitAlimentaire produitAlimentaireVide = new ProduitAlimentaire();
		listeDesProduits.add(produitAlimentaireVide);
	}
	
	public void attribuerDesPrixDeLaitAuxProduits() {
		for(ProduitAlimentaire listePr : listeDesProduits) {
			listePr.attribuerPrixLait();
		}
	}
	
	public void completerLesInformationsManquantesDesProduitAlimentaires() {
		for(ProduitAlimentaire listePr : listeDesProduits) {
			listePr.completerInformationManquante();
		}
	}
	
	public void affecterDatesAuxProduitsAlimentaires() {
		for(ProduitAlimentaire listePr : listeDesProduits) {
			listePr.affecterDatesAuxProduits();
		}
	}
	
	public static List<ProduitAlimentaire> getListeDesProduits() {
		return listeDesProduits;
	}
}
