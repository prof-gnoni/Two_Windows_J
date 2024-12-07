package mypackage;

import javax.swing.*;
import java.awt.*;
public class SecondFrame extends JFrame {
    public SecondFrame(Color color) {
        setTitle("Finestra Secondaria");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());
        JLabel label = new JLabel("Colore scelto: ") {
            {
                setOpaque(true); // Rendi la label opaca per mostrare il colore
                setBackground(color); // Imposta lo sfondo della label con il colore scelto
                setPreferredSize(new Dimension(250, 100)); // Dimensione della label
            }
        };
        add(label);
    }
}
