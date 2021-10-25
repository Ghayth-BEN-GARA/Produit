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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import tn.XXX.gestionmagasin.ProduitAgricole;

public class creerProduitAgricoleNonVide {

	private JFrame creerProduitAgricoleNonVideFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formCreerProduitAgricoleNonVidePanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, nbrProduitAgricoleNonVideCreerLabel, activeLigneLabel, bgImagelabel,
				   identifiantCreerProduitAgricoleLabel, erreurIdentifiantCreerProduitAgricoleLabel, typeCreerProduitAgricoleLabel, erreurTypeCreerProduitAgricoleLabel, libelleCreerProduitAgricoleLabel,
				   erreurLibelleCreerProduitAgricoleLabel, quantiteCreerProduitAgricoleLabel, erreurQuantiteCreerProduitAgricoleLabel, saisonCreerProduitAgricoleLabel, erreurSaisonCreerProduitAgricoleLabel;
	private JButton menuButton, creerProduitsAgricoleNonVideButton;
	private JTextField identifiantCreerProduitAgricoleTextField, libelleCreerProduitAgricoleTextField, quantiteCreerProduitAgricoleTextField;
	private JComboBox<String> typeCreerProduitAgricoleComboBox, saisonCreerProduitAgricoleComboBox;
	private JScrollPane generalFrameScrollPane;
	
	private static List<ProduitAgricole> listeDesProduitsAgricoles = new ArrayList<ProduitAgricole>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creerProduitAgricoleNonVide window = new creerProduitAgricoleNonVide();
					window.creerProduitAgricoleNonVideFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public creerProduitAgricoleNonVide() {
		initialize();
	}

	private void initialize() {
		creerProduitAgricoleNonVideFrame = new JFrame("Créer un produit agricole non vide");
		creerProduitAgricoleNonVideFrame.setBackground(Color.WHITE);
		creerProduitAgricoleNonVideFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		creerProduitAgricoleNonVideFrame.getContentPane().setForeground(Color.BLACK);
		creerProduitAgricoleNonVideFrame.getContentPane().setBackground(Color.WHITE);
		creerProduitAgricoleNonVideFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		creerProduitAgricoleNonVideFrame.setType(Type.POPUP);
		creerProduitAgricoleNonVideFrame.setAutoRequestFocus(true);
		creerProduitAgricoleNonVideFrame.setUndecorated(false);
		creerProduitAgricoleNonVideFrame.setEnabled(true);
		creerProduitAgricoleNonVideFrame.getContentPane().setLayout(null);
		creerProduitAgricoleNonVideFrame.setVisible(true);
		creerProduitAgricoleNonVideFrame.setSize(1000, 800);
		creerProduitAgricoleNonVideFrame.setResizable(true);
		creerProduitAgricoleNonVideFrame.setLocationRelativeTo(null);
		creerProduitAgricoleNonVideFrame.setMinimumSize(new Dimension(1000, 1500));
		
		generalFrameScrollPane = new JScrollPane();
		generalFrameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		generalFrameScrollPane.setBounds(0, 0, 985, 800);
		
		generalFramePanel = new JPanel();
		generalFrameScrollPane.setViewportView(generalFramePanel);
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setPreferredSize(new Dimension(1000, 1000));
		generalFramePanel.setSize(1000, 1050);
		generalFramePanel.setBorder(null);
		generalFramePanel.setLayout(null);
		
		creerProduitAgricoleNonVideFrame.getContentPane().add(generalFrameScrollPane);
		creerProduitAgricoleNonVideFrame.setVisible(true);
		creerProduitAgricoleNonVideFrame.requestFocusInWindow();
		
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
		bodyPanel.setBounds(0, 158, 984, 800);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		nbrProduitAgricoleNonVideCreerLabel = new JLabel("");
		nbrProduitAgricoleNonVideCreerLabel.setBounds(405, 62, 294, 34);
		nbrProduitAgricoleNonVideCreerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbrProduitAgricoleNonVideCreerLabel.setForeground(new Color(41, 178, 73));
		nbrProduitAgricoleNonVideCreerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		nbrProduitAgricoleNonVideCreerLabel.setBackground(Color.WHITE);
		entetePanel.add(nbrProduitAgricoleNonVideCreerLabel);
		
		menuButton = new JButton("CREATION DES PRODUITS AGRICOLES NON VIDES");
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(364, 100, 335, 23);
		menuButton.setBorder(null);
		menuButton.setContentAreaFilled(false);
		menuButton.setFocusable(false);
		menuButton.setMaximumSize(new Dimension(117, 25));
		menuButton.setMinimumSize(new Dimension(117, 25));
		menuButton.setPreferredSize(new Dimension(117,  25));
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(menuButton);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBounds(374, 125, 316, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		backgroundImagePanel = new JPanel();
		backgroundImagePanel.setBackground(Color.WHITE);
		backgroundImagePanel.setBounds(10, 11, 430, 687);
		bodyPanel.add(backgroundImagePanel);
		backgroundImagePanel.setLayout(null);
		
		bgImagelabel = new JLabel("");
		bgImagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgImagelabel.setIcon(new ImageIcon(creerProduitAgricoleNonVide.class.getResource("/images/creerProduitAgricoleNonVide.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 664);
		backgroundImagePanel.add(bgImagelabel);
		
		formCreerProduitAgricoleNonVidePanel = new JPanel();
		formCreerProduitAgricoleNonVidePanel.setBackground(Color.WHITE);
		formCreerProduitAgricoleNonVidePanel.setBounds(474, 1, 503, 687);
		bodyPanel.add(formCreerProduitAgricoleNonVidePanel);
		formCreerProduitAgricoleNonVidePanel.setLayout(null);
		
		identifiantCreerProduitAgricoleLabel = new JLabel("IDENTIFIANT");
		identifiantCreerProduitAgricoleLabel.setForeground(new Color(0, 0, 51));
		identifiantCreerProduitAgricoleLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		identifiantCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		identifiantCreerProduitAgricoleLabel.setBounds(131, 0, 283, 41);
		formCreerProduitAgricoleNonVidePanel.add(identifiantCreerProduitAgricoleLabel);
		
		identifiantCreerProduitAgricoleTextField = new JTextField();
		identifiantCreerProduitAgricoleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		identifiantCreerProduitAgricoleTextField.setEditable(true);
		identifiantCreerProduitAgricoleTextField.setEnabled(true);
		identifiantCreerProduitAgricoleTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		identifiantCreerProduitAgricoleTextField.setBackground(Color.WHITE);
		identifiantCreerProduitAgricoleTextField.setBounds(131, 39, 283, 41);
		identifiantCreerProduitAgricoleTextField.setForeground(new Color(102, 102, 102));
		identifiantCreerProduitAgricoleTextField.setText("Identifiant de produit..");
		formCreerProduitAgricoleNonVidePanel.add(identifiantCreerProduitAgricoleTextField);
		identifiantCreerProduitAgricoleTextField.setColumns(10);
		
		identifiantCreerProduitAgricoleTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(identifiantCreerProduitAgricoleTextField, "Identifiant de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(identifiantCreerProduitAgricoleTextField, "Identifiant de produit..");		
			} 
		});
		
		identifiantCreerProduitAgricoleTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType1(identifiantCreerProduitAgricoleTextField, erreurIdentifiantCreerProduitAgricoleLabel, e);
			 }
		 });
		
		erreurIdentifiantCreerProduitAgricoleLabel = new JLabel("");
		erreurIdentifiantCreerProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurIdentifiantCreerProduitAgricoleLabel.setForeground(new Color(204, 0, 0));
		erreurIdentifiantCreerProduitAgricoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurIdentifiantCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		erreurIdentifiantCreerProduitAgricoleLabel.setBounds(131, 81, 283, 36);
		formCreerProduitAgricoleNonVidePanel.add(erreurIdentifiantCreerProduitAgricoleLabel);
		
		typeCreerProduitAgricoleLabel = new JLabel("TYPE");
		typeCreerProduitAgricoleLabel.setForeground(new Color(0, 0, 51));
		typeCreerProduitAgricoleLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		typeCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		typeCreerProduitAgricoleLabel.setBounds(131, 117, 283, 41);
		formCreerProduitAgricoleNonVidePanel.add(typeCreerProduitAgricoleLabel);
		
		typeCreerProduitAgricoleComboBox = new JComboBox<String>();
		typeCreerProduitAgricoleComboBox.setEditable(false);
		typeCreerProduitAgricoleComboBox.setEnabled(true);
		typeCreerProduitAgricoleComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		typeCreerProduitAgricoleComboBox.setBackground(Color.WHITE);
		typeCreerProduitAgricoleComboBox.setBounds(131, 158, 283, 41);
		typeCreerProduitAgricoleComboBox.setForeground(new Color(102, 102, 102));
		formCreerProduitAgricoleNonVidePanel.add(typeCreerProduitAgricoleComboBox);
		typeCreerProduitAgricoleComboBox.setMaximumRowCount(20);
		typeCreerProduitAgricoleComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		typeCreerProduitAgricoleComboBox.addItem("Fruit");
		typeCreerProduitAgricoleComboBox.addItem("Légume");
		typeCreerProduitAgricoleComboBox.setUI(new BasicComboBoxUI() {
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
		((JLabel)typeCreerProduitAgricoleComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		erreurTypeCreerProduitAgricoleLabel = new JLabel("");
		erreurTypeCreerProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurTypeCreerProduitAgricoleLabel.setForeground(new Color(204, 0, 0));
		erreurTypeCreerProduitAgricoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurTypeCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		erreurTypeCreerProduitAgricoleLabel.setBounds(131, 201, 283, 36);
		formCreerProduitAgricoleNonVidePanel.add(erreurTypeCreerProduitAgricoleLabel);
		
		libelleCreerProduitAgricoleLabel = new JLabel("LIBELLE");
		libelleCreerProduitAgricoleLabel.setForeground(new Color(0, 0, 51));
		libelleCreerProduitAgricoleLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		libelleCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		libelleCreerProduitAgricoleLabel.setBounds(131, 234, 283, 41);
		formCreerProduitAgricoleNonVidePanel.add(libelleCreerProduitAgricoleLabel);
		
		libelleCreerProduitAgricoleTextField = new JTextField();
		libelleCreerProduitAgricoleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelleCreerProduitAgricoleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		libelleCreerProduitAgricoleTextField.setEditable(true);
		libelleCreerProduitAgricoleTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		libelleCreerProduitAgricoleTextField.setBackground(Color.WHITE);
		libelleCreerProduitAgricoleTextField.setBounds(131, 275, 283, 41);
		libelleCreerProduitAgricoleTextField.setForeground(new Color(102, 102, 102));
		libelleCreerProduitAgricoleTextField.setText("Libellé de produit..");
		formCreerProduitAgricoleNonVidePanel.add(libelleCreerProduitAgricoleTextField);
		libelleCreerProduitAgricoleTextField.setColumns(10);
		
		libelleCreerProduitAgricoleTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(libelleCreerProduitAgricoleTextField, "Libellé de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(libelleCreerProduitAgricoleTextField, "Libellé de produit..");		
			} 
		});
		
		libelleCreerProduitAgricoleTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 erreurLibelleCreerProduitAgricoleLabel.setText("");
			 }
		 });
		
		erreurLibelleCreerProduitAgricoleLabel = new JLabel("");
		erreurLibelleCreerProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurLibelleCreerProduitAgricoleLabel.setForeground(new Color(204, 0, 0));
		erreurLibelleCreerProduitAgricoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurLibelleCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		erreurLibelleCreerProduitAgricoleLabel.setBounds(131, 316, 283, 36);
		formCreerProduitAgricoleNonVidePanel.add(erreurLibelleCreerProduitAgricoleLabel);
		
		quantiteCreerProduitAgricoleLabel = new JLabel("QUANTITE");
		quantiteCreerProduitAgricoleLabel.setForeground(new Color(0, 0, 51));
		quantiteCreerProduitAgricoleLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		quantiteCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		quantiteCreerProduitAgricoleLabel.setBounds(131, 351, 283, 41);
		formCreerProduitAgricoleNonVidePanel.add(quantiteCreerProduitAgricoleLabel);
		
		quantiteCreerProduitAgricoleTextField = new JTextField();
		quantiteCreerProduitAgricoleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		quantiteCreerProduitAgricoleTextField.setHorizontalAlignment(SwingConstants.CENTER);
		quantiteCreerProduitAgricoleTextField.setEditable(true);
		quantiteCreerProduitAgricoleTextField.setFont(new Font("Dialog", Font.PLAIN, 11));
		quantiteCreerProduitAgricoleTextField.setBackground(Color.WHITE);
		quantiteCreerProduitAgricoleTextField.setBounds(131, 392, 283, 41);
		quantiteCreerProduitAgricoleTextField.setForeground(new Color(102, 102, 102));
		quantiteCreerProduitAgricoleTextField.setText("Quantité de produit..");
		formCreerProduitAgricoleNonVidePanel.add(quantiteCreerProduitAgricoleTextField);
		quantiteCreerProduitAgricoleTextField.setColumns(10);
		
		quantiteCreerProduitAgricoleTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				focusLostParametres(quantiteCreerProduitAgricoleTextField, "Quantité de produit..");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusGainedParametres(quantiteCreerProduitAgricoleTextField, "Quantité de produit..");		
			} 
		});
		
		quantiteCreerProduitAgricoleTextField.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 keyPressedParametresType2(quantiteCreerProduitAgricoleTextField, erreurQuantiteCreerProduitAgricoleLabel, e);
			 }
		 });
		
		erreurQuantiteCreerProduitAgricoleLabel = new JLabel("");
		erreurQuantiteCreerProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurQuantiteCreerProduitAgricoleLabel.setForeground(new Color(204, 0, 0));
		erreurQuantiteCreerProduitAgricoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurQuantiteCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		erreurQuantiteCreerProduitAgricoleLabel.setBounds(131, 432, 283, 36);
		formCreerProduitAgricoleNonVidePanel.add(erreurQuantiteCreerProduitAgricoleLabel);
		
		saisonCreerProduitAgricoleLabel = new JLabel("SAISON");
		saisonCreerProduitAgricoleLabel.setForeground(new Color(0, 0, 51));
		saisonCreerProduitAgricoleLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		saisonCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		saisonCreerProduitAgricoleLabel.setBounds(131, 479, 283, 41);
		formCreerProduitAgricoleNonVidePanel.add(saisonCreerProduitAgricoleLabel);
		
		saisonCreerProduitAgricoleComboBox = new JComboBox<String>();
		saisonCreerProduitAgricoleComboBox.setEditable(false);
		saisonCreerProduitAgricoleComboBox.setEnabled(true);
		saisonCreerProduitAgricoleComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		saisonCreerProduitAgricoleComboBox.setBackground(Color.WHITE);
		saisonCreerProduitAgricoleComboBox.setBounds(131, 520, 283, 41);
		saisonCreerProduitAgricoleComboBox.setForeground(new Color(102, 102, 102));
		formCreerProduitAgricoleNonVidePanel.add(saisonCreerProduitAgricoleComboBox);
		saisonCreerProduitAgricoleComboBox.setMaximumRowCount(20);
		saisonCreerProduitAgricoleComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		saisonCreerProduitAgricoleComboBox.addItem("Janvier");
		saisonCreerProduitAgricoleComboBox.addItem("Février");
		saisonCreerProduitAgricoleComboBox.addItem("Mars");
		saisonCreerProduitAgricoleComboBox.addItem("Avril");
		saisonCreerProduitAgricoleComboBox.addItem("Mai");
		saisonCreerProduitAgricoleComboBox.addItem("Juin");
		saisonCreerProduitAgricoleComboBox.addItem("Juillet");
		saisonCreerProduitAgricoleComboBox.addItem("Aout");
		saisonCreerProduitAgricoleComboBox.addItem("Septembre");
		saisonCreerProduitAgricoleComboBox.addItem("Octobre");
		saisonCreerProduitAgricoleComboBox.addItem("Novembre");
		saisonCreerProduitAgricoleComboBox.addItem("Décembre");
		saisonCreerProduitAgricoleComboBox.setUI(new BasicComboBoxUI() {
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
		((JLabel)saisonCreerProduitAgricoleComboBox.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		erreurSaisonCreerProduitAgricoleLabel = new JLabel("");
		erreurSaisonCreerProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		erreurSaisonCreerProduitAgricoleLabel.setForeground(new Color(204, 0, 0));
		erreurSaisonCreerProduitAgricoleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		erreurSaisonCreerProduitAgricoleLabel.setBackground(Color.WHITE);
		erreurSaisonCreerProduitAgricoleLabel.setBounds(131, 562, 283, 36);
		formCreerProduitAgricoleNonVidePanel.add(erreurSaisonCreerProduitAgricoleLabel);
		
		creerProduitsAgricoleNonVideButton = new JButton("CREER DES PRODUITS AGRICOLES NON VIDES");
		creerProduitsAgricoleNonVideButton.setFont(new Font("Dialog", Font.BOLD, 12));
		creerProduitsAgricoleNonVideButton.setFocusable(false);
		creerProduitsAgricoleNonVideButton.setEnabled(true);
		creerProduitsAgricoleNonVideButton.setContentAreaFilled(true);
		creerProduitsAgricoleNonVideButton.setBorder(null);
		creerProduitsAgricoleNonVideButton.setBounds(131, 605, 283, 51);
		formCreerProduitAgricoleNonVidePanel.add(creerProduitsAgricoleNonVideButton);
		creerProduitsAgricoleNonVideButton.setForeground(Color.WHITE);
		creerProduitsAgricoleNonVideButton.setHorizontalAlignment(SwingConstants.CENTER);
		creerProduitsAgricoleNonVideButton.setBackground(new Color(41, 178, 73));
		creerProduitsAgricoleNonVideButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	
		creerProduitsAgricoleNonVideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateFormCreerProduitAgricoleNonVide();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(creerProduitAgricoleNonVideFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerProduitAgricoleNonVideFrame.dispose();
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
	
	public boolean validerQuantite(String quantite) {
		boolean test = false;
		
		if((quantite.equals("")) || (quantite.equals("Quantité de produit.."))) {
			test = false;
		}
		
		else {
			test = true;
		}
		return test;
	}
	
	public void validateFormCreerProduitAgricoleNonVide() {
		String identifiant = identifiantCreerProduitAgricoleTextField.getText();
		String type = typeCreerProduitAgricoleComboBox.getSelectedItem().toString();
		String libelle = libelleCreerProduitAgricoleTextField.getText();
		String quantite = quantiteCreerProduitAgricoleTextField.getText();
		String saison = saisonCreerProduitAgricoleComboBox.getSelectedItem().toString();
		
		if(validerIdentifiant(identifiant) == false) {
			erreurIdentifiantCreerProduitAgricoleLabel.setText("L'identifiant de produit est obligatoire !");
		}
		
		else if(validerLibelle(libelle) == false) {
			erreurLibelleCreerProduitAgricoleLabel.setText("La libellé de produit est obligatoire !");
		}
		
		else if(validerQuantite(quantite) == false) {
			erreurQuantiteCreerProduitAgricoleLabel.setText("La quantité de produit est obligatoire !");
		}
		
		else {
			creerProduitsAgricolesNonVide(Integer.parseInt(identifiant), type, libelle, Double.parseDouble(quantite), saison);
			nbrProduitAgricoleNonVideCreerLabel.setText("+ " + listeDesProduitsAgricoles.size() + " " + "produit(s) agricole(s) non vide(s) créé(s).");
			Timer t = new Timer(3000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	nbrProduitAgricoleNonVideCreerLabel.setText(null);
	            }
	        });
	        t.setRepeats(false);
	        t.start();
	        
	        identifiantCreerProduitAgricoleTextField.setText("Identifiant de produit..");
	        typeCreerProduitAgricoleComboBox.setSelectedIndex(0);
			libelleCreerProduitAgricoleTextField.setText("Libellé de produit..");
			quantiteCreerProduitAgricoleTextField.setText("Quantité de produit..");
			saisonCreerProduitAgricoleComboBox.setSelectedIndex(0);
			
			retourAuMenu();
			formCreerProduitAgricoleNonVidePanel.requestFocusInWindow();			
		}
	}
	
	public void creerProduitsAgricolesNonVide(int identifiant, String type, String libelle, Double quantite, String saison) {
		ProduitAgricole produitAgricoleNonVide = new ProduitAgricole(identifiant, type, libelle, quantite, saison);
		listeDesProduitsAgricoles.add(produitAgricoleNonVide);
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(null,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	creerProduitAgricoleNonVideFrame.dispose();
			new menuGestionAvances();
	    }
	}
	
	public static List<ProduitAgricole> getListeDesProduitsAgricoles() {
		return listeDesProduitsAgricoles;
	}

}
