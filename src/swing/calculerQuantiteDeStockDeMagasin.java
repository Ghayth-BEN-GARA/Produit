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
import tn.XXX.gestionmagasin.MagasinProduitAgricole;

public class calculerQuantiteDeStockDeMagasin {

	private JFrame calculerQuantiteStockMagasinFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formCalculerQuantiteStockPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, resultatCalculeQuantiteStockLabel, activeLigneLabel, bgImagelabel, listeDesMagasinsLabel;
	private JButton menuButton, calculerQuantiteStockButton;
	private JComboBox<MagasinProduitAgricole> listeDesMagasinsComboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculerQuantiteDeStockDeMagasin window = new calculerQuantiteDeStockDeMagasin();
					window.calculerQuantiteStockMagasinFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public calculerQuantiteDeStockDeMagasin() {
		initialize();
	}

	private void initialize() {
		calculerQuantiteStockMagasinFrame = new JFrame("Calculer la quantité de stock de magasin");
		calculerQuantiteStockMagasinFrame.setBackground(Color.WHITE);
		calculerQuantiteStockMagasinFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		calculerQuantiteStockMagasinFrame.getContentPane().setForeground(Color.BLACK);
		calculerQuantiteStockMagasinFrame.getContentPane().setBackground(Color.WHITE);
		calculerQuantiteStockMagasinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		calculerQuantiteStockMagasinFrame.setType(Type.POPUP);
		calculerQuantiteStockMagasinFrame.setAutoRequestFocus(true);
		calculerQuantiteStockMagasinFrame.setUndecorated(false);
		calculerQuantiteStockMagasinFrame.setEnabled(true);
		calculerQuantiteStockMagasinFrame.getContentPane().setLayout(null);
		calculerQuantiteStockMagasinFrame.setVisible(true);
		calculerQuantiteStockMagasinFrame.setSize(1000, 800);
		calculerQuantiteStockMagasinFrame.setResizable(true);
		calculerQuantiteStockMagasinFrame.setLocationRelativeTo(null);
		calculerQuantiteStockMagasinFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		calculerQuantiteStockMagasinFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		calculerQuantiteStockMagasinFrame.requestFocusInWindow();
		
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
		
		resultatCalculeQuantiteStockLabel = new JLabel("");
		resultatCalculeQuantiteStockLabel.setBounds(405, 62, 294, 34);
		resultatCalculeQuantiteStockLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultatCalculeQuantiteStockLabel.setForeground(new Color(41, 178, 73));
		resultatCalculeQuantiteStockLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatCalculeQuantiteStockLabel.setBackground(Color.WHITE);
		entetePanel.add(resultatCalculeQuantiteStockLabel);
		
		menuButton = new JButton("CALCULER LA QUANTITE DE STOCK DANS LA MAGASIN");
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
		activeLigneLabel.setBounds(348, 125, 369, 11);
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
		bgImagelabel.setIcon(new ImageIcon(calculerQuantiteDeStockDeMagasin.class.getResource("/images/creerProduitAgricoleNonVide.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		formCalculerQuantiteStockPanel = new JPanel();
		formCalculerQuantiteStockPanel.setBackground(Color.WHITE);
		formCalculerQuantiteStockPanel.setBounds(474, 1, 503, 569);
		bodyPanel.add(formCalculerQuantiteStockPanel);
		formCalculerQuantiteStockPanel.setLayout(null);
		
		listeDesMagasinsLabel = new JLabel("MAGASIN");
		listeDesMagasinsLabel.setForeground(new Color(0, 0, 51));
		listeDesMagasinsLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesMagasinsLabel.setBackground(Color.WHITE);
		listeDesMagasinsLabel.setBounds(131, 0, 283, 41);
		formCalculerQuantiteStockPanel.add(listeDesMagasinsLabel);
		
		listeDesMagasinsComboBox = new JComboBox<MagasinProduitAgricole>();
		listeDesMagasinsComboBox.setEditable(false);
		listeDesMagasinsComboBox.setEnabled(true);
		listeDesMagasinsComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesMagasinsComboBox.setBackground(Color.WHITE);
		listeDesMagasinsComboBox.setBounds(131, 39, 283, 41);
		listeDesMagasinsComboBox.setForeground(new Color(102, 102, 102));
		formCalculerQuantiteStockPanel.add(listeDesMagasinsComboBox);
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
		
		calculerQuantiteStockButton = new JButton("CALCULER LA QUANTITE DE STOCK");
		calculerQuantiteStockButton.setFont(new Font("Dialog", Font.BOLD, 12));
		calculerQuantiteStockButton.setFocusable(false);
		calculerQuantiteStockButton.setEnabled(true);
		calculerQuantiteStockButton.setContentAreaFilled(true);
		calculerQuantiteStockButton.setBorder(null);
		calculerQuantiteStockButton.setBounds(131, 134, 283, 51);
		formCalculerQuantiteStockPanel.add(calculerQuantiteStockButton);
		calculerQuantiteStockButton.setForeground(Color.WHITE);
		calculerQuantiteStockButton.setHorizontalAlignment(SwingConstants.CENTER);
		calculerQuantiteStockButton.setBackground(new Color(41, 178, 73));
		calculerQuantiteStockButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		calculerQuantiteStockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculerQuantiteStock();
				calculerQuantiteStockMagasinFrame.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(calculerQuantiteStockMagasinFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	calculerQuantiteStockMagasinFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirComboParListeDesMagasins() {
		for(MagasinProduitAgricole listeMa : creerMagasinProduitAgricoleNonVide.getListeDesMagasins()) {
			listeDesMagasinsComboBox.addItem(listeMa);
		}
	}
	
	public void calculerQuantiteStock() {
		MagasinProduitAgricole selectedMagasin = (MagasinProduitAgricole) listeDesMagasinsComboBox.getSelectedItem();
		float qteStock = 0;
		
		for(MagasinProduitAgricole listeMa : creerMagasinProduitAgricoleNonVide.getListeDesMagasins()) {
			if(listeMa == selectedMagasin) {
				qteStock = listeMa.calculStock();
				break;
			}
		}
		
		resultatCalculeQuantiteStockLabel.setText(qteStock + " produit(s) de type fruit trouvé(s).");
		
		Timer t = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatCalculeQuantiteStockLabel.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(calculerQuantiteStockMagasinFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	calculerQuantiteStockMagasinFrame.dispose();
			new menuGestionAvances();
	    }
	}

}
