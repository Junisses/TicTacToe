import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tic_tac_toe implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;

    //Colores
    Color amarillo = new Color(255,255,153);
    Color naranja = new Color(200,200,200);

    public tic_tac_toe() {
        frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icono = new ImageIcon("tic-tac-toe.png");
        frame.setIconImage(icono.getImage());

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(naranja);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].setBackground(amarillo);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();

        if(xTurn) {
            button.setText("X");
            Color rojo = new Color(255,182,193);
            button.setBackground(rojo);
        } 
        else {
            button.setText("O");
            Color azul = new Color(173,216,230);
            button.setBackground(azul);
        }

        button.setEnabled(false);
        
        xTurn= !xTurn;

        checkForWinner();
    }

    public void checkForWinner(){
        for (int i = 0; i < 9; i += 3){
            if (buttons[i].getText().equals(buttons[i+1].getText()) && 
                buttons[i].getText().equals(buttons[i+2].getText()) &&
                !buttons[i].isEnabled()){
                    JOptionPane.showMessageDialog(frame, "Gana " + buttons[i].getText() + "!");
                    resetGame();
                    return;
            }
        }
        for (int i = 0; i < 3; i++){
            if (buttons[i].getText().equals(buttons[i+3].getText()) && 
                buttons[i].getText().equals(buttons[i+6].getText()) &&
                !buttons[i].isEnabled()){
                    JOptionPane.showMessageDialog(frame, "Gana " + buttons[i].getText() + "!");
                    resetGame();
                    return;
            }
        }

        if (buttons[0].getText().equals(buttons[4].getText()) && 
            buttons[0].getText().equals(buttons[8].getText()) &&
            !buttons[0].isEnabled()){
                JOptionPane.showMessageDialog(frame, "Gana " + buttons[0].getText() + "!");
                resetGame();
                return;
        }

        if (buttons[2].getText().equals(buttons[4].getText()) && 
            buttons[2].getText().equals(buttons[6].getText()) &&
            !buttons[2].isEnabled()){
                JOptionPane.showMessageDialog(frame, "Gana " + buttons[2].getText() + "!");
                resetGame();
                return;
        }

        // Empate
        boolean tie = true;

        for (int i = 0; i < 9; i++){
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }

        if (tie) {
            JOptionPane.showMessageDialog(frame, "EMPATE!");
            resetGame();
        }
    }

    public void resetGame() {
        for (int i = 0; i < 9; i++){
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(amarillo);
        }

        xTurn = true;
    }

    public static void main(String[] args){
        new tic_tac_toe();
    }
}
