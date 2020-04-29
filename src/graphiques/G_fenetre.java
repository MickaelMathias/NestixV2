package graphiques;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class G_fenetre extends JFrame {

   public G_fenetre() {
      this.setTitle("Nestix");
      this.setSize(1220, 800);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}