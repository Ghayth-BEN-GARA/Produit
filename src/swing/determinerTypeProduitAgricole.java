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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class determinerTypeProduitAgricole {

	private JFrame determinerTypeProduitFrame;
	private JScrollPane generalFrameScrollPane, afficherDeterminationTypeProduitAgricoleScrollPane;
	private JPanel generalFramePanel, entetePanel, bodyPanel, backgroundImagePanel, determinerTypeProduitPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, retourAuMenuGestionDesProduitsLabel, activeLigneLabel, bgImagelabel, 
				   imageDeterminerTypeProduitAgricoleLabel;
	private JButton menuButton;
	private JTextPane afficherDeterminationTypeProduitAgricoleTextPane;
	private StyledDocument documentStyledDocument;
	private SimpleAttributeSet centerSimpleAttributeSet;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					determinerTypeProduitAgricole window = new determinerTypeProduitAgricole();
					window.determinerTypeProduitFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public determinerTypeProduitAgricole() {
		initialize();
	}

	private void initialize() {
		determinerTypeProduitFrame = new JFrame("Déterminer le type des produits agricoles crées");
		determinerTypeProduitFrame.setBackground(Color.WHITE);
		determinerTypeProduitFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		determinerTypeProduitFrame.getContentPane().setForeground(Color.BLACK);
		determinerTypeProduitFrame.getContentPane().setBackground(Color.WHITE);
		determinerTypeProduitFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		determinerTypeProduitFrame.setType(Type.POPUP);
		determinerTypeProduitFrame.setAutoRequestFocus(true);
		determinerTypeProduitFrame.setUndecorated(false);
		determinerTypeProduitFrame.setEnabled(true);
		determinerTypeProduitFrame.getContentPane().setLayout(null);
		determinerTypeProduitFrame.setVisible(true);
		determinerTypeProduitFrame.setSize(1000, 900);
		determinerTypeProduitFrame.setResizable(true);
		determinerTypeProduitFrame.setLocationRelativeTo(null);
		determinerTypeProduitFrame.setMinimumSize(new Dimension(1000, 1500));
		
		generalFrameScrollPane = new JScrollPane();
		generalFrameScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		generalFrameScrollPane.setBounds(0, 0, 985, 800);
		
		generalFramePanel = new JPanel();
		generalFrameScrollPane.setViewportView(generalFramePanel);
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setPreferredSize(new Dimension(1000, 900));
		generalFramePanel.setSize(1000, 900);
		generalFramePanel.setBorder(null);
		generalFramePanel.setLayout(null);
		
		determinerTypeProduitFrame.getContentPane().add(generalFrameScrollPane);
		determinerTypeProduitFrame.setVisible(true);
		determinerTypeProduitFrame.requestFocusInWindow();
		
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
		
		retourAuMenuGestionDesProduitsLabel = new JLabel("");
		retourAuMenuGestionDesProduitsLabel.setBounds(827, 74, 134, 64);
		entetePanel.add(retourAuMenuGestionDesProduitsLabel);
		retourAuMenuGestionDesProduitsLabel.setIcon(new ImageIcon(afficherListeDesProduits.class.getResource("/images/exit.png")));
		retourAuMenuGestionDesProduitsLabel.setBackground(Color.WHITE);
		retourAuMenuGestionDesProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		retourAuMenuGestionDesProduitsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		retourAuMenuGestionDesProduitsLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  {  
		    	determinerTypeProduitFrame.dispose();
				new menuGestionAvances();
		    }  
		});
		
		menuButton = new JButton("DETERMINER LE TYPE DES PRODUITS AGRICLES");
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
		bgImagelabel.setIcon(new ImageIcon(determinerTypeProduitAgricole.class.getResource("/images/typeBackground.jpg")));
		bgImagelabel.setBounds(0, 0, 430, 625);
		backgroundImagePanel.add(bgImagelabel);
		
		determinerTypeProduitPanel = new JPanel();
		determinerTypeProduitPanel.setBackground(Color.WHITE);
		determinerTypeProduitPanel.setBounds(474, 1, 500, 634);
		bodyPanel.add(determinerTypeProduitPanel);
		determinerTypeProduitPanel.setLayout(null);
		
		imageDeterminerTypeProduitAgricoleLabel = new JLabel("");
		imageDeterminerTypeProduitAgricoleLabel.setBackground(Color.WHITE);
		imageDeterminerTypeProduitAgricoleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageDeterminerTypeProduitAgricoleLabel.setIcon(new ImageIcon(menuGestionAvances.class.getResource("/images/type.png")));
		imageDeterminerTypeProduitAgricoleLabel.setBounds(0, 0, 500, 125);
		determinerTypeProduitPanel.add(imageDeterminerTypeProduitAgricoleLabel);
		
		afficherDeterminationTypeProduitAgricoleScrollPane = new JScrollPane();
		afficherDeterminationTypeProduitAgricoleScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		afficherDeterminationTypeProduitAgricoleScrollPane.setBounds(10, 132, 480, 493);
		afficherDeterminationTypeProduitAgricoleScrollPane.setBorder(null);
		determinerTypeProduitPanel.add(afficherDeterminationTypeProduitAgricoleScrollPane);
		
		afficherDeterminationTypeProduitAgricoleTextPane = new JTextPane();
		afficherDeterminationTypeProduitAgricoleScrollPane.setViewportView(afficherDeterminationTypeProduitAgricoleTextPane);
		afficherDeterminationTypeProduitAgricoleTextPane.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		afficherDeterminationTypeProduitAgricoleTextPane.setBackground(Color.WHITE);
		afficherDeterminationTypeProduitAgricoleTextPane.setForeground(new Color(0, 0, 51));
		afficherDeterminationTypeProduitAgricoleTextPane.setEditable(false);
		afficherDeterminationTypeProduitAgricoleTextPane.setFocusable(false);
		afficherDeterminationTypeProduitAgricoleTextPane.setEnabled(true);
		afficherDeterminationTypeProduitAgricoleTextPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		afficherDeterminationTypeProduitAgricoleTextPane.setText("");
		afficherDeterminationTypeProduitAgricoleTextPane.setBorder(null);
		documentStyledDocument = afficherDeterminationTypeProduitAgricoleTextPane.getStyledDocument();
		centerSimpleAttributeSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerSimpleAttributeSet, StyleConstants.ALIGN_CENTER);
		documentStyledDocument.setParagraphAttributes(0, documentStyledDocument.getLength(), centerSimpleAttributeSet, false);
		determinerTypeProduit();
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(determinerTypeProduitFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	determinerTypeProduitFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void determinerTypeProduit() {
		afficherDeterminationTypeProduitAgricoleTextPane.setText(creerProduitAgricoleNonVide.getListeDesProduitsAgricoles().toString());
	}

}
