package Game.controleur;

import Game.vue.Etat;
import Game.vue.Screen;

import javax.swing.*;
import java.awt.*;

public class FinPartie extends JPanel {

    public FinPartie(Screen screen, Controleur controleur){
        setLayout(new BorderLayout());
        JLabel text = new JLabel("Egalité !");
        String nomGagnant = controleur.getGagnant();
        if(!(nomGagnant == null)) text.setText("Victoire à " + nomGagnant);
        text.setFont(new Font("Arial", Font.BOLD, 55));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setOpaque(true);
        text.setBackground(new Color(255, 215, 0));
        text.setBorder(BorderFactory.createLineBorder(new Color(202,178,4),5,true));

        add(text, BorderLayout.NORTH);

        JPanel replayPanel = new JPanel();
        replayPanel.setLayout(new BorderLayout());

        JLabel replayLabel = new JLabel("Voulez vous rejouer ?");
        replayLabel.setFont(new Font("Arial", Font.BOLD, 25));
        replayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        replayPanel.add(replayLabel, BorderLayout.NORTH);
        JButton yesButton = new JButton("OUI");
        yesButton.addActionListener(ActionEvent ->{
            controleur.rejouer();
            screen.setStep(Etat.PARTIE_EN_COURS);
            screen.getFrame().remove(this);
        });
        yesButton.setFont(new Font("Arial", Font.BOLD, 50));
        yesButton.setHorizontalAlignment(SwingConstants.CENTER);
        yesButton.setOpaque(true);
        yesButton.setBackground(new Color(60, 160, 100));

        replayPanel.add(yesButton, BorderLayout.CENTER);

        JButton noButton = new JButton("QUITTER");
        noButton.addActionListener(ActionEvent -> {
            screen.getFrame().dispose();
        });
        noButton.setFont(new Font("Arial", Font.BOLD, 50));
        noButton.setHorizontalAlignment(SwingConstants.CENTER);
        noButton.setBackground(new Color(98, 91, 72));
        noButton.setOpaque(true);

        add(noButton, BorderLayout.SOUTH);
        add(replayPanel);

    }

}
