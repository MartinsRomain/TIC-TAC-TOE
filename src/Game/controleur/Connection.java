package Game.controleur;

import Game.exceptions.PseudoInvalideException;
import Game.vue.Etat;
import Game.vue.Screen;

import javax.swing.*;
import java.awt.*;

public class Connection extends JPanel{

    public Connection(Screen screen, Controleur controleur) {

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JLabel bienvenue = new JLabel("Tic Tac Toe");
        bienvenue.setBackground(new Color(208, 192, 122));
        bienvenue.setOpaque(true);
        bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
        bienvenue.setFont(new Font("Arial", Font.BOLD,30));
        bienvenue.setBorder(BorderFactory.createLineBorder(Color.BLACK,4,true));
        add(bienvenue, BorderLayout.PAGE_START);

        JPanel panelNames = new JPanel();
        BorderLayout panelNameLayout = new BorderLayout();
        panelNames.setLayout(panelNameLayout);

        JLabel askNames = new JLabel("Entrez les pseudos des deux joueurs");
        askNames.setHorizontalAlignment(SwingConstants.CENTER);
        askNames.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT, 40));
        panelNames.add(askNames, BorderLayout.NORTH);

        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        textField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField1.setBackground(new Color(225, 206, 154));
        textField2.setBackground(new Color(58, 137, 35));
        textField1.setFont(new Font("Arial" , Font.BOLD, 30));
        textField2.setFont(new Font("Arial" , Font.BOLD, 30));
        textField1.setHorizontalAlignment(SwingConstants.CENTER);
        textField2.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel textFieldPanel = new JPanel();
        BoxLayout textFiledPanelLayout = new BoxLayout(textFieldPanel,BoxLayout.Y_AXIS);
        textFieldPanel.setLayout(textFiledPanelLayout);
        textFieldPanel.add(textField1);
        textFieldPanel.add(textField2);

        panelNames.add(textFieldPanel, BorderLayout.CENTER);

        JButton button = new JButton("Valider");
        button.setFont(new Font("Arial", Font.BOLD, 40));
        button.addActionListener(actionEvent -> {
            try {
                controleur.creerPartie(textField1.getText(), textField2.getText());
                screen.setStep(Etat.PARTIE_EN_COURS);
                screen.getFrame().remove(this);
            } catch (PseudoInvalideException e) {
                System.err.println(e);
            }

        });

        panelNames.add(button, BorderLayout.SOUTH);

        add(panelNames,BorderLayout.CENTER);
    }
}
