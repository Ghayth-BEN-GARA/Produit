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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class comparerLesProduits1 {

	private JFrame comparerLesProduits1Frame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formComparerLesProduits1Panel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, activeLigneLabel, resultatComparaisonDesProduits1Label, bgImagelabel, listeDesMagasinsLabel, identifiantProduitComparerLesProduits1Label,
				   erreurIdentifiantProduitComparerLesProduits1Label, libelleProduitComparerLesProduits1Label, erreurLibelleProduitComparerLesProduits1Label, prixProduitComparerLesProduits1Label, erreurPrixProduitComparerLesProduits1Label;
	private JButton menuButton, comparerLesProduits1Button;
	private JComboBox<Magasin> listeDesMagasinsComboBox;
	private JTextField identifiantProduitComparerLesProduits1TextField, libelleProduitComparerLesProduits1TextField, prixProduitComparerLesProduits1TextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comparerLesProduits1 window = new comparerLesProduits1();
					window.comparerLesProduits1Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public comparerLesProduits1() {
		initialize();
	}

	private void initialize() {
		comparerLesProduits1Frame = new JFrame("Comparer les produits");
		comparerLesProduits1Frame.setBackground(Color.WHITE);
		comparerLesProduits1Frame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		comparerLesProduits1Frame.getContentPane().setForeground(Color.BLACK);
		comparerLesProduits1Frame.getContentPane().setBackground(Color.WHITE);
		comparerLesProduits1Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		comparerLesProduits1Frame.setType(Type.POPUP);
		comparerLesProduits1Frame.setAutoRequestFocus(true);
		comparerLesProduits1Frame.setUndecorated(false);
		comparerLesProduits1Frame.setEnabled(true);
		comparerLesProduits1Frame.getContentPane().setLayout(null);
		comparerLesProduits1Frame.setVisible(true);
		comparerLesProduits1Frame.setSize(1000, 800);
		comparerLesProduits1Frame.setResizable(true);
		comparerLesProduits1Frame.setLocationRelativeTo(null);
		comparerLesProduits1Frame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		comparerLesProduits1Frame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		comparerLesProduits1Frame.requestFocusInWindow();
		
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
		
		resultatComparaisonDesProduits1Label = new JLabel("");
		resultatComparaisonDesProduits1Label.setBounds(405, 62, 294, 34);
		resultatComparaisonDesProduits1Label.setHorizontalAlignment(SwingConstants.CENTER);
		resultatComparaisonDesProduits1Label.setForeground(new Color(41, 178, 73));
		resultatComparaisonDesProduits1Label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatComparaisonDesProduits1Label.setBackground(Color.WHITE);
		entetePanel.add(resultatComparaisonDesProduits1Label);
		
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
		backgroundImagePanel.setBounds(10, 11, 430, 559);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);	
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgImagelabel.setIcon(new ImageIcon(comparerLesProduits1.class.getResource("/images/comparerProduit1.png")));
		bgImagelabel.setBounds(0, 0, 430, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		formComparerLesProduits1Panel = new JPanel();
		formComparerLesProduits1Panel.setBackground(Color.WHITE);
		formComparerLesProduits1Panel.setBounds(474, 1, 503, 569);
		bodyPanel.add(formComparerLesProduits1Panel);
		formComparerLesProduits1Panel.setLayout(null);
		
		listeDesMagasinsLabel = new JLabel("MAGASIN");
		listeDesMagasinsLabel.setForeground(new Color(0, 0, 51));
		listeDesMagasinsLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesMagasinsLabel.setBackground(Color.WHITE);
		listeDesMagasinsLabel.setBounds(131, 0, 283, 41);
		formComparerLesProduits1Panel.add(listeDesMagasinsLabel);
		
		listeDesMagasinsComboBox = new JComboBox<Magasin>();
		listeDesMagasinsComboBox.setEditable(false);
		listeDesMagasinsComboBox.setEnabled(true);
		listeDesMagasinsComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesMagasinsComboBox.setBackground(Color.WHITE);
		listeDesMagasinsComboBox.setBounds(131, 39, 283, 41);
		listeDesMagasinsComboBox.setForeground(new Color(102, 102, 102));
		formComparerLesProduits1Panel.add(listeDesMagasinsComboBox);
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
		
		identifiantProduitComparerLesProduits1Label = new JLabel("IDENTIFIANT");
		identifiantProduitComparerLesProduits1Label.setForeground(new Color(0, 0, 51));
		identifiantProduitComparerLesProduits1Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiantProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		identifiantProduitComparerLesProduits1Label.setBounds(131, 117, 283, 41);
		formComparerLesProduits1Panel.add(identifiantProduitComparerLesProduits1Label);
		
		identifiantProduitComparerLesProduits1TextField = new JTextField();
		identifiantProduitComparerLesProduits1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiantProduitComparerLesProduits1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiantProduitComparerLesProduits1TextField.setEditable(true);
		identifiantProduitComparerLesProduits1TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiantProduitComparerLesProduits1TextField.setBackground(Color.WHITE);
		identifiantProduitComparerLesProduits1TextField.setBounds(131, 159, 283, 41);
		identifiantProduitComparerLesProduits1TextField.setForeground(new Color(102, 102, 102));
		identifiantProduitComparerLesProduits1TextField.setText("Identifiant de produit..");
		formComparerLesProduits1Panel.add(identifiantProduitComparerLesProduits1TextField);
		identifiantProduitComparerLesProduits1TextField.setColumns(10);
		
		identifiantProduitComparerLesProduits1TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiantProduitComparerLesProduits1TextField, "Identifiant de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiantProduitComparerLesProduits1TextField, "Identifiant de produit..");		
			} 
		});
		
		identifiantProduitComparerLesProduits1TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiantProduitComparerLesProduits1TextField, erreurIdentifiantProduitComparerLesProduits1Label, e);
			 }
		 });
		
		erreurIdentifiantProduitComparerLesProduits1Label = new JLabel("");
		erreurIdentifiantProduitComparerLesProduits1Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiantProduitComparerLesProduits1Label.setForeground(new Color(204, 0, 0));
		erreurIdentifiantProduitComparerLesProduits1Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiantProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		erreurIdentifiantProduitComparerLesProduits1Label.setBounds(131, 201, 283, 36);
		formComparerLesProduits1Panel.add(erreurIdentifiantProduitComparerLesProduits1Label);
		
		libelleProduitComparerLesProduits1Label = new JLabel("LIBELLE");
		libelleProduitComparerLesProduits1Label.setForeground(new Color(0, 0, 51));
		libelleProduitComparerLesProduits1Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		libelleProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		libelleProduitComparerLesProduits1Label.setBounds(131, 234, 283, 41);
		formComparerLesProduits1Panel.add(libelleProduitComparerLesProduits1Label);
		
		libelleProduitComparerLesProduits1TextField = new JTextField();
		libelleProduitComparerLesProduits1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelleProduitComparerLesProduits1TextField.setEditable(true);
		libelleProduitComparerLesProduits1TextField.setEnabled(true);
		libelleProduitComparerLesProduits1TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		libelleProduitComparerLesProduits1TextField.setBackground(Color.WHITE);
		libelleProduitComparerLesProduits1TextField.setBounds(131, 275, 283, 41);
		libelleProduitComparerLesProduits1TextField.setForeground(new Color(102, 102, 102));
		libelleProduitComparerLesProduits1TextField.setText("Libellé de produit..");
		formComparerLesProduits1Panel.add(libelleProduitComparerLesProduits1TextField);
		libelleProduitComparerLesProduits1TextField.setColumns(10);
		
		libelleProduitComparerLesProduits1TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(libelleProduitComparerLesProduits1TextField, "Libellé de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(libelleProduitComparerLesProduits1TextField, "Libellé de produit..");		
			} 
		});
		
		libelleProduitComparerLesProduits1TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurLibelleProduitComparerLesProduits1Label.setText("");
			 }
		 });
		
		erreurLibelleProduitComparerLesProduits1Label = new JLabel("");
		erreurLibelleProduitComparerLesProduits1Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurLibelleProduitComparerLesProduits1Label.setForeground(new Color(204, 0, 0));
		erreurLibelleProduitComparerLesProduits1Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurLibelleProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		erreurLibelleProduitComparerLesProduits1Label.setBounds(131, 316, 283, 36);
		formComparerLesProduits1Panel.add(erreurLibelleProduitComparerLesProduits1Label);
		
		prixProduitComparerLesProduits1Label = new JLabel("PRIX");
		prixProduitComparerLesProduits1Label.setForeground(new Color(0, 0, 51));
		prixProduitComparerLesProduits1Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		prixProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		prixProduitComparerLesProduits1Label.setBounds(131, 351, 283, 41);
		formComparerLesProduits1Panel.add(prixProduitComparerLesProduits1Label);
		
		prixProduitComparerLesProduits1TextField = new JTextField();
		prixProduitComparerLesProduits1TextField.setHorizontalAlignment(SwingConstants.CENTER);
		prixProduitComparerLesProduits1TextField.setEditable(true);
		prixProduitComparerLesProduits1TextField.setEnabled(true);
		prixProduitComparerLesProduits1TextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		prixProduitComparerLesProduits1TextField.setBackground(Color.WHITE);
		prixProduitComparerLesProduits1TextField.setBounds(131, 392, 283, 41);
		prixProduitComparerLesProduits1TextField.setForeground(new Color(102, 102, 102));
		prixProduitComparerLesProduits1TextField.setText("Prix de produit..");
		formComparerLesProduits1Panel.add(prixProduitComparerLesProduits1TextField);
		prixProduitComparerLesProduits1TextField.setColumns(10);
		
		erreurPrixProduitComparerLesProduits1Label = new JLabel("");
		erreurPrixProduitComparerLesProduits1Label.setHorizontalAlignment(SwingConstants.CENTER);
		erreurPrixProduitComparerLesProduits1Label.setForeground(new Color(204, 0, 0));
		erreurPrixProduitComparerLesProduits1Label.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurPrixProduitComparerLesProduits1Label.setBackground(Color.WHITE);
		erreurPrixProduitComparerLesProduits1Label.setBounds(131, 433, 283, 36);
		formComparerLesProduits1Panel.add(erreurPrixProduitComparerLesProduits1Label);
		
		prixProduitComparerLesProduits1TextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(prixProduitComparerLesProduits1TextField, "Prix de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(prixProduitComparerLesProduits1TextField, "Prix de produit..");		
			} 
		});
		
		prixProduitComparerLesProduits1TextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType2(prixProduitComparerLesProduits1TextField, erreurPrixProduitComparerLesProduits1Label, e);
			 }
		 });
		
		comparerLesProduits1Button = new JButton("COMPARER LES PRODUITS");
		comparerLesProduits1Button.setFont(new Font("Dialog", Font.BOLD, 12));
		comparerLesProduits1Button.setFocusable(false);
		comparerLesProduits1Button.setEnabled(true);
		comparerLesProduits1Button.setContentAreaFilled(true);
		comparerLesProduits1Button.setBorder(null);
		comparerLesProduits1Button.setBounds(131, 479, 283, 51);
		formComparerLesProduits1Panel.add(comparerLesProduits1Button);
		comparerLesProduits1Button.setForeground(Color.WHITE);
		comparerLesProduits1Button.setHorizontalAlignment(SwingConstants.CENTER);
		comparerLesProduits1Button.setBackground(new Color(41, 178, 73));
		comparerLesProduits1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comparerLesProduits1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateFormComparerLesProduits();			
				formComparerLesProduits1Panel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesProduits1Frame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesProduits1Frame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirComboParListeDesMagasins() {
		for(Magasin listeMa : menuGestionMagasin.getListeDesMagasins()) {
			listeDesMagasinsComboBox.addItem(listeMa);
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
		String identifiant = identifiantProduitComparerLesProduits1TextField.getText();
		String libelle = libelleProduitComparerLesProduits1TextField.getText();
		String prix = prixProduitComparerLesProduits1TextField.getText();
		
		if(validerIdentifiant(identifiant) == false) {
			erreurIdentifiantProduitComparerLesProduits1Label.setText("L'identifiant de produit est obligatoire !");
		}
		
		else if(validerIdentifiantNull(identifiant) == false) {
			erreurIdentifiantProduitComparerLesProduits1Label.setText("L'identifiant de produit est nul !");
		}
		
		else if(validerLibelle(libelle) == false) {
			erreurLibelleProduitComparerLesProduits1Label.setText("La libellé de produit est obligatoire !");
		}
		
		else if(validerPrix(prix) == false) {
			erreurPrixProduitComparerLesProduits1Label.setText("Le prix de produit est obligatoire !");
		}
		
		else if(validerPrixNull(prix)== false) {
			erreurPrixProduitComparerLesProduits1Label.setText("Le prix de produit est null !");
		}
		
		else {
			comparerLesProduitsAlimentaires1();
			identifiantProduitComparerLesProduits1TextField.setText("Identifiant de produit..");
			libelleProduitComparerLesProduits1TextField.setText("Libellé de produit..");
			prixProduitComparerLesProduits1TextField.setText("Prix de produit..");
		}
	}
	
	public void comparerLesProduitsAlimentaires1() {
		Magasin selectedMagasin = (Magasin) listeDesMagasinsComboBox.getSelectedItem();
		ProduitAlimentaire p = new ProduitAlimentaire(Integer.parseInt(identifiantProduitComparerLesProduits1TextField.getText()), libelleProduitComparerLesProduits1TextField.getText(), null, Double.parseDouble(prixProduitComparerLesProduits1TextField.getText()), null);
		boolean test = false;
		
		test = selectedMagasin.comparerProduitMethode1(p);
		if(test == true) {
			resultatComparaisonDesProduits1Label.setForeground(new Color(41, 178, 73));
			resultatComparaisonDesProduits1Label.setText("Les deux produits sont conformes.");
		}
		
		else {
			resultatComparaisonDesProduits1Label.setForeground(new Color(204, 0, 0));
			resultatComparaisonDesProduits1Label.setText("Les deux produits ne sont pas conformes.");
		}
		
		Timer t = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatComparaisonDesProduits1Label.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesProduits1Frame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesProduits1Frame.dispose();
			new menuGestionMagasin();
	    }
	}
}
