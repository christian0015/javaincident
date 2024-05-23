import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Vector;

import java.io.*;
import java.util.Collections;


// Classe PanelInscription pour l'inscription des utilisateurs
class PanelInscription extends JPanel {
    private JTextField idField;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField villeField;
    private JTextField posteField;
    private JTextField bureauField;
    private JTextField disponibiliteField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private static final String FILE_PATH = "data.ser";  // Fichier pour stocker les données


    public PanelInscription() {
        setLayout(new BorderLayout());

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(150, 20));
        nomField = new JTextField();
        nomField.setPreferredSize(new Dimension(150, 20));
        prenomField = new JTextField();
        prenomField.setPreferredSize(new Dimension(150, 20));
        villeField = new JTextField();
        villeField.setPreferredSize(new Dimension(150, 20));
        posteField = new JTextField();
        posteField.setPreferredSize(new Dimension(150, 20));
        bureauField = new JTextField();
        bureauField.setPreferredSize(new Dimension(150, 20));
        disponibiliteField = new JTextField();
        disponibiliteField.setPreferredSize(new Dimension(150, 20));
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(150, 20));
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 20));
        signupButton = new JButton("S'inscrire");


        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(170, 500));
        //panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nom:"));
        panel.add(nomField);
        panel.add(new JLabel("Prénom:"));
        panel.add(prenomField);
        panel.add(new JLabel("Ville:"));
        panel.add(villeField);
        panel.add(new JLabel("Poste:"));
        panel.add(posteField);
        panel.add(new JLabel("Bureau:"));
        panel.add(bureauField);
        panel.add(new JLabel("Disponibilité:"));
        panel.add(disponibiliteField);
        panel.add(new JLabel("Nom d'utilisateur:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(passwordField);
        panel.add(signupButton);
        // Crée un JLabel pour afficher l'image
        JLabel backgroundLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src\\asset\\backroundDynamos6.jpg");
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);
        backgroundLabel.setIcon(imageIcon);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());


        // Ajouter l'image et le panel principal
        mainPanel.add(panel, BorderLayout.WEST);
        mainPanel.add(backgroundLabel, BorderLayout.EAST);
        JPanel mainPanel0=new JPanel(new BorderLayout());
        //mainPanel0.setLayout(new GridBagLayout());
        mainPanel0.add(mainPanel, BorderLayout.CENTER);
        mainPanel0.setPreferredSize(new Dimension(700, 500));

        JPanel Center = new JPanel(new BorderLayout());
        Center.setPreferredSize(new Dimension(500, 500));
        Center.add(mainPanel0, BorderLayout.CENTER);
        add(Center, BorderLayout.CENTER);


        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> newUser = new HashMap<>();
                newUser.put("ID", idField.getText());
                newUser.put("Nom", nomField.getText());
                newUser.put("Prénom", prenomField.getText());
                newUser.put("Ville", villeField.getText());
                newUser.put("Poste", posteField.getText());
                newUser.put("Bureau", bureauField.getText());
                newUser.put("Disponibilité", disponibiliteField.getText());
                newUser.put("Username", usernameField.getText());
                newUser.put("PassWord", new String(passwordField.getPassword()));

                // Lire les utilisateurs existants, ajouter le nouvel utilisateur, puis écrire les données
                List<Map<String, String>> users = readUserData();
                users.add(newUser);
                writeUserData(users);

                JOptionPane.showMessageDialog(PanelInscription.this, "Inscription réussie", "Succès", JOptionPane.INFORMATION_MESSAGE);
                SwingUtilities.getWindowAncestor(PanelInscription.this).dispose(); // Fermer la fenêtre d'inscription


                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ApplicationFrame().setVisible(true);
                        }
                    });

            }
        });
    }

    // Méthode pour lire les données utilisateur depuis le fichier
    private List<Map<String, String>> readUserData() {
        List<Map<String, String>> userList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PanelInscription.FILE_PATH))) {
            Vector<Vector<String>> data = (Vector<Vector<String>>) ois.readObject();
            for (Vector<String> userData : data) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put("ID", userData.get(0));
                userMap.put("Nom", userData.get(1));
                userMap.put("Prénom", userData.get(2));
                userMap.put("Ville", userData.get(3));
                userMap.put("Poste", userData.get(4));
                userMap.put("Bureau", userData.get(5));
                userMap.put("Disponibilité", userData.get(6));
                userMap.put("Username", userData.get(7));
                userMap.put("PassWord", userData.get(8));
                userList.add(userMap);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    // Méthode pour écrire les données utilisateur dans le fichier
    private void writeUserData(List<Map<String, String>> users) {
        Vector<Vector<String>> data = new Vector<>();
        for (Map<String, String> user : users) {
            Vector<String> userData = new Vector<>();
            userData.add(user.get("ID"));
            userData.add(user.get("Nom"));
            userData.add(user.get("Prénom"));
            userData.add(user.get("Ville"));
            userData.add(user.get("Poste"));
            userData.add(user.get("Bureau"));
            userData.add(user.get("Disponibilité"));
            userData.add(user.get("Username"));
            userData.add(user.get("PassWord"));
            data.add(userData);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PanelInscription.FILE_PATH))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}