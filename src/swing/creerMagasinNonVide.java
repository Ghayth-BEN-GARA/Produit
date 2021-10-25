package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import tn.XXX.gestionmagasin.Magasin;
import tn.XXX.gestionmagasin.ProduitAlimentaire;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class creerMagasinNonVide {

	private JFrame creerMagasinNonVideFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formCreerMagasinNonVidePanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, nbrMagasinNonVideCreerLabel, activeLigneLabel, bgImagelabel, identifiantCreerMagasinLabel, erreurIdentifiantCreerMagasinLabel,
				   adresseCreerMagasinLabel, erreurAdresseCreerMagasinLabel, capaciteCreerMagasinLabel, erreurCapaciteCreerMagasinLabel, produitCreerMagasinLabel, erreurProduitCreerMagasinLabel;
	private JButton menuButton, creerMagasinNonVideButton;
	private JTextField identifiantCreerMagasintTextField, adresseCreerMagasinTextField, capaciteCreerMagasinTextField;
	private JComboBox<ProduitAlimentaire> produitAlimentaireComboBox;
	private DefaultListCellRenderer centerDefaultListCellRenderer;
	
	private List<ProduitAlimentaire> listeDesProduitsAffecter;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerMagasinNonVide window = new creerMagasinNonVide();
					window.creerMagasinNonVideFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public creerMagasinNonVide() {
		initialize();
	}

	private void initialize() {
		creerMagasinNonVideFrame = new JFrame("Créer un magasin non vide");
		creerMagasinNonVideFrame.setBackground(Color.WHITE);
		creerMagasinNonVideFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		creerMagasinNonVideFrame.getContentPane().setForeground(Color.BLACK);
		creerMagasinNonVideFrame.getContentPane().setBackground(Color.WHITE);
		creerMagasinNonVideFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		creerMagasinNonVideFrame.setType(Type.POPUP);
		creerMagasinNonVideFrame.setAutoRequestFocus(true);
		creerMagasinNonVideFrame.setUndecorated(false);
		creerMagasinNonVideFrame.setEnabled(true);
		creerMagasinNonVideFrame.getContentPane().setLayout(null);
		creerMagasinNonVideFrame.setVisible(true);
		creerMagasinNonVideFrame.setSize(1000, 800);
		creerMagasinNonVideFrame.setResizable(true);
		creerMagasinNonVideFrame.setLocationRelativeTo(null);
		creerMagasinNonVideFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		creerMagasinNonVideFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		creerMagasinNonVideFrame.requestFocusInWindow();
		
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
		
		nbrMagasinNonVideCreerLabel = new JLabel("");
		nbrMagasinNonVideCreerLabel.setBounds(405, 62, 294, 34);
		nbrMagasinNonVideCreerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrMagasinNonVideCreerLabel.setForeground(new Color(41, 178, 73));
		nbrMagasinNonVideCreerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrMagasinNonVideCreerLabel.setBackground(Color.WHITE);
		entetePanel.add(nbrMagasinNonVideCreerLabel);
		
		menuButton = new JButton("CREATION DES MAGASINS NON VIDES");
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
		bgImagelabel.setIcon(new ImageIcon(creerMagasinNonVide.class.getResource("/images/creerMagasinNonVideBackground.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 595);
		backgroundImagePanel.add(bgImagelabel);
		
		formCreerMagasinNonVidePanel = new JPanel();
		formCreerMagasinNonVidePanel.setBackground(Color.WHITE);
		formCreerMagasinNonVidePanel.setBounds(474, 1, 503, 569);
		bodyPanel.add(formCreerMagasinNonVidePanel);
		formCreerMagasinNonVidePanel.setLayout(null);
		
		identifiantCreerMagasinLabel = new JLabel("IDENTIFIANT");
		identifiantCreerMagasinLabel.setForeground(new Color(0, 0, 51));
		identifiantCreerMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiantCreerMagasinLabel.setBackground(Color.WHITE);
		identifiantCreerMagasinLabel.setBounds(131, 0, 283, 41);
		formCreerMagasinNonVidePanel.add(identifiantCreerMagasinLabel);
		
		identifiantCreerMagasintTextField = new JTextField();
		identifiantCreerMagasintTextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiantCreerMagasintTextField.setEditable(true);
		identifiantCreerMagasintTextField.setEnabled(true);
		identifiantCreerMagasintTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiantCreerMagasintTextField.setBackground(Color.WHITE);
		identifiantCreerMagasintTextField.setBounds(131, 39, 283, 41);
		identifiantCreerMagasintTextField.setForeground(new Color(102, 102, 102));
		identifiantCreerMagasintTextField.setText("Identifiant de magasin..");
		formCreerMagasinNonVidePanel.add(identifiantCreerMagasintTextField);
		identifiantCreerMagasintTextField.setColumns(10);
		
		identifiantCreerMagasintTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiantCreerMagasintTextField, "Identifiant de magasin..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiantCreerMagasintTextField, "Identifiant de magasin..");		
			} 
		});
		
		identifiantCreerMagasintTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiantCreerMagasintTextField, erreurIdentifiantCreerMagasinLabel, e);
				 erreurProduitCreerMagasinLabel.setText("");
			 }
		 });
		
		erreurIdentifiantCreerMagasinLabel = new JLabel("");
		erreurIdentifiantCreerMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiantCreerMagasinLabel.setForeground(new Color(204, 0, 0));
		erreurIdentifiantCreerMagasinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiantCreerMagasinLabel.setBackground(Color.WHITE);
		erreurIdentifiantCreerMagasinLabel.setBounds(131, 81, 283, 36);
		formCreerMagasinNonVidePanel.add(erreurIdentifiantCreerMagasinLabel);
		
		adresseCreerMagasinLabel = new JLabel("ADRESSE");
		adresseCreerMagasinLabel.setForeground(new Color(0, 0, 51));
		adresseCreerMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		adresseCreerMagasinLabel.setBackground(Color.WHITE);
		adresseCreerMagasinLabel.setBounds(131, 117, 283, 41);
		formCreerMagasinNonVidePanel.add(adresseCreerMagasinLabel);
		
		adresseCreerMagasinTextField = new JTextField();
		adresseCreerMagasinTextField.setHorizontalAlignment(SwingConstants.CENTER);
		adresseCreerMagasinTextField.setHorizontalAlignment(SwingConstants.CENTER);
		adresseCreerMagasinTextField.setEditable(true);
		adresseCreerMagasinTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		adresseCreerMagasinTextField.setBackground(Color.WHITE);
		adresseCreerMagasinTextField.setBounds(131, 159, 283, 41);
		adresseCreerMagasinTextField.setForeground(new Color(102, 102, 102));
		adresseCreerMagasinTextField.setText("Adresse de magasin..");
		formCreerMagasinNonVidePanel.add(adresseCreerMagasinTextField);
		adresseCreerMagasinTextField.setColumns(10);
		
		adresseCreerMagasinTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(adresseCreerMagasinTextField, "Adresse de magasin..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(adresseCreerMagasinTextField, "Adresse de magasin..");		
			} 
		});
		
		adresseCreerMagasinTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurAdresseCreerMagasinLabel.setText("");
			 }
		 });
		
		erreurAdresseCreerMagasinLabel = new JLabel("");
		erreurAdresseCreerMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurAdresseCreerMagasinLabel.setForeground(new Color(204, 0, 0));
		erreurAdresseCreerMagasinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurAdresseCreerMagasinLabel.setBackground(Color.WHITE);
		erreurAdresseCreerMagasinLabel.setBounds(131, 201, 283, 36);
		formCreerMagasinNonVidePanel.add(erreurAdresseCreerMagasinLabel);
		
		capaciteCreerMagasinLabel = new JLabel("CAPACITE");
		capaciteCreerMagasinLabel.setForeground(new Color(0, 0, 51));
		capaciteCreerMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		capaciteCreerMagasinLabel.setBackground(Color.WHITE);
		capaciteCreerMagasinLabel.setBounds(131, 234, 283, 41);
		formCreerMagasinNonVidePanel.add(capaciteCreerMagasinLabel);
		
		capaciteCreerMagasinTextField = new JTextField();
		capaciteCreerMagasinTextField.setHorizontalAlignment(SwingConstants.CENTER);
		capaciteCreerMagasinTextField.setEditable(true);
		capaciteCreerMagasinTextField.setEnabled(true);
		capaciteCreerMagasinTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		capaciteCreerMagasinTextField.setBackground(Color.WHITE);
		capaciteCreerMagasinTextField.setBounds(131, 275, 283, 41);
		capaciteCreerMagasinTextField.setForeground(new Color(102, 102, 102));
		capaciteCreerMagasinTextField.setText("Capacité de magasin..");
		formCreerMagasinNonVidePanel.add(capaciteCreerMagasinTextField);
		capaciteCreerMagasinTextField.setColumns(10);
		
		capaciteCreerMagasinTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(capaciteCreerMagasinTextField, "Capacité de magasin..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(capaciteCreerMagasinTextField, "Capacité de magasin..");		
			} 
		});
		
		capaciteCreerMagasinTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(capaciteCreerMagasinTextField, erreurCapaciteCreerMagasinLabel, e);
			 }
		 });
		
		erreurCapaciteCreerMagasinLabel = new JLabel("");
		erreurCapaciteCreerMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurCapaciteCreerMagasinLabel.setForeground(new Color(204, 0, 0));
		erreurCapaciteCreerMagasinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurCapaciteCreerMagasinLabel.setBackground(Color.WHITE);
		erreurCapaciteCreerMagasinLabel.setBounds(131, 316, 283, 36);
		formCreerMagasinNonVidePanel.add(erreurCapaciteCreerMagasinLabel);
		
		produitCreerMagasinLabel = new JLabel("PRODUIT");
		produitCreerMagasinLabel.setForeground(new Color(0, 0, 51));
		produitCreerMagasinLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		produitCreerMagasinLabel.setBackground(Color.WHITE);
		produitCreerMagasinLabel.setBounds(131, 351, 283, 41);
		formCreerMagasinNonVidePanel.add(produitCreerMagasinLabel);
		
		produitAlimentaireComboBox = new JComboBox<ProduitAlimentaire>();
		centerDefaultListCellRenderer = new DefaultListCellRenderer();
		centerDefaultListCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		produitAlimentaireComboBox.setRenderer(centerDefaultListCellRenderer);
		produitAlimentaireComboBox.setEditable(false);
		produitAlimentaireComboBox.setEnabled(true);
		produitAlimentaireComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		produitAlimentaireComboBox.setBackground(Color.WHITE);
		produitAlimentaireComboBox.setBounds(131, 392, 283, 41);
		produitAlimentaireComboBox.setForeground(new Color(102, 102, 102));
		formCreerMagasinNonVidePanel.add(produitAlimentaireComboBox);
		produitAlimentaireComboBox.setMaximumRowCount(20);
		produitAlimentaireComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		produitAlimentaireComboBox.setUI(new BasicComboBoxUI() {
		    protected JButton createArrowButton() {
		        return new JButton() {
					private static final long serialVersionUID = 1L;
					
					public int getWidth() {
		                return 0;
		            }
		        };
		    }
		    @Override
            public void paintCurrentValueBackground(final Graphics g, final Rectangle bounds, final boolean hasFocus){
                final Color t = g.getColor();
                
                if (this.comboBox.isEnabled()) {
                	 g.setColor(Color.WHITE);
                }
                   
                else {
                	g.setColor(Color.WHITE);
                }
                    
                g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
                g.setColor(t);
            }
		});
		remplirComboParListeDesProduits();
		
		erreurProduitCreerMagasinLabel = new JLabel("");
		erreurProduitCreerMagasinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurProduitCreerMagasinLabel.setForeground(new Color(204, 0, 0));
		erreurProduitCreerMagasinLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurProduitCreerMagasinLabel.setBackground(Color.WHITE);
		erreurProduitCreerMagasinLabel.setBounds(131, 432, 283, 36);
		formCreerMagasinNonVidePanel.add(erreurProduitCreerMagasinLabel);
		
		creerMagasinNonVideButton = new JButton("CREER DES MAGASINS NON VIDES");
		creerMagasinNonVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		creerMagasinNonVideButton.setFocusable(false);
		creerMagasinNonVideButton.setEnabled(true);
		creerMagasinNonVideButton.setContentAreaFilled(true);
		creerMagasinNonVideButton.setBorder(null);
		creerMagasinNonVideButton.setBounds(131, 479, 283, 51);
		formCreerMagasinNonVidePanel.add(creerMagasinNonVideButton);
		creerMagasinNonVideButton.setForeground(Color.WHITE);
		creerMagasinNonVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		creerMagasinNonVideButton.setBackground(new Color(41, 178, 73));
		creerMagasinNonVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		creerMagasinNonVideButton.addActionListener(new ActionListener() {
			int countpr = 0;
			public void actionPerformed(ActionEvent arg0) {
				if(creerMagasinNonVideButton.getText().equals("CREER DES MAGASINS NON VIDES")) {
					validateFormCreerMagasin();
				}
				
				else if(creerMagasinNonVideButton.getText().equals("AFFECTER LE PRODUIT A MAGASIN")) {
					if(arg0.getActionCommand().equals("AFFECTER LE PRODUIT A MAGASIN")) {
						ajouterProduitDansListeDesProduitsAffecter();
						countpr++;
						nbrMagasinNonVideCreerLabel.setText("+ " + countpr + " " + "produit(s) affecté(s) à magasin.");
						Timer t = new Timer(3000, new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				            	erreurProduitCreerMagasinLabel.setText(null);
				            }
				        });
				        t.setRepeats(false);
				        t.start();
				        if(countpr == Integer.parseInt(capaciteCreerMagasinTextField.getText())) {
				        	affecterListeDesProduitsAMagasin();
				        	erreurProduitCreerMagasinLabel.setText("La magasin est saturé");
				        	creerMagasinNonVideButton.setText("CREER DES MAGASINS NON VIDES");
				        	identifiantCreerMagasintTextField.setEnabled(true);
				        	adresseCreerMagasinTextField.setEnabled(true);
				        	capaciteCreerMagasinTextField.setEnabled(true);
				        	identifiantCreerMagasintTextField.setText("Identifiant de magasin..");
				        	adresseCreerMagasinTextField.setText("Adresse de magasin..");
				        	capaciteCreerMagasinTextField.setText("Capacité de magasin..");
				        	countpr = 0;
				        	retourAuMenu();
				        }
					}     
				}
				
				formCreerMagasinNonVidePanel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(creerMagasinNonVideFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerMagasinNonVideFrame.dispose();
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
	
	public void remplirComboParListeDesProduits() {
		for(ProduitAlimentaire listePr : menuGestionProduit.getListeDesProduits()) {
			produitAlimentaireComboBox.addItem(listePr);
		}
	}
	
	public boolean validerIdentifiant(String identifiant) {
		boolean test = false;
		
		if((identifiant.equals("")) || (identifiant.equals("Identifiant de magasin.."))) {
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
	
	public boolean validerAdresse(String adresse) {
		boolean test = false;
		
		if((adresse.equals("")) || (adresse.equals("Adresse de magasin.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerCapacite(String capacite) {
		boolean test = false;
		
		if((capacite.equals("")) || (capacite.equals("Capacité de magasin.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerCapaciteNull(String capacite) {
		boolean test = false;
		
		if((Integer.parseInt(capacite) == 0)) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public boolean validerLimiteCapacite(String capacite) {
		boolean test = false;
		
		if((Integer.parseInt(capacite) < 0) || (Integer.parseInt(capacite) > 50)) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public void validateFormCreerMagasin() {
		String identifiant = identifiantCreerMagasintTextField.getText();
		String adresse = adresseCreerMagasinTextField.getText();
		String capacite = capaciteCreerMagasinTextField.getText();
		
		if(validerIdentifiant(identifiant) == false) {
			erreurIdentifiantCreerMagasinLabel.setText("L'identifiant de magasin est obligatoire !");
		}
		
		else if(validerIdentifiantNull(identifiant) == false) {
			erreurIdentifiantCreerMagasinLabel.setText("L'identifiant de magasin est nul !");
		}
		
		else if(validerAdresse(adresse) == false) {
			erreurAdresseCreerMagasinLabel.setText("L'adresse de magasin est obligatoire !");
		}
		
		else if(validerCapacite(capacite) == false) {
			erreurCapaciteCreerMagasinLabel.setText("La capacité de magasin est obligatoire !");
		}
		
		else if(validerCapaciteNull(capacite) == false) {
			erreurCapaciteCreerMagasinLabel.setText("La capacité de magasin est null !");
		}
		
		else if(validerLimiteCapacite(capacite) == false) {
			erreurCapaciteCreerMagasinLabel.setText("La capacité de magasin est supérieur à 50 !");
		}
		
		else {
			listeDesProduitsAffecter = new ArrayList<>();
			creerMagasinAlimentaireNonVide(Integer.parseInt(identifiant), adresse, Integer.parseInt(capacite));
			nbrMagasinNonVideCreerLabel.setText("+ " + Magasin.getNombreMagasinNonVideCreer() + " " + "magasin(s) non vide(s) créé(s).");
			Timer t = new Timer(3000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	nbrMagasinNonVideCreerLabel.setText(null);
	            }
	        });
	        t.setRepeats(false);
	        t.start();
	        
			identifiantCreerMagasintTextField.setEnabled(false);
			adresseCreerMagasinTextField.setEnabled(false);
			capaciteCreerMagasinTextField.setEnabled(false);
			creerMagasinNonVideButton.setText("AFFECTER LE PRODUIT A MAGASIN");
		}
	}
	
	public void creerMagasinAlimentaireNonVide(int identifiant, String adresse, int capacite) {
		Magasin magasinNonVide = new Magasin(identifiant, adresse, capacite, null);
		menuGestionMagasin.getListeDesMagasins().add(magasinNonVide);
	}
	
	public void ajouterProduitDansListeDesProduitsAffecter() {
		listeDesProduitsAffecter.add((ProduitAlimentaire) produitAlimentaireComboBox.getSelectedItem());
	}
	
	public void affecterListeDesProduitsAMagasin() {
		for(Magasin listeM: menuGestionMagasin.getListeDesMagasins()) {
			if(listeM.getIdentifiantMagasin() == Integer.parseInt(identifiantCreerMagasintTextField.getText())){
				listeM.setEnsembleDesProduits(listeDesProduitsAffecter);
			}
		}
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(creerMagasinNonVideFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerMagasinNonVideFrame.dispose();
			new menuGestionMagasin();
	    }
	}

}
