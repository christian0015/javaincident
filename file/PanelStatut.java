import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
//import org.jdesktop.swingx.border.DropShadowBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Vector;

import java.io.*;
import java.util.Collections;


public class PanelStatut extends JPanel {

    private DefaultTableModel tableModel;
    public JTable table;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;

    private JButton searchField;
    private JComboBox<String> sortComboBox;

    //private String valeurId;
    //private String valeurNom;
    //private String valeurPrenom;
    //private String valeurVille;
    //private String valeurPost;

    private static final String FILE_PATH = "dataIncidents.ser";  // Fichier pour stocker les données
    private static final String FILE_PATH_II = "dataIncidents.ser";  // Fichier pour stocker les données


    public PanelStatut() {

        // Récuperation de la taille de l'écran avec Toolkit
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Pourcentage de largeurs (20%, 15%, 60%) des panels
        //int sidePanelWidth = (int) (width * 0.2);
        int smallSidePanelWidth = (int) (width * 0.15);
        int middlePanelWidth = (int) (width * 0.7);
        int panelHeight = height;

        Color Coul200200220 = new Color(220, 220, 220);
        this.setBackground(Coul200200220);
        this.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        this.setVisible(false); // Initialisation à false

        JPanel entetePanelAcceuil = new JPanel();
        entetePanelAcceuil.setPreferredSize(new Dimension(middlePanelWidth, panelHeight*1/8));
        this.add(entetePanelAcceuil);

        // Crée un JLabel pour afficher l'image
        JLabel backgroundEntetePanelAcceuil = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src\\asset\\backroundStatutVerification.png");

        backgroundEntetePanelAcceuil.setIcon(imageIcon);
        //backgroundEntetePanelAcceuil.setBounds(0,0, middlePanelWidth, 100);
        entetePanelAcceuil.add(backgroundEntetePanelAcceuil);

        // Path IcoImage dans un bouton Code Incidence
        ImageIcon iconButtonCodeIncident = new ImageIcon("src\\asset/statut.png");
        Image imgCodeIncident = iconButtonCodeIncident.getImage();
        Image newImgCodeIncident = imgCodeIncident.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonCodeIncident = new ImageIcon(newImgCodeIncident);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonCodeIncident = new JButton("Code Couleur Incident", iconButtonCodeIncident);
        buttonCodeIncident.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonCodeIncident.setPreferredSize(new Dimension(width/9, 40));
        buttonCodeIncident.setBackground(Coul200200220);
        this.add(buttonCodeIncident);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons


        // Path IcoImage dans un bouton Affiche Incidence
        ImageIcon iconButtonAfficheIncident = new ImageIcon("src\\asset/statut.png");
        Image imgAfficheIncident = iconButtonAfficheIncident.getImage();
        Image newImgAfficheIncident = imgAfficheIncident.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonAfficheIncident = new ImageIcon(newImgAfficheIncident);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonAfficheIncident = new JButton("Afficher toutes", iconButtonAfficheIncident);
        buttonAfficheIncident.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAfficheIncident.setPreferredSize(new Dimension(width/9, 40));
        buttonAfficheIncident.setBackground(Coul200200220);
        this.add(buttonAfficheIncident);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Ajouter Incidence
        ImageIcon iconButtonAjouterIncident = new ImageIcon("src\\asset/statut.png");
        Image imgAjouterIncident = iconButtonAjouterIncident.getImage();
        Image newImgAjouterIncident = imgAjouterIncident.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonAjouterIncident = new ImageIcon(newImgAjouterIncident);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonAjouterIncident = new JButton("Ajouter", iconButtonAjouterIncident);
        buttonAjouterIncident.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAjouterIncident.setPreferredSize(new Dimension(width/9, 40));
        buttonAjouterIncident.setBackground(Coul200200220);
        this.add(buttonAjouterIncident);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Affiche Incidence
        ImageIcon iconButtonSupprimeIncident = new ImageIcon("src\\asset/statut.png");
        Image imgSupprimeIncident = iconButtonSupprimeIncident.getImage();
        Image newImgSupprimeIncident = imgSupprimeIncident.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonSupprimeIncident = new ImageIcon(newImgSupprimeIncident);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonSupprimeIncident = new JButton("Supprimer", iconButtonSupprimeIncident);
        buttonSupprimeIncident.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonSupprimeIncident.setPreferredSize(new Dimension(width/9, 40));
        buttonSupprimeIncident.setBackground(Coul200200220);
        this.add(buttonSupprimeIncident);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons


        //*********************** Code couleur Incidence *********************
        JPanel panelCodeIncidence= new JPanel();
        panelCodeIncidence.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelCodeIncidence.setBackground(Coul200200220);
        this.add(panelCodeIncidence);

        JLabel labelCodeCouleur1= new JLabel("Incidence legère");
        labelCodeCouleur1.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur2= new JLabel("Incidence moyen");
        labelCodeCouleur2.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur3= new JLabel("Incidence lourde");
        labelCodeCouleur3.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur4= new JLabel("Incidence Nécessaire");
        labelCodeCouleur4.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur5= new JLabel("Incidence Importante");
        labelCodeCouleur5.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur6= new JLabel("Incidence Urgente");
        labelCodeCouleur6.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));

        JPanel block01= new JPanel();
        block01.setPreferredSize(new Dimension(350, 70));
        Color Coul1691991999264 = new Color(130, 100, 100, 250);
        block01.setBackground(Coul1691991999264);
        panelCodeIncidence.add(block01);
        block01.add(labelCodeCouleur1);

        JPanel block02= new JPanel();
        block02.setPreferredSize(new Dimension(350, 70));
        Color Coul12015939a259 = new Color(120, 159, 39, 250);
        block02.setBackground(Coul12015939a259);
        panelCodeIncidence.add(block02);
        block02.add(labelCodeCouleur2);


        JPanel block03 = new JPanel(); // 20 est le rayon pour l'arrondi
        block03.setPreferredSize(new Dimension(350, 70));
        Color Coul200200220a106 = new Color(230, 120, 200, 250);
        block03.setBackground(Coul200200220a106);
        panelCodeIncidence.add(block03);
        block03.add(labelCodeCouleur3);

        JPanel block04= new JPanel();
        block04.setPreferredSize(new Dimension(350, 70));
        Color Coul406080256 = new Color(40, 160, 80, 250);
        block04.setBackground(Coul406080256);
        panelCodeIncidence.add(block04);
        block04.add(labelCodeCouleur4);

        JPanel block05= new JPanel();
        block05.setPreferredSize(new Dimension(350, 70));
        Color Coul1691991999265 = new Color(169, 0, 100, 250);
        block05.setBackground(Coul1691991999265);
        panelCodeIncidence.add(block05);
        block05.add(labelCodeCouleur5);

        JPanel block06= new JPanel();
        block06.setPreferredSize(new Dimension(350, 70));
        Color Coul21215944 = new Color(212, 59, 39, 250);
        block06.setBackground(Coul21215944);
        panelCodeIncidence.add(block06);
        block06.add(labelCodeCouleur6);


        // Création des données du tableau
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("ID Empoye");
        columnNames.add("ID Technicien");
        columnNames.add("Statut");
        columnNames.add("Titre");
        columnNames.add("Categorie");
        columnNames.add("Description");
        columnNames.add("Code Couleur");

        //Vector<Vector<String>> rowData = new Vector<>();
        Vector<Vector<String>> rowData = loadData();  // Charger les données du fichier
        // Ajoutez vos données ici, par exemple :




        // Ajout des boutons au panneau
        JPanel buttonPanel = new JPanel();

        this.add(buttonPanel, BorderLayout.NORTH);

        // Création du modèle de tableau
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // Ajouter le tableau à un JScrollPane pour permettre le défilement s'il y a beaucoup de lignes
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(750, 250));
        this.add(scrollPane);

        // Création du champ de recherche
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Rechercher");

        // Création de la liste déroulante pour le tri
        sortComboBox = new JComboBox<>(columnNames.toArray(new String[0]));
        sortComboBox.setSelectedIndex(0); // Sélectionnez le premier élément par défaut
        JButton sortButton = new JButton("Trier");

        // Ajout des composants de recherche et de tri au panneau
        JPanel searchSortPanel = new JPanel();
        searchSortPanel.add(new JLabel("Recherche: "));
        searchSortPanel.add(searchField);
        searchSortPanel.add(searchButton);
        searchSortPanel.add(new JLabel("Trier par: "));
        searchSortPanel.add(sortComboBox);
        searchSortPanel.add(sortButton);
        buttonPanel.add(searchSortPanel, BorderLayout.NORTH);

        // Initialiser le TableRowSorter pour le tri et la recherche
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);

        //************* Ajouter Une Incidence ************
        JPanel panelAjoutIncidence= new JPanel();
        panelAjoutIncidence.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelAjoutIncidence.setBackground(Coul200200220);
        this.add(panelAjoutIncidence);

        //JPanel block1= new JPanel();
        // Crée un JPanel arrondi
        RoundedPanel spaceIncidence1 = new RoundedPanel(20); // 20 est le rayon pour l'arrondi
        spaceIncidence1.setPreferredSize(new Dimension(700, 250));
        Color Coul13020200a250 = new Color(130, 20, 200, 250);
        spaceIncidence1.setBackground(Coul13020200a250);
        panelAjoutIncidence.add(spaceIncidence1);
        //
        JLabel LabelAjoutIncidentID = new JLabel("Entre le n° Incident\n: ");
        LabelAjoutIncidentID.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentID.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentID);
        //Saisie
        // Création et ajout du JComboBox
        JTextField SaisieIncidentID = new JTextField("1");
        SaisieIncidentID.setFont(new Font("Roboto", Font.BOLD, 14));
        SaisieIncidentID.setPreferredSize(new Dimension(200, 30));
        SaisieIncidentID.setForeground(Color.gray);
        spaceIncidence1.add(SaisieIncidentID);

        //Espacement entre element du menu
        spaceIncidence1.add(Box.createRigidArea(new Dimension(250, 0))); // Espacement entre les boutons

        JLabel LabelAjoutIncidentID_Personnel = new JLabel("Entre votre n° ID\n: ");
        LabelAjoutIncidentID_Personnel.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentID_Personnel.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentID_Personnel);
        //Saisie
        // Création et ajout du JComboBox
        JTextField SaisieIncidentID_Personnel = new JTextField("200");
        SaisieIncidentID_Personnel.setFont(new Font("Roboto", Font.BOLD, 14));
        SaisieIncidentID_Personnel.setPreferredSize(new Dimension(200, 30));
        SaisieIncidentID_Personnel.setForeground(Color.gray);
        spaceIncidence1.add(SaisieIncidentID_Personnel);
        spaceIncidence1.add(SaisieIncidentID_Personnel);

        //Espacement entre element du menu
        spaceIncidence1.add(Box.createRigidArea(new Dimension(200, 0))); // Espacement entre les boutons



        JLabel LabelAjoutIncidentCategorie = new JLabel("Entre la Categorie d'incidence\n: ");
        LabelAjoutIncidentCategorie.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentCategorie.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentCategorie);
        //Saisie
        // Création et ajout du JComboBox
        String[] valeursComboboxSaisieIncidentCategorie = {"Panne Materiel", "Informatique", "Technique", "Maintenace", "Fonctionnel", "Electricité", "Incendie"}; // Vos valeurs de liste
        JComboBox<String> comboboxSaisieIncidentCategorie = new JComboBox<>(valeursComboboxSaisieIncidentCategorie);
        comboboxSaisieIncidentCategorie.setFont(new Font("Roboto", Font.BOLD, 14));
        comboboxSaisieIncidentCategorie.setPreferredSize(new Dimension(250, 30));
        comboboxSaisieIncidentCategorie.setBackground(Color.DARK_GRAY);
        comboboxSaisieIncidentCategorie.setForeground(Color.WHITE);
        spaceIncidence1.add(comboboxSaisieIncidentCategorie);

        JLabel LabelAjoutIncidentTitre = new JLabel("De quelle incidence s'agit-il?\n: ");
        LabelAjoutIncidentTitre.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentTitre.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentTitre);
        //Saisie
        // Création et ajout du JComboBox
        String[] valeursComboboxSaisieIncidentTitre = {"Probleme de Reseaux", "Probleme logiciel", "Probleme Equipement", "Il faut une maintenace(mise à jour)", "Probleme d'alimentation Electricité", "Je ne comprends rien"}; // Vos valeurs de liste
        JComboBox<String> comboboxSaisieIncidentTitre = new JComboBox<>(valeursComboboxSaisieIncidentTitre);
        comboboxSaisieIncidentTitre.setFont(new Font("Roboto", Font.BOLD, 15));
        comboboxSaisieIncidentTitre.setPreferredSize(new Dimension(250, 30));
        comboboxSaisieIncidentTitre.setBackground(Color.DARK_GRAY);
        comboboxSaisieIncidentTitre.setForeground(Color.WHITE);
        spaceIncidence1.add(comboboxSaisieIncidentTitre);


        JLabel LabelAjoutIncidentDescription = new JLabel("Donne une breuve description\n: ");
        LabelAjoutIncidentDescription.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentDescription.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentDescription);
        //Saisie
        JTextField SaisieIncidentDescription = new JTextField("Ex: Depuis que la mis à jour... ");
        SaisieIncidentDescription.setFont(new Font("Roboto", Font.BOLD, 14));
        SaisieIncidentDescription.setPreferredSize(new Dimension(250, 60));
        SaisieIncidentDescription.setForeground(Color.gray);
        spaceIncidence1.add(SaisieIncidentDescription);

        //Espacement entre element du menu
        spaceIncidence1.add(Box.createRigidArea(new Dimension(100, 0))); // Espacement entre les boutons


        JLabel LabelAjoutIncidentCodeCouleur = new JLabel("Code Couleur\n: ");
        LabelAjoutIncidentCodeCouleur.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelAjoutIncidentCodeCouleur.setForeground(Color.WHITE);
        spaceIncidence1.add(LabelAjoutIncidentCodeCouleur);
        //Saisie
        // Création et ajout du JComboBox
        String[] valeursComboboxSaisieIncidentCodeCouleur = {"Marron", "Vert Militaire", "Rose", "Vert", "Violet", "Rouge"}; // Vos valeurs de liste
        JComboBox<String> comboboxSaisieIncidentCodeCouleur = new JComboBox<>(valeursComboboxSaisieIncidentCodeCouleur);
        comboboxSaisieIncidentCodeCouleur.setFont(new Font("Roboto", Font.BOLD, 15));
        comboboxSaisieIncidentCodeCouleur.setPreferredSize(new Dimension(250, 30));
        comboboxSaisieIncidentCodeCouleur.setBackground(Color.DARK_GRAY);
        comboboxSaisieIncidentCodeCouleur.setForeground(Color.WHITE);
        spaceIncidence1.add(comboboxSaisieIncidentCodeCouleur);


        //
        JButton ButtonAddIncident1 = new JButton("Ajouter\n ");
        ButtonAddIncident1.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonAddIncident1.setPreferredSize(new Dimension(250, 50));
        Color Coul406080a250 = new Color(40, 60, 80, 250);
        ButtonAddIncident1.setBackground(Coul406080a250);
        ButtonAddIncident1.setForeground(Color.WHITE);
        panelAjoutIncidence.add(ButtonAddIncident1);
        //
        JButton ButtonConfimationIncident1 = new JButton("Enregistrer\n ");
        ButtonConfimationIncident1.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonConfimationIncident1.setPreferredSize(new Dimension(250, 50));
        Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonConfimationIncident1.setBackground(Coul1691001999259);
        ButtonConfimationIncident1.setForeground(Color.WHITE);
        panelAjoutIncidence.add(ButtonConfimationIncident1);


        //************* Supprimer Une Incidence ************
        JPanel panelSupprimerIncidence= new JPanel();
        panelSupprimerIncidence.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelSupprimerIncidence.setBackground(Coul200200220);
        this.add(panelSupprimerIncidence);



        JButton ButtonConfimationSupprIncident1 = new JButton("Suppression Incident\n ");
        ButtonConfimationSupprIncident1.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonConfimationSupprIncident1.setPreferredSize(new Dimension(250, 50));
        //Color Coul406080a250 = new Color(40, 60, 80, 250);
        ButtonConfimationSupprIncident1.setBackground(Coul1691001999259);
        ButtonConfimationSupprIncident1.setForeground(Color.WHITE);
        panelSupprimerIncidence.add(ButtonConfimationSupprIncident1);

        JButton ButtonConfimationEnregIncident = new JButton("Enregistrer\n ");
        ButtonConfimationEnregIncident.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonConfimationEnregIncident.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonConfimationEnregIncident.setBackground(Coul1691001999259);
        ButtonConfimationEnregIncident.setForeground(Color.WHITE);
        panelSupprimerIncidence.add(ButtonConfimationEnregIncident);




        // ActionListener pour buttonCodeIncident
        buttonCodeIncident.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelCodeIncidence.setVisible(true);
                panelAjoutIncidence.setVisible(false);
                panelSupprimerIncidence.setVisible(false);
            }
        });

        // ActionListener pour buttonAfficheIncident
        buttonAfficheIncident.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setVisible(true);
                panelCodeIncidence.setVisible(false);
                panelAjoutIncidence.setVisible(false);
                panelSupprimerIncidence.setVisible(false);scrollPane.setVisible(true);
            }
        });

        // ActionListener pour buttonAfficheIncident
        buttonAjouterIncident.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelAjoutIncidence.setVisible(true);
                panelCodeIncidence.setVisible(false);
                buttonPanel.setVisible(false);
                panelSupprimerIncidence.setVisible(false);scrollPane.setVisible(false);
            }
        });

        // ActionListener pour buttonSupprimeIncident
        buttonSupprimeIncident.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelSupprimerIncidence.setVisible(true);
                buttonPanel.setVisible(true);
                panelCodeIncidence.setVisible(false);
                panelAjoutIncidence.setVisible(false);scrollPane.setVisible(true);
            }
        });


        // Ajout des écouteurs d'événements aux boutons
        ButtonAddIncident1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeurId =SaisieIncidentID.getText().toString();
                String valeurIdPersonnel =SaisieIncidentID_Personnel.getText();
                String valeurIDTechnicien ="0";
                String valeurStatut ="En cours";
                String valeurTitre =comboboxSaisieIncidentTitre.getSelectedItem().toString();
                String valeurCategorie =comboboxSaisieIncidentCategorie.getSelectedItem().toString();
                String valeurDescription =SaisieIncidentDescription.getText();
                String valeurCodeCouleur =comboboxSaisieIncidentCodeCouleur.getSelectedItem().toString();
                // Ajout d'une nouvelle ligne avec des données fictives
                Vector<String> newRowData = new Vector<>();
                newRowData.add(valeurId);
                newRowData.add(valeurIdPersonnel);
                newRowData.add(valeurIDTechnicien);
                newRowData.add(valeurStatut);
                newRowData.add(valeurTitre);
                newRowData.add(valeurCategorie);
                newRowData.add(valeurDescription);
                newRowData.add(valeurCodeCouleur);
                ajouterLigne(newRowData);
            }
        });

        ButtonConfimationSupprIncident1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Suppression de la première ligne
                if (table.getSelectedRow() != -1) {
                    supprimerLigne(table.getSelectedRow());
                }
            }
        });

        ButtonConfimationEnregIncident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        ButtonConfimationIncident1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        // Action de recherche sur le tableau
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                if (searchText.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                }
            }
        });

        sortComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columnIndex = sortComboBox.getSelectedIndex();
                table.getRowSorter().toggleSortOrder(columnIndex);
            }
        });

    }

    // Méthode pour ajouter une nouvelle ligne au tableau
    public void ajouterLigne(Vector<String> rowData) {
        tableModel.addRow(rowData);
    }
    // Méthode pour supprimer une ligne du tableau
    public void supprimerLigne(int rowIndex) {
        tableModel.removeRow(rowIndex);
    }

    // Méthode pour charger les données depuis un fichier
    private Vector<Vector<String>> loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Vector<Vector<String>>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Fichier de données non trouvé. Chargement de données par défaut.");
            return new Vector<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new Vector<>();
        }
    }
    // Méthode pour sauvegarder les données dans un fichier
    private void saveData() {
        //Vector<Vector<String>> data = tableModel.getDataVector();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            // Il est maintenant ici
            oos.writeObject(tableModel.getDataVector());
            System.out.println("Données sauvegardées.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
