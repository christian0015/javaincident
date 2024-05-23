import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationFrame extends JFrame{
    public ApplicationFrame(){
    //public static void main(String[] args) {
        // Création de la JFrame principale
        JFrame applicationFrame = new JFrame("Gestion de Serveur");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Récuperation de la taille de l'écran avec Toolkit
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        applicationFrame.setSize(width, height);

        // Pourcentage de largeurs (20%, 15%, 60%) des panels
        //int sidePanelWidth = (int) (width * 0.2);
        int smallSidePanelWidth = (int) (width * 0.15);
        int middlePanelWidth = (int) (width * 0.6);
        int panelHeight = height;

        // Création des panels, Coul667071 Coul230 & 200 sont mes équivalences en hexadécimales
        JPanel upPanel = new JPanel();
        //Color Coul667071 = new Color(66, 70, 71);
        Color Coul667071 = new Color(20, 200, 220);
        upPanel.setBackground(Coul667071);
        upPanel.setPreferredSize(new Dimension(width, 50));

        JPanel leftPanel = new JPanel();
        Color Coul200 = new Color(200, 200, 200);
        leftPanel.setBackground(Coul200);
        leftPanel.setPreferredSize(new Dimension(smallSidePanelWidth, panelHeight));

        JPanel middlePanel = new JPanel();
        Color Coul230 = new Color(230, 230, 230);
        middlePanel.setBackground(Coul230);
        middlePanel.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Coul200);
        rightPanel.setPreferredSize(new Dimension(smallSidePanelWidth, panelHeight));

        // Attrubutions par Ajout des panels à la JFrame principale
        applicationFrame.getContentPane().setLayout(new BorderLayout());
        applicationFrame.getContentPane().add(upPanel, BorderLayout.NORTH);
        applicationFrame.getContentPane().add(leftPanel, BorderLayout.WEST);
        applicationFrame.getContentPane().add(middlePanel, BorderLayout.CENTER);
        applicationFrame.getContentPane().add(rightPanel, BorderLayout.EAST);


        //**************     U P  P A N E L *************
        // Path du Logo,
        ImageIcon logoIcon = new ImageIcon("src\\asset/serverLogo2.png"); // Spécifiez le chemin de votre image ici
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setPreferredSize(new Dimension(40, 40)); // Définir la taille de l'image à 40x40 pixels
        // Nom de l'application
        JLabel textLabel = new JLabel("Gestion de Serveur");
        textLabel.setForeground(Color.WHITE); // Couleur du texte
        // Contenair logo et nom_App
        JPanel logoTextPanel = new JPanel();
        logoTextPanel.setBackground(new Color(66, 70, 71)); // Couleur de fond du panel
        logoTextPanel.add(logoLabel);
        logoTextPanel.add(textLabel);
        logoTextPanel.setPreferredSize(new Dimension(width, 40));

        //********* E S P A C E  C O M P T E *******************
        // Path IcoImage dans un bouton
        ImageIcon iconButtonCompte = new ImageIcon("src\\asset/profile.png");
        Image imgButtonCompte = iconButtonCompte.getImage();
        Image newImgButtonCompte = imgButtonCompte.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonCompte = new ImageIcon(newImgButtonCompte);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonCompte = new JButton("", iconButtonCompte);
        //buttonCompte.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonCompte.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonCompte.setPreferredSize(new Dimension(width/25, 40));
        //buttonCompte.setBackground(Coul667071);

        // Ajout des panels à upPanel
        upPanel.setLayout(new BorderLayout());
        upPanel.add(logoTextPanel, BorderLayout.WEST);
        upPanel.add(buttonCompte, BorderLayout.EAST);


        //************ L e f t  P a n e l ********************

        // Boutons des Navigation avec des icônes Img
        // Path IcoImage dans un bouton(Lien de l'image)
        ImageIcon iconButtonAcceuil = new ImageIcon("src\\asset/logoHome.png");
        Image imgButtonAcceuil = iconButtonAcceuil.getImage(); //Recuperer l'image par le lieniconButtonAcceuil et la stocker dans "imgButtonAcceuil
        Image newImgButtonAcceuil = imgButtonAcceuil.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);// Taille Image
        iconButtonAcceuil = new ImageIcon(newImgButtonAcceuil); //Recuperer l'image et re-stocker dans iconButtonAcceuil qui devient une image et non un lien

        // Bouton à partit de l'icône redimensionnée
        JButton buttonAcceuil = new JButton("Accueil", iconButtonAcceuil); // Ajouter l'image à coté du texte du boutton
        //buttonAcceuil.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonAcceuil.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAcceuil.setPreferredSize(new Dimension(width/9, 40));
        buttonAcceuil.setBackground(Coul200);
        leftPanel.add(buttonAcceuil); // LeftPanel est un JPanel quelconque ou je souhaite placer le button  

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons

        // Path IcoImage dans un bouton
        ImageIcon iconButtonServeurList = new ImageIcon("src\\asset/statut.png");
        Image imgServeurList = iconButtonServeurList.getImage();
        Image newImgServeurList = imgServeurList.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonServeurList = new ImageIcon(newImgServeurList);

        // Bouton à partit de l'icône redimensionnée
        JButton buttonServeurList = new JButton("Incidence Statut", iconButtonServeurList);
        //buttonServeurList.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonServeurList.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonServeurList.setPreferredSize(new Dimension(width/9, 40));
        buttonServeurList.setBackground(Coul200);
        leftPanel.add(buttonServeurList);

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons


        // Path IcoImage dans un bouton
        ImageIcon iconButtonPersonnelle = new ImageIcon("src\\asset/personnel2.png");
        Image imgButtonPersonnelle = iconButtonPersonnelle.getImage();
        Image newImgButtonPersonnelle = imgButtonPersonnelle.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonPersonnelle = new ImageIcon(newImgButtonPersonnelle);

        // Bouton à partit de l'icône redimensionnée
        JButton buttonPersonnelle = new JButton("Personnels", iconButtonPersonnelle);
        //buttonPersonnelle.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonPersonnelle.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonPersonnelle.setPreferredSize(new Dimension(width/9, 40));
        buttonPersonnelle.setBackground(Coul200);
        leftPanel.add(buttonPersonnelle);

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons


        // Path IcoImage dans un bouton
        ImageIcon iconButtonDepannage = new ImageIcon("src\\asset/depannage.png");
        Image imgButtonDepannage = iconButtonDepannage.getImage();
        Image newImgButtonDepannage = imgButtonDepannage.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonDepannage = new ImageIcon(newImgButtonDepannage);

        // Bouton à partit de l'icône redimensionnée
        JButton buttonDepannage = new JButton("Dépanner", iconButtonDepannage);
        //buttonDepannage.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonDepannage.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonDepannage.setPreferredSize(new Dimension(width/9, 40));
        buttonDepannage.setBackground(Coul200);
        leftPanel.add(buttonDepannage);

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons


        // Path IcoImage dans un bouton
        ImageIcon iconButtonSetting = new ImageIcon("src\\asset/setting.png");
        Image imgButtonSetting = iconButtonSetting.getImage();
        Image newImgButtonSetting = imgButtonSetting.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonSetting = new ImageIcon(newImgButtonSetting);

        // Bouton à partit de l'icône redimensionnée
        JButton buttonSetting = new JButton("Parametre", iconButtonSetting);
        //buttonSetting.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonSetting.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonSetting.setPreferredSize(new Dimension(width/9, 40));
        buttonSetting.setBackground(Coul200);
        leftPanel.add(buttonSetting);

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons


        // Path IcoImage dans un bouton
        ImageIcon iconButtonProfile = new ImageIcon("src\\asset/profile.png");
        Image imgButtonProfile = iconButtonProfile.getImage();
        Image newImgButtonProfile = imgButtonProfile.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonProfile = new ImageIcon(newImgButtonProfile);

        // Bouton à partit de l'icône redimensionnée
        JButton buttonProfile = new JButton("Profil", iconButtonProfile);
        //buttonProfile.setVerticalTextPosition(SwingConstants.LEFT); // Texte à gauche de l'icône
        buttonProfile.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonProfile.setPreferredSize(new Dimension(width/9, 40));
        buttonProfile.setBackground(Coul200);
        leftPanel.add(buttonProfile);

        //Espacement entre element du menu
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Espacement entre les boutons

        /*
        JButton button2 = new JButton("Profil");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT); // Alignement au centre horizontalement
        ImageIcon icon2 = new ImageIcon("asset/profile.png");
        
        button2.setIcon(icon2);
        button2.setVerticalTextPosition(SwingConstants.BOTTOM); // Texte en bas de l'icône
        button2.setHorizontalTextPosition(SwingConstants.CENTER); // Texte centré horizontalement
        button2.setPreferredSize(new Dimension(width*1/9, 40));
        leftPanel.add(button2);

        //Espacement entre element du menu
     leftPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Espacement entre les boutons
         */



        //*********** M I D D L E  P A N N E L ***************
        // Création des panneaux à middlePanel

        PanelAcceuil panelAcceuil = new PanelAcceuil();

        PanelStatut PanelStatut = new PanelStatut();

        PanelPersonnel PanelPersonnel = new PanelPersonnel();

        PanelDepannage PanelDepannage = new PanelDepannage();



        PanelProfil PanelProfil = new PanelProfil();
        PanelParametre PanelParametre = new PanelParametre();


        // L'Ajout des Panels à middlePanel avec CardLayout(special Manage Event, gérer l'affichage des panneaux)
        middlePanel.setLayout(new CardLayout()); //CardLayout gére l'affichage des panneaux
        middlePanel.add(panelAcceuil, "PanelContenairAcceuil");
        middlePanel.add(PanelStatut, "PanelContenairServeurStatut");
        middlePanel.add(PanelPersonnel, "PanelContenairPersonnels");
        middlePanel.add(PanelDepannage, "PanelContenairDepannage");
        middlePanel.add(PanelParametre, "PanelContenairParametre");
        middlePanel.add(PanelProfil, "PanelContenairProfil");


        //********** A J O U T  L I S T E N E R ( ACTION EVENT [Only_Click] )

        // ActionListener pour buttonAcceuil
        buttonAcceuil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelAcceuil.setVisible(true);
                PanelStatut.setVisible(false);
                PanelPersonnel.setVisible(false);
                PanelDepannage.setVisible(false);
                PanelParametre.setVisible(false);
                PanelProfil.setVisible(false);
            }
        });

        // ActionListener pour buttonServeurList //buttonServeurStatut
        buttonServeurList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelStatut.setVisible(true);
                panelAcceuil.setVisible(false);
                panelAcceuil.setVisible(false);
                PanelPersonnel.setVisible(false);
                PanelDepannage.setVisible(false);
                PanelParametre.setVisible(false);
                PanelProfil.setVisible(false);
            }
        });

        // ActionListener pour buttonPersonnelle
        buttonPersonnelle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelPersonnel.setVisible(true);
                panelAcceuil.setVisible(false);
                panelAcceuil.setVisible(false);
                PanelStatut.setVisible(false);
                PanelDepannage.setVisible(false);
                PanelParametre.setVisible(false);
                PanelProfil.setVisible(false);
            }
        });

        // ActionListener pour buttonDepannage
        buttonDepannage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelDepannage.setVisible(true);
                panelAcceuil.setVisible(false);
                PanelStatut.setVisible(false);
                PanelPersonnel.setVisible(false);
                PanelParametre.setVisible(false);
                PanelProfil.setVisible(false);
            }
        });

        // ActionListener pour buttonSetting
        buttonSetting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelParametre.setVisible(true);
                panelAcceuil.setVisible(false);
                PanelStatut.setVisible(false);
                PanelPersonnel.setVisible(false);
                PanelDepannage.setVisible(false);
                PanelProfil.setVisible(false);
            }
        });

        // ActionListener pour buttonProfile
        buttonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelProfil.setVisible(true);
                panelAcceuil.setVisible(false);
                PanelStatut.setVisible(false);
                PanelPersonnel.setVisible(false);
                PanelDepannage.setVisible(false);
                PanelParametre.setVisible(false);
            }
        });

        // Affichage de la JFrame principale
        applicationFrame.setVisible(true);
    }
}
