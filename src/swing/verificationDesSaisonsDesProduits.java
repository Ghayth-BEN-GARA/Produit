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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import tn.XXX.gestionmagasin.ProduitAgricole;
import tn.XXX.gestionmagasin.ProduitFruit;
import tn.XXX.gestionmagasin.ProduitLegume;

public class verificationDesSaisonsDesProduits {

	private JFrame verificationSaisonionFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, verifierSaisonPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, resultatVerifierSaissonLabel, activeLigneLabel, bgImagelabel, listeDesProduitsLabel, saisionPasserLabel;
	private JButton menuButton, verifierSaisonProduitButton;
	private JComboBox<ProduitAgricole> listeDesProduitsComboBox;
	private JComboBox<String> saisonPasserComboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verificationDesSaisonsDesProduits window = new verificationDesSaisonsDesProduits();
					window.verificationSaisonionFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public verificationDesSaisonsDesProduits() {
		initialize();
	}

	private void initialize() {
		verificationSaisonionFrame = new JFrame("Vérification des saisons des produits");
		verificationSaisonionFrame.setBackground(Color.WHITE);
		verificationSaisonionFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		verificationSaisonionFrame.getContentPane().setForeground(Color.BLACK);
		verificationSaisonionFrame.getContentPane().setBackground(Color.WHITE);
		verificationSaisonionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		verificationSaisonionFrame.setType(Type.POPUP);
		verificationSaisonionFrame.setAutoRequestFocus(true);
		verificationSaisonionFrame.setUndecorated(false);
		verificationSaisonionFrame.setEnabled(true);
		verificationSaisonionFrame.getContentPane().setLayout(null);
		verificationSaisonionFrame.setVisible(true);
		verificationSaisonionFrame.setSize(1000, 800);
		verificationSaisonionFrame.setResizable(true);
		verificationSaisonionFrame.setLocationRelativeTo(null);
		verificationSaisonionFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		verificationSaisonionFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		verificationSaisonionFrame.requestFocusInWindow();
		
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
		
		resultatVerifierSaissonLabel = new JLabel("");
		resultatVerifierSaissonLabel.setBounds(435, 62, 164, 34);
		resultatVerifierSaissonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultatVerifierSaissonLabel.setForeground(new Color(41, 178, 73));
		resultatVerifierSaissonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatVerifierSaissonLabel.setBackground(Color.WHITE);
		entetePanel.add(resultatVerifierSaissonLabel);
		
		menuButton = new JButton("VERIFIER LES SESSIONS DES PRODUITS");
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(348, 100, 369, 23);
		menuButton.setBorder(null);
		menuButton.setContentAreaFilled(false);
		menuButton.setFocusable(false);
		menuButton.setMaximumSize(new Dimension(117, 25));
		menuButton.setMinimumSize(new Dimension(117, 25));
		menuButton.setPreferredSize(new Dimension(117,  25));
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(menuButton);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBounds(415, 125, 239, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBackground(Color.WHITE);
		backgroundImagePanel.setBounds(10, 11, 430, 559);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setIcon(new ImageIcon(verificationDesSaisonsDesProduits.class.getResource("/images/fruitBackground.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		verifierSaisonPanel = new JPanel();
		verifierSaisonPanel.setBackground(Color.WHITE);
		verifierSaisonPanel.setBounds(474, 1, 503, 569);
		bodyPanel.add(verifierSaisonPanel);
		verifierSaisonPanel.setLayout(null);
		
		listeDesProduitsLabel = new JLabel("PRODUIT");
		listeDesProduitsLabel.setForeground(new Color(0, 0, 51));
		listeDesProduitsLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesProduitsLabel.setBackground(Color.WHITE);
		listeDesProduitsLabel.setBounds(131, 0, 283, 41);
		verifierSaisonPanel.add(listeDesProduitsLabel);
		
		listeDesProduitsComboBox = new JComboBox<ProduitAgricole>();
		listeDesProduitsComboBox.setEditable(false);
		listeDesProduitsComboBox.setEnabled(true);
		listeDesProduitsComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesProduitsComboBox.setBackground(Color.WHITE);
		listeDesProduitsComboBox.setBounds(131, 39, 283, 41);
		listeDesProduitsComboBox.setForeground(new Color(102, 102, 102));
		verifierSaisonPanel.add(listeDesProduitsComboBox);
		listeDesProduitsComboBox.setMaximumRowCount(20);
		listeDesProduitsComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		listeDesProduitsComboBox.setUI(new BasicComboBoxUI() {
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
		((JLabel)listeDesProduitsComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		remplirComboParListeDesProduits();
		
		saisionPasserLabel = new JLabel("SAISON");
		saisionPasserLabel.setForeground(new Color(0, 0, 51));
		saisionPasserLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		saisionPasserLabel.setBackground(Color.WHITE);
		saisionPasserLabel.setBounds(131, 117, 283, 41);
		verifierSaisonPanel.add(saisionPasserLabel);
		
		saisonPasserComboBox = new JComboBox<String>();
		saisonPasserComboBox.setEditable(false);
		saisonPasserComboBox.setEnabled(true);
		saisonPasserComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		saisonPasserComboBox.setBackground(Color.WHITE);
		saisonPasserComboBox.setBounds(131, 158, 283, 41);
		saisonPasserComboBox.setForeground(new Color(102, 102, 102));
		verifierSaisonPanel.add(saisonPasserComboBox);
		saisonPasserComboBox.setMaximumRowCount(20);
		saisonPasserComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		saisonPasserComboBox.addItem("Janvier");
		saisonPasserComboBox.addItem("Février");
		saisonPasserComboBox.addItem("Mars");
		saisonPasserComboBox.addItem("Avril");
		saisonPasserComboBox.addItem("Mai");
		saisonPasserComboBox.addItem("Juin");
		saisonPasserComboBox.addItem("Juillet");
		saisonPasserComboBox.addItem("Aout");
		saisonPasserComboBox.addItem("Septembre");
		saisonPasserComboBox.addItem("Octobre");
		saisonPasserComboBox.addItem("Novembre");
		saisonPasserComboBox.addItem("Décembre");
		saisonPasserComboBox.setUI(new BasicComboBoxUI() {
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
		((JLabel)saisonPasserComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		verifierSaisonProduitButton = new JButton("VERIFIER LA SAISON DES PRODUITS");
		verifierSaisonProduitButton.setFont(new Font("Dialog", Font.BOLD, 12));
		verifierSaisonProduitButton.setFocusable(false);
		verifierSaisonProduitButton.setEnabled(true);
		verifierSaisonProduitButton.setContentAreaFilled(true);
		verifierSaisonProduitButton.setBorder(null);
		verifierSaisonProduitButton.setBounds(131, 250, 283, 51);
		verifierSaisonPanel.add(verifierSaisonProduitButton);
		verifierSaisonProduitButton.setForeground(Color.WHITE);
		verifierSaisonProduitButton.setHorizontalAlignment(SwingConstants.CENTER);
		verifierSaisonProduitButton.setBackground(new Color(41, 178, 73));
		verifierSaisonProduitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		verifierSaisonProduitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verifierSessionProduit();
				verificationSaisonionFrame.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(verificationSaisonionFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	verificationSaisonionFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirComboParListeDesProduits() {
		for(ProduitAgricole listeMa : creerProduitAgricoleNonVide.getListeDesProduitsAgricoles()) {
			listeDesProduitsComboBox.addItem(listeMa);
		}
	}
	
	public void verifierSessionProduit() {
		ProduitAgricole selectedProduit = (ProduitAgricole) listeDesProduitsComboBox.getSelectedItem();
		String selectedSaison = (String) saisonPasserComboBox.getSelectedItem();
		boolean estFrais = false;
		
		if(selectedProduit.getTypeProduit().equals("Fruit")) {
			ProduitFruit pf = new ProduitFruit();
			estFrais = pf.estFrais(selectedProduit.getSaisonProduit(), selectedSaison);
		}
		
		else {
			ProduitLegume pl = new ProduitLegume();
			estFrais =  pl.estFrais(selectedProduit.getSaisonProduit(), selectedSaison);
		}
		
		
		if(estFrais == true) {
			resultatVerifierSaissonLabel.setText("TRUE");	
		}
		
		else {
			resultatVerifierSaissonLabel.setText("FALSE");	
		}
					
		Timer t = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatVerifierSaissonLabel.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}

	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(verificationSaisonionFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	verificationSaisonionFrame.dispose();
			new menuGestionAvances();
	    }
	}
}
