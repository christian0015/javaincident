import javax.swing.*;
import java.awt.*;

public class PanelAcceuil extends JPanel {
    public PanelAcceuil() {

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
        entetePanelAcceuil.setPreferredSize(new Dimension(middlePanelWidth, panelHeight*1/4));
        this.add(entetePanelAcceuil);

        // Crée un JLabel pour afficher l'image
        JLabel backgroundEntetePanelAcceuil = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src\\asset\\backroundDynamos6.jpg");
        Image imgContainAcceuil = imageIcon.getImage();
        Image newImgAcceuil = imgContainAcceuil.getScaledInstance(width, 250, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImgAcceuil);


        backgroundEntetePanelAcceuil.setIcon(imageIcon);
        entetePanelAcceuil.add(backgroundEntetePanelAcceuil);

        JLabel LabelPP1 = new JLabel("Vous rencontrez un probleme ?");
        LabelPP1.setFont(new Font("Roboto", Font.BOLD, 18));
        LabelPP1.setForeground(Color.WHITE);
        //LabelPP1.setBackground(Color.BLACK);
        //LabelPP1.setSize(new Dimension(350, 50));
        //LabelPP1.setBounds(100, 200, 350, 100); // Définit les positions x et y du JLabel et ses dimensions
        //LabelPP1.setOpaque(true); // Définit le JLabel comme opaque pour que la couleur de fond soit visible
        this.add(LabelPP1);

        JLabel LabelPP2 = new JLabel("En faire part aux superieurs ?");
        LabelPP2.setFont(new Font("Roboto", Font.BOLD, 18));
        LabelPP2.setForeground(Color.WHITE);

        JLabel LabelPP3 = new JLabel("Cette app vous le permet");
        LabelPP3.setFont(new Font("Roboto", Font.BOLD, 18));
        LabelPP3.setForeground(Color.WHITE);

        JLabel LabelPP4 = new JLabel("Pour une gestion éfficace");
        LabelPP4.setFont(new Font("Roboto", Font.BOLD, 18));
        LabelPP4.setForeground(Color.WHITE);

        JPanel listBlock= new JPanel();
        listBlock.setPreferredSize(new Dimension(middlePanelWidth, panelHeight));
        listBlock.setBackground(Coul200200220);
        this.add(listBlock);


        RoundedPanel block1 = new RoundedPanel(20); // 20 est le rayon pour l'arrondi
        block1.setLayout(new GridLayout(1, 1));
        block1.setBorder(BorderFactory.createTitledBorder("Probleme ?"));
        block1.setPreferredSize(new Dimension(350, 80));
        Color Coul200200220a100 = new Color(219, 60, 90, 250);
        block1.setBackground(Coul200200220a100);
        listBlock.add(block1);
        block1.add(LabelPP1);

        JPanel block2= new JPanel();
        block2.setPreferredSize(new Dimension(350, 80));
        block2.setLayout(new GridLayout(1, 1));
        block2.setBorder(BorderFactory.createTitledBorder("Solution ?"));
        Color Coul406080250 = new Color(40, 80, 150, 250);
        block2.setBackground(Coul406080250);
        listBlock.add(block2);
        block2.add(LabelPP2);

        JPanel block3= new JPanel();
        block3.setLayout(new GridLayout(1, 1));
        block3.setBorder(BorderFactory.createTitledBorder("Via cette application"));
        block3.setPreferredSize(new Dimension(350, 80));
        Color Coul1691991999259 = new Color(169, 100, 100, 250);
        block3.setBackground(Coul1691991999259);
        listBlock.add(block3);
        block3.add(LabelPP3);

        RoundedPanel block4= new RoundedPanel(20);
        block4.setLayout(new GridLayout(1, 1));
        block4.setBorder(BorderFactory.createTitledBorder("Gestion Incidence"));
        block4.setPreferredSize(new Dimension(350, 80));
        Color Coul21215939 = new Color(212, 159, 39, 250);
        block4.setBackground(Coul21215939);
        listBlock.add(block4);
        block4.add(LabelPP4);

    }
}
