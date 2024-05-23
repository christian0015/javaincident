import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.event.TableModelEvent;
//import javax.swing.event.TableModelListener;
//import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Vector;

import java.io.*;
import java.util.Collections;



public class PanelPersonnel extends JPanel {
    private DefaultTableModel tableModel;
    public JTable table;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;

    private JButton searchField;
    private JComboBox<String> sortComboBox;

    private String valeurId;
    private String valeurNom;
    private String valeurPrenom;
    private String valeurVille;
    private String valeurPost;

    private static final String FILE_PATH = "data.ser";  // Fichier pour stocker les données

    public PanelPersonnel() {

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



        // Path IcoImage dans un bouton Affiche Personnel
        ImageIcon iconButtonAffichePersonnel = new ImageIcon("src\\asset/personnel2.png");
        Image imgAffichePersonnel = iconButtonAffichePersonnel.getImage();
        Image newImgAffichePersonnel = imgAffichePersonnel.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonAffichePersonnel = new ImageIcon(newImgAffichePersonnel);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonAffichePersonnel = new JButton("Afficher toutes", iconButtonAffichePersonnel);
        buttonAffichePersonnel.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAffichePersonnel.setPreferredSize(new Dimension(width/9, 40));
        buttonAffichePersonnel.setBackground(Coul200200220);
        this.add(buttonAffichePersonnel);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Ajouter Personnel
        ImageIcon iconButtonAjouterPersonnel = new ImageIcon("src\\asset/personnel2.png");
        Image imgAjouterPersonnel = iconButtonAjouterPersonnel.getImage();
        Image newImgAjouterPersonnel = imgAjouterPersonnel.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonAjouterPersonnel = new ImageIcon(newImgAjouterPersonnel);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonAjouterPersonnel = new JButton("Ajouter", iconButtonAjouterPersonnel);
        buttonAjouterPersonnel.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonAjouterPersonnel.setPreferredSize(new Dimension(width/9, 40));
        buttonAjouterPersonnel.setBackground(Coul200200220);
        this.add(buttonAjouterPersonnel);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons

        // Path IcoImage dans un bouton Affiche Personnel
        ImageIcon iconButtonSupprimePersonnel = new ImageIcon("src\\asset/personnel2.png");
        Image imgSupprimePersonnel = iconButtonSupprimePersonnel.getImage();
        Image newImgSupprimePersonnel = imgSupprimePersonnel.getScaledInstance(width/50, 20, java.awt.Image.SCALE_SMOOTH);
        iconButtonSupprimePersonnel = new ImageIcon(newImgSupprimePersonnel);
        // Bouton à partit de l'icône redimensionnée
        JButton buttonSupprimePersonnel = new JButton("Supprimer", iconButtonSupprimePersonnel);
        buttonSupprimePersonnel.setHorizontalTextPosition(SwingConstants.RIGHT); // Texte à droite de l'icône
        buttonSupprimePersonnel.setPreferredSize(new Dimension(width/9, 40));
        buttonSupprimePersonnel.setBackground(Coul200200220);
        this.add(buttonSupprimePersonnel);
        //Espacement entre element du menu
        this.add(Box.createRigidArea(new Dimension(50, 0))); // Espacement entre les boutons




        //************************************************


        // Création des données du tableau
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Ville");
        columnNames.add("Poste");
        columnNames.add("Bureau");
        columnNames.add("Disponibilité");
        columnNames.add("Username");
        columnNames.add("PassWord");

        //Vector<Vector<String>> rowData = new Vector<>();
        Vector<Vector<String>> rowData = loadData();  // Charger les données du fichier
        // Ajoutez vos données ici, par exemple :


        // Ajout des boutons au panneau
        JPanel buttonPanel = new JPanel();

        this.add(buttonPanel, BorderLayout.NORTH);

        // Vérification des données chargées
        if (rowData == null) {
            rowData = new Vector<>();
            System.out.println("Null");
        }
        else {System.out.println("No Null");}
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



        //************* Ajouter Un Personnel ************
        JPanel panelAjoutPersonnel= new JPanel();
        panelAjoutPersonnel.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelAjoutPersonnel.setBackground(Coul200200220);
        panelAjoutPersonnel.setVisible(false);
        this.add(panelAjoutPersonnel);

        // Crée un JPanel d'Ajout
        RoundedPanel spaceAjoutPersonne = new RoundedPanel(20); // 20 est le rayon pour l'arrondi
        spaceAjoutPersonne.setPreferredSize(new Dimension(750, 200));
        Color Coul13020200a250 = new Color(130, 20, 200, 250);
        spaceAjoutPersonne.setBackground(Coul13020200a250);
        panelAjoutPersonnel.add(spaceAjoutPersonne);
        //
        JLabel LabelId = new JLabel("Entre le n° Id\n: ");
        LabelId.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelId.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelId);
        //Saisie
        JTextField ZoneID = new JTextField("300");
        ZoneID.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneID.setPreferredSize(new Dimension(250, 30));
        ZoneID.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneID);
        spaceAjoutPersonne.add(ZoneID);
        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(0, 0))); // Espacement entre les boutons
        //Saisie
        JLabel LabelNom = new JLabel("Nom\n: ");
        LabelNom.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelNom.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelNom);
        //Saisie
        JTextField ZoneNom = new JTextField("Lafoi");
        ZoneNom.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneNom.setPreferredSize(new Dimension(250, 30));
        ZoneNom.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneNom);
        //Saisie
        JLabel LabelPrenom = new JLabel("Prenom\n: ");
        LabelPrenom.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelPrenom.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelPrenom);
        //Saisie
        JTextField ZonePrenom = new JTextField("Joe");
        ZonePrenom.setFont(new Font("Roboto", Font.BOLD, 14));
        ZonePrenom.setPreferredSize(new Dimension(250, 30));
        ZonePrenom.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZonePrenom);
        //Saisie
        JLabel LabelVille = new JLabel("Ville\n: ");
        LabelVille.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelVille.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelVille);
        //Saisie
        JTextField ZoneVille = new JTextField("Kinshasa");
        ZoneVille.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneVille.setPreferredSize(new Dimension(250, 30));
        ZoneVille.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneVille);
        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(40, 0))); // Espacement entre les boutons
        //Saisie
        JLabel LabelPost = new JLabel("Entre le post\n: ");
        LabelPost.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelPost.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelPost);
        //Saisie du JComboBox
        String[] valeursComboboxPost = {"President Directeur Generale","Directeur Generale", "Directeur Adjoint", "Chef de service","Technicien", "Assistant", "Employe Ordinaire"}; // Vos valeurs de liste
        JComboBox<String> comboboxPost = new JComboBox<>(valeursComboboxPost);
        comboboxPost.setFont(new Font("Roboto", Font.BOLD, 14));
        comboboxPost.setPreferredSize(new Dimension(250, 30));
        comboboxPost.setBackground(Color.DARK_GRAY);
        comboboxPost.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(comboboxPost);
        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(0, 0))); // Espacement entre les boutons
        //Saisie
        JLabel LabelBureau = new JLabel("Bureau\n: ");
        LabelBureau.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelBureau.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelBureau);
        //Saisie
        JTextField ZoneBureau = new JTextField("00A1");
        ZoneBureau.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneBureau.setPreferredSize(new Dimension(250, 30));
        ZoneBureau.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneBureau);
        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(0, 0))); // Espacement entre les boutons
        //Saisie
        JLabel LabelUsername = new JLabel("Saissisez le Username\n: ");
        LabelUsername.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelUsername.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelUsername);
        //Saisie
        JTextField ZoneUsername = new JTextField("joe1");
        ZoneUsername.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneUsername.setPreferredSize(new Dimension(200, 30));
        ZoneUsername.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneUsername);
        //Saisie
        JLabel LabelPassword = new JLabel("Password\n: ");
        LabelPassword.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelPassword.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelPassword);
        //Saisie
        JTextField ZonePassword = new JTextField("0001");
        ZonePassword.setFont(new Font("Roboto", Font.BOLD, 14));
        ZonePassword.setPreferredSize(new Dimension(200, 30));
        ZonePassword.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZonePassword);
        //Espacement entre element du menu

        // Création des boutons
        JButton ButtonAjoutPersonnel = new JButton("Ajout Personnel\n ");
        ButtonAjoutPersonnel.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonAjoutPersonnel.setPreferredSize(new Dimension(250, 50));
        Color Coul1691001999259 = new Color(169, 100, 100, 250);
        Color Coul406080a250 = new Color(40, 60, 80, 250);
        ButtonAjoutPersonnel.setBackground(Coul406080a250);
        ButtonAjoutPersonnel.setForeground(Color.WHITE);
        panelAjoutPersonnel.add(ButtonAjoutPersonnel);

        JButton ButtonEnregistrementPersonnel = new JButton("Enregistrer\n ");
        ButtonEnregistrementPersonnel.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonEnregistrementPersonnel.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonEnregistrementPersonnel.setBackground(Coul1691001999259);
        ButtonEnregistrementPersonnel.setForeground(Color.WHITE);
        panelAjoutPersonnel.add(ButtonEnregistrementPersonnel);


        //************* Supprimer Une Personnel ************
        JPanel panelSupprimerPersonnel= new JPanel();
        panelSupprimerPersonnel.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        panelSupprimerPersonnel.setBackground(Coul200200220);
        panelSupprimerPersonnel.setVisible(false);
        this.add(panelSupprimerPersonnel);


        // Création des boutons
        JButton ButtonASuppPersonnel = new JButton("Suppression Personnel\n ");
        ButtonASuppPersonnel.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonASuppPersonnel.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonASuppPersonnel.setBackground(Coul1691001999259);
        ButtonASuppPersonnel.setForeground(Color.WHITE);
        panelSupprimerPersonnel.add(ButtonASuppPersonnel);

        JButton ButtonEnregistrementPersonnel2 = new JButton("Enregistrer \n ");
        ButtonEnregistrementPersonnel2.setFont(new Font("Roboto", Font.BOLD, 16));
        ButtonEnregistrementPersonnel2.setPreferredSize(new Dimension(250, 50));
        //Color Coul1691001999259 = new Color(169, 100, 100, 250);
        ButtonEnregistrementPersonnel2.setBackground(Coul1691001999259);
        ButtonEnregistrementPersonnel2.setForeground(Color.WHITE);
        panelSupprimerPersonnel.add(ButtonEnregistrementPersonnel2);



        // ActionListener pour buttonAffichePersonnel
        buttonAffichePersonnel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setVisible(true);
                panelAjoutPersonnel.setVisible(false);
                panelSupprimerPersonnel.setVisible(false);scrollPane.setVisible(true);
            }
        });

        // ActionListener pour buttonAffichePersonnel
        buttonAjouterPersonnel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelAjoutPersonnel.setVisible(true);
                buttonPanel.setVisible(false);
                panelSupprimerPersonnel.setVisible(false);scrollPane.setVisible(false);
            }
        });

        // ActionListener pour buttonSupprimePersonnel
        buttonSupprimePersonnel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelSupprimerPersonnel.setVisible(true);
                buttonPanel.setVisible(true);
                panelAjoutPersonnel.setVisible(false);scrollPane.setVisible(true);
            }
        });


        // Ajout des écouteurs d'événements aux boutons
        ButtonAjoutPersonnel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeurId =ZoneID.getText();
                String valeurNom =ZoneNom.getText();
                String valeurPrenom =ZonePrenom.getText();
                String valeurVille =ZoneVille.getText();
                String valeurPost =comboboxPost.getSelectedItem().toString();
                // Ajout d'une nouvelle ligne avec des données fictives
                Vector<String> newRowData = new Vector<>();
                newRowData.add(valeurId);
                newRowData.add(valeurNom);
                newRowData.add(valeurPrenom);
                newRowData.add(valeurVille);
                newRowData.add(valeurPost);
                newRowData.add(ZoneBureau.getText());
                newRowData.add("1");
                newRowData.add(ZoneUsername.getText());
                newRowData.add(ZonePassword.getText());
                ajouterLigne(newRowData);
            }
        });

        ButtonASuppPersonnel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Suppression de la première ligne
                if (table.getSelectedRow() != -1) {
                    supprimerLigne(table.getSelectedRow());
                }
            }
        });

        ButtonEnregistrementPersonnel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        ButtonEnregistrementPersonnel.addActionListener(new ActionListener() {
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
            Object data = ois.readObject();
            if (data instanceof Vector) {
                // Vérifie que tous les éléments de la liste sont des Vector
                Vector<?> vectorData = (Vector<?>) data;
                if (!vectorData.isEmpty() && vectorData.get(0) instanceof Vector) {
                    return (Vector<Vector<String>>) vectorData;
                }
            }
            System.out.println("Données du fichier non valides. Chargement de données par défaut.");
            return new Vector<>();
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
