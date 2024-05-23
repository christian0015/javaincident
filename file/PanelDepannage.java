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

public class PanelDepannage extends JPanel {
    private DefaultTableModel tableModel;
    public JTable table;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton searchField;
    private JComboBox<String> sortComboBox;

    private static final String FILE_PATH = "dataIncidents.ser";  // Fichier pour stocker les données

    public PanelDepannage() {

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
        entetePanelAcceuil.add(backgroundEntetePanelAcceuil);

        // Path IcoImage dans un bouton Code Depannage
        ImageIcon iconButtonCodeDepannage = new ImageIcon("src\\asset/depannage.png");
        Image imgCodeDepannage = iconButtonCodeDepannage.getImage();
        Image newImgCodeDepannage = imgCodeDepannage.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonCodeDepannage = new ImageIcon(newImgCodeDepannage);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonCodeDepannage = new JButton("Code Couleur Depannage", iconButtonCodeDepannage);
        buttonCodeDepannage.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonCodeDepannage.setPreferredSize(new Dimension(width/9, 40));
        buttonCodeDepannage.setBackground(Coul200200220);
        this.add(buttonCodeDepannage);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Affiche Depannage
        ImageIcon iconButtonAfficheDepannage = new ImageIcon("src\\asset/depannage.png");
        Image imgAfficheDepannage = iconButtonAfficheDepannage.getImage();
        Image newImgAfficheDepannage = imgAfficheDepannage.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonAfficheDepannage = new ImageIcon(newImgAfficheDepannage);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonAfficheDepannage = new JButton("Afficher toutes", iconButtonAfficheDepannage);
        buttonAfficheDepannage.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAfficheDepannage.setPreferredSize(new Dimension(width/9, 40));
        buttonAfficheDepannage.setBackground(Coul200200220);
        this.add(buttonAfficheDepannage);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Affiche Depannage
        ImageIcon iconButtonSupprimeDepannage = new ImageIcon("src\\asset/depannage.png");
        Image imgSupprimeDepannage = iconButtonSupprimeDepannage.getImage();
        Image newImgSupprimeDepannage = imgSupprimeDepannage.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonSupprimeDepannage = new ImageIcon(newImgSupprimeDepannage);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonSupprimeDepannage = new JButton("Fini et Suppression", iconButtonSupprimeDepannage);
        buttonSupprimeDepannage.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonSupprimeDepannage.setPreferredSize(new Dimension(width/9, 40));
        buttonSupprimeDepannage.setBackground(Coul200200220);
        this.add(buttonSupprimeDepannage);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        //*********************** Code couleur Depannage *********************
        JPanel panelCodeDepannage= new JPanel();
        panelCodeDepannage.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelCodeDepannage.setBackground(Coul200200220);
        this.add(panelCodeDepannage);
        //
        JLabel labelCodeCouleur1= new JLabel("Depannage legère");
        labelCodeCouleur1.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur2= new JLabel("Depannage moyen");
        labelCodeCouleur2.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur3= new JLabel("Depannage lourde");
        labelCodeCouleur3.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur4= new JLabel("Depannage Nécessaire");
        labelCodeCouleur4.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur5= new JLabel("Depannage Importante");
        labelCodeCouleur5.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        JLabel labelCodeCouleur6= new JLabel("Depannage Urgente");
        labelCodeCouleur6.setFont(new Font("Roboto", Font.CENTER_BASELINE, 14));
        //
        JPanel block01= new JPanel();
        block01.setPreferredSize(new Dimension(350, 70));
        Color Coul1691991999264 = new Color(130, 100, 100, 250);
        block01.setBackground(Coul1691991999264);
        panelCodeDepannage.add(block01);
        block01.add(labelCodeCouleur1);
        //
        JPanel block02= new JPanel();
        block02.setPreferredSize(new Dimension(350, 70));
        Color Coul12015939a259 = new Color(120, 159, 39, 250);
        block02.setBackground(Coul12015939a259);
        panelCodeDepannage.add(block02);
        block02.add(labelCodeCouleur2);
        //
        JPanel block03 = new JPanel(); // 20 est le rayon pour l'arrondi
        block03.setPreferredSize(new Dimension(350, 70));
        Color Coul200200220a106 = new Color(230, 120, 200, 250);
        block03.setBackground(Coul200200220a106);
        panelCodeDepannage.add(block03);
        block03.add(labelCodeCouleur3);
        //
        JPanel block04= new JPanel();
        block04.setPreferredSize(new Dimension(350, 70));
        Color Coul406080256 = new Color(40, 160, 80, 250);
        block04.setBackground(Coul406080256);
        panelCodeDepannage.add(block04);
        block04.add(labelCodeCouleur4);
        //
        JPanel block05= new JPanel();
        block05.setPreferredSize(new Dimension(350, 70));
        Color Coul1691991999265 = new Color(169, 0, 100, 250);
        block05.setBackground(Coul1691991999265);
        panelCodeDepannage.add(block05);
        block05.add(labelCodeCouleur5);
        //
        JPanel block06= new JPanel();
        block06.setPreferredSize(new Dimension(350, 70));
        Color Coul21215944 = new Color(212, 59, 39, 250);
        block06.setBackground(Coul21215944);
        panelCodeDepannage.add(block06);
        block06.add(labelCodeCouleur6);

//*****************************************************************
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


        //************* Supprimer Une Depannage ************
        JPanel panelSupprimerDepannage= new JPanel();
        panelSupprimerDepannage.setPreferredSize(new Dimension(middlePanelWidth, 200));
        panelSupprimerDepannage.setBackground(Coul200200220);
        this.add(panelSupprimerDepannage);

        JButton ButtonSupprDepannage1 = new JButton("Suppression\n ");
        ButtonSupprDepannage1.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonSupprDepannage1.setPreferredSize(new Dimension(250, 50));
        Color Coul406080a250 = new Color(40, 60, 80, 250);
        Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonSupprDepannage1.setBackground(Coul1691001999259);
        ButtonSupprDepannage1.setForeground(Color.WHITE);
        panelSupprimerDepannage.add(ButtonSupprDepannage1);

        JButton ButtonConfimationDepannage = new JButton("Enregistrer\n ");
        ButtonConfimationDepannage.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonConfimationDepannage.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonConfimationDepannage.setBackground(Coul1691001999259);
        ButtonConfimationDepannage.setForeground(Color.WHITE);
        this.add(ButtonConfimationDepannage);

        JButton ButtonConfimationDepannage2 = new JButton("Enregistrer\n ");
        ButtonConfimationDepannage2.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonConfimationDepannage2.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonConfimationDepannage2.setBackground(Coul1691001999259);
        ButtonConfimationDepannage2.setForeground(Color.WHITE);
        panelSupprimerDepannage.add(ButtonConfimationDepannage2);


        // ActionListener pour buttonCodeDepannage
        buttonCodeDepannage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelCodeDepannage.setVisible(true);
                panelSupprimerDepannage.setVisible(false);
            }
        });

        // ActionListener pour buttonAfficheDepannage
        buttonAfficheDepannage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setVisible(true);
                panelCodeDepannage.setVisible(false);
                panelSupprimerDepannage.setVisible(false);scrollPane.setVisible(true);
            }
        });


        // ActionListener pour buttonSupprimeDepannage
        buttonSupprimeDepannage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelSupprimerDepannage.setVisible(true);
                buttonPanel.setVisible(true);
                panelCodeDepannage.setVisible(false);
            }
        });


        ButtonSupprDepannage1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Suppression de la première ligne
                if (table.getSelectedRow() != -1) {
                    supprimerLigne(table.getSelectedRow());
                }
            }
        });

        ButtonConfimationDepannage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        ButtonConfimationDepannage2.addActionListener(new ActionListener() {
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
