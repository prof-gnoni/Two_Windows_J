package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainFrame extends JFrame {
    private JTextField colorTextField;
    public MainFrame() {
        setTitle("Finestra Principale");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        colorTextField = new JTextField(15);
        JButton openButton = new JButton("Apri Finestra Secondaria");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String colorInput = colorTextField.getText();
                Color color = getColorFromString(colorInput);
// Controlla se il colore è valido
                if (color != null) {
                    SecondFrame secondFrame = new SecondFrame(color);
                    secondFrame.setVisible(true); // Mostra la finestra secondaria
                } else {
                    JOptionPane.showMessageDialog(MainFrame.this,
                            "Colore non valido! Usa un nome di colore o un codice esadecimale.",
                            "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(new JLabel("Inserisci colore: "));
        add(colorTextField);
        add(openButton);
    }
    // Converti il testo in un oggetto Color
    private Color getColorFromString(String colorInput) {
        Color color = null;
        try {
// Prova a ottenere il colore dal nome
            color = (Color) Color.class.getField(colorInput.toLowerCase()).get(null);
        } catch (Exception e) {
// Se non funzionano i nomi, prova a ottenere il colore dal codice esadecimale
            try {
                color = Color.decode(colorInput);
            } catch (NumberFormatException ex) {
// Colore non valido
                return null;
            }
        }
        return color;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}