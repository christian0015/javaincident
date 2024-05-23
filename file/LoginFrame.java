import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class LoginFrame extends JFrame {
    private static final String FILE_PATH = "data.ser";  // Fichier pour stocker les données

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    private List<Map<String, String>> users;

    public LoginFrame() {
        setTitle("Connexion");
        setSize(800, 300);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lire les données du fichier
        users = readUserData();

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel pour les champs de texte et les boutons
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 200));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Se connecter");
        signupButton = new JButton("S'inscrire");

        panel.add(new JLabel("Nom d'utilisateur:"));
        panel.add(usernameField);
        panel.add(new JLabel("Mot de passe:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signupButton);

        // Ajouter des listeners
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (verifyCredentials(username, password)) {
                    dispose(); // Fermer la fenêtre de connexion

                    // Ouverture de l'application principale
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new ApplicationFrame().setVisible(true);
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Identifiants invalides", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Inscription");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new PanelInscription());
                frame.pack();
                frame.setLocationRelativeTo(null); // Centrer la fenêtre
                frame.setVisible(true);
                // Fermer la fenêtre de connexion
                LoginFrame.this.dispose();
            }
        });

        // Crée un JLabel pour afficher l'image
        JLabel backgroundLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(("src\\asset\\backroundDynamos6.jpg"));
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);
        backgroundLabel.setIcon(imageIcon);

        // Ajouter l'image et le panel principal
        mainPanel.add(panel, BorderLayout.WEST);
        mainPanel.add(backgroundLabel, BorderLayout.EAST);
        JPanel mainPanel0=new JPanel(new BorderLayout());
        add(mainPanel0);
        mainPanel0.setLayout(new GridBagLayout());
        mainPanel0.add(mainPanel);

        setLocationRelativeTo(null); // Centrer la fenêtre
    }

    // Méthode pour lire les données utilisateur depuis le fichier
    private List<Map<String, String>> readUserData() {
        List<Map<String, String>> userList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
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

    // Méthode pour vérifier les identifiants
    private boolean verifyCredentials(String username, String password) {
        for (Map<String, String> user : users) {
            if (user.get("Username").equals(username) && user.get("PassWord").equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }
}