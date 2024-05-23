import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PanelPersonne extends JPanel {
    private DefaultTableModel tableModel;
    public JTable table;
    private JButton searchField;
    private JComboBox<String> sortComboBox;
    private JButton addButton;
    private JButton deleteButton;
    private JButton saveButton;
    private String valeurId;
    private String valeurNom;
    private String valeurPrenom;
    private String valeurVille;
    private String valeurPost;

    public PanelPersonne() {
        // Récuperation de la taille de l'écran avec Toolkit
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        // Pourcentage de largeurs (20%, 15%, 60%) des panels
        int smallSidePanelWidth = (int) (width * 0.15);
        int middlePanelWidth = (int) (width * 0.7);
        int panelHeight = height;

        Color Coul200200220 = new Color(220, 220, 220);
        this.setBackground(Coul200200220);
        this.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));

        // Création des données du tableau
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Nom");
        columnNames.add("Prénom");
        columnNames.add("Ville");
        columnNames.add("Poste");

        Vector<Vector<String>> rowData = new Vector<>();
        // Ajoutez vos données ici, par exemple :

        // Création du modèle de tableau
        tableModel = new DefaultTableModel(rowData, columnNames);
        table = new JTable(tableModel);

        // Ajouter le tableau à un JScrollPane pour permettre le défilement s'il y a beaucoup de lignes
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        // Création des boutons
        addButton = new JButton("Ajouter");
        deleteButton = new JButton("Supprimer");
        saveButton = new JButton("Enregistrer");

        // Ajout des boutons au panneau
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

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

        // Rendre le panneau visible
        this.setVisible(true);

        // Crée un JPanel arrondi
        RoundedPanel spaceAjoutPersonne = new RoundedPanel(20); // 20 est le rayon pour l'arrondi
        spaceAjoutPersonne.setPreferredSize(new Dimension(700, 250));
        Color Coul13020200a250 = new Color(130, 20, 200, 250);
        spaceAjoutPersonne.setBackground(Coul13020200a250);
        this.add(spaceAjoutPersonne);
        //
        JLabel LabelId = new JLabel("Entre le n°\n: ");
        LabelId.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelId.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelId);
        //Saisie
        // Création et ajout du JComboBox
        String[] valeursComboboxId = {"1", "2", "3", "4", "5", "6", "7", "8"}; // Vos valeurs de liste
        JComboBox<String> comboboxId = new JComboBox<>(valeursComboboxId);
        comboboxId.setFont(new Font("Roboto", Font.BOLD, 16));
        comboboxId.setPreferredSize(new Dimension(150, 30));
        comboboxId.setBackground(Color.DARK_GRAY);
        comboboxId.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(comboboxId);

        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(350, 0))); // Espacement entre les boutons

        JLabel LabelNom = new JLabel("Nom\n: ");
        LabelNom.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelNom.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelNom);
        //Saisie
        JTextField ZoneNom = new JTextField("Ex: Azerty ");
        ZoneNom.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneNom.setPreferredSize(new Dimension(250, 30));
        ZoneNom.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneNom);

        JLabel LabelPrenom = new JLabel("Prenom\n: ");
        LabelPrenom.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelPrenom.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelPrenom);
        //Saisie
        JTextField ZonePrenom = new JTextField("Ex: Azerty ");
        ZonePrenom.setFont(new Font("Roboto", Font.BOLD, 14));
        ZonePrenom.setPreferredSize(new Dimension(250, 30));
        ZonePrenom.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZonePrenom);

        JLabel LabelVille = new JLabel("Ville\n: ");
        LabelVille.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelVille.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelVille);
        //Saisie
        JTextField ZoneVille = new JTextField("Ex: Azerty ");
        ZoneVille.setFont(new Font("Roboto", Font.BOLD, 14));
        ZoneVille.setPreferredSize(new Dimension(250, 30));
        ZoneVille.setForeground(Color.gray);
        spaceAjoutPersonne.add(ZoneVille);


        JLabel LabelPost = new JLabel("Entre le post\n: ");
        LabelPost.setFont(new Font("Roboto", Font.BOLD, 16));
        LabelPost.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(LabelPost);
        //Saisie
        // Création et ajout du JComboBox
        String[] valeursComboboxPost = {"President Directeur Generale","Directeur Generale", "Directeur Adjoint", "Chef de service","Technicien", "Assistant", "Employe Ordinaire"}; // Vos valeurs de liste
        JComboBox<String> comboboxPost = new JComboBox<>(valeursComboboxPost);
        comboboxPost.setFont(new Font("Roboto", Font.BOLD, 14));
        comboboxPost.setPreferredSize(new Dimension(250, 30));
        comboboxPost.setBackground(Color.DARK_GRAY);
        comboboxPost.setForeground(Color.WHITE);
        spaceAjoutPersonne.add(comboboxPost);

        //Espacement entre element du menu
        spaceAjoutPersonne.add(Box.createRigidArea(new Dimension(200, 0))); // Espacement entre les boutons


        // Ajout des écouteurs d'événements aux boutons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeurId =comboboxId.getSelectedItem().toString();
                String valeurNom =ZoneNom.getText();
                String valeurPrenom =LabelPrenom.getText();
                String valeurVille =ZoneVille.getText();
                String valeurPost =comboboxPost.getSelectedItem().toString();
                // Ajout d'une nouvelle ligne avec des données fictives
                Vector<String> newRowData = new Vector<>();
                newRowData.add(valeurId);
                newRowData.add(valeurNom);
                newRowData.add(valeurPrenom);
                newRowData.add(valeurVille);
                newRowData.add(valeurPost);
                ajouterLigne(newRowData);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Suppression de la première ligne
                if (table.getSelectedRow() != -1) {
                    supprimerLigne(table.getSelectedRow());
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enregistrement (pour l'instant, cela ne fait rien)
                System.out.println("Enregistrement...");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText().toLowerCase(); // Convertir la requête en minuscules pour une correspondance insensible à la casse
                DefaultRowSorter<?, ?> sorter = (DefaultRowSorter<?, ?>) table.getRowSorter();
                sorter.setRowFilter(RowFilter.regexFilter(query)); // Appliquer le filtre de recherche au trieur de lignes
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sortBy = (String) sortComboBox.getSelectedItem();
                // Votre logique de tri ici
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
}
