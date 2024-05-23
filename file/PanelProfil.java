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



public class PanelProfil extends JPanel {
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

    public PanelProfil() {

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
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\HP\\IdeaProjects\\Gestion Serveur\\src\\asset\\backroundStatutVerification.png");
        backgroundEntetePanelAcceuil.setIcon(imageIcon);
        //backgroundEntetePanelAcceuil.setBounds(0,0, middlePanelWidth, 100);
        entetePanelAcceuil.add(backgroundEntetePanelAcceuil);


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
        columnNames.add("UserName");
        columnNames.add("PassWord");

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

    // Méthode pour obtenir le modèle de table
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    // Méthode pour obtenir la table
    public JTable getTable() {
        return table;
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

}
