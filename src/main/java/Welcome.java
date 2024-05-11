import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
     public Welcome() {
         this.setSize(400,400);
         Label welcome = new Label("welcome");
         this.add(welcome);
         this.setVisible(true);
     }
}
