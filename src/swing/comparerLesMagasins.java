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

public class comparerLesMagasins {

	private JFrame comparerLesMagasinsFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, formComparerLesMagasinsPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, resultatComparerLesMagasinsLabel, activeLigneLabel, bgImagelabel, listeDesMagasins1Label,
				   listeDesMagasins2Label;
	private JButton menuButton, comparerLesMagasinsButton;
	private JComboBox<Magasin> listeDesMagasins1ComboBox, listeDesMagasins2ComboBox;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comparerLesMagasins window = new comparerLesMagasins();
					window.comparerLesMagasinsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public comparerLesMagasins() {
		initialize();
	}

	private void initialize() {
		comparerLesMagasinsFrame = new JFrame("Comparer les magasins");
		comparerLesMagasinsFrame.setBackground(Color.WHITE);
		comparerLesMagasinsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		comparerLesMagasinsFrame.getContentPane().setForeground(Color.BLACK);
		comparerLesMagasinsFrame.getContentPane().setBackground(Color.WHITE);
		comparerLesMagasinsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		comparerLesMagasinsFrame.setType(Type.POPUP);
		comparerLesMagasinsFrame.setAutoRequestFocus(true);
		comparerLesMagasinsFrame.setUndecorated(false);
		comparerLesMagasinsFrame.setEnabled(true);
		comparerLesMagasinsFrame.getContentPane().setLayout(null);
		comparerLesMagasinsFrame.setVisible(true);
		comparerLesMagasinsFrame.setSize(1000, 800);
		comparerLesMagasinsFrame.setResizable(true);
		comparerLesMagasinsFrame.setLocationRelativeTo(null);
		comparerLesMagasinsFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		comparerLesMagasinsFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		comparerLesMagasinsFrame.requestFocusInWindow();
		
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
		
		resultatComparerLesMagasinsLabel = new JLabel("");
		resultatComparerLesMagasinsLabel.setBounds(383, 62, 406, 34);
		resultatComparerLesMagasinsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultatComparerLesMagasinsLabel.setForeground(new Color(41, 178, 73));
		resultatComparerLesMagasinsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		resultatComparerLesMagasinsLabel.setBackground(Color.WHITE);
		entetePanel.add(resultatComparerLesMagasinsLabel);
		
		menuButton = new JButton("COMPARER DES MAGASINS");
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
		bgImagelabel.setIcon(new ImageIcon(comparerLesMagasins.class.getResource("/images/comparerProduit1.png")));
		bgImagelabel.setBounds(0, 0, 430, 523);
		backgroundImagePanel.add(bgImagelabel);
		
		formComparerLesMagasinsPanel = new JPanel();
		formComparerLesMagasinsPanel.setBackground(Color.WHITE);
		formComparerLesMagasinsPanel.setBounds(450, 11, 534, 559);
		bodyPanel.add(formComparerLesMagasinsPanel);
		formComparerLesMagasinsPanel.setLayout(null);
		
		listeDesMagasins1Label = new JLabel("MAGASIN 1");
		listeDesMagasins1Label.setForeground(new Color(0, 0, 51));
		listeDesMagasins1Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesMagasins1Label.setBackground(Color.WHITE);
		listeDesMagasins1Label.setBounds(0, 153, 220, 41);
		formComparerLesMagasinsPanel.add(listeDesMagasins1Label);
		
		listeDesMagasins1ComboBox = new JComboBox<Magasin>();
		listeDesMagasins1ComboBox.setEditable(false);
		listeDesMagasins1ComboBox.setEnabled(true);
		listeDesMagasins1ComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesMagasins1ComboBox.setBackground(Color.WHITE);
		listeDesMagasins1ComboBox.setBounds(0, 194, 220, 41);
		listeDesMagasins1ComboBox.setForeground(new Color(102, 102, 102));
		formComparerLesMagasinsPanel.add(listeDesMagasins1ComboBox);
		listeDesMagasins1ComboBox.setMaximumRowCount(20);
		listeDesMagasins1ComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		listeDesMagasins1ComboBox.setUI(new BasicComboBoxUI() {
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
		
		listeDesMagasins2Label = new JLabel("MAGASIN 2");
		listeDesMagasins2Label.setForeground(new Color(0, 0, 51));
		listeDesMagasins2Label.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		listeDesMagasins2Label.setBackground(Color.WHITE);
		listeDesMagasins2Label.setBounds(270, 153, 220, 41);
		formComparerLesMagasinsPanel.add(listeDesMagasins2Label);
		
		listeDesMagasins2ComboBox = new JComboBox<Magasin>();
		listeDesMagasins2ComboBox.setEditable(false);
		listeDesMagasins2ComboBox.setEnabled(true);
		listeDesMagasins2ComboBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		listeDesMagasins2ComboBox.setBackground(Color.WHITE);
		listeDesMagasins2ComboBox.setBounds(270, 194, 220, 41);
		listeDesMagasins2ComboBox.setForeground(new Color(102, 102, 102));
		formComparerLesMagasinsPanel.add(listeDesMagasins2ComboBox);
		listeDesMagasins2ComboBox.setMaximumRowCount(20);
		listeDesMagasins2ComboBox.setBorder(new LineBorder(Color.GRAY, 1));
		listeDesMagasins2ComboBox.setUI(new BasicComboBoxUI() {
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
		
		comparerLesMagasinsButton = new JButton("COMPARER LES MAGASINS");
		comparerLesMagasinsButton.setFont(new Font("Dialog", Font.BOLD, 12));
		comparerLesMagasinsButton.setFocusable(false);
		comparerLesMagasinsButton.setEnabled(true);
		comparerLesMagasinsButton.setContentAreaFilled(true);
		comparerLesMagasinsButton.setBorder(null);
		comparerLesMagasinsButton.setBounds(111, 263, 283, 51);
		formComparerLesMagasinsPanel.add(comparerLesMagasinsButton);
		comparerLesMagasinsButton.setForeground(Color.WHITE);
		comparerLesMagasinsButton.setHorizontalAlignment(SwingConstants.CENTER);
		comparerLesMagasinsButton.setBackground(new Color(41, 178, 73));
		comparerLesMagasinsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		comparerLesMagasinsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comparerDeuxMagasins();			
				formComparerLesMagasinsPanel.requestFocusInWindow();
			}
		});
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesMagasinsFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesMagasinsFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void remplirComboParListeDesMagasins() {
		for(Magasin listeMa : menuGestionMagasin.getListeDesMagasins()) {
			listeDesMagasins1ComboBox.addItem(listeMa);
			listeDesMagasins2ComboBox.addItem(listeMa);
		}
	}
	
	public void comparerDeuxMagasins() {
		Magasin selectedMagasin1 = (Magasin) listeDesMagasins1ComboBox.getSelectedItem();
		Magasin selectedMagasin2 = (Magasin) listeDesMagasins2ComboBox.getSelectedItem();
		
		resultatComparerLesMagasinsLabel.setText(Magasin.comparerDeuxMagasins(selectedMagasin1, selectedMagasin2));
		
		Timer t = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resultatComparerLesMagasinsLabel.setText(null);
            }
        });
        t.setRepeats(false);
        t.start();
        
        retourAuMenu();
	}
	
	public void retourAuMenu() {
		int dialog = JOptionPane.showConfirmDialog(comparerLesMagasinsFrame,"Retour au menu pricipale ?", "Retour",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	comparerLesMagasinsFrame.dispose();
			new menuGestionMagasin();
	    }
	}
}
