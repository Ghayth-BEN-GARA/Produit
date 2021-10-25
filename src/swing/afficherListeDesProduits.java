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
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class afficherListeDesProduits {

	private JFrame afficherLesProduitsFrame;
	private JPanel generalFramePanel, entetePanel, bodyPanel, listeDesProduitsPanel;
	private JLabel infoLabel, logoutLabel, photoProfilLabel, nomPrenomLabel, metierLabel, etudiantLabel, villeLabel, activeLigneLabel, retourAuMenuGestionDesProduitsLabel;
	private JButton menuButton;
	private JTextPane afficherListeDesProduitsTextPane;
	private JScrollPane afficherListeDesProduitsScrollPane;
	private StyledDocument documentStyledDocument;
	private SimpleAttributeSet centerSimpleAttributeSet;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afficherListeDesProduits window = new afficherListeDesProduits();
					window.afficherLesProduitsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public afficherListeDesProduits() {
		initialize();
	}

	private void initialize() {
		afficherLesProduitsFrame = new JFrame("Afficher la liste des produits");
		afficherLesProduitsFrame.setBackground(Color.WHITE);
		afficherLesProduitsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(menuApplication.class.getResource("/images/gestion.png")));
		afficherLesProduitsFrame.getContentPane().setForeground(Color.BLACK);
		afficherLesProduitsFrame.getContentPane().setBackground(Color.WHITE);
		afficherLesProduitsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		afficherLesProduitsFrame.setType(Type.POPUP);
		afficherLesProduitsFrame.setAutoRequestFocus(false);
		afficherLesProduitsFrame.setUndecorated(false);
		afficherLesProduitsFrame.setEnabled(true);
		afficherLesProduitsFrame.getContentPane().setLayout(null);
		afficherLesProduitsFrame.setVisible(true);
		afficherLesProduitsFrame.setSize(1000, 800);
		afficherLesProduitsFrame.setResizable(true);
		afficherLesProduitsFrame.setLocationRelativeTo(null);
		afficherLesProduitsFrame.setPreferredSize(new Dimension(1000, 1300));
		
		generalFramePanel = new JPanel();
		generalFramePanel.setBackground(Color.WHITE);
		generalFramePanel.setBounds(0, 0, 984, 749);
		afficherLesProduitsFrame.getContentPane().add(generalFramePanel);
		generalFramePanel.setLayout(null);
		afficherLesProduitsFrame.requestFocusInWindow();
		
		entetePanel = new JPanel();
		entetePanel.setBackground(Color.WHITE);
		entetePanel.setBounds(0, 0, 984, 193);
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
			
		menuButton = new JButton("LISTE DES PRODUITS");
		menuButton.setForeground(Color.BLACK);
		menuButton.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(406, 147, 263, 23);
		menuButton.setBorder(null);
		menuButton.setContentAreaFilled(false);
		menuButton.setFocusable(false);
		menuButton.setMaximumSize(new Dimension(117, 25));
		menuButton.setMinimumSize(new Dimension(117, 25));
		menuButton.setPreferredSize(new Dimension(117,  25));
		menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		entetePanel.add(menuButton);
		
		activeLigneLabel = new JLabel();
		activeLigneLabel.setBounds(472, 171, 132, 11);
		entetePanel.add(activeLigneLabel);
		activeLigneLabel.setBackground(new Color(41, 178, 73));
		activeLigneLabel.setOpaque(true);
		
		bodyPanel = new JPanel();
		bodyPanel.setBackground(Color.WHITE);
		bodyPanel.setBorder(null);
		bodyPanel.setBounds(0, 204, 1345, 673);
		bodyPanel.setBorder(null);
		generalFramePanel.add(bodyPanel);
		bodyPanel.setLayout(null);
		
		retourAuMenuGestionDesProduitsLabel = new JLabel("");
		retourAuMenuGestionDesProduitsLabel.setBounds(471, 0, 134, 64);
		bodyPanel.add(retourAuMenuGestionDesProduitsLabel);
		retourAuMenuGestionDesProduitsLabel.setIcon(new ImageIcon(afficherListeDesProduits.class.getResource("/images/exit.png")));
		retourAuMenuGestionDesProduitsLabel.setBackground(Color.WHITE);
		retourAuMenuGestionDesProduitsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		retourAuMenuGestionDesProduitsLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		retourAuMenuGestionDesProduitsLabel.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e)  {  
		    	afficherLesProduitsFrame.dispose();
				new menuGestionProduit();
		    }  
		});
		
		listeDesProduitsPanel = new JPanel();
		listeDesProduitsPanel.setBackground(Color.WHITE);
		listeDesProduitsPanel.setBounds(10, 74, 972, 466);
		bodyPanel.add(listeDesProduitsPanel);
		listeDesProduitsPanel.setLayout(null);
		
		afficherListeDesProduitsScrollPane = new JScrollPane();
		afficherListeDesProduitsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		afficherListeDesProduitsScrollPane.setBounds(10, 11, 952, 374);
		afficherListeDesProduitsScrollPane.setBorder(null);
		listeDesProduitsPanel.add(afficherListeDesProduitsScrollPane);
		
		afficherListeDesProduitsTextPane = new JTextPane();
		afficherListeDesProduitsScrollPane.setViewportView(afficherListeDesProduitsTextPane);
		afficherListeDesProduitsTextPane.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		afficherListeDesProduitsTextPane.setBackground(Color.WHITE);
		afficherListeDesProduitsTextPane.setForeground(new Color(0, 0, 51));
		afficherListeDesProduitsTextPane.setEditable(false);
		afficherListeDesProduitsTextPane.setFocusable(false);
		afficherListeDesProduitsTextPane.setEnabled(true);
		afficherListeDesProduitsTextPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
		afficherListeDesProduitsTextPane.setText("");
		afficherListeDesProduitsTextPane.setBorder(null);
		documentStyledDocument = afficherListeDesProduitsTextPane.getStyledDocument();
		centerSimpleAttributeSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerSimpleAttributeSet, StyleConstants.ALIGN_CENTER);
		documentStyledDocument.setParagraphAttributes(0, documentStyledDocument.getLength(), centerSimpleAttributeSet, false);
		afficherListeDesProduitsAlimentaires();			
	}
	
	public void deconnexion() {
		int dialog = JOptionPane.showConfirmDialog(afficherLesProduitsFrame,"Vous êtes sur de quitter votre session ?", "Déconnexion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if(dialog == JOptionPane.YES_OPTION){
	    	afficherLesProduitsFrame.dispose();
			new loginToApplication();
	    }
	}
	
	public void afficherListeDesProduitsAlimentaires() {
		afficherListeDesProduitsTextPane.setText(menuGestionProduit.getListeDesProduits().toString());
	}
}
