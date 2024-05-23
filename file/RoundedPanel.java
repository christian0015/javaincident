import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class RoundedPanel extends JPanel {
    private int arc;

    public RoundedPanel(int arc) {
        this.arc = arc;
        setOpaque(false); // Rend le JPanel transparent pour que la couleur de fond soit visible à travers la bordure
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getForeground());
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc); // Dessine la bordure arrondie
        g2d.dispose();
    }


}
