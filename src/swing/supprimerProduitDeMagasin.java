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
import tn.XXX.gestionmagasin.Magasin;
import tn.XXX.gestionmagasin.ProduitAlimentaire;

public class supprimerProduitDeMagasin {

	private JFrame supprimerProduitFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formSupprimerDesProduitsPanel;	
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, resultatSupprimerDesProduitsLabel, activeLigneLabel, bgImagelabel,
				   listeDesMagasinsLabel, listeDesProduitsLabel;
	private JButton menuButton, supprimerDesProduitsButton;
	private JComboBox<Magasin> listeDesMagasinsComboBox;
	private JComboBox<ProduitAlimentaire> listeDesProduitsComboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerProduitDeMagasin window = new supprimerProduitDeMagasin();
					window.supprimerProduitFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public supprimerProduitDeMagasin() {
		initialize();
	}

	private void initialize() {
		supprimerProduitFrame = new JFrame("Supprimer des produits");
		supprimerProduitFrame.setBackground(Color.WHITE);
		supprimerProduitFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		supprimerProduitFrame.getContentPane().setForeground(Color.BLACK);
		supprimerProduitFrame.getContentPane().setBackground(Color.WHITE);
		supprimerProduitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		supprimerProduitFrame.setType(Type.POPUP);
		supprimerProduitFrame.setAutoRequestFocus(true);
		supprimerProduitFrame.setUndecorated(false);
		supprimerProduitFrame.setEnabled(true);
		supprimerProduitFrame.getContentPane().setLayout(null);
		supprimerProduitFrame.setVisible(true);
		supprimerProduitFrame.setSize(1000, 800);
		supprimerProduitFrame.setResizable(true);
		supprimerProduitFrame.setLocationRelativeTo(null);
		supprimerProduitFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		supprimerProduitFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		supprimerProduitFrame.requestFocusInWindow();
		
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
		
		resultatSupprimerDesProduitsLabel = new JLabel("");
		resultatSupprimerDesProduitsLabel.setBounds(405, 62, 294, 34);
		resultatSupprimerDesProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultatSupprimerDesProduitsLabel.setForeground(new Color(41, 178, 73));
		resultatSupprimerDesProduitsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatSupprimerDesProduitsLabel.setBackground(Color.WHITE);
		entetePanel.add(resultatSupprimerDesProduitsLabel);
		
		menuButton = new JButton("SUPPRIMER DES PRODUITS");
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
		activeLigneLabel.setBounds(450, 125, 174, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBackground(Color.WHITE);
		backgroundImagePanel.setBounds(10, 11, 430, 559);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgImagelabel.setIcon(new ImageIcon(supprimerProduitDeMagasin.class.getResource("/images/delete_photo.gif")));
		bgImagelabel.setBounds(0, 0, 430, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		formSupprimerDesProduitsPanel = new JPanel();
		formSupprimerDesProduitsPanel.setBackground(Color.WHITE);
		formSupprimerDesProduitsPanel.setBounds(474, 1, 503, 569);
		bodyPanel.add(formSupprimerDesProduitsPanel);
		formSupprimerDesProduitsPanel.setLayout(null);
		
		listeDesMagasinsLabel = new JLabel("MAGASIN");
		listeDesMagasinsLabel.setForeground(new Color(0, 0, 51));
		listeDesMagasinsLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesMagasinsLabel.setBackground(Color.WHITE);
		listeDesMagasinsLabel.setBounds(131, 0, 283, 41);
		formSupprimerDesProduitsPanel.add(listeDesMagasinsLabel);
		
		listeDesMagasinsComboBox = new JComboBox<Magasin>();
		listeDesMagasinsComboBox.setEditable(false);
		listeDesMagasinsComboBox.setEnabled(true);
		listeDesMagasinsComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesMagasinsComboBox.setBackground(Color.WHITE);
		listeDesMagasinsComboBox.setBounds(131, 39, 283, 41);
		listeDesMagasinsComboBox.setForeground(new Color(102, 102, 102));
		formSupprimerDesProduitsPanel.add(listeDesMagasinsComboBox);
		listeDesMagasinsComboBox.setMaximumRowCount(20);
		listeDesMagasinsComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		listeDesMagasinsComboBox.setUI(new BasicComboBoxUI() {
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
		remplirComboParListeDesMagasins();
		
		listeDesProduitsLabel = new JLabel("PRODUIT");
		listeDesProduitsLabel.setForeground(new Color(0, 0, 51));
		listeDesProduitsLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesProduitsLabel.setBackground(Color.WHITE);
		listeDesProduitsLabel.setBounds(131, 117, 283, 41);
		formSupprimerDesProduitsPanel.add(listeDesProduitsLabel);
		
		listeDesProduitsComboBox = new JComboBox<ProduitAlimentaire>();
		listeDesProduitsComboBox.setEditable(false);
		listeDesProduitsComboBox.setEnabled(true);
		listeDesProduitsComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesProduitsComboBox.setBackground(Color.WHITE);
		listeDesProduitsComboBox.setBounds(131, 158, 283, 41);
		listeDesProduitsComboBox.setForeground(new Color(102, 102, 102));
		formSupprimerDesProduitsPanel.add(listeDesProduitsComboBox);
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
		listeDesMagasinsComboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	listeDesProduitsComboBox.removeAllItems();
		    	remplirComboParListeDesProduits();
		    }
		});
				
		supprimerDesProduitsButton = new JButton("SUPPRIMER LES PRODUITS");
		supprimerDesProduitsButton.setFont(new Font("Dialog", Font.BOLD, 12));
		supprimerDesProduitsButton.setFocusable(false);
		supprimerDesProduitsButton.setEnabled(true);
		supprimerDesProduitsButton.setContentAreaFilled(true);
		supprimerDesProduitsButton.setBorder(null);
		supprimerDesProduitsButton.setBounds(131, 253, 283, 51);
		formSupprimerDesProduitsPanel.add(supprimerDesProduitsButton);
		supprimerDesProduitsButton.setForeground(Color.WHITE);
		supprimerDesProduitsButton.setHorizontalAlignment(SwingConstants.CENTER);
		supprimerDesProduitsButton.setBackground(new Color(41, 178, 73));
		supprimerDesProduitsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		supprimerDesProduitsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supprimerDesProduitsDeMagasin();			
				formSupprimerDesProduitsPanel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(supprimerProduitFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	supprimerProduitFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirComboParListeDesMagasins() {
		for(Magasin listeMa : menuGestionMagasin.getListeDesMagasins()) {
			listeDesMagasinsComboBox.addItem(listeMa);
		}
	}
	
	public void remplirComboParListeDesProduits() {
		for(Magasin listeMa: menuGestionMagasin.getListeDesMagasins()) {
			if (listeMa.equals(listeDesMagasinsComboBox.getSelectedItem())){
				for(ProduitAlimentaire listePr : listeMa.getEnsembleDesProduits()) {
					listeDesProduitsComboBox.addItem(listePr);
				}
			}
		}
	}
	
	public void supprimerDesProduitsDeMagasin() {
		Magasin selectedMagasin = (Magasin) listeDesMagasinsComboBox.getSelectedItem();
		ProduitAlimentaire selectedProduit = (ProduitAlimentaire) listeDesProduitsComboBox.getSelectedItem();
		boolean test = false;
		
		for(Magasin listeMa : menuGestionMagasin.getListeDesMagasins()) {
			if(listeMa.equals(selectedMagasin)) {
				listeMa.supprimerProduit(selectedProduit.getIdentifiantProduit());
				test = true;
				break;
			}
			
			else {
				test = false;
			}
		}
		
		if(test == true) {
			resultatSupprimerDesProduitsLabel.setForeground(new Color(41, 178, 73));
			resultatSupprimerDesProduitsLabel.setText("Ce produit est supprimé.");
		}
		
		else {
			resultatSupprimerDesProduitsLabel.setForeground(new Color(204, 0, 0));
			resultatSupprimerDesProduitsLabel.setText("Ce produit n'est pas supprimé.");
		}
		
		Timer t = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatSupprimerDesProduitsLabel.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}

	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(supprimerProduitFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	supprimerProduitFrame.dispose();
			new menuGestionMagasin();
	    }
	}
}
