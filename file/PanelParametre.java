import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class PanelParametre extends JPanel {
    private static final String FILE_PATH = "data.ser";  // Fichier pour stocker les données
    private static final String FILE_PATH_INCIDENTS = "dataIncidents.ser";  // Fichier pour stocker les données

    public PanelParametre() {
        // Configuration générale du panneau
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(220, 220, 220));
        this.setPreferredSize(new Dimension(400, 300));


        // Espacement
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        // Informations sur l'application
        JPanel panelAppInfo = new JPanel();
        panelAppInfo.setLayout(new GridLayout(3, 1));
        panelAppInfo.setBackground(new Color(240, 240, 240));
        panelAppInfo.setBorder(BorderFactory.createTitledBorder("À propos de l'application"));

        JLabel labelAppName = new JLabel("Nom de l'application: Gestion des Incidents");
        JLabel labelVersion = new JLabel("Version: 1.0.0");
        JLabel labelDate = new JLabel("Date: 18.05.2024");

        panelAppInfo.add(labelAppName);
        panelAppInfo.add(labelVersion);
        panelAppInfo.add(labelDate);

        this.add(panelAppInfo);

        // Informations sur le créateur
        JPanel panelCreatorInfo = new JPanel();
        panelCreatorInfo.setLayout(new GridLayout(2, 1));
        panelCreatorInfo.setBackground(new Color(240, 240, 240));
        panelCreatorInfo.setBorder(BorderFactory.createTitledBorder("Créateur"));

        JLabel labelCreatorName = new JLabel("Nom: Christian Tukinda Stocklin");
        JLabel labelCreatorOrigin = new JLabel("Origine: Congolaise\uD83C\uDDE8\uD83C\uDDE9");

        panelCreatorInfo.add(labelCreatorName);
        panelCreatorInfo.add(labelCreatorOrigin);

        this.add(panelCreatorInfo);


        // Informations sur le Fonctionnement
        JPanel panelFonctionAppInfo = new JPanel();
        panelFonctionAppInfo.setLayout(new GridLayout(8, 1));
        panelFonctionAppInfo.setBackground(new Color(240, 240, 240));
        panelFonctionAppInfo.setBorder(BorderFactory.createTitledBorder("Fonctionnement"));

        JLabel labelFonctionModification = new JLabel("Modifications:Vous pouvez modifier les valeurs dans les différents tableaux.");
        JLabel labelFonctionModificationInfo = new JLabel("Modification et Validation: !!! Il est necessaire de quitter la case d'edition pour valider avec Enregistrement l'ensemble de modification !!!");
        JLabel labelFonctionModificationInfo1 = new JLabel("Modification et Validation: !!! En cas contrare aucune modification n'est validé !!!");
        JLabel labelFonctionIncident = new JLabel("Déclarer/Suppression d'une incidence: Sous onglet Statut");
        JLabel labelFonctionPersonnel = new JLabel("Ajouter/Suppresion d'un personnel : Sous onglet personnel");
        JLabel labelFonctionDepanner = new JLabel("Depannage : Consiste à Affecter à une incidence un Identifiant du technicien maitre en domain");
        JLabel labelFonctionDepannerFini = new JLabel("Le technicien : Peut mettre constamment à jour l'évolution de son travail sous l'Onglet Statut, et modification de statut dans le tableau");
        JLabel labelFonctionDepannerFiniSupp = new JLabel("Le Responsable ayant fini : Accède à l'onglet Depannage et click sur Fini, recherche sa mission et la supprime");

        panelFonctionAppInfo.add(labelFonctionModification);
        panelFonctionAppInfo.add(labelFonctionModificationInfo);
        panelFonctionAppInfo.add(labelFonctionModificationInfo1);
        panelFonctionAppInfo.add(labelFonctionIncident);
        panelFonctionAppInfo.add(labelFonctionPersonnel);
        panelFonctionAppInfo.add(labelFonctionDepanner);
        panelFonctionAppInfo.add(labelFonctionDepannerFini);
        panelFonctionAppInfo.add(labelFonctionDepannerFiniSupp);

        this.add(panelFonctionAppInfo);

        // Bouton de réinitialisation
        JButton resetButton = new JButton("Réinitialiser les données");
        resetButton.setBackground(new Color(200, 0, 0));
        resetButton.setForeground(Color.WHITE);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetData();
            }
        });

        this.add(resetButton);



        // Espacement
        this.add(Box.createRigidArea(new Dimension(0, 150)));
    }

    // Méthode pour réinitialiser les fichiers de données
    private void resetData() {
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
             ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(FILE_PATH_INCIDENTS))) {
            oos1.writeObject(new Vector<Vector<String>>());
            oos2.writeObject(new Vector<Vector<String>>());
            JOptionPane.showMessageDialog(this, "Données réinitialisées avec succès.", "Réinitialisation", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la réinitialisation des données.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
