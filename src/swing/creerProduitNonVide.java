package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
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
import javax.swing.SwingConstants;
import javax.swing.Timer;
import tn.XXX.gestionmagasin.ProduitAlimentaire;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class creerProduitNonVide {

	private JFrame creerProduitNonVideFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formCreerProduitNonVidePanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, activeLigneLabel, identifiantCreerProduitLabel, erreurIdentifiantCreerProduitLabel,
				   libelleCreerProduitLabel, erreurLibelleCreerProduitLabel, marqueCreerProduitLabel, erreurMarqueCreerProduitLabel, prixCreerProduitLabel, erreurPrixCreerProduitLabel, bgImagelabel,
				   nbrProduitNonVideCreerLabel;
	private JButton menuButton, creerProduitsNonVideButton;
	private JTextField identifiantCreerProduitTextField, libelleCreerProduitTextField, marqueCreerProduitTextField, prixCreerProduitTextField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerProduitNonVide window = new creerProduitNonVide();
					window.creerProduitNonVideFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public creerProduitNonVide() {
		initialize();
	}

	private void initialize() {
		creerProduitNonVideFrame = new JFrame("Créer un produit alimentaire non vide");
		creerProduitNonVideFrame.setBackground(Color.WHITE);
		creerProduitNonVideFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		creerProduitNonVideFrame.getContentPane().setForeground(Color.BLACK);
		creerProduitNonVideFrame.getContentPane().setBackground(Color.WHITE);
		creerProduitNonVideFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		creerProduitNonVideFrame.setType(Type.POPUP);
		creerProduitNonVideFrame.setAutoRequestFocus(true);
		creerProduitNonVideFrame.setUndecorated(false);
		creerProduitNonVideFrame.setEnabled(true);
		creerProduitNonVideFrame.getContentPane().setLayout(null);
		creerProduitNonVideFrame.setVisible(true);
		creerProduitNonVideFrame.setSize(1000, 800);
		creerProduitNonVideFrame.setResizable(true);
		creerProduitNonVideFrame.setLocationRelativeTo(null);
		creerProduitNonVideFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		creerProduitNonVideFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		creerProduitNonVideFrame.requestFocusInWindow();
		
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
		bodyPanel.setBounds(0, 158, 984, 591);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		nbrProduitNonVideCreerLabel = new JLabel("");
		nbrProduitNonVideCreerLabel.setBounds(405, 62, 294, 34);
		nbrProduitNonVideCreerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitNonVideCreerLabel.setForeground(new Color(41, 178, 73));
		nbrProduitNonVideCreerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrProduitNonVideCreerLabel.setBackground(Color.WHITE);
		entetePanel.add(nbrProduitNonVideCreerLabel);
		
		menuButton = new JButton("CREATION DES PRODUITS NON VIDES");
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
		activeLigneLabel.setBounds(415, 125, 238, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBackground(Color.WHITE);
		backgroundImagePanel.setBounds(10, 11, 430, 559);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setVerticalAlignment(SwingConstants.TOP);
		bgImagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgImagelabel.setIcon(new ImageIcon(creerProduitNonVide.class.getResource("/images/creerProduitVideBackground.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 595);
		backgroundImagePanel.add(bgImagelabel);
		
		formCreerProduitNonVidePanel = new JPanel();
		formCreerProduitNonVidePanel.setBackground(Color.WHITE);
		formCreerProduitNonVidePanel.setBounds(474, 1, 503, 569);
		bodyPanel.add(formCreerProduitNonVidePanel);
		formCreerProduitNonVidePanel.setLayout(null);
		
		identifiantCreerProduitLabel = new JLabel("IDENTIFIANT");
		identifiantCreerProduitLabel.setForeground(new Color(0, 0, 51));
		identifiantCreerProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiantCreerProduitLabel.setBackground(Color.WHITE);
		identifiantCreerProduitLabel.setBounds(131, 0, 283, 41);
		formCreerProduitNonVidePanel.add(identifiantCreerProduitLabel);
		
		identifiantCreerProduitTextField = new JTextField();
		identifiantCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiantCreerProduitTextField.setEditable(true);
		identifiantCreerProduitTextField.setEnabled(true);
		identifiantCreerProduitTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiantCreerProduitTextField.setBackground(Color.WHITE);
		identifiantCreerProduitTextField.setBounds(131, 39, 283, 41);
		identifiantCreerProduitTextField.setForeground(new Color(102, 102, 102));
		identifiantCreerProduitTextField.setText("Identifiant de produit..");
		formCreerProduitNonVidePanel.add(identifiantCreerProduitTextField);
		identifiantCreerProduitTextField.setColumns(10);
		
		identifiantCreerProduitTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiantCreerProduitTextField, "Identifiant de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiantCreerProduitTextField, "Identifiant de produit..");		
			} 
		});
		
		identifiantCreerProduitTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiantCreerProduitTextField, erreurIdentifiantCreerProduitLabel, e);
			 }
		 });
		
		erreurIdentifiantCreerProduitLabel = new JLabel("");
		erreurIdentifiantCreerProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiantCreerProduitLabel.setForeground(new Color(204, 0, 0));
		erreurIdentifiantCreerProduitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiantCreerProduitLabel.setBackground(Color.WHITE);
		erreurIdentifiantCreerProduitLabel.setBounds(131, 81, 283, 36);
		formCreerProduitNonVidePanel.add(erreurIdentifiantCreerProduitLabel);
		
		libelleCreerProduitLabel = new JLabel("LIBELLE");
		libelleCreerProduitLabel.setForeground(new Color(0, 0, 51));
		libelleCreerProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		libelleCreerProduitLabel.setBackground(Color.WHITE);
		libelleCreerProduitLabel.setBounds(131, 117, 283, 41);
		formCreerProduitNonVidePanel.add(libelleCreerProduitLabel);
		
		libelleCreerProduitTextField = new JTextField();
		libelleCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelleCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelleCreerProduitTextField.setEditable(true);
		libelleCreerProduitTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		libelleCreerProduitTextField.setBackground(Color.WHITE);
		libelleCreerProduitTextField.setBounds(131, 159, 283, 41);
		libelleCreerProduitTextField.setForeground(new Color(102, 102, 102));
		libelleCreerProduitTextField.setText("Libellé de produit..");
		formCreerProduitNonVidePanel.add(libelleCreerProduitTextField);
		libelleCreerProduitTextField.setColumns(10);
		
		libelleCreerProduitTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(libelleCreerProduitTextField, "Libellé de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(libelleCreerProduitTextField, "Libellé de produit..");		
			} 
		});
		
		libelleCreerProduitTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurLibelleCreerProduitLabel.setText("");
			 }
		 });
		
		erreurLibelleCreerProduitLabel = new JLabel("");
		erreurLibelleCreerProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurLibelleCreerProduitLabel.setForeground(new Color(204, 0, 0));
		erreurLibelleCreerProduitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurLibelleCreerProduitLabel.setBackground(Color.WHITE);
		erreurLibelleCreerProduitLabel.setBounds(131, 201, 283, 36);
		formCreerProduitNonVidePanel.add(erreurLibelleCreerProduitLabel);
		
		marqueCreerProduitLabel = new JLabel("MARQUE");
		marqueCreerProduitLabel.setForeground(new Color(0, 0, 51));
		marqueCreerProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		marqueCreerProduitLabel.setBackground(Color.WHITE);
		marqueCreerProduitLabel.setBounds(131, 234, 283, 41);
		formCreerProduitNonVidePanel.add(marqueCreerProduitLabel);
		
		marqueCreerProduitTextField = new JTextField();
		marqueCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		marqueCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		marqueCreerProduitTextField.setEditable(true);
		marqueCreerProduitTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		marqueCreerProduitTextField.setBackground(Color.WHITE);
		marqueCreerProduitTextField.setBounds(131, 275, 283, 41);
		marqueCreerProduitTextField.setForeground(new Color(102, 102, 102));
		marqueCreerProduitTextField.setText("Marque de produit..");
		formCreerProduitNonVidePanel.add(marqueCreerProduitTextField);
		marqueCreerProduitTextField.setColumns(10);
		
		marqueCreerProduitTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(marqueCreerProduitTextField, "Marque de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(marqueCreerProduitTextField, "Marque de produit..");		
			} 
		});
		
		marqueCreerProduitTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurMarqueCreerProduitLabel.setText("");
			 }
		 });
		
		erreurMarqueCreerProduitLabel = new JLabel("");
		erreurMarqueCreerProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurMarqueCreerProduitLabel.setForeground(new Color(204, 0, 0));
		erreurMarqueCreerProduitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurMarqueCreerProduitLabel.setBackground(Color.WHITE);
		erreurMarqueCreerProduitLabel.setBounds(131, 316, 283, 36);
		formCreerProduitNonVidePanel.add(erreurMarqueCreerProduitLabel);
		
		prixCreerProduitLabel = new JLabel("PRIX");
		prixCreerProduitLabel.setForeground(new Color(0, 0, 51));
		prixCreerProduitLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		prixCreerProduitLabel.setBackground(Color.WHITE);
		prixCreerProduitLabel.setBounds(131, 351, 283, 41);
		formCreerProduitNonVidePanel.add(prixCreerProduitLabel);
		
		prixCreerProduitTextField = new JTextField();
		prixCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		prixCreerProduitTextField.setHorizontalAlignment(SwingConstants.CENTER);
		prixCreerProduitTextField.setEditable(true);
		prixCreerProduitTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		prixCreerProduitTextField.setBackground(Color.WHITE);
		prixCreerProduitTextField.setBounds(131, 392, 283, 41);
		prixCreerProduitTextField.setForeground(new Color(102, 102, 102));
		prixCreerProduitTextField.setText("Prix de produit..");
		formCreerProduitNonVidePanel.add(prixCreerProduitTextField);
		prixCreerProduitTextField.setColumns(10);
		
		prixCreerProduitTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(prixCreerProduitTextField, "Prix de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(prixCreerProduitTextField, "Prix de produit..");		
			} 
		});
		
		prixCreerProduitTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType2(prixCreerProduitTextField, erreurPrixCreerProduitLabel, e);
			 }
		 });
		
		erreurPrixCreerProduitLabel = new JLabel("");
		erreurPrixCreerProduitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurPrixCreerProduitLabel.setForeground(new Color(204, 0, 0));
		erreurPrixCreerProduitLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurPrixCreerProduitLabel.setBackground(Color.WHITE);
		erreurPrixCreerProduitLabel.setBounds(131, 432, 283, 36);
		formCreerProduitNonVidePanel.add(erreurPrixCreerProduitLabel);
		
		creerProduitsNonVideButton = new JButton("CREER DES PRODUITS NON VIDES");
		creerProduitsNonVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		creerProduitsNonVideButton.setFocusable(false);
		creerProduitsNonVideButton.setEnabled(true);
		creerProduitsNonVideButton.setContentAreaFilled(true);
		creerProduitsNonVideButton.setBorder(null);
		creerProduitsNonVideButton.setBounds(131, 479, 283, 51);
		formCreerProduitNonVidePanel.add(creerProduitsNonVideButton);
		creerProduitsNonVideButton.setForeground(Color.WHITE);
		creerProduitsNonVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		creerProduitsNonVideButton.setBackground(new Color(41, 178, 73));
		creerProduitsNonVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		creerProduitsNonVideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateFormCreerProduitNonVide();
				formCreerProduitNonVidePanel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(creerProduitNonVideFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerProduitNonVideFrame.dispose();
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
	
	public boolean validerMarque(String marque) {
		boolean test = false;
		
		if((marque.equals("")) || (marque.equals("Marque de produit.."))) {
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
	
	public void validateFormCreerProduitNonVide() {
		String identifiant = identifiantCreerProduitTextField.getText();
		String libelle = libelleCreerProduitTextField.getText();
		String marque = marqueCreerProduitTextField.getText();
		String prix = prixCreerProduitTextField.getText();
		
		if(validerIdentifiant(identifiant) == false) {
			erreurIdentifiantCreerProduitLabel.setText("L'identifiant de produit est obligatoire !");
		}
		
		else if(validerLibelle(libelle) == false) {
			erreurLibelleCreerProduitLabel.setText("La libellé de produit est obligatoire !");
		}
		
		else if(validerMarque(marque) == false) {
			erreurMarqueCreerProduitLabel.setText("La marque de produit est obligatoire !");
		}
		
		else if(validerPrix(prix) == false) {
			erreurPrixCreerProduitLabel.setText("Le prix de produit est obligatoire !");
		}
		
		else if((validerIdentifiant(identifiant) == true) && (validerLibelle(libelle) == true) && (validerMarque(marque) == true) && (validerPrix(prix) == true)){
			creerProduitAlimentaireNonVide(Integer.parseInt(identifiant), libelle, marque, Double.parseDouble(prix));
			nbrProduitNonVideCreerLabel.setText("+ " + ProduitAlimentaire.getNombreProduitNonVide() + " " + "produit(s) non vide(s) créé(s).");
			Timer t = new Timer(3000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	nbrProduitNonVideCreerLabel.setText(null);
	            }
	        });
	        t.setRepeats(false);
	        t.start();
	        
			identifiantCreerProduitTextField.setText("Identifiant de produit..");
			libelleCreerProduitTextField.setText("Libellé de produit..");
			marqueCreerProduitTextField.setText("Marque de produit..");
			prixCreerProduitTextField.setText("Prix de produit..");
			
			erreurIdentifiantCreerProduitLabel.setText("");
			erreurLibelleCreerProduitLabel.setText("");
			erreurMarqueCreerProduitLabel.setText("");
			erreurPrixCreerProduitLabel.setText("");
			
			formCreerProduitNonVidePanel.requestFocusInWindow();
			retourAuMenu();
		}
	}
	
	public void creerProduitAlimentaireNonVide(int identifiant, String libelle, String marque, double prix) {		
		ProduitAlimentaire produitAlimentaireNonVide = new ProduitAlimentaire(identifiant, libelle, marque, prix, null);
		menuGestionProduit.getListeDesProduits().add(produitAlimentaireNonVide);
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(creerProduitNonVideFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerProduitNonVideFrame.dispose();
			new menuGestionProduit();
	    }
	}
}
